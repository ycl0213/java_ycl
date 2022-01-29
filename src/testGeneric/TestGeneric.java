package testGeneric;

import com.sun.glass.ui.ClipboardAssistance;
import org.junit.Test;

import java.util.*;

public class TestGeneric {
    //1、没有使用泛型的情况
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(12);
        list.add(13);
        list.add(24);
        list.add(45);
        list.add(new String("AA"));
        for (int i = 0; i < list.size(); i++) {
            int s = (Integer)list.get(i);
            System.out.println(s); //报错：java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
        }

    }
    //2、使用泛型的情况
    @Test
    public void test2(){
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(23);
        //list.add(new String("AA")); //错误
        list.add(56);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    //Map中使用泛型
    @Test
    public void test3(){
        Map<String, Integer> map = new HashMap<>();
        map.put("AA", 13);
        map.put("BB", 23);
        map.put("CC", 45);
        Set<Map.Entry<String,Integer>> set = map.entrySet();
        for(Map.Entry<String,Integer> m : set){
            System.out.println(m.getKey() + ":" + m.getValue());
        }
    }

    //泛型与继承的关系

    /**
     * 1、若类A是类B的子类，那么List<A>就不是List<B>的子接口
     */
    @Test
    public void test4(){
        List<Object> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        //list = list1; //错误，类型不匹配
    }

    //通配符 ?

    /**
     * List<A>、List<B>....都是List<?>的子类
     */
    @Test
    public void test5(){
        List<?> list = new ArrayList<>();
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list = list1;
        list = list2;
        List<? extends Number> list4 = new ArrayList<>();
        List<Integer> list5 = new ArrayList<>();
        list4 = list5;
        List<? super Number> list6 = new ArrayList<>();
        list6 = list1;

        show1(list1);
        //show1(list2); //出错 list2是String类型
        show2(list1);
        show2(list2);// 可以放入list2
        show3(list1);
        show3(list2);
    }
    public void show1(List<Object> list){

    }
    public void show2(List<?> list){} //具有通用性

    public void show3(List<? extends Object> list){}  //? extends E:代表E和E的子类
}
