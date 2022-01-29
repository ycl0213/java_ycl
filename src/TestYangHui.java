/**
 * 打印杨辉三角
 */

public class TestYangHui {
    public static void main(String[] args) {
        int n = 10;
        int[][] a = new int[n][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new int[i+1];
            for (int j = 0; j < a[i].length; j++) {
                a[i][0] = a[i][i] = 1;
                if(j > 0 && j < i) {
                    a[i][j] = a[i - 1][j - 1] + a[i - 1][j];  //关系
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();

        }
    }
}
