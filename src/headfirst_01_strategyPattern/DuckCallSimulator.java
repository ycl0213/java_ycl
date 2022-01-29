package headfirst_01_strategyPattern;

public class DuckCallSimulator {
    public static void main(String[] args) {
        Duck duckcall = new DuckCall();
        duckcall.setQuackBehavior(new DuckCallQuck());
        duckcall.performQuack();
    }
}
