package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


class Exercise001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        Exercise001 exercise001 = new Exercise001();
        int[] res = exercise001.twoSum(new int[]{0,1,2,1}, 2);
        System.out.println(Arrays.toString(res));
    }
}