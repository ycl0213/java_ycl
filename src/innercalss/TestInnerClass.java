package innercalss;

public class TestInnerClass {
    public static void main(String[] args) {
        // 创建static的内部类的对象：可以直接通过外部类调用静态内部类的构造器
        Person.Dog d = new Person.Dog();
        //创建非static的内部类对象：先要创建外部类的对象，通过外部类的对象调用内部类的构造器
        Person p = new Person();
        Person.Bird b = p.new Bird();
        b.method();
        b.setName("黄鹂");
    }


}

class Person{
    String name = "小花";
    int age;
    //成员内部类（非static的）
    class Bird{
        String name = "杜鹃";
        int id;
        public Bird(){
        }
        public void method(){
            show();
        }

        public void setName(String name) {
            System.out.println(name); // 黄鹂
            System.out.println(this.name);// 杜鹃
            System.out.println(Person.this.name);//小花  调用Person对象的属性
        }
    }

    //成员内部类（static的）
    static class Dog{

    }

    public void show(){
        System.out.println("我是show()方法");
    }
}
