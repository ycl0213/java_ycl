package testabstract;

public class TestEmployee {
    public static void main(String[] args) {
        Manager m = new Manager("小张", "001", 15000, 2000);
        m.work();
        CommonEmployee c = new CommonEmployee("小王", "002", 12000);
        c.work();
    }
}

abstract class Employee{
    private String name;
    private String id;
    private double salary;

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }
    //抽象方法
    public abstract void work();
}

//Manager类
class Manager extends Employee{
    private double bonus;

    public Manager(String name, String id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void work(){
        System.out.println("Manager work()");
    }

}
//CommonEmployee类
class CommonEmployee extends Employee{
    public CommonEmployee(String name, String id, double salary) {
        super(name, id, salary);
    }
    public void work(){
        System.out.println("CommonEmployee work()");
    }
}
