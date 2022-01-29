package wrapper;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class WrapperExercise {
    public static void main(String[] args) {
        Vector vector = new Vector();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生的成绩：（以负数结束）");
        Integer score = scanner.nextInt();
        int maxScore = 0;
        while (score >= 0){
            vector.addElement(score);
            score = scanner.nextInt();
            //获取最高分
            if(score > maxScore){
                maxScore = score;
            }
        }
        System.out.println("最高分为： " + maxScore);
//        for (int i = 0; i < vector.size(); i++) {
//            int c = maxScore - (int)vector.elementAt(i);
//            if(c <= 10){
//                System.out.println("学生成绩为：" + (int)vector.elementAt(i) +", 等级为A");
//            }else if( c <= 20){
//                System.out.println("学生成绩为：" + (int)vector.elementAt(i) +", 等级为B");
//            }else if(c <= 30){
//                System.out.println("学生成绩为：" + (int)vector.elementAt(i) +", 等级为C");
//            }else{
//                System.out.println("学生成绩为：" + (int)vector.elementAt(i) +", 等级为D");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < vector.size(); i++) {
            Integer score1 = (Integer)vector.elementAt(i);
            char level;
            if(maxScore - score1 <= 10){
                level = 'A';
            }else if(maxScore - score1 <= 20){
                level = 'B';
            }else if(maxScore - score1 <= 30){
                level = 'C';
            }else{
                level = 'D';
            }
            System.out.println("学生成绩为： " + score1 + ", 等级为： " + level);
        }
    }
}
