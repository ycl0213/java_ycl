package testthread;

/**
 * 模拟火车站三个窗口售票
 * 同样存在线程的安全问题
 */
public class TestWindow {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();

    }
}
class Window extends Thread{
    static int ticket = 100; //设置为static的变量
    static Object obj = new Object();  //需要将同步监视器声明为static的，保证共用一个锁
    public void run(){
        while(true){
            synchronized (obj) { //在本问题中，this表示：w1，w2，w3对象，不是同一个对象，不能使用
                //同理，这里不能使用同步方法，即不能通过将共享数据的方法声明为synchronized来解决线程安全问题，因为
                //同步方法的锁为this对象，当前有三个对象，没有达到同一个锁的目的；
                if(ticket > 0){
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "售票，票号为： " + ticket--);
                }else{
                    break;
                }
            }
        }
    }
}
