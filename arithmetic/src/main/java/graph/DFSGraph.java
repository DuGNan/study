package graph;

/**
 * @author dugn
 * @Date 2020/8/31
 * @Description
 */

import java.util.Iterator;
import java.util.LinkedList;

public class DFSGraph {

    private int V; // 定义结点（vertices）

    // 图的邻接表表示（ Adjacency List）
    private LinkedList<Integer> adj[];

    // 构造图的构造方法
    DFSGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    // 向图中添加边
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // DFS算法工具
    void DFSUtil(int v, boolean visited[]) {
        // 标记当前结点为已访问（visited）并输出
        visited[v] = true;
        System.out.print(v + " ");

        // 访问当前的结点的所有邻接结点
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    // DFS traversal. 用来回溯调用 DFSUtil()工具
    void DFS(int v) {
        // 标记所有节点为未访问状态（ not visited），设置初始值为false。
        boolean visited[] = new boolean[V];

        // 回溯 DFS traversal
        DFSUtil(v, visited);
    }

    public static void main(String args[]) {
        DFSGraph g = new DFSGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("下面是DFS搜索结果 " + "(从2号结点开始)");

        g.DFS(2);
    }
}
