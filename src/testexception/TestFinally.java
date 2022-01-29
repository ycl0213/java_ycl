package testexception;

public class TestFinally {
    public static void main(String[] args) {
        int i = method();
        System.out.println(i);  //3
    }
    public static int method(){
        try{
            System.out.println(10 / 0);
            return 1; //如果程序没有异常，在执行该语句之前先执行finally语句
        }catch (Exception e){
            e.printStackTrace();
            return 3; //不会执行
        }
        finally {
            System.out.println("我是finally");
            //return 2;//在finally中有return，程序终止，输出2
        }
    }
}

