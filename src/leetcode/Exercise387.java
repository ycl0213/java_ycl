package leetcode;

import java.util.ArrayList;
import java.util.List;

//class Solution {
//    public int firstUniqChar(String s) {
//        char[] cs = s.toCharArray();
//        ArrayList list = new ArrayList();
//        for (int i = 0; (i < cs.length - 1) && !(list.contains(cs[i])); i++) {
//            for (int j = i + 1; j < cs.length; j++) {
//                if(cs[i] == cs[j]){
//                    list.add(cs[i]);
//                    break;
//                }else{
//                    j++;
//                }
//            }
//            if(list.isEmpty()) {
//                return i;
//            }
//        }
//        return -1;
//    }
//}


class Solution387 {
    public int firstUniqChar(String s) {
        for(int i=0; i<s.length(); i++){
            int first = s.indexOf(s.charAt(i));
            int last = s.lastIndexOf(s.charAt(i));
            if(first ==  last){
                return i;
            }
        }
        return -1;
    }
}

public class Exercise387{
    public static void main(String[] args) {
        Solution387 solution = new Solution387();
        System.out.println(solution.firstUniqChar("loeleetcode"));
    }

}
