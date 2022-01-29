package single;

import javax.swing.*;

/**
 * 单例设计模式
 */
public class TestSingle {
    public static void main(String[] args) {
        Single s1 = Single.getInstance();
        Single s2 = Single.getInstance();
        System.out.println(s1 == s2);//true
        System.out.println("=====");
        Single1 s11 = Single1.getInstance();
        Single1 s12 = Single1.getInstance();
        System.out.println(s11 == s12);//true

    }
}
//饿汉式
class Single{
    //1、私有化构造器。使得在类的外部不能调用该构造器
    private Single(){
    }
    //2、在类的内部创建一个类的实例，私有化此对象
    private static Single instance = new Single();
    //3、提供公共的方法来调用。在该公共的方法中，只能通过类来调用，因此设为static方法,同时类的实例也必须为static
    public static Single getInstance(){
        return instance;
    }
}

//懒汉式
class Single1{
    //1、私有化构造器。使得在类的外部不能调用该构造器
    private Single1(){

    }
    //2、在类的内部创建一个类的实例，初始给null
    private static Single1 instance = null;
    public static Single1 getInstance(){
        if(instance == null){
            return instance = new Single1(); //只会创建一次
        }
        return instance;
    }
}
