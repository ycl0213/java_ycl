public class TestGreatestCommonDivisor {
    public static void main(String[] args) {
        int m = 12;
        int n = 28;
        int max = Math.max(m, n);
        int min = Math.min(m, n);
        for(int i = min; i >= 1; i--){
            if(m % i == 0 && n % i == 0){
                System.out.println("最大公约数为： " + i);
                break;
            }
        }
    }
}
