package testIO;

import org.junit.Test;
import java.io.*;

public class TestObjectInputOutputStream {
    //对象的反序列化过程：将硬盘中的文件通过ObjectInputStream转换为相应的对象
    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("person.txt")));
            Person p1 = (Person)ois.readObject();
            System.out.println(p1);
            Person p2 = (Person)ois.readObject();
            System.out.println(p2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //对象的序列化过程：将内存中的对象通过ObjectOutputStream转换成二进制流，存储在硬盘文件中
    @Test
    public void testObjectOutputStream(){
        Person p1 = new Person("小明",23, new Pet("花花"));
        Person p2 = new Person("小化",21, new Pet("小花"));
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("person.txt")));
            oos.writeObject(p1);
            oos.writeObject(p2);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

/**
 * 要实现序列化的类必须具备的条件：
 * 1、要求此类是可序列化的：实现Serializable接口;
 * 2、要求此类的属性也同样需要实现Serializable接口；
 * 3、凡是实现Serializable接口的类都有一个表示序列化版本标识符的静态变量：
 *      private static final long serialVersionUID;
 * 4、ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量；
 */
class Person implements Serializable {
    private static final long serialVersionUID = 325235322L;
    private String name;
    private Integer age;
    private Pet pet;

    public Person(String name, Integer age,Pet pet) {
        this.name = name;
        this.age = age;
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pet=" + pet +
                '}';
    }
}
class Pet implements Serializable{
    private static final long serialVersionUID = 24124124L;
    private String name;

    public Pet(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }
}