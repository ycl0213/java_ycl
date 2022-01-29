package testcollections;

import java.util.*;

/**
 * 从键盘中输入10个整数，并按倒序、从大到小输出
 */

public class CollectionsExercise {
    public static void main(String[] args) {
        List list = new ArrayList();
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            list.add(s.nextInt());
        }
        Collections.reverse(list);
        System.out.println("倒序： " + list);
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Integer && o2 instanceof Integer){
                    return -(((Integer) o1).compareTo((Integer) o2));
                }
                return 0;
            }
        });
        System.out.println("从大到小排序： " + list);
    }
}
