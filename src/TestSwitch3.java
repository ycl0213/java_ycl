import java.util.Scanner;

public class TestSwitch3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int month = s.nextInt();
        switch (month){
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("冬季");
                break;
            default:
                System.out.println("输入有误！");
                break;
        }
    }
}
