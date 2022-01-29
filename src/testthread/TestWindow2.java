package testthread;

public class TestWindow2 {
    public static void main(String[] args) {
        Window2 w2 = new Window2();
        Thread t1 = new Thread(w2);
        Thread t2 = new Thread(w2);
        Thread t3 = new Thread(w2);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
//采用同步方法
class Window2 implements Runnable{
    int ticket = 100; //共享的数据
    @Override
    public void run() {
        while (true) {
            show();
        }
    }
    public synchronized void show(){//将操作共享数据的方法声明为synchronized，同步方法的锁为this对象
            if (ticket > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "售票，票号为：" + ticket--);
            }
    }
}
