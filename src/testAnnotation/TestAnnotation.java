package testAnnotation;

import javax.swing.text.Style;
import java.util.ArrayList;
import java.util.List;

public class TestAnnotation {
    public static void main(String[] args) {
        Person p = new Student("小王", 12, "学校1");
        p.walk();
        p.eat();

        @SuppressWarnings("rawtypes")
        List list = new ArrayList<>();
    }

}

@MyAnnotation("myannotation")
class Student extends Person{
    private String school;
    public Student(String name, int age, String school) {
        super(name, age);
        this.school = school;
    }
    //注解
    @Override
    public void walk(){
        System.out.println("学生走路");
    }
    @Override
    public void eat(){
        System.out.println("学生吃饭");
    }
}
class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public void walk(){
        System.out.println("走路");
    }
    @Deprecated
    public void eat(){
        System.out.println("吃饭");
    }
}
