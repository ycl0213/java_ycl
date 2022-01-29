package testthread;

/**
 * 方式二：采用实现的方式创建多线程
 *
 */
public class TestThreadMethod2 {
    public static void main(String[] args) {
        //3、创建实现了Runnable接口的类的对象，
        SubThread1 st1 = new SubThread1();
        //4、将该对象作为形参给Thread对象的构造器中，创建Thread对象，此对象即为一个线程
        Thread t = new Thread(st1);
        //想要启动一个多线程，必须使用start()方法
        //5、调用start()方法启动线程
        t.start(); //启动线程，执行Thread对象生成时构造器形参的run()方法
        //再创建一个线程
        Thread t2 = new Thread(st1);
        t2.start();
    }
}
//1、创建一个实现了Runnable接口的类
class SubThread1 implements Runnable{
    @Override
    //2、重写run()方法，再该方法中实现子线程的功能
    public void run() {
        for (int i = 1; i <= 100 ; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }

    }
}
