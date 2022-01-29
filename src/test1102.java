import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class test1102 {
    /**
     * 暴力法
     */
//    public static void main(String[] args) {
//        int n = 5;
//        int k = 3;
//        int i = ~(-1 << k) << n - k; // 11111111111111111111111111111000--> 00000000000000000000000000000111--->00000000000000000000000000011100   11111   1000111
//        System.out.println(i);
//    }


    /**
     * 移位运算的优先级小于加减运算的优先级
     * 层次遍历法
     * 1、找出一个1的所有情况，00001、00010、00100、01000、10000
     * 2、遍历找出的一个1的情况for (int combination : combinations)：
     *    1）将first设为当前combination左移Integer.SIZE - Integer.numberOfLeadingZeros(combination)位
     *    2）将combination与e进行与运算，得到当前combination下两个1的所有情况：00011、00101、01001、10001；
     *    3）重复
     * 3、遍历找出的两个1的所有情况：
     * @param n
     * @param k
     * @return
     */

//    public Iterable<Integer> combinations1(int n, int k) {
//        List<Integer> combinations = Collections.singletonList(0);
//        for (int c = 0; c < k; c++) {
//            List<Integer> next = new ArrayList<>();
//            for (int combination : combinations) {
//                int first = 1 << Integer.SIZE - Integer.numberOfLeadingZeros(combination);
//                for (int e = first; e < 1 << n; e <<= 1) {
//                    next.add(combination | e);
//                }
//            }
//            combinations = next;
//        }
//        return combinations;
//    }

    /**
     * 深度优先
     * @param n
     * @param k
     * @return
     */

    public Iterable<Integer> combinations2(int n, int k) {
        return () -> new Iterator<Integer>() {
            private int index = 1;
            private final int[] stack = new int[n + 1];

            @Override
            public boolean hasNext() {
                return index != 0;
            }

            @Override
            public Integer next() {
                for (; ; ) {
                    int combination = stack[index--];
                    if (Integer.bitCount(combination) == k) {
                        return combination;
                    }
                    int first = 1 << Integer.SIZE - Integer.numberOfLeadingZeros(combination);
                    for (int e = first; e < 1 << n; e <<= 1) {
                        stack[++index] = combination | e;
                    }
                }
            }
        };
    }



    public static void main(String[] args) {
        test1102 t = new test1102();
        Iterable<Integer> integers = t.combinations2(5,3);
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
