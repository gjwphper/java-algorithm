package guide.multiThread;

public class RunnableTest implements Runnable{
    private int i = 5;

    @Override
    public void run() {
        while (i > 0) {
            System.out.println(Thread.currentThread().getName() + " i = " + i);
            i--;
        }
    }

    public static void main(String[] args) {
        // 创建两个实现 Runnable 实现类的实例
        RunnableTest runnableDemo1 = new RunnableTest();
        RunnableTest runnableDemo2 = new RunnableTest();
        // 创建两个线程对象
        Thread thread1 = new Thread(runnableDemo1, "线程1");
        Thread thread2 = new Thread(runnableDemo2, "线程2");
        // 启动线程
        thread1.start();
        thread2.start();
    }


}
