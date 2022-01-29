package testinterface;

public class TestInterface {
    public static void main(String[] args) {
        TestInterface t = new TestInterface();
        t.test1(new Duck());
        t.test2(new Duck());
    }

    //接口与具体的实现类之间也存在多态性
    public void test1(Runner r){
        r.run();
    }
    public void test2(Swimmer s){
        s.swim();
    }
}
//接口
interface Runner{
    public abstract void run();
}

interface Swimmer{
    void swim();
}

interface Flier{
    void fly();
}
//类实现接口
class Duck implements Runner,Swimmer,Flier{
    public void run(){
        System.out.println("丑小鸭走路");
    }

    @Override
    public void swim() {
        System.out.println("丑小鸭游泳");

    }

    @Override
    public void fly() {
        System.out.println("丑小鸭飞");
    }
}