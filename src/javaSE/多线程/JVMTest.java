package javaSE.多线程;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/*
 *  运行结果：输出启动的线程的ID和Name
 *  12-Monitor Ctrl-Break
 *  11-Common-Cleaner
 *  5-Attach Listener
 *  4-Signal Dispatcher
 *  3-Finalizer
 *  2-Reference Handler
 *  1-main
 */
public class JVMTest {
    public static void main(String[] args) {
//        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
//        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
//        for (ThreadInfo threadInfo : threadInfos) {
//            System.out.println(threadInfo.getThreadId() + "-" + threadInfo.getThreadName());
//        }

        for (int i = 0; i < 2000; i++) {
            final int j = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(j);
                }
            });

            try {
                thread.start();
                thread.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace(); }
        }
    }
}
