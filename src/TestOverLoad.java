public class TestOverLoad {
    public static void main(String[] args) {
        OverLoad o = new OverLoad();
        o.mOl(2);
        o.mOl(2,4);
        o.mOl("A");

        OverLoad2 o2 = new OverLoad2();
        int max1 = o2.max(3,7);
        System.out.println("第一个方法，最大值为: " + max1);
        double max2 = o2.max(2.1,4.1);
        System.out.println("第二个方法，最大值为： " + max2);
        double max3 = o2.max(2.3,7.9082,1.2);
        System.out.println("第三个方法，最大值为： " + max3);
    }


}

class OverLoad{
    public void mOl(int x){
        System.out.println("平方运行结果： " + x*x);
    }
    public void mOl(int x, int y){
        System.out.println("乘积运算结果： " + x * y);
    }
    public void mOl(String s){
        System.out.println("字符串为： " + s);
    }
}

class OverLoad2{
    public int max(int x, int y){
        return Math.max(x,y);
    }
    public double max(double d1, double d2){
        return Math.max(d1,d2);
    }
    public double max(double d1, double d2, double d3){
        double max = Math.max(max(d1, d2), d3);
        return max;
//        if(d1 > d2){
//            if(d2 > d3){
//                System.out.println("第三个方法，最大值为： " + d1);
//            }else if(d3 > d1){
//                System.out.println("第三个方法，最大值为： " + d3);
//            }
//        }
//        else if(d2 > d3){
//            System.out.println("第三个方法，最大值为： " + d2);
//        }else{
//            System.out.println("第三个方法，最大值为： " + d3);
//        }
    }
}
