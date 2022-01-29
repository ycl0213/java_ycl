package testinterface2;

/**
 * 接口的应用
 */
public class TestInterface {
    public static void main(String[] args) {
        ComparableCircle c1 = new ComparableCircle(2.1);
        ComparableCircle c2=  new ComparableCircle(2.3);
        System.out.println(c1.compareTo(c2));
        System.out.println(c1.compareTo(new String()));
    }
}
interface CompareObject{
    public int compareTo(Object o);
}

class Circle{
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

class ComparableCircle extends Circle implements CompareObject {
    public ComparableCircle(double radius){
        super(radius);
    }
    @Override
    public int compareTo(Object o) throws MyException{
        if(this == o) {
            return 0;
        }else if(o instanceof ComparableCircle){
            if(this.getRadius() == ((ComparableCircle) o).getRadius()){
                return 0;
            }else if(this.getRadius() >((ComparableCircle) o).getRadius()){
                return 1;
            }else{
                return -1;
            }
        }
       // throw new RuntimeException();  //手动抛出一个现有的异常
        throw new MyException("输入有误");
    }
}

class MyException extends RuntimeException{
    static final long serialVersionUID = -7034897190745766931L;

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}

