package util.time;

import com.alibaba.fastjson.JSON;
import util.time.TraceWatch;

import java.util.concurrent.TimeUnit;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2/1/2021 11:48 AM
 */
public class TraceWatchTest {

    public void TraceWatchTest() throws InterruptedException {
        TraceWatch traceWatch = new TraceWatch();

        traceWatch.start("function1");
        TimeUnit.SECONDS.sleep(1); // 模拟业务代码
        traceWatch.stop();

        traceWatch.start("function2");
        TimeUnit.SECONDS.sleep(1); // 模拟业务代码
        traceWatch.stop();

        traceWatch.record("function1", 1); // 直接记录耗时

        System.out.println(JSON.toJSONString(traceWatch.getTaskMap()));
    }
}
