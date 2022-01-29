package TestOOP;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class TestPerson {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "张三";
        p1.age = 18;
        p1.sex = "男";
        System.out.println("姓名为： " + p1.name + " 年龄为： " + p1.age + " 性别为： " + p1.sex);
        System.out.println("============");
        p1.addAge(2);
        System.out.println("修改后年龄为： " + p1.age);
        System.out.println("----------");
        Person p2 = new Person();
        p2.addAge(5);
        System.out.println("p2年龄为: " + p2.age);
        System.out.println("p2姓名为： " + p2.name);
    }


}


class Person{
    String name;
    int age;
    String sex;
    public void study(){
        System.out.println("studing");
    }

    public int showAge(){
        return age;
    }
    public void addAge(int i){
        age += i;
    }

}