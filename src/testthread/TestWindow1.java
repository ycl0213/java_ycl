package testthread;

/**
 * 使用实现Runnable接口的方式模拟火车站售票窗口
 * 此程序存在线程的安全问题，打印车票时会出现重票错票
 */
public class TestWindow1 {
    public static void main(String[] args) {
        Window1 w1 = new Window1();  //共享一个w1对象
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
class Window1 implements Runnable{
    int ticket = 100; //共享的数据
    @Override
    public void run() {
            while (true) {
                //要求所有的线程必须共用同一把锁
                synchronized (this) {//在本问题中，可以使用this，表示当前对象
                    if (ticket > 0) {
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "售票，票号为：" + ticket--);
                    }else{
                        break;
                    }
                }
            }
    }
}


