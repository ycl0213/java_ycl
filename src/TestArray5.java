import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.jar.JarOutputStream;

/**
 * 1、求数组的最大值，最小值，平均值，总和；
 * 2、数组的复制、反转；
 * 3、数组元素的排序；
 *
 */

public class TestArray5 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,5,3,-5,8,12,23,-10};
        //求最大值
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("最大值为： " + max);

        //求最小值
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println("最小值为： " + min);

        //求平均值和总和
        int ave = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        ave = sum / arr.length;
        System.out.println("总和为： " + sum);
        System.out.println("平均值为： " + ave);


        //数组的复制
        int[] arr_copy = new int[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            arr_copy[i] = arr[i];
        }
        System.out.println("复制后的数组为： ");
        for (int i = 0; i <arr_copy.length ; i++) {
            System.out.print(arr_copy[i] + " ");
        }
//        for (int i = 0; i <arr.length ; i++) {
//            System.out.print(arr[i] + " ");
//        }

        //数组的反转
        /**
         * 方法1
         */
//        for (int i = 0; i <arr.length / 2 ; i++) {  //除以2
//            int temp;
//            temp = arr[arr.length-1-i];
//            arr[arr.length-1-i] = arr[i];
//            arr[i] = temp;
//        }

        /**
         * 方法2
         */
        for (int i = 0, j = arr.length-1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }
        System.out.println();
        System.out.println("反转后为: ");
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }



    }


}
