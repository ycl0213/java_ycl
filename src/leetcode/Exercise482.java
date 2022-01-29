package leetcode;

import java.util.Stack;


/**
 * 用StringBuilder
 */
class Solution482_1{
    public String licenseKeyFormatting(String s, int k) {
        String[] s1 = s.split("-");
        StringBuilder ns = new StringBuilder();
        for (String value : s1) {
            ns.append(value.toUpperCase());
        }
        StringBuilder res = new StringBuilder();
        for (int i = ns.length(); i >= 0;i = i-k) {
            int j = i - k;
            if(j > 0){
                String sub = ns.substring(j,i);
                res.insert(0,sub);
                res.insert(0,"-");
            }else if(j == 0){
                String sub = ns.substring(j, j + k);
                res.insert(0,sub);
                break;
            }else{
                res.insert(0,ns.substring(0,i));
                break;
            }
        }
        return res.toString();
    }
}


/**
 * 用栈，吐泡泡把字母一个个吐出来，逢K的倍数就加个杠！
 */
class Solution482_2 {
    public String licenseKeyFormatting(String S, int K) {


        String s = S.replaceAll("-", "");
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++)
        {
            stack.push(s.charAt(i));
        }
        int count = 0;
        String result = "";
        while (!stack.isEmpty())
        {
            result +=stack.pop();
            count++;
            if (count % K == 0 && !stack.isEmpty())
            {
                result += "-" ;
            }
        }
        return new StringBuffer(result.toUpperCase()).reverse().toString();

    }
}


public class Exercise482 {
    public static void main(String[] args) {
        Solution482_2 solution482 = new Solution482_2();
        System.out.println(solution482.licenseKeyFormatting("5F3Z-2e-9-w",3));
    }

}
