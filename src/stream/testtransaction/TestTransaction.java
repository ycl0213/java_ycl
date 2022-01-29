package stream.testtransaction;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestTransaction {
    List<Transaction> transactions = new ArrayList<>();
    @Before
    public void befor(){

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        Transaction transaction1 = new Transaction(brian, 2011, 300);
        Transaction transaction2 = new Transaction(raoul, 2012, 1000);
        Transaction transaction3 = new Transaction(raoul, 2011, 400);
        Transaction transaction4 = new Transaction(mario, 2012, 710);
        Transaction transaction5 = new Transaction(mario, 2012, 700);
        Transaction transaction6 = new Transaction(alan, 2012, 950);
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);
        transactions.add(transaction5);
        transactions.add(transaction6);



    }

    //1. 找出2011年发生的所有交易， 并按交易额排序（从低到高）
    @Test
    public void test1(){
        transactions.stream()
                .filter(e -> e.getYear() == 2011)
                .sorted((e1, e2) -> -Integer.compare(e1.getValue(),e2.getValue()))  //从高到低
                .forEach(System.out::println);
        System.out.println("-------------");
        transactions.stream()
                .filter(e -> e.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue));//从低到高
    }

    //2. 交易员都在哪些不同的城市工作过？
    @Test
    public void test2(){
        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        System.out.println("---------");
        transactions.stream()
                .map((t) -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }

    //3. 查找所有来自剑桥的交易员，并按姓名排序
    @Test
    public void test3(){
        transactions.stream()
                .filter(t -> t.getTrader().getCity() == "Cambridge")
                .map(Transaction::getTrader)
                .sorted((t1, t2)-> t1.getName().compareTo(t2.getName()))
                .distinct()
                .forEach(System.out::println);
    }

    //4. 返回所有交易员的姓名字符串，按字母顺序排序
    @Test
    public void test4(){
        String collect = transactions.stream()
                .map(t -> t.getTrader().getName())
                .sorted()
                .collect(Collectors.joining(","));
        System.out.println(collect);
        System.out.println("----------");
        transactions.stream()
                .map(t -> t.getTrader().getName())
                .sorted()
                .forEach(System.out::println);

        System.out.println("----------");

        String str = transactions.stream()
                .map(t -> t.getTrader().getName())
                .sorted()
                .reduce("", String::concat);
        System.out.println(str);

        System.out.println("-----------");
        transactions.stream()
                .map(t -> t.getTrader().getName())
                .flatMap(TestTransaction::filterCharacter)
                .sorted(String::compareToIgnoreCase)
                .forEach(System.out::println);
    }

    //5. 有没有交易员是在米兰工作的？
    @Test
    public void test5(){
        boolean milan = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println(milan);
    }

    //6. 打印生活在剑桥的交易员的所有交易额
    @Test
    public void test6(){
        IntSummaryStatistics cambridge = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .collect(Collectors.summarizingInt(Transaction::getValue));
        System.out.println(cambridge.getSum());

        System.out.println("------------");
        Optional<Integer> cambridge1 = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(Integer::sum);
        System.out.println(cambridge1.get());
    }

    //7. 所有交易中，最高的交易额是多少
    @Test
    public void test7(){
        IntSummaryStatistics collect = transactions.stream()
                .collect(Collectors.summarizingInt(Transaction::getValue));
        System.out.println(collect.getMax());

        System.out.println("------------");
        Optional<Integer> first = transactions.stream()
                .map(Transaction::getValue)
                .sorted((v1,v2) -> -v1.compareTo(v2))
                .findFirst();
        System.out.println(first.get());

        System.out.println("----------");
        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo);
        System.out.println(max.get());
    }

    //8. 找到交易额最小的交易
    @Test
    public void test8(){
        Optional<Transaction> min = transactions.stream().sorted(Comparator.comparingInt(Transaction::getValue)).findFirst();
        System.out.println(min.get());

        System.out.println("------------");
        Optional<Transaction> min1 = transactions.stream().min((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()));
        System.out.println(min1.get());
    }

    public static Stream<String> filterCharacter(String str){
        List<String> list = new ArrayList<>();
        for(Character c : str.toCharArray()){
            list.add(c.toString());
        }
        return list.stream();
    }

}
