/**
 * 实现水仙花数
 */

public class TestFor3 {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            int high = i / 100;  //得到百位
            int high1 = i % 100;
            int mid = high1 / 10; //得到十位
            int mid1= high1 % 10; //得到个位
            int num1 = high * high * high;
            int num2 = mid * mid *mid;
            int num3 = mid1 * mid1 * mid1;
            if(num1 + num2 + num3 == i){
                System.out.println(i);
            }
        }
    }
}
