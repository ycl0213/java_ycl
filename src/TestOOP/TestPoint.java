package TestOOP;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class TestPoint {
    public static void main(String[] args) {
        Point p = new Point(2,3,4);
        System.out.println("X: " + p.getX() + ", Y: " + p.getY() + ", Z: " + p.getZ());
        System.out.println("距离为： " + p.getDis());
    }


}

class Point{
    private double x;
    private double y;
    private double z;
    public Point(double i, double j, double k){
        x = i;
        y = j;
        z = k;
    }
    public void setX(double x){
        x = x;
    }
    public void setY(double y){
        y = y;
    }
    public void setZ(double z){
        z = z;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getZ(){
        return z;
    }
    public double getDis(){
        return (x * x + y * y + z * z) * (x * x + y * y + z * z);
    }
}
