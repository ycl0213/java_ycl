package testexception;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class TestException {
    @Test
    public void test1(){
        try {
            int[] i = new int[10];
            //java.lang.ArrayIndexOutOfBoundsException: 10
            System.out.println(i[10]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("数组越界了！");
        }
    }
    @Test
    public void test2(){
        int i = 10;
        //java.lang.ArithmeticException: / by zero
        System.out.println(i / 0);
    }
    @Test
    public void test3(){
        Object o = new Date();
        //java.lang.ClassCastException: java.util.Date cannot be cast to java.lang.String
        String s = (String)o;
    }
    @Test
    public void test4(){
        Person p = new Person();
        p = null;
        //java.lang.NullPointerException
        System.out.println(p.toString());
    }
    @Test
    //通过throws Exception抛出可能的异常
    public void test5() throws IOException{
            FileInputStream fil = new FileInputStream(new File("C:\\Users\\13248\\IdeaProjects\\study\\ycl\\src\\testexception\\hello1.txt"));
            int b;
            while((b = fil.read()) !=-1){
                System.out.println((char)b);
            }
            fil.close();
    }
    public void method() throws IOException{  //往上抛
        test5();
    }

    public static void main(String[] args) throws IOException {  //此时将编译时异常变为了运行时异常
        TestException t = new TestException();
        t.method();
    }
}

class Person{

}
