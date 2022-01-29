package TestOOP;

public class TestBoyGirl {
    public static void main(String[] args) {
        Boy b = new Boy();
        Girl g = new Girl();
        b.setName("小华");
        b.setAge(23);
        g.setName("小花");
        b.marry(g);
        b.shout();
        System.out.println("======");
//        int[][] a = new int[][]{{1},{2,3},{2,3,4}};
//        int[] arr = new int[3];
//        arr[0] = 2;
//        arr[1] = 3;
//        int[] arr2 = new int[]{1,2,3,4};
        System.out.println(Integer.toBinaryString(16));


    }
}
