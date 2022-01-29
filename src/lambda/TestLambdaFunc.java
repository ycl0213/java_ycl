package lambda;

import org.jcp.xml.dsig.internal.dom.DOMUtils;
import org.junit.Test;

import java.util.*;
import java.util.function.*;

/**
 * java8内置的函数式接口
 */
public class TestLambdaFunc {
    /**
     * 1、Consumer<T>接口
     */
    @Test
    public void test1(){
        happy(1000L,x -> System.out.println("消费了：" + x + "元"));

        //使用方法引用
        happy(1000,System.out::println);
        System.out.println("---------");

        //对象::实例方法名
        Employee employee = new Employee();
        Supplier<Integer> sup = employee::getAge;
        System.out.println(sup.get());
    }
    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }

    /**
     * Supplier<T>接口
     */
    @Test
    public void test2(){
        List<Integer> list = getNumList(6,() -> (int)(Math.random() * 100));
        System.out.println(list);
    }

    //产生指定个数的整数，放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < num; i++){
            list.add(sup.get());
        }
        return list;
    }

    /**
     * Function<T，R>接口
     */
    @Test
    public void test3(){
        String res = strHandler("asdfccd", str -> str.substring(2,5));
        String res1 = strHandler("\t\t\t\t lalalala\n",str-> str.trim()); //去除首尾空格
        System.out.println(res);
        System.out.println(res1);
    }
    public String strHandler(String str, Function<String,String> fun){
        return fun.apply(str);
    }

    /**
     * Predicate<T>接口
     */

    @Test
    public void test4(){
        List<String> list = getStrValue(Arrays.asList("ada","afaafas","wwqr","hello","sa"), str -> str.length() >= 3);  //过滤出字符串长度大于等于3的
        System.out.println(list);
    }

    //将满足条件的字符串放入到集合中
    public List<String> getStrValue(List<String> strList, Predicate<String> pre){
        List<String> list = new ArrayList<>();
        for(String str : strList){
            if(pre.test(str)){
                list.add(str);
            }
        }
        return list;
    }

    /**
     * 类::静态方法名
     */
    @Test
    public void test5(){
        Comparator<Integer> com = Integer::compareTo;
        System.out.println(com.compare(12,13));

    }

    /**
     * 类::实例方法名
     */

    @Test
    public void test6(){
        BiPredicate<String,String> biPredicate = String::equals;  //类::实例方法名
        System.out.println(biPredicate.test("ad", "sa"));
    }

    /**
     * 构造器引用
     */

    @Test
    public void test7(){
        Supplier<Employee> sup = () -> new Employee();

        Supplier<Employee> sup1  = Employee::new; //构造器引用
        System.out.println(sup1.get());
    }

    /**
     * 数组引用
     */
    @Test
    public void test8(){
        Function<Integer, String[]> fun = (x) -> new String[x];
        String[] arrStr = fun.apply(4);
        for(String str : arrStr){
            System.out.println(str);
        }

        //使用数组引用
        Function<Integer, String[]> fun1 = String[]::new;
        System.out.println(fun1.apply(12).length);
    }
}
