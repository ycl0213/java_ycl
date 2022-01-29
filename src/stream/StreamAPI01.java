package stream;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;
import org.junit.runner.notification.RunListener;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream的三个步骤：
 * 1、创建stream
 * 2、中间操作
 * 3、终止操作（终端操作）
 */
public class StreamAPI01 {

    @Test
    public void test1(){
        //创建stream
        //1、可以通过Collection系列集合提供的stream()方法或parallelstream()方法
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2、通过Arrays中的静态方法stream()获取数组流
        Integer[] integers = new Integer[10];
        Stream<Integer> stream2 = Arrays.stream(integers);

        //3、通过Stream类中的静态方法of()创建流
        Stream<String> stream3 = Stream.of("aa","bb","cc");

        //4、创建无限流
        //(1)迭代：
        Stream<Integer> stream4 = Stream.iterate(0,x -> x+2);

        //中间操作+终止操作
        stream4.limit(10).forEach(System.out::println);

        //(2)生成：
        Stream.generate(() -> Math.random()).
                limit(10).
                forEach(System.out::println);
    }


    /**
     * 2、中间操作
     */

    List<Employee> employee = Arrays.asList(
            new Employee("张一", 23, 8000, Employee.Status.BUSY),
            new Employee("张二",45,67756, Employee.Status.FREE),
            new Employee("张三",65,23444, Employee.Status.VOCATION),
            new Employee("张五", 34,4500, Employee.Status.BUSY),
            new Employee("张六", 34,4500, Employee.Status.FREE),
            new Employee("张五", 34,4500, Employee.Status.BUSY),
            new Employee("张五", 34,4500, Employee.Status.VOCATION)
    );
    @Test
    public void test2(){

        //内部迭代：迭代操作有Stream API完成
        //中间操作：不会执行任何操作
        Stream<Employee> stream = employee.stream().filter(e -> {
            System.out.println("Stream API");
            return e.getAge() > 30;
        });

        //终止操作：执行全部内容
        stream.forEach(System.out::println);

    }

    //外部迭代：
    @Test
    public void test3(){
        Iterator<Employee> iterator = employee.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //limit
    @Test
    public void test4(){
        employee.stream().filter(e -> e.getSalary() > 5000)
                .limit(2)
                .forEach(System.out::println);
    }

    //skip
    //diatinct
    @Test
    public void test5(){
        employee.stream().filter(e -> e.getSalary() > 3000)
                .skip(2)
                .distinct()
                .forEach(System.out::println);
    }

    //map
    @Test
    public void test6(){
        List<String> list = Arrays.asList("fff", "lll", "aaa","bbb","ccc","ddd");
        list.stream().map(str -> str.toUpperCase())
                .forEach(System.out::println);

        employee.stream().map(Employee::getName)
                .forEach(System.out::println);

        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPI01::filterStream);
        streamStream.forEach(s -> s.forEach(System.out::println));


        //使用flatmap
        Stream<Character> characterStream = list.stream().flatMap(StreamAPI01::filterStream);
        characterStream.forEach(System.out::println);
    }

    //sorted()  ----自然排序
    //sorted(Comparator com) ----定制排序
    @Test
    public void test7(){
        List<String> list = Arrays.asList("fff", "lll", "aaa","bbb","ccc","ddd");
        list.stream().sorted().forEach(System.out::println);
        employee.stream().sorted((e1, e2) -> {
            if(e1.getAge().equals(e2.getAge())){
                return e1.getName().compareTo(e2.getName());
            }else{
                return e1.getAge().compareTo(e2.getAge());
            }
        }).forEach(System.out::println);
    }

    public static Stream<Character> filterStream(String str){
        List<Character> list = new ArrayList<>();
        for(Character c: str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }


    /**
     * Stream()的终止操作：
     * 1、查找与匹配
     */

    // allMatch()：检查是否匹配所有元素
    @Test
    public void test8(){
        boolean b = employee.stream().allMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);
    }

    //anyMatch():检查是否至少匹配一个元素
    @Test
    public void test9(){
        boolean b1 = employee.stream().anyMatch(e -> e.getStatus().equals(Employee.Status.VOCATION));
        System.out.println(b1);
    }

    //noneMatch():检查是否没有匹配所有元素
    @Test
    public void test10(){
        boolean b3 = employee.stream().noneMatch(e -> e.getStatus().equals(Employee.Status.VOCATION));
        System.out.println(b3);
    }

    //findFirst():返回第一个元素  返回类型为Optional<T>
    @Test
    public void test11(){
        Optional<Employee> first = employee.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .findFirst();
        System.out.println(first.get());
    }

    //findAny()：返回当前流中的任意元素  返回类型为Optional<T>
    @Test
    public void test12(){
        Optional<Employee> any = employee.parallelStream()
                .filter(e -> e.getStatus().equals(Employee.Status.FREE))
                .findAny();
        System.out.println(any.get());
    }

    //count():返回流中元素的总个数
    @Test
    public void test13(){
        long count = employee.stream().count();
        System.out.println(count);
    }

    //max()：返回流中最大值   返回类型为Optional<T>
    @Test
    public void test14(){
        Optional<Employee> max = employee.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(max.get());
    }

    //min()：返回流中最小值    返回类型为Optional<T>
    @Test
    public void test15(){
        Optional<Double> min = employee.stream().map(Employee::getSalary).min(Double::compareTo);
        System.out.println(min.get());

        Optional<Employee> min1 = employee.stream().min(Comparator.comparingInt(Employee::getAge));
        System.out.println(min1.get());
    }

    /**
     * 2、归约： reduce
     */

    @Test
    public void test16(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        Integer reduce = list.stream().reduce(0, Integer::sum);  // x = 0; y = 1; x = x + y; y = 2;.....
        System.out.println(reduce);

        Optional<Double> reduce1 = employee.stream().map(Employee::getSalary).reduce(Double::sum);  //这种情况下没有起始值会存在为空的情况，因此返回为Optional
        System.out.println(reduce1.get());
    }

    /**
     * 收集：collect——将流转换为其他形式，接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
     */
    @Test
    public void test17(){
        List<String> name = employee.stream().map(Employee::getName).collect(Collectors.toList());
        name.forEach(System.out::println);

        System.out.println("--------------");
        employee.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet())
                .forEach(System.out::println);  //去重

        System.out.println("-------------");
        employee.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new))
                .forEach(System.out::println);  //收集到指定

        System.out.println("----------");
        Long number = employee.stream().collect(Collectors.counting());  //收集流中元素的总数
        System.out.println(number);

        System.out.println("-----------");
        Double avge = employee.stream().collect(Collectors.averagingDouble(Employee::getSalary));  //获取平均值
        System.out.println(avge);

        System.out.println("------------");
        Double sum = employee.stream().mapToDouble(Employee::getSalary).sum();  //获取总和
        System.out.println(sum);

        System.out.println("--------------");
        Optional<Employee> max = employee.stream().collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))); //获取最大值
        System.out.println(max.get());

        System.out.println("--------------");
        Optional<Double> min1 = employee.stream().map(Employee::getSalary).collect(Collectors.minBy(Double::compareTo));  //获取最小值
        System.out.println(min1.get());

        System.out.println("--------------");
        DoubleSummaryStatistics collect = employee.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect.getMax()); //获取工资的最大值
        System.out.println(collect.getAverage()); //获取工资的平均值
        System.out.println(collect.getMin());//获取工资的最小值
        System.out.println(collect.getSum());//获取工资的总和


        System.out.println("---------");
        String str = employee.stream().map(Employee::getName).collect(Collectors.joining(","));//将姓名链接为字符串
        System.out.println(str);
    }

    /**
     * 分组:groupingBy()
     * 多级分组
     */
    @Test
    public void test18(){
        Map<Employee.Status, List<Employee>> map = employee.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);

        Map<Employee.Status, Map<String, List<Employee>>> collect = employee.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(e -> {
            if (e.getAge() <= 35) {
                return "青年";
            } else if (e.getAge() <= 60) {
                return "中年";
            } else {
                return "老年";
            }
        })));  //多级分组
        System.out.println(collect);
    }

    /**
     * 分区：满足条件的为一个区，不满足条件的为另一个区
     */
    @Test
    public void test19(){
        Map<Boolean, List<Employee>> collect = employee.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 8000));  //分区
        System.out.println(collect);
    }
}


class Employee{
    private String name;
    private Integer age;
    private Double salary;
    private Status status;

    public Employee(String name, int age, double salary, Status status) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", status=" + status +
                '}';
    }

    public enum Status{
        FREE,
        BUSY,
        VOCATION
    }
}
