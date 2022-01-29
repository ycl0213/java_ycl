package TestOOP;


public class TestConstructor {
    public static void main(String[] args) {
        Person3 p3 = new Person3(18);
        Person3 p31 = new Person3("小明",21);
        System.out.println(p3.getAge());
        System.out.println("姓名为： " + p31.getName() + " 年龄为： " +p31.getAge());

        System.out.println("========");
        Person3 p32 = new Person3("小华", 18, "正才中学");
        System.out.println(p32.getName() + "的学校为： " + p32.getSchool());
        Person3 p33 = new Person3("小军", 21 ,"泉水高中一中", "物理");
        System.out.println(p33.getName() + "的学校为： " + p33.getSchool() + ", 主修: " + p33.getMajor());
    }


}

class Person3{
    private int age;
    private String name;
    private String school;
    private String major;
    //构造器
    public Person3(int a){
        age = a;
    }
    public Person3(String n, int a){
        name = n;
        age = a;
    }
    public Person3(String n, int a, String s){
        name = n;
        age = a;
        school = s;

    }
    public Person3(String n, int a, String s, String m){
        name = n;
        age = a;
        school = s;
        major = m;

    }
    public int getAge() {
        return age;
    }
    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
    public String getSchool(){
        return school;
    }
    public String getMajor(){
        return major;
    }
}
