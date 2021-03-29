package com.dgn;

import java.io.IOException;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/3/26 19:35
 */
public class SelectorDemo {


    public static void main(String[] args) throws IOException {
        //调用Selector.open()方法创建一个Selector
        SocketChannel channel = SocketChannel.open();
        //与Selector一起使用时，Channel必须处于非阻塞模式下。这意味着不能将FileChannel与Selector一起使用，因为FileChannel不能切换到非阻塞模式。而套接字通道都可以
        channel.configureBlocking(false);
        Selector selector = Selector.open();
        channel.configureBlocking(false);
        SelectionKey key = channel.register(selector, SelectionKey.OP_READ);
        while(true) {

            int readyChannels = selector.select();
            //没有准好的channel
            if(readyChannels == 0) {
                continue;
            }

            //获取准备好的channel集合
            Set selectedKeys = selector.selectedKeys();
            Iterator keyIterator = selectedKeys.iterator();
            while(keyIterator.hasNext()) {
                SelectionKey selectionKey = (SelectionKey) keyIterator.next();
                if(selectionKey.isAcceptable()) {
                    // a connection was accepted by a ServerSocketChannel.
                } else if (selectionKey.isConnectable()) {
                    // a connection was established with a remote server.
                } else if (selectionKey.isReadable()) {
                    // a channel is ready for reading
                } else if (key.isWritable()) {
                    // a channel is ready for writing
                }
                keyIterator.remove();
            }
        }


    }
}
