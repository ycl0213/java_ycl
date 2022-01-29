package teststring;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringExercise {
    /**
     * 模拟trim方法，去除字符串两端的空格
     */
    @Test
    public void test1(){
        String str1 = "   advvsd   dsfs    ";
        int start = 0;
        int end = str1.length()-1;
        while(start < end && str1.charAt(start) == ' '){
            start++;
        }
        while (start < end && str1.charAt(end) == ' '){
            end--;
        }
        String substring = str1.substring(start, end + 1);
        System.out.println(substring);
    }

    /**
     * 将一个字符串中指定部分进行反转
     */
     @Test
    public void test2(){
         String str = "adadsfger";
         int start = 2;
         int end = 5;
         char[] c = str.toCharArray();
         for(int i = start, j = end; i < j; i++, j--){
             char temp = c[i];
             c[i] = c[j];
             c[j] =temp;
         }
         //字符数组转化为字符串
         System.out.println(new String(c));

     }

    /**
     * 将一个字符串中指定部分进行反转(方法2)
     */
    @Test
    public void test2_2(){
        String str = "adadsfger";
        int start = 2;
        int end = 5;
        StringBuffer sb = new StringBuffer();  //使用StringBuffer
        sb.append(str.substring(0,start));
        for (int i = end; i >= start; i--) {
            char c = str.charAt(i);
            sb.append(c);
        }
        sb.append(str.substring(end + 1));
        System.out.println(sb);

    }

    /**
     * 获取一个字符串在另一个字符串中出现的次数(方法1)
     */

    @Test
    public void test3(){
        String str1 = "abcd";
        String str2 = "abcsfsabsjfbsdkjnabcsdkabcabc";
        Instant startTime = Instant.now();
        int count = 0;
        while(str2.indexOf(str1) != -1){
            count++;
            str2 = str2.substring(str2.indexOf(str1) + str1.length());
        }
        System.out.println(count);
        Instant endTime = Instant.now();
        System.out.println("花费的时间：" + Duration.between(startTime,endTime).toNanos());
    }

//    /**
//     * 获取一个字符串在另一个字符串中出现的次数(方法2)
//     */
//    @Test
//    public void test3_2(){
//        String str1 = "abcd";
//        String str2 = "abcsfsabsjfbsdkjnabcsdkabcabc";
//        Instant startTime = Instant.now();
//        int count = 0;
//        char[] str1Chars = str1.toCharArray();
//        char[] str2Chars = str2.toCharArray();
//        for(int i = 0 , j = 0; i < str2Chars.length; i++){
//            if(str2Chars[i] == str1Chars[j]){
//                j++;
//                if(j == str1Chars.length){
//                    count++;
//                    j = 0;
//                    i--;
//                }
//            }
//        }
//        System.out.println(count);
//        Instant endTime = Instant.now();
//        System.out.println("花费的时间：" + Duration.between(startTime,endTime).toNanos());
//
//    }

    /**
     * 获取两个字符串中最大相同子串
     * 想法：1.获取两个字符串中较短的字符串，如果该字符串在较长字符串中则输出；
     * 2.循环截取较短字符串（两种情况：从前截，从后截）
     */
    public static List<String> getSubStr(String str1, String str2){
        List<String> res = new ArrayList<>();
        String maxStr = str1.length() > str2.length() ? str1 : str2;
        String minStr = str1.length() > str2.length() ? str2 : str1;
        int len = minStr.length();
        for (int i = 0; i < len; i++) {
            for (int x = 0, y = len - i; y <= len; x++, y++) {
                String subStr = minStr.substring(x,y);
                if(maxStr.contains(subStr)){
                    res.add(subStr);
                }
            }
            if(res.size() != 0){
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> res = getSubStr("abcdegasdkkvas", "abcdefdvsgasdkkfbeb");
        System.out.println(res);

        String res1 = reverseStr("I am a student!");
        System.out.println(res1);
    }

    /**
     * 对字符串中字符进行自然顺序排序
     */

    @Test
    public void test5(){
        String str = "jsfjsavjhge";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        System.out.println(chars);
    }

    /**
     * 将I am a student ！ 倒叙输出字符串  ---->  ! student a am I
     */
    public static String reverseStr(String str){
        String[] str1 = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = str1.length - 1; i >= 0 ; i--) {
            sb.append(str1[i]).append(" ");
        }
        return String.valueOf(sb);
    }

}
