package testIO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * java.io.File类：
 * 1、凡是与输入输出有关系的类、接口都定义在java.io包下；
 * 2、File是一个类，可以有构造器创建对象，此对象对应着一个文件或文件目录;
 * 3、File类对象是与平台无关的；
 */
public class TestIO {
    @Test
    public void test3() throws IOException {
        File file1 = new File("C:\\Users\\13248\\ycl资料\\IO\\helloworld.txt"); //绝对路径
        File file3 = new File("C:\\Users\\13248\\ycl资料\\IO1\\IO2"); //表示一个文件目录
        File file4 = new File("C:\\Users\\13248\\ycl资料");
        //1、delete()
        System.out.println(file1.delete());//返回boolean值，删除成功为true
        //2、createNewFile()
        if(!file1.exists()){
            boolean b = file1.createNewFile();
            System.out.println(b);
        }
        //3、mkdir():创建文件目录：只有在上层文件目录存在的情况下才会返回true
        if(!file3.exists()){
            boolean b = file3.mkdir();
            System.out.println(b);
        }
        //4、delete():删除文件目录
        System.out.println(file3.delete());
        //5、mkdirs()：当创建的目录的上级目录不存在时，需要使用mkdirs()一并创建
        boolean b1 = file3.mkdirs();
        //6、list()：列出文件目录下的所有文件。返回一个String类型的数组
        String[] str = file4.list();
        for(String s : str){
            System.out.println(s);
        }
        System.out.println();
        //7、listFiles():以File[]的形式列举出目录下的所有文件，可对其进行File中的相关操作
        File[] files = file4.listFiles();
        for(File f : files){
            //System.out.println(f.getName());
            System.out.println(f);
        }

    }
    @Test
    public void test2(){
        File file1 = new File("C:\\Users\\13248\\ycl资料\\IO\\helloworld.txt"); //绝对路径
        File file2 = new File("hello1"); //相对路径
        File file3 = new File("C:\\Users\\13248\\ycl资料\\IO\\IO1"); //表示一个文件目录

        //1、exists()
        System.out.println(file1.exists());
        //2、canWrite()
        System.out.println(file1.canWrite());
        //3、canRead()
        System.out.println(file1.canRead());
        //4、isFile()
        System.out.println(file1.isFile());
        //5、isDirectory()
        System.out.println(file1.isDirectory());
        //6、lastModified()
        System.out.println(new Date(file1.lastModified()));
        //7、length()
        System.out.println(file1.length());
        System.out.println();

        //1、
        System.out.println(file3.exists());
        //2、
        System.out.println(file3.canWrite());
        //3、
        System.out.println(file3.canRead());
        //4、
        System.out.println(file3.isFile());
        //5、
        System.out.println(file3.isDirectory());
        //6、
        System.out.println(file3.lastModified());
        //7、
        System.out.println(file3.length());
    }
    @Test
    public void test(){
        /**
         * 路径分为绝对路径和相对路径：
         */
        File file1 = new File("C:\\Users\\13248\\ycl资料\\IO\\helloworld.txt"); //绝对路径
        File file2 = new File("hello1"); //相对路径
        File file3 = new File("C:\\Users\\13248\\ycl资料\\IO\\IO1"); //表示一个文件目录

        //常用方法
        //1、getName()
        System.out.println(file1.getName());
        //2、getPath()
        System.out.println(file1.getPath());
        //3、getAbsoluteFile()
        System.out.println(file1.getAbsoluteFile());
        //4、getAbsolutePath()
        System.out.println(file1.getAbsolutePath());
        //5、getParent():获取上一层目录
        System.out.println(file1.getParent());
        //6、renameTo(File newName)：重命名
        //file1重命名为file2，要求file1一定存在，file2一定不存在；返回boolean类型
        //要求file1和file2都是文件或文件目录
        System.out.println(file1.renameTo(file2));

        System.out.println();
        //1、
        System.out.println(file3.getName());
        //2、
        System.out.println(file3.getPath());
        //3、
        System.out.println(file3.getAbsoluteFile());
        //4、
        System.out.println(file3.getAbsolutePath());
        //5、
        System.out.println(file3.getParent());
    }
}
