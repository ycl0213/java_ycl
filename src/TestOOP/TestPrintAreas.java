package TestOOP;

public class TestPrintAreas {
    public static void main(String[] args) {
        PassObject p = new PassObject();
        Circle2 c = new Circle2();
        p.printAreas(5.0, c);
        System.out.println("now radius is : " + c.getRadius());
    }
}

class Circle2{
    double radius;
    public double findArea(double r){
        return 3.14 * r * r;
    }
    public void setRadius(double r){
        radius = r;
    }
    public double getRadius(){
        return radius;
    }
}

class PassObject{
    public void printAreas(double times,Circle2 circle){
        System.out.println("radius" + "\t\t" + "Areas ");
        double temp = 0;
        for (double i = 1.0; i <= times ; i++, temp = i) {
            circle.setRadius(i);
            double area = circle.findArea(circle.getRadius());
            System.out.println(circle.getRadius() + "\t\t" + area);
        }
        circle.setRadius(temp);

    }
}

