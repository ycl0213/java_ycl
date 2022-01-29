import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.Scanner;


/**
 * 使用switch把小写的char转换为大写
 */

public class TestSwitch1 {
    public static void main(String[] args) {
        char c ='c';
        switch (c){
            case 'a':
                System.out.println('A');
                break;
            case 'b':
                System.out.println('B');
                break;
            case 'c':
                System.out.println('C');
                break;
            case 'd':
                System.out.println('D');
                break;
            case 'e':
                System.out.println('E');
                break;
            default:
                System.out.println("other");
                break;
        }
    }
}
