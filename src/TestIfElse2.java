import java.util.Scanner;

public class TestIfElse2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入身高（cm）： ");
        int high = s.nextInt();
        System.out.println("请输入财富（千万）：");
        double money = s.nextDouble();
        System.out.println("帅否：");
        boolean handsome = s.hasNextBoolean();
        if(high > 180 & money > 1 & handsome){
            System.out.println("嫁");
        }
        else if(high > 180 || money > 1 || handsome){
            System.out.println("还可以");
        }else{
            System.out.println("不嫁");
        }
    }
}
