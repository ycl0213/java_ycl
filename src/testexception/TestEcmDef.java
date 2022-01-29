package testexception;

import java.util.Scanner;

public class TestEcmDef {
    public static void main(String[] args) {
        try {
            int i = Integer.parseInt(args[0]);
            int j = Integer.parseInt(args[1]);
            TestEcmDef t = new TestEcmDef();
            t.ecm(i, j);
        } catch (NumberFormatException e1) {
            System.out.println("数据类型不一致");
        } catch (ArrayIndexOutOfBoundsException e2) {
            System.out.println("缺少命令行参数");
        } catch (ArithmeticException e3) {
            System.out.println("除数不能为0");
        } catch (EcDef e4) {
            System.out.println(e4.getMessage());
        }
    }

    public void ecm(int i, int j) throws EcDef{
        if (i < 0 || j < 0) {
            throw new EcDef("输入有负数");
        }
        System.out.println(i / j);
    }
}

class EcDef extends Exception{
    static final long serialVersionUID = -7034890745766939L;
    public EcDef() {
    }

    public EcDef(String message) {
        super(message);
    }
}

