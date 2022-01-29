package leetcode;

public class Exercise492 {
    public static void main(String[] args) {
        Solution_492 solution_492 = new Solution_492();
        int[] res = solution_492.constructRectangle(8);
        System.out.println("[" + res[0] + "," + res[1] + "]");
    }
}


/**
 * 双指针
 */
class Solution_492 {
    public int[] constructRectangle(int area) {
        int[] res = new int[2];
        int left;
        int right;
        left = right = (int)Math.sqrt(area);
        while (left <= right){
            if(left * right == area){
                res[0] = right;
                res[1] = left;
                return res;
            }else if(left * right < area){
                right++;
            }else {
                left--;
            }
        }
        return res;
    }
}
