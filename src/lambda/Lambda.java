package lambda;

import org.junit.Test;

import java.time.Instant;
import java.util.*;

public class Lambda {
    //原来的匿名内部类
    @Test
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(com);
    }

    //lambda表达式
    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }


    List<Employee> emps = Arrays.asList(new Employee("张一", 23, 5555),
            new Employee("张二", 45, 7777),
            new Employee("张三", 35, 6666),
            new Employee("张四", 56, 8888),
            new Employee("张五", 43, 6666));

    //获取当前公司中员工年龄大于35的员工信息

    /**
     * 优化方式一：策略设计模式
     *
     * @param list
     * @return
     */
    public List<Employee> filterEmployees1(List<Employee> list, MyPredicate<Employee> mp) {
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : list) {
            if (mp.test(employee)) {
                employees.add(employee);
            }
        }
        return employees;
    }


    @Test
    public void test3() {
        List<Employee> list = filterEmployees1(emps, new FilterEmployeeByAge());  //按年龄过滤
        for (Employee employee : list) {
            System.out.println(employee);
        }

        System.out.println("------------");
        List<Employee> list1 = filterEmployees1(emps, new FilterEmployeeBySalary());
        for (Employee employee : list1) {
            System.out.println(employee);
        }
    }

    /**
     * 优化方式二：匿名内部类
     */
    @Test
    public void test4() {
        List<Employee> list = filterEmployees1(emps, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() >= 7000;
            }
        });
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    /**
     * 优化方式三：lambda表达式
     */

    @Test
    public void test5() {
        List<Employee> list = filterEmployees1(emps, e -> e.getSalary() <= 6000);
        list.forEach(System.out::println);

    }

    /**
     * 优化方式五：stream API
     */
    @Test
    public void test6(){
        emps.stream().
                filter(e -> e.getSalary() >= 7000)
                .forEach(System.out::println);
    }
}
