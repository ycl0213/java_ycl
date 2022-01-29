package testmain;

public class TestMain1 {
    public static void main(String[] args) {
        Main.main(new String[1000]);
    }
}

//Main中有静态的main方法，可以直接通过Main.main调用
class Main{
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            args[i] = "Value_" + i;
            System.out.println(args[i]);
        }
    }
}
