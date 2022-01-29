package TestOOP;

/**
 * 使用了static关键字
 */
public class TestArrayUtil {
    public static void main(String[] args) {
        int[] a = new int[]{2,14,65,34,-54,0,-12,-1,100};
        System.out.println("最大值为： " + ArrayUtil.max(a));
        System.out.println("最小值为： " + ArrayUtil.min(a));
        System.out.println("总和为： " + ArrayUtil.sum(a));
        System.out.println("平均值为： " + ArrayUtil.avg(a));

        System.out.println("=======");
        System.out.println("数组的复制： ");
        int[] arr_copy = ArrayUtil.copy(a);
        for (int i = 0; i < arr_copy.length; i++) {
            System.out.print(arr_copy[i] + " ");
        }
        System.out.println();
        System.out.println("数组的反转：");
        int[] arr_reverse = ArrayUtil.reverse(a);
        for (int i = 0; i < arr_reverse.length; i++) {
            System.out.print(arr_reverse[i] + " ");
        }
        System.out.println();

        System.out.println("数组的遍历：");
        ArrayUtil.printArray(a);

        System.out.println();
        System.out.println("数组的排序: ");
        ArrayUtil.sort(a);
    }


}

class ArrayUtil{
    //求数组的最大值
    public static int max(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    //求数组的最小值
    public static int min(int[] arr){
        int min = arr[0];
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    //求数组的总和
    public static int sum(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    //求数组的平均值
    public static int avg(int[] arr){
        int sum = sum(arr);
        int avg = sum / arr.length;
        return avg;
    }

    //数组的复制
    public static int[] copy(int[] arr){
        int[] arr2 = new int[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            arr2[i] = arr[i];
        }
        return arr2;
    }

    //数组的反转
    public static int[] reverse(int[] arr){
        for (int i = 0; i < arr.length / 2 ; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        return arr;
    }

    //遍历数组
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    //数组排序 (直接排序)
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min_index = i;
            for (int j = i; j < arr.length ; j++) {
                if(arr[min_index] > arr[j]){
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
