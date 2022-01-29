package testIO;

import org.junit.Test;

import java.io.*;

public class TestFileInputOutputStream {
    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis(); // 查看花费的时间
        copyFile("C:\\Users\\13248\\Desktop\\1.jpg", "C:\\Users\\13248\\Desktop\\2.jpg");//调用方法
        long end = System.currentTimeMillis();
        System.out.println(end - start);  //20ms
    }
    //包装成方法
    public static void copyFile(String src, String dest){
        //1、提供读入、写出的文件位置
        File fileIn = new File(src); //实现图片的复制
        File fileOut = new File(dest);
        //2、提供相应的流
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try{
            fileInputStream = new FileInputStream(fileIn);
            fileOutputStream = new FileOutputStream(fileOut);
            //3、具体操作
            byte[] b = new byte[5];
            int len;
            while((len = fileInputStream.read(b)) != -1){
                fileOutputStream.write(b,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //4、关闭输出流
            if(fileOutputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //5、关闭输入流
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //从硬盘读取一个文件，将其写入到另一个位置(相当于文件的复制)
    @Test
    public void testFileInputOutputStream(){
        //1、提供读入、写出的文件位置
        File fileIn = new File("C:\\Users\\13248\\Desktop\\1.jpg"); //实现图片的复制
        File fileOut = new File("C:\\Users\\13248\\Desktop\\2.jpg");
        //2、提供相应的流
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try{
            fileInputStream = new FileInputStream(fileIn);
            fileOutputStream = new FileOutputStream(fileOut);
            //3、具体操作
            byte[] b = new byte[5];
            int len;
            while((len = fileInputStream.read(b)) != -1){
                fileOutputStream.write(b,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //4、关闭输出流
            if(fileOutputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //5、关闭输入流
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void testFileOutputStream(){
        //1、创建一个File文件，表明要写入的文件位置
        File file = new File("hello2.txt");
        //2、创建一个FileOutputStream的对象，将File的对象作为形参传递给FileOutputStream的构造器
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream = new FileOutputStream(file);
            //3、将内容写入到hello2文件中，若hello2不存在，会自动创建一个文件，若存在，则覆盖文件中的内容
            fileOutputStream.write(new String(" I love China").getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null){
                try {
                    //4、关闭流
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //使用read(byte[] b)方法读取文件
    @Test
    public void testFileInputStream3(){
        FileInputStream fileInputStream = null;
        try {
            File file = new File("hello1");
            fileInputStream = new FileInputStream(file);
            byte[] b = new byte[5]; //读取到的数据要写入的数组
            int len; //记录每次读入到byte中的数组的长度
            while((len = fileInputStream.read(b)) != -1){
                String str = new String(b,0,len);
                System.out.print(str);
//                for(int i = 0; i < len; i++){
//                    System.out.print((char) b[i]);
//                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    //采用try-catch的方式处理异常更合理：保证流的关闭操作一定可以执行
    @Test
    public void testFileInputStream2(){
        FileInputStream fileInputStream = null;
        try {
            //1、创建一个File类的对象
            File file = new File("hello");
            //2、创建一个FileInputStream类的对象
            fileInputStream = new FileInputStream(file);
            //3、调用FileInputStream的方法，实现file文件的读取
            int b;
            //read()方法是一个byte一个byte读，当返回-1时代表读取结束
            while((b = fileInputStream.read()) != -1){
                System.out.print((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream != null) {
                //4、关闭流
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //从硬盘存在的一个文件中，读取其内容到程序中
    //要读取的文件一定要存在
    @Test
    public void testFileInputStream1() throws IOException {
        //1、创建一个File类的对象
        File file = new File("hello");
        //2、创建一个FileInputStream类的对象
        FileInputStream fileInputStream = new FileInputStream(file);
        //3、调用FileInputStream的方法，实现file文件的读取
        int b;
        //read()方法是一个byte一个byte读，当返回-1时代表读取结束
        while((b = fileInputStream.read()) != -1){
            System.out.print((char) b);
        }
        //4、关闭流
        fileInputStream.close();
    }
}

