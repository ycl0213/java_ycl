package polymorphism;

public class TestInstance {
    public static void main(String[] args) {
        TestInstance t = new TestInstance();
        t.method1(new Person());
        t.method1(new Student());
        t.method1(new Graduate());

    }
    public void method1(Person p){
        System.out.println(p.getInfo());
        System.out.println("=====");
        if(p instanceof Graduate){
            System.out.println("a graduated student");
        }
        if(p instanceof Student){
            System.out.println("a student");
        }
        if(p instanceof Person){
            System.out.println("a person");
        }
    }
}
class Person{
    protected String name = "person";
    protected int age = 50;
    public String getInfo(){
        return "Name: " + name + "\n" + "age: " + age;
    }
}

class Student extends Person{
    protected String school = "pku";
    public String getInfo(){
        return "Name: " + name + "\n" + "age: " + age + "\nschool: " + school;
    }
}

class Graduate extends Student{
    public String major = "TT";
    public String getInfo(){
        return "Name: " + name + "\n" + "age: " + age + "\nschool: " + school + "\nmajor: " + major;
    }
}
