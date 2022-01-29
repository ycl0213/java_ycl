package extend;

import java.rmi.ConnectIOException;

public class TestCylinder {
    public static void main(String[] args) {

        Cylinder c = new Cylinder();
        System.out.println(c.findVolume());
        System.out.println(c.findArea());
        System.out.println("========");
        c.setLength(3);
        System.out.println(c.getLength());
        c.setRadius(2);
        System.out.println(c.getRadius());
        System.out.println("圆柱的表面积：");
        System.out.println(c.findArea());
        System.out.println("圆柱的体积：");
        System.out.println(c.findVolume());

        System.out.println("圆的底面积：");
        Circle circle = new Circle();
        System.out.println(circle.findArea());

        System.out.println("=====");
        Circle c1 = new Circle();
        c1.setRadius(4);
        System.out.println("圆的面积为： " + c1.findArea());


    }
}
