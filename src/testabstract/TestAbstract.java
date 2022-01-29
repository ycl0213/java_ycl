package testabstract;

public class TestAbstract {
    public static void main(String[] args) {
        Student s = new Student();
        s.eat();
        s.walk();
        Person p = new Worker();
        p.eat();
        p.walk();
    }


}
abstract class Person{
    private String name;
    //抽象的方法不用写方法体
    public abstract void eat();
    public abstract void walk();
   //抽象类有构造器
    public Person(){

    }
    public Person(String name){
        this.name = name;
    }
}
class Student extends Person{
    public void eat() {
        System.out.println("学生吃饭");
    }
    public void walk(){
        System.out.println("学生走路");
    }
}

class Worker extends Person{
    public void eat() {
        System.out.println("工人吃饭");
    }
    public void walk(){
        System.out.println("工人走路");
    }
}