package testset;

import org.junit.Test;
import sun.plugin2.message.CustomSecurityManagerAckMessage;

import java.util.*;

public class TestSet {
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("BB");
        set.add("BB");  //不可重复性
        set.add(null); //可以添加null
        set.add(new Person("小花",21)); //必须重写Person类中的equals()方法和hashcode()方法
        set.add(new Person("小花",21));
        System.out.println(set.size());
        System.out.println(set);
    }

    //TreeSet的自然排序
    @Test
    public void testTreeSet(){
        Set set = new TreeSet();
//        set.add(123);
//        set.add(234);
//        set.add("456");
//        System.out.println(set);

//        set.add("123");
//        set.add("456");
//        set.add("AA");
//        set.add("BB");

        //出错：java.lang.ClassCastException: testset.Person cannot be cast to java.lang.Comparable
        //当Person类没有实现Comparable接口时，向TreeSet中添加对象会报错，需要定义的类实现Comparable接口并重写compareTo()方法
        set.add(new Person("CC",21));
        set.add(new Person("MM",22));
        set.add(new Person("DD",22));
        set.add(new Person("DD",26));
        for(Object o : set){
            System.out.println(o);
        }
    }
    //TreeSet的定制排序:
    //1、创建一个实现了Comparator接口的类对象
    //2、在TreeSet中添加Customer对象，在此compare方法中指明按照Customer的哪个属性进行比较
    //3、将此对象作为形参传递给TreeSet的构造器中
    @Test
    public void testTreeSet2(){
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Customer && o2 instanceof Customer){
                    Customer c1 = (Customer)o1;
                    Customer c2 = (Customer)o2;
                    int i = c1.getId().compareTo(c2.getId());
                    if(i == 0){
                        return c1.getName().compareTo(c2.getName());
                    }
                    return i;
                }
                return 0;
            }
        };

        Set set = new TreeSet(com);  //将此对象作为形参传递给TreeSet的构造器中
        set.add(new Customer("EE",11));
        set.add(new Customer("DE",12));
        set.add(new Customer("CC",21));
        set.add(new Customer("AA",12));
        for(Object o : set){
            System.out.println(o);
        }

    }
}

class Person implements Comparable{
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) &&
                age.equals(person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    //重写compareTo()方法，指定Person中按照哪个属性进行排序
    @Override
    public int compareTo(Object o) {
        if(o instanceof Person){
            Person p = (Person)o;
            //return this.name.compareTo(p.name); //按照Person类中name属性进行排序
            //return this.age.compareTo(p.age); //这种方法会导致添加的对象若改属性相同则被认为对象相同，只会添加一个

            //先比较age，age相同再比较name
            int i = this.age.compareTo(p.age);
            if(i == 0){
                return this.name.compareTo(p.name);
            }
            return i;
        }
        return 0;
    }
}
