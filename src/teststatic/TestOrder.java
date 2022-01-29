package teststatic;

import com.sun.org.apache.xpath.internal.operations.Or;

public class TestOrder {
    public static void main(String[] args) {
        Order o1 = new Order();
        System.out.println(o1);
        System.out.println("===");
        Order o2 = new Order();
        System.out.println(o2); //每创建一次对象，就加载一次非静态代码块
    }
}
class Order{
    private int id;
    private String orderName;
    private static String orderDesc;
    //非静态代码块，可以有输出语句，可以对属性赋值
    {
        id = 1001;
        orderName = "AA";
        System.out.println("代码块1");
        orderDesc = "我是非静态的订单描述";
        showDesc();//非静态的代码块可以执行静态的结构
        showDesc1();//非静态的代码块可以执行非静态的结构
    }
    //可以有多个代码块
    {
        id = 1002;
        orderName = "BB";
        System.out.println("代码块2");

    }
    //静态代码块
    static {
        System.out.println("静态代码块2");
        orderDesc = "我是订单描述";
        showDesc(); //静态的代码块中只能执行静态的结构（方法）
    }
    static {
        System.out.println("静态代码块1");
    }
    //代码块的执行早于构造器
    public Order() {
        System.out.println("Order类空参的构造器");
    }

    public Order(int id, String orderName) {
        this.id = id;
        this.orderName = orderName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getId() {
        return id;
    }

    public String getOrderName() {
        return orderName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderName='" + orderName + '\'' +
                '}';
    }

    public static void showDesc(){
        System.out.println(orderDesc);
    }
    public  void showDesc1(){
        System.out.println(orderDesc);
    }
}
