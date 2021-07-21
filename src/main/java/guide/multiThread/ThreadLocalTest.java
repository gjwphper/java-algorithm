package guide.multiThread;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalTest {
    static ThreadLocal<String> local = new ThreadLocal<>();
    public static void main(String[] args){

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                local.set("threadOne's local value");
                try {
                    Thread.sleep(5000); //沉睡5000 毫秒，确保 threadTwo 执行 remove 完成
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(local.get());
            }
        });
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                local.set("threadTwo's local value");
                System.out.println(local.get());
                local.remove();
                System.out.println("local 变量执行 remove 操作完毕。");
            }
        });
        threadTwo. start();
        threadOne. start();
    }

}
