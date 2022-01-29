package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamExercise {
    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream()
                .map(x -> x * x)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Test
    public void test2(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Optional<Integer> reduce = list.stream().map(x -> 1).reduce(Integer::sum);  //使用map和reduce实现计算流中元素总数
        System.out.println(reduce.get());
    }

}
