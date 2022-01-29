package headfirst_01_strategyPattern;

public class ModelDuck extends Duck{
    @Override
    public void display() {
        System.out.println("I’m a model duck");
    }
    public ModelDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }
}
