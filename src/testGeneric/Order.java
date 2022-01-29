package testGeneric;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 自定义泛型类
 * @param <T>
 */
public class Order<T> {
    private String orderName;
    private int orderId;
    private T t; //泛型类型的变量
    List<T> list = new ArrayList<>();
    public void add(){
        list.add(t);
    }

    public void setT(T t){
        this.t = t;
    }
    public T getT(){
        return t;
    }
    //声明泛型方法
    public <E> E getE(E e){
        return e;
    }
    public <E> List<E> formArrayToList(E[] e, List<E> list){
        for (E e1 : e){
            list.add(e1);
        }
        return list;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    //自定义泛型类的使用
    @Test
    public void test(){
        //1、当实例化泛型类的对象时，指定泛型的具体类型，指明以后，对于类中所有使用泛型的地方都变为该类型
        //2、如果自定义了泛型类，但是在使用时没有指定泛型类的具体类型，这时默认使用Object类型
        Order<Boolean> order = new Order<>();
        order.setT(false);
        System.out.println(order.getT());
        System.out.println();
        order.add();
        order.add();
        System.out.println(order.list);
        System.out.println();
        SubOrder subOrder = new SubOrder();
        subOrder.setT(12);
        System.out.println(subOrder.getT());
        subOrder.add();
        subOrder.add();
        System.out.println(subOrder.list);

        int o = order.getE(45);
        System.out.println(o);
        double d = order.getE(4.5);
        System.out.println(d);
        System.out.println(order.formArrayToList(new Integer[]{1,2,3}, new ArrayList<>()));
        System.out.println(order.formArrayToList(new String[]{"A","B"}, new ArrayList<>()));
    }


    @Test
    public void test1(){
        List<String> list  = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        List<?> list1 = list;
        //可以读取声明为通配符的集合类的对象
        Iterator<?> iterator = list1.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //不允许向声明为通配符的集合类中写入对象
        //list1.add("cc");

    }
}

//继承泛型类或泛型接口时，可以指定泛型的具体类型。如果不指明，都需要写成<T>
class SubOrder extends Order<Integer>{

}
