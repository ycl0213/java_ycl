package teststatic;

import java.rmi.ConnectIOException;

public class TestStatic {
    public static void main(String[] args) {
        Circle c1 = new Circle(2);
        Circle c2 = new Circle(2);
        System.out.println(Circle.getTotal());
        Circle.show();
        c2.setInfo("我是一个漂亮的圆");
        //Circle.setInfo("我是一个漂亮的圆");
        Circle.show();

    }
}

class Circle{
    private double radius;
    private static String info = "我是一个圆";
    private static int total;//因为total是static的，在内存中独一份，所以可以用来记录创建的对象的个数

    public Circle(double radius) {
        this.radius = radius;
        total++;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public static void setTotal(int total) {
        Circle.total = total;
    }

    public double getRadius() {
        return radius;
    }

    public static int getTotal() {
        return total;
    }

    public static void setInfo(String info) {
        Circle.info = info;
    }

    public static String getInfo() {
        return info;
    }

    public static void show(){
        System.out.println(info);
        //System.out.println("我是一个圆");
    }
}
