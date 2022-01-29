package TestOOP;

public class Boy {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public void marry(Girl girl){
        System.out.println("我要娶： " + girl.getName());
        girl.marry(this);
    }
    public void shout(){
        if(age > 22){
            System.out.println("到了结婚的年龄！");
        }else{
            System.out.println("再等等");
        }
    }
}
