package teststring;

import org.junit.Test;

import java.util.*;

public class TestString {
    @Test
    public void test(){

    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.sort(Arrays.asList(1,4,3,5,2), (x,y) -> x - y);
//        String str1 = "javaEE";
//        String str2 = "javaEE";
//        String str3 = new String("javaEE");
//        String str4 = "javaEE" + "Android";
//        String str5 = "Android";
//        String str6 = str1 + str5;
//        str5 = str5 + "Handoop";
//        String str7 = str6.intern();
//        str1.compareTo(str2);
//
//        System.out.println(str1 ==str2);//true
//        System.out.println(str1 == str3);//false
//        System.out.println(str1.equals(str3));//true
//
//        System.out.println(str4 == str6); //fasle
//        System.out.println(str4.equals(str6));//true
//        System.out.println(str7 == str4);//ture

//        List<Integer> list = new ArrayList<>();
//        System.out.println(list.isEmpty());
//        System.out.println(list.size());

        Map<String, String> settingMap = new HashMap<>();
        if(settingMap != null){
            System.out.println("不为空啊");
        }
    }
}
