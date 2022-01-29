import java.util.Scanner;

public class TestSwitch4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入月份： ");
        int month = s.nextInt();
        System.out.println("请输入日期： ");
        int day = s.nextInt();
        int sum = 0;//记录第几天
        switch (month){
            case 12:
                sum += 30;
            case 11:
                sum += 31;
            case 10:
                sum += 30;
            case 9:
                sum += 31;
            case 8:
                sum += 31;
            case 7:
                sum += 30;
            case 6:
                sum += 31;
            case 5:
                sum += 30;
            case 4:
                sum += 31;
            case 3:
                sum += 28;
            case 2:
                sum += 31;
            case 1:
                sum += day;
        }
        System.out.println(sum);
    }
}
