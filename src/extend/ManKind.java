package extend;

public class ManKind {
    private int sex;//1:男  0：女
    private int salary;

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSex() {
        return sex;
    }

    public int getSalary() {
        return salary;
    }

    public void manOrWoman(){
        if(sex == 1){
            System.out.println("性别为: man");
        }else{
            System.out.println("性别为： woman");
        }
    }
    public void employeed(){
        if(salary == 0){
            System.out.println("no job");
        }else{
            System.out.println("job");
        }
    }
}
