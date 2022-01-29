import java.util.HashMap;
import java.util.Map;

/**
 * 打印出1-100的质数
 */
public class TestPrimeNumber {
    public static void main(String[] args) {

        /**
         * 方法1
         */
        int sum  = 0;
        for (int i = 2; i <= 100; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if(i % j == 0){
                    count++;
                }
            }
            if (count == 2) {
                sum += i;
                System.out.println(i);
            }
        }
        System.out.println(sum);

        /**
         * 方法2
         */
//        for (int i = 2; i <= 100 ; i++) {
//            boolean flag = false;
//            for (int j = 2; j < Math.sqrt(i); j++) {  //使用Math.sqrt(i)可提升速度
//                if (i % j == 0) {
//                    flag = true;
//                    break;
//                }
//            }
//            if(!flag){
//                System.out.println(i);
//            }
//        }

    }
}

