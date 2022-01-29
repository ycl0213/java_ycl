package testthreadcommunication;

/**
 * 使用两个线程打印1-100之间的数，要求线程1和线程2交替打印
 */
public class TestCommunication {
    public static void main(String[] args) {
        SubThread s = new SubThread();
        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);
        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }

}
class SubThread implements Runnable{
    int num = 1;
    @Override
    public void run() {
        while(true){
            synchronized (this) {
                notify(); //唤醒正在排队等待同步资源的线程
                if (num <= 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                }
                try {
                    wait();  //当前线程挂起
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}