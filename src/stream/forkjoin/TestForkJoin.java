package stream.forkjoin;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class TestForkJoin {
    @Test
    public void test1(){
        long startTime = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0,100000000L);
        Long sum = pool.invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        System.out.println(sum);
    }

    //java8并行流
    @Test
    public void test2(){
        Instant start = Instant.now();
        LongStream.rangeClosed(0,100000000000L)
                .parallel()
                .reduce(0,Long::sum);

        Instant end = Instant.now();
        System.out.println("耗费时间为： " + Duration.between(start,end).toMillis());
    }
}
