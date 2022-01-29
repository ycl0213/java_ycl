import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 结果为：
 * atguigu
 * atguigu
 * atguigu
 * atguigu
 * atguigu
 * null
 * null
 * null
 * null
 * null
 */

public class Test {
    public static void main(String[] args){
        String[] str = new String[5];
        for(String myStr : str){
            myStr = "atguigu";
            System.out.println(myStr);
        }
        for(int i = 0;i < str.length;i++){
            System.out.println(str[i]);
        }

        List list1 = new ArrayList();
        list1.add(23);
        ListIterator listIterator = list1.listIterator();
        listIterator.next();
        listIterator.set(12);
        System.out.println(list1);


/**
 * 向下转型
 */
        float d =(float) 12.4D;
        System.out.println(d);
    }



}
