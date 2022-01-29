package polymorphism;

import java.rmi.ConnectIOException;

public class TestGeometricObject {
    public static void main(String[] args) {
        TestGeometricObject t = new TestGeometricObject();
        t.equalsArea(new Circle(2,"yellow",2), new MyRectangle(2,3,"yellow",2));
        t.diaplayGGeometricObject(new Circle(1,"red",3));

    }
    //体现多态的应用
    public void equalsArea(GeometricObject g1, GeometricObject g2){
        if(g1.findArea() == g2.findArea()){
            System.out.println("面积相等");
        }else{
            System.out.println("面积不等");
        }
    }
    public void diaplayGGeometricObject(GeometricObject g){
        if(g instanceof Circle){
            System.out.println("circle" + " 面积为： " + g.findArea());
        }
        if(g instanceof MyRectangle){
            System.out.println("MyRectangle" + " 面积为: " + g.findArea());
        }
        if(g instanceof GeometricObject){
            System.out.println("GeometricObject" + " 面积为: " + g.findArea());
        }
    }
}

class GeometricObject{
    protected String color;
    protected double weight;

    protected GeometricObject(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }
    public double findArea(){
        return new GeometricObject("yellow",2).findArea();
    }
}
//Circle类
class Circle extends GeometricObject{
    private double radius;

    public Circle(double radius, String color, double weight) {
        super(color,weight);
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    public double findArea(){
        return 3.14 * this.getRadius() * this.getRadius();
    }
}
//MyRectangle类
class MyRectangle extends GeometricObject{
    private double width;
    private double height;
    public MyRectangle(double width, double height, String color, double weight) {
        super(color, weight);
        this.width = width;
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
    public double findArea(){
        return this.getWidth() * this.getHeight();
    }
}


