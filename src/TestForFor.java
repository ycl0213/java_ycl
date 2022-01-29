
public class TestForFor {
    /**
     * 打印正杨辉三角
     * ----*
     * ---* *
     * --* * *
     * -* * * *
     * * * * * *
     * i  j-   k*   j = 4-i  k = i + 1
     * 0  4   1
     * 1  3   2
     * 2  2   3
     * 3  1   4
     * 4  0   5
     */
//    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 4-i; j++) {
//                System.out.print("-");
//            }
//            for (int k = 0; k < i + 1 ; k++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//    }

    /**
     * 打印倒杨辉三角
     * * * * * *
     * -* * * *
     * --* * *
     * ---* *
     * ----*
     * i   j-   k*   j = i   k = 5-i
     * 0   0   5
     * 1   1   4
     * 2   2   3
     * 3   3   2
     * 4   4   1
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("-");
            }
            for (int k = 0; k < 5 - i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
