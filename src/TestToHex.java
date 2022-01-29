/**
 * 手动实现十进制转为十六进制
 */

public class TestToHex {
    public static void main(String[] args) {
        int i = 61;
        String res = "";
        for(; i != 0; i >>= 4){
            int j = i & 15;//获取i的低四位
            String s = j <= 9 ? j + "" : (char)((j - 10) + 'a') + "";
            res = s + res;
        }
        System.out.println(res);
    }
}
