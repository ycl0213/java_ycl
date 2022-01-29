package headfirst_01_strategyPattern;

public class DuckCallQuck implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("duckCall Quack!");
    }
}
