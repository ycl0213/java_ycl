
import java.util.Scanner;

public class TestArray3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();//读入学生人数
        int[] scores = new int[num];
        int max_score = 0;
        for (int i = 0; i < scores.length; i++) {
            scores[i] = s.nextInt();  //依次读入学生成绩
            if(scores[i] > max_score){
                max_score = scores[i];  //获取最高分
            }
        }

        System.out.println("最高分为： " + max_score);
        char level;
        for (int i = 0; i < scores.length; i++) {
            if(scores[i] >= max_score - 10){
                level = 'A';
            }else if(scores[i] >= max_score - 20){
                level = 'B';
            }else if(scores[i] >= max_score - 30){
                level = 'C';
            }else{
                level = 'D';
            }
            System.out.println("student " + i + " score is " + scores[i] + " grade is " + level);
        }


    }
}
