package TestOOP;

public class TestPerson2 {
    public static void main(String[] args) {
        Person2 p2 = new Person2();
        p2.setAge(45);
        System.out.println(p2.getAge());
    }


}

class Person2{
    private int age;
    public void setAge(int a){
        if(a > 0 && a < 130) {
            age = a;
        }else{
            System.out.println("错误！！");
        }
    }
    public int getAge(){
        return age;
    }
}
