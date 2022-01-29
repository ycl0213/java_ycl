package extend;

class Kids extends ManKind {
    private int yearsOld;

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void printYearsOld(){
        System.out.println(yearsOld);
    }

    //重写父类的employeed()方法
    public void employeed(){
        System.out.println("Kids should study!");
    }
}
public class TestKids{
    public static void main(String[] args) {
        Kids someKids = new Kids();
        someKids.setSex(0);
        someKids.setSalary(1);
        someKids.setYearsOld(24);
        someKids.manOrWoman();
        someKids.employeed();
        someKids.printYearsOld();
    }
}