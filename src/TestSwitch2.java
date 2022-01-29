import java.util.Scanner;

/**
 * 学生成绩大于等于60分，输出合格，低于60分，输出不合格
 */
public class TestSwitch2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int score = s.nextInt();
        int judge = score >= 60 ? 1 : -1;
        switch (judge){
            case 1:
                System.out.println("合格");
                break;
            case -1:
                System.out.println("不合格");
                break;
            default:
                System.out.println("有误");
                break;
        }
    }
}
