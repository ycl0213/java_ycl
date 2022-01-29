package extend;

public class TestDog {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.setAge(10);
        d.setName("花花");
        d.setHostName("小明");
        System.out.println("name: " + d.getName() + ", age: " + d.getAge() + ", hostName: " + d.getHostName());
    }

}
//生物类
class Creator{
    private int age;

    public Creator() {
        System.out.println("this is Creator's constructor");
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
class Animal extends Creator{
    private String name;

    public Animal() {
        System.out.println("this is Animal's constructor");
    }
//    public Animal(String name){
//        this.name = name;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
class Dog extends Animal{
    private String hostName;

    public Dog() {
        System.out.println("this is Dog's constructor");
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHostName() {
        return hostName;
    }
}
