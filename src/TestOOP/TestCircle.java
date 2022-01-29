package TestOOP;

import java.rmi.ConnectIOException;

public class TestCircle {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.r = 2.1;
        c.getArea();
    }


}

class Circle{
    double r = 1.0; //圆的半径
    public void getArea(){
        double area = 3.14 * r * r;
        System.out.println(area);
    }
}
