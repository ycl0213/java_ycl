package headfirst_01_strategyPattern;

public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("I’m flying!!");
    }
}
