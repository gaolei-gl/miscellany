package com.lei.thread;

import java.util.concurrent.*;

/**
 * Created by com.lei on 16-1-20.
 * 执行任务的线程拥有自己的执行策略--任务不响应中断。
 * 启动任务线程之后，利用显示有超时的join等待线程结束
 * 最后在检查一下是否需要把执行线程内可能存在的异常抛出
 */
public class InterruptByAnotherThread {
    private static ScheduledExecutorService executorService = null;

    public static void main(String[] args) {
        executorService = Executors.newScheduledThreadPool(10);
        // TODO: 16-1-20  do some thing here
//        runTask(...);
        executorService.shutdown();
    }

    public static void runTask(final Runnable runnable, long timeout, TimeUnit unit) throws Throwable {
        class RethrowableTask implements Runnable {
            private volatile Throwable throwable;

            public void run() {
                try {
                    runnable.run();
                } catch (Throwable t) {
                    this.throwable = t;
                }
            }

            void reThrow() throws Throwable {
                if (throwable != null) {
                    throw throwable;
                }
            }
        }

        RethrowableTask task = new RethrowableTask();
        final Thread taskThread = new Thread(task);
        taskThread.start();
        executorService.schedule(new Runnable() {
            public void run() {
                taskThread.interrupt();
            }
        }, timeout, TimeUnit.SECONDS);

        taskThread.join(unit.toSeconds(timeout));
        task.reThrow();

    }
}
