package extend;

public class Cylinder extends Circle{
    private double length;

    public Cylinder() {
        this.length = 1;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }
    //方法重写:求圆柱的表面积
    public double findArea(){
        return super.findArea() * 2 + 2 * 3.14 * this.getRadius() * length;
    }
    public double findVolume(){
        //return findArea() * length;
        return 3.14 * this.getRadius() * this.getRadius() * length;
    }
}
