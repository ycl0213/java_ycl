/**
 * 直接排序
 */

public class DirectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,56,32,23,14,78,-2,0,4};
//        for (int i = 0; i < arr.length ; i++) {
//            for (int j = i+1; j < arr.length; j++) {
//                if(arr[i] > arr[j]){
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//
//        }

        /**
         * 优化
         */
        for (int i = 0; i < arr.length; i++) {
            int min_index = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[j] < arr[min_index]){
                    min_index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }




    }
}
