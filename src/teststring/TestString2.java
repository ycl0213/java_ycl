package teststring;


import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

public class TestString2 {
    /**
     * 1、字符串与基本数据类型、包装类之间的转换
     * 1）字符串----->基本数据类型、包装类：调用相应的包装类的parseXxx(String str)方法
     */
    @Test
    public void test1(){
        String str = "123";
        int i = Integer.parseInt(str);
        System.out.println(i);
    }

    /**
     * 1）基本数据类型、包装类----->字符串：调用String类的valuesOf()方法
     */
    @Test
    public void test2(){
        Integer i = 123;
        String s = String.valueOf(i);
        System.out.println(s);

        System.out.println("------------");
        Boolean b = true;
        String s1 = String.valueOf(b);
        System.out.println(s1);

        Boolean b2 = true;
        String s2 = b2.toString();
        System.out.println(s2);
        System.out.println("true".equals(s2));
    }

    /**
     * 2、字符串与字节数组的转换
     * 1)字符串----->字节数组：调用字符串的getByte()方法
     */
    @Test
    public void test3(){
        String str = "sfsd";
        byte[] bytes = str.getBytes();
        for(byte b : bytes){
            System.out.println((char)b);
        }
        System.out.println("-------");
        /**
         * 字节数组----->字符串:使用字符串的构造器
         */
        String str1 = new String(bytes);
        System.out.println(str1);
    }

    /**
     * 2、字符串与字符数组的转换
     * * 1)字符串----->字符数组：调用字符串的toCharArray()方法
     */
    @Test
    public void test4(){
        String str = "afsa";
        char[] chars = str.toCharArray();
        for(char c : chars){
            System.out.println(c);
        }

        System.out.println("-------");
        /**
         * 1)字符数组----->字符串：使用字符串的构造器
         */
        String str1 = new String(chars);
        System.out.println(str1);
    }
}
