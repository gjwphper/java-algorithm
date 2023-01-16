package guide.multiThread;

class Add{
    public int count = 0;
    public int num = 40000;

    //对count进行加一操作
    synchronized public void addition(){
        count++;
//        System.out.println(Thread.currentThread().getName());
    }

    public void jj(){
        num--;
    }
}

public class Test {
    static Add add = new Add();
    public static void main(String[] args) throws InterruptedException {



        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                add.addition();
//                add.jj();
            }
        },"thread---------------1");
        Thread thread2 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                add.addition();
//                add.jj();
            }
        },"thread---------------2");

        //有2个线程各对执行addition() 10000次
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();


        System.out.println(add.count);
        System.out.println(add.num);
    }
}