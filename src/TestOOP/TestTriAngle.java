package TestOOP;

public class TestTriAngle {
    public static void main(String[] args) {
        TriAngle t = new TriAngle(2,4);
        System.out.println("底边长为： " + t.getBase() + ", 高为： " + t.getHeight() + ", 面积为: " + 0.5 * t.getBase() * t.getHeight());
    }


}

class TriAngle{
    private double base;
    private double height;
    public TriAngle(double b, double h){
        base = b;
        height = h;

    }
    public double getBase(){
        return base;
    }
    public double getHeight(){
        return height;
    }
}
