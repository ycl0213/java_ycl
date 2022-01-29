package lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class TestLambda {

    //语法格式一：无参数，无返回值
    @Test
    public void test1(){
        Runnable r = () -> System.out.println("Hello Lambda");
        r.run();
    }

    //语法格式二：有一个参数，并且无返回值
    @Test
    public void test2(){
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("Hello world!");
    }

    //语法格式三：有两个以上参数，有返回值，并且Lambda体中有多条语句
    @Test
    public void test3(){
        Comparator<Integer> com = (x,y) -> {
            System.out.println("Lambda体");
            return Integer.compare(x,y);
        };
    }

    //语法格式五：有两个以上的参数，有返回值，但是Lambda体中只有一条语句时，return和{}可以省略
    @Test
    public void test4(){
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
    }

    /**
     * Lambda表达式需要“函数式接口”的支持
     * 函数式接口：接口中只有一个抽象方法的接口，可以使用注解@FunctionalInterface修饰，可以检查是否是函数式接口
     */
    @Test
    public void test5(){
        Integer num = operation(100,x -> x * x);
        System.out.println(num);
    }
    public Integer operation(Integer num, MyFun myFun){
        return myFun.getValue(num);
    }

    /**
     * 练习1
     */
    List<Employee> emps = Arrays.asList(
            new Employee( "张三", 18, 9999.99),
            new Employee( "李四", 59, 6666.66),
            new Employee("王五", 8, 3333.33),
            new Employee( "赵六", 8, 7777.77),
            new Employee( "田七", 38, 5555.55)
    );
    @Test
    public void test6(){
        Collections.sort(emps,(e1, e2) -> {
         if(e1.getAge() == e2.getAge()){
             return e1.getName().compareTo(e2.getName());
         }else{
             return Integer.compare(e1.getAge(),e2.getAge());
         }
        });
        for(Employee employee : emps){
            System.out.println(employee);
        }

    }

    /**
     * 练习2
     */

    @Test
    public void test7(){
        String res = operation1("abcdef", s -> s.toUpperCase()); //转大写
        System.out.println(res);
        String subStr = operation1("JAVA嗯嗯嗯JAVA", s -> s.substring(4,7));//截取
        System.out.println(subStr);
        String res2 = operation1("addsd", String::toUpperCase);  //使用方法引用
        System.out.println(res2);
    }

    public String operation1(String str, MyFuntion my){
        return my.getValue(str);
    }

    /**
     * 练习3
     */

    @Test
    public void test8(){
        Long res1 = operation3(12L,13L, (x,y) -> x + y);
        System.out.println(res1);
        System.out.println("-----------");
        Long res2 = operation3(2L,5L,(x,y) -> x * y);
        System.out.println(res2);

        Long res3 = operation3(1L,2L,Long::sum);
        System.out.println(res3);

        Long res4 = operation3(1L,2L,Long::max);
        System.out.println(res4);
    }
    public Long operation3(long l1, long l2, MyFunction2<Long,Long> my){
        return my.Handle(l1,l2);
    }
}
