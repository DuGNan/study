package juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dugn
 * @Date 2020/9/18
 * @Description
 */
public class Demo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            //锁代码
        } finally {
            lock.unlock();
        }
    }
}
