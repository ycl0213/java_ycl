/**
 * 冒泡排序
 */

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,56,32,23,14,78,-2,0,4};
        for (int i = 1; i <arr.length ; i++) {
            for (int j = 0; j <arr.length-i ; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
