package testmap;

import org.junit.Test;
import testset.Customer;

import java.io.*;
import java.util.*;

public class TestMap {
    @Test
    public void test1(){
        Map m = new HashMap();
        m.put("AA", 123);
        m.put("BB",456);
        m.put(null, null);
        m.put(123,"CC");
        m.put(new Person("DD",23), 233);

        //1、遍历Key集
        Set keys = m.keySet();
        for(Object o : keys){
            System.out.println(o);
        }
        System.out.println("========");
        //2、遍历value集
        Collection values = m.values();
        Iterator iterator = values.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("===== ");
        //3、遍历key-value对
        //3.1 使用Set map.keySet();
        Set set1 = m.keySet();
        for (Object obj : set1){
            System.out.println(obj + " = " + m.get(obj));
        }
        System.out.println("======");
        //3.2、使用Set entrySet()
        Set set2 = m.entrySet();
        for(Object obj : set2){
            Map.Entry entry = (Map.Entry)obj;
            //System.out.println(entry.getKey() + " = " + entry.getValue());
            System.out.println(entry);
        }
    }

    @Test
    public void testTreeMap(){
        //与TreeSet类似
    }

    //使用properties处理属性文件
    @Test
    public void testPropertier() throws IOException {
        Properties pro = new Properties();
        pro.load(new FileInputStream(new File("test.properties"))); //读取文件中的属性
        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        System.out.println(user);
        System.out.println(password);
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
