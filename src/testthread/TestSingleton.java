package testthread;

/**
 * 解决单例懒汉式可能存在的线程安全问题
 */
public class TestSingleton {
}
class Singleton{
    private Singleton(){

    }
    private static Singleton instanse = null;
    public static Singleton getInstance(){
        //对于静态方法而言，使用当前类本身充当锁
        synchronized (Singleton.class) {
            if (instanse == null) {
                instanse = new Singleton();
            }
        }
        return instanse;
    }
}
