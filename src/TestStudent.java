import java.util.Random;

class Student {
    public int number;
    public int state;
    public int score;
    public Student(int num, int sta, int sco){
        this.number = num;
        this.state = sta;
        this.score = sco;
    }
}

public class TestStudent{
    public static void main(String[] args) {
        Student s[] = new Student[20];
        for(int i = 0; i < 20; i++) {
            s[i] = new Student(i+1, (int) (Math.random()*6+1), (int) (Math.random()*100));
            if(s[i].state == 3){
                System.out.println(s[i].number);
                System.out.println(s[i].score);
                System.out.println(s[i].state);
            }
        }
    }
}
