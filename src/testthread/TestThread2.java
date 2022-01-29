package testthread;

/**
 * 创建两个子线程，一个打印1-100之间的奇数；另一个打印1-100之间的偶数
 */
public class TestThread2 {
    public static void main(String[] args) {
//        SubThread1 st1 = new SubThread1();
//        SubThread2 st2 = new SubThread2();
//        st1.setName("子线程1");
//        st2.setName("子线程2");
//        st1.start();
//        st2.start();
        //继承与Thread类的匿名类的对象
        new Thread(){
            public void run(){
                for (int i = 1; i <= 100 ; i++) {
                    if(i % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + ": 偶数： " + i);
                    }
                }
            }
        }.start();

        new Thread(){
            public void run(){
                for (int i = 1; i <= 100 ; i++) {
                    if(i % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + ": 奇数： " + i);
                    }
                }
            }
        }.start();
        Thread.currentThread().setName("主线程");
        for (int i = 1; i <= 100 ; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }


}
//class SubThread1 extends Thread{
//    public void run(){
//        for (int i = 1; i <= 100 ; i++) {
//            if(i % 2 == 0){
//                System.out.println(Thread.currentThread().getName() + ": 偶数： " + i);
//            }
//        }
//    }
//}
//class SubThread2 extends Thread{
//    public void run(){
//        for (int i = 1; i <= 100 ; i++) {
//            if(i % 2 != 0){
//                System.out.println(Thread.currentThread().getName() + ": 奇数： " + i);
//            }
//        }
//    }
//}