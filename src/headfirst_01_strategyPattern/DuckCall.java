package headfirst_01_strategyPattern;

public class DuckCall extends Duck{
    @Override
    public void display() {
        System.out.println("duckCall");
    }
    public DuckCall(){
        quackBehavior = new DuckCallQuck();
    }
}
