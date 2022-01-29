package polymorphism;

import com.sun.deploy.uitoolkit.impl.awt.AWTAnimationPanel2;

public class TestAnimal {
    public static void main(String[] args) {
        TestAnimal t = new TestAnimal();
        t.fun(new Animal()); //向上转型
        t.fun(new Dog());
        t.fun(new Cat());
    }
    public void fun(Animal a){
        a.eat();
        a.jump();
        //使用instanceof判断是否是类的一个实例对象
        if(a instanceof Dog){
            ((Dog) a).wang(); //向下转型
        }
        if(a instanceof Cat){
            ((Cat) a).catchMouse();
        }
    }
}
class Animal{
    private String name;
    private int age;
    public void eat(){
        System.out.println("进食");
    }
    public void jump(){
        System.out.println("跳");
    }
}

class Dog extends Animal{
    public void eat(){
        System.out.println("狗吃食");
    }
    public void jump(){
        System.out.println("狗急跳墙");
    }
    public void wang(){
        System.out.println("狗叫");
    }
}

class Cat extends Animal{
    public void eat(){
        System.out.println("猫吃鱼");
    }
    public void jump(){
        System.out.println("猫跳");
    }
    public void catchMouse(){
        System.out.println("猫抓老鼠");
    }
}
