import java.util.Scanner;

public class TestWhile2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int p_count = 0;
        int n_count = 0;
        while (true){
            int input = s.nextInt();
            if(input > 0){
                p_count++;
            }else if(input < 0){
                n_count++;
            }else{
                break;
            }
        }
        System.out.println(p_count);
        System.out.println(n_count);

    }
}

