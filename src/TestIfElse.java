import java.util.Scanner;

/**
 * 求三个数中的最大值
 */
public class TestIfElse {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num1 = s.nextInt();
        int num2 = s.nextInt();
        int num3 = s.nextInt();
        if(num1 > num2 & num1 > num3){
            System.out.println("最大值为: " + num1);
        }else if(num1 > num3){
            System.out.println("最大值为： " + num2);
        }else if(num2 > num3){
            System.out.println("最大值为： " + num2);
        } else{
            System.out.println("最大值为： " + num3);
        }
    }
}
