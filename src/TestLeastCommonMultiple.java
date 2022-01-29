public class TestLeastCommonMultiple {
    public static void main(String[] args) {
        int m = 12;
        int n = 28;
        int max = Math.max(m,n);
        int min = Math.min(m,n);
        for (int i = max; i <= m * n; i++) {
            if(i % m == 0 && i % n == 0){
                System.out.println("最小公倍数为： " + i);
                break;
            }

        }
    }
}
