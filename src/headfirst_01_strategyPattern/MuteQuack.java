package headfirst_01_strategyPattern;

public class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
