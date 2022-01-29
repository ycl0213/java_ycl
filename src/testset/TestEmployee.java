package testset;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class TestEmployee {
    public static void main(String[] args) {
        //方式一：(自然排序)Employee实现Comparable接口，并按name排序
        Set<Employee> set = new TreeSet();
        set.add(new Employee("小花", 22, new MyDate(1990, 2, 1)));
        set.add(new Employee("小名", 22, new MyDate(1989, 3, 12)));
        set.add(new Employee("小花", 21, new MyDate(1991, 12, 11)));
        set.add(new Employee("小崔", 24, new MyDate(1987, 2, 16)));
        set.add(new Employee("小兰", 20, new MyDate(1995, 6, 18)));
        for(Object o : set){
            System.out.println(o);
        }

        System.out.println("========");
        //方式二：（定制排序）创建TreeSet时传入Comparator对象，按生日日期的先后排序
        Set<Employee> set1 = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee)o1;
                    Employee e2 = (Employee)o2;
                    int i = e1.getBirthday().getYear() - e2.getBirthday().getYear();
                    if(i == 0){
                        int j = e1.getBirthday().getMonth() - e2.getBirthday().getMonth();
                        if(j == 0){
                            return e1.getBirthday().getDay() - e2.getBirthday().getDay();
                        }
                        return j;
                    }
                    return i;
                }
                return 0;
            }
        });
        set1.add(new Employee("小花", 22, new MyDate(1990, 2, 1)));
        set1.add(new Employee("小名", 22, new MyDate(1989, 3, 12)));
        set1.add(new Employee("小花", 21, new MyDate(1989, 3, 13)));
        set1.add(new Employee("小名", 21, new MyDate(1995, 3, 13)));
        set1.add(new Employee("小兰", 20, new MyDate(1995, 6, 18)));
        for(Object o : set1){
            System.out.println(o);
        }
    }
}

class Employee implements Comparable{
    private String name;
    private Integer age;
    private MyDate birthday;

    public Employee(String name, Integer age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday.toString() +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Employee){
            Employee e = (Employee)o;
            int i = this.name.compareTo(e.name);
            if(i == 0){
                return this.age.compareTo(e.age);
            }
            return i;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name) &&
                age.equals(employee.age) &&
                birthday.equals(employee.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, birthday);
    }
}

class MyDate{
    private int year;
    private int month;
    private int day;

    public MyDate(int yeat, int month, int day) {
        this.year = yeat;
        this.month = month;
        this.day = day;
    }

    public void setYear(int yeat) {
        this.year = yeat;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "yeat=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year &&
                month == myDate.month &&
                day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}
