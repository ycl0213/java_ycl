package leetcode;

class Solution485_1{
    public int findMaxConsecutiveOnes(int[] nums){
        String s = new String();
        for(int i = 0; i < nums.length; i++){
            s+= nums[i];
        }
        String[] s1 = s.split("0");
        int maxnum = 0;
        for(String string : s1){
            if(string.length() > maxnum){
                maxnum = string.length();
            }
        }
        return maxnum;
    }
}


class Solution485_2{
    public int findMaxConsecutiveOnes(int[] nums){
        int num = 0;
        int maxnum = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                num++;
            }else{
                if(num >= maxnum){
                    maxnum = num;
                }
                num = 0;
            }
        }
        if(num > maxnum){
            maxnum = num;
        }
        return maxnum;
    }
}


public class Exercise485 {
    public static void main(String[] args) {
        Solution485_1 solution485_1 = new Solution485_1();
        Solution485_2 solution485_2 = new Solution485_2();
        System.out.println(solution485_2.findMaxConsecutiveOnes(new int[]{0,0,1,1,0,0,1,1,1}));
        System.out.println(solution485_1.findMaxConsecutiveOnes(new int[]{1,0,1,0,0,1,0,1,1,0}));
    }
}
