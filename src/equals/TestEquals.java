package equals;

import java.util.Objects;

public class TestEquals {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        System.out.println(p1 == p2);//false
        System.out.println(p1.equals(p2));

    }

}
class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

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

    //重写equals()方法：
//    public boolean equals(Object obj){
//        if(this == obj){
//            return true;
//        }
//        if(obj instanceof Person){
//            Person p = (Person)obj;
//            return this.age == p.age && this.name == p.name;
//        }else{
//            return false;
//        }
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

