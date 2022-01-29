package leetcode;

class Solution463{
    public int islandPerimeter(int[][] grid) {
        if(grid == null  || grid.length == 0){
            return 0;
        }
        int rsp = 0;
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){
                    rsp += 4;
                    if(i > 0 && grid[i-1][j] == 1){
                        rsp -= 2;
                    }
                    if(j > 0 && grid[i][j-1] == 1){
                        rsp -= 2;
                    }
                }
            }
        }
        return rsp;
    }
}



public class Exercise463 {
    public static void main(String[] args) {
        Solution463 solution463 = new Solution463();
        System.out.println(solution463.islandPerimeter(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));
    }
}
