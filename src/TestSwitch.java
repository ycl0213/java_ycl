import java.util.Scanner;

public class TestSwitch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int score = input.nextInt();
        if(score < 0 || score > 100){
            System.out.println("输入有误，请重新输入： ");
        }
        switch (score / 10){
            case 9:
                System.out.println("A");
                break;
            case 8:
            case 7:
                System.out.println("B");
                break;
            case 6:
                System.out.println("C");
                break;
            default:
                System.out.println("D");
        }
    }
}
