package equals;


public class TestGeometricObject {
    public static void main(String[] args) {
        Circle circle1 = new Circle(2);
        Circle circle2 = new Circle(2);
        System.out.println(circle1.equals(circle2));

        System.out.println(circle1.toString());

    }
}

class GeometricObject{
    protected String color;
    protected double weight;

    public GeometricObject() {
        this.color = "white";
        this.weight = 1.0;
    }

    public GeometricObject(String color, double weight) {
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
}

class Circle extends GeometricObject{
    private double radius;

    public Circle() {
        this.radius = 1.0;// 没有写super()时，默认调用父类的空参构造器
    }

    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(String color, double weight, double radius){
        super(color, weight);
        this.radius = radius;

    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    public double findArea(){
        return 3.14 * radius * radius;
    }

    //重写equals()方法
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof Circle){
            Circle circle = (Circle)obj;
            return this.radius == circle.radius;
        }
        return false;
    }

    //重写toString()方法
    public String toString(){
        return "radius: " + radius;
    }
}
