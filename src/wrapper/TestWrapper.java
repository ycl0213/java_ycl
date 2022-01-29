package wrapper;

import org.junit.Test;

public class TestWrapper {

    @Test
    public void rest1(){
        int i = 10;
        Integer integer = new Integer(i); //基本数据类型转换为包装类
        System.out.println(integer.toString());
        Float f = new Float("12.3F");
        System.out.println(f.toString());
        integer = new Integer("12");
        System.out.println(integer);
        Order o = new Order();
        System.out.println(o.b);// null
        int i2 = integer.intValue();
        System.out.println(i2);
        float f1 = f.floatValue();
        System.out.println(f1);
    }

    @Test
    //包装类、基本数据类型与String的转换
    public void test2(){
        int i1 = 10;
        Integer i2 = i1; //自动装箱
        String str1 = String.valueOf(i2); //
        System.out.println(str1);
        String str2 = String.valueOf(true);
        System.out.println(str2);
        System.out.println("======");
        //String类--->包装类转换，调用包装类的parseXxx()方法
        int i3 = Integer.parseInt(str1);
        System.out.println(i3);
        boolean b1 = Boolean.parseBoolean(str2);
        System.out.println(b1);


    }
}

class Order{
    Boolean b;
}
