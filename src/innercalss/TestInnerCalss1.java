package innercalss;

public class TestInnerCalss1 {
}

class OuterClass{
   public Comparable getComparable(){
       //1、创建一个实现Comparable接口的类：局部内部类
       class MyComparable implements Comparable{

           @Override
           public int compareTo(Object o) {
               return 0;
           }
       }
       //2、返回一个实现类的对象
       return new MyComparable();
   }

   public Comparable getComparable1(){
       //创建匿名内部类
       return new Comparable() {
           @Override
           public int compareTo(Object o) {
               return 0;
           }
       };
   }
}
