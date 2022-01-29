package testthread;

/**
 * 创建一个子线程，实现1-100之间自然数的输出；同时主线程执行同样的操作；
 * 创建多线程的方法：
 * 1、继承java.lang.Thread类
 *
 */
//1、创建一个继承于Thread的子类
class SubThread extends Thread{
    //2、重写Thread类中的run()方法，在run()方法中实现此子线程要完成的功能
    public void run(){
        for (int i = 1; i <= 100 ; i++) {
            System.out.println(Thread.currentThread().getName() + ": 优先级为 " + Thread.currentThread().getPriority() + " " + i);
        }
    }
}
public class TestThread {
    public static void main(String[] args) {
        SubThread st = new SubThread();
        st.setName("子线程1");
        st.setPriority(Thread.MAX_PRIORITY);
        st.start(); //一个线程只能执行一次start()
        Thread.currentThread().setName("====主线程");
        for (int i = 1; i <= 100 ; i++) {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + ": 优先级为 " + Thread.currentThread().getPriority() + " " + i);
//            if(i == 20){
//                try {
//                    st.join(); //强制让子线程加入并且在执行完以后才释放当前子线程的CPU的执行权
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(i % 10 == 0){
//                Thread.yield(); //调用此方法的线程释放当前CPU的执行权
//            }
        }
//        System.out.println(st.isAlive()); //false
    }
}
