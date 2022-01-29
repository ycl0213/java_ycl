package testcollections;

import org.junit.Test;

import java.util.*;

public class TestCollections {
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(23);
        list.add(45);
        list.add(675);
        System.out.println("反转前： " + list);
        //反转
        Collections.reverse(list);
        System.out.println("反转后： " + list);
        //随机排列
        Collections.shuffle(list);
        System.out.println("随机排列后：" + list);
        //排序
        //报错：java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
        //由于list含有不同类型的元素
        Collections.sort(list);
        System.out.println("排序后： " + list);

        //sort(list,Comparator)
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Integer && o2 instanceof Integer){
                    return -((Integer) o1).compareTo((Integer) o2);
                }
                return 0;
            }
        });
        System.out.println("指定排序后： " + list);

        //交换
        Collections.swap(list, 0,3);
        System.out.println("交换后： " + list);
    }

    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(23);
        list.add(45);
        list.add(675);
        //max
        System.out.println(list);
        Object o = Collections.max(list);
        System.out.println("最大元素为： " + o);
        //返回指定集合中指定元素出现的次数
        int i = Collections.frequency(list, 23);
        System.out.println("23 出现的次数: " + i);
        //List list2 = new ArrayList(); //报错：java.lang.IndexOutOfBoundsException: Source does not fit in dest
         List list2 = Arrays.asList(new Object[list.size()]);
        Collections.copy(list2, list);
        System.out.println("list2： " + list2);
        //raplaceAll
        Collections.replaceAll(list, 456, 45);
        System.out.println(list);
    }
}
