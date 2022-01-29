package testfinal;

import java.util.function.DoubleBinaryOperator;

public class TestFinal {
}

//final修饰属性时
class A{
    // final int I; //final修饰的常量不能使用默认初始化
    final int I = 10; //可以使用显式的初始化
    final double PI;  //可以在代码块中初始化
    final String NAME; //可以在构造器中初始化
    {
        PI = 3.14;
    }
    public A(){
        NAME = "AA";
    }
    public void m1(){
        System.out.println(I);
  //      I = 12;//不能给final修饰的常量重新赋值
    }

}
