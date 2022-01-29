package testIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 自定义类实现scanner类的作用
 */
public class TestMyInput {
    public String nextString() {
        String str = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in); //将输入的字节转换为字符
            BufferedReader br = new BufferedReader(isr);
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    public int nextInt(){
        return Integer.parseInt(nextString());
    }
    public Boolean nexBoolean(){
        return Boolean.parseBoolean(nextString());
    }

    public static void main(String[] args) {
        TestMyInput in = new TestMyInput();
        System.out.println("请输入字符串：");
        System.out.println(in.nextString());

        int j = in.nextInt();
        System.out.println(j + 1);

    }

}
