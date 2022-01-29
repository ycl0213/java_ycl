package testcollection;

import org.junit.Test;

import java.util.*;

public class TestCollection {
    @Test
    public void rest1(){
        Collection coll = new ArrayList();
        //1、size()方法:返回集合中元素的个数
        System.out.println(coll.size());

        //2、add(Object o)方法
        coll.add(123);
        coll.add("QQ");
        coll.add(new Date());
        System.out.println(coll.size());

        //3、addAll(Collection coll)方法
        Collection coll1 = Arrays.asList(1,2,3);
        coll.addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll); //可以直接打印集合
    }

    @Test
    public void test2(){
        Collection coll2 = new ArrayList();
        coll2.add("12");
        coll2.add("abc");
        coll2.add("aa");

        Collection coll3 = Arrays.asList("12",2,3);
        coll2.retainAll(coll3);
        System.out.println(coll2);
    }
}

