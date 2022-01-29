package testIO;

import org.junit.Test;

import java.io.*;

public class TestBuffered {
    @Test
    public void testBufferedReader(){
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("hello5.txt");
            File file1 = new File("hello6.txt");
            FileReader fileReader = new FileReader(file);
            FileWriter fileWriter = new FileWriter(file1);
            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);
            //一次读一行
            String str;
            while ((str = bufferedReader.readLine()) != null){
                //System.out.println(str);
                bufferedWriter.write(str);
                bufferedWriter.newLine();//实现写操作的换行
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedWriter != null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void testCopy(){
        long start = System.currentTimeMillis();
        BufferedCopy("C:\\Users\\13248\\Desktop\\1.jpg","C:\\Users\\13248\\Desktop\\4.jpg");
        long end = System.currentTimeMillis();
        System.out.println(end - start); //  小于1ms  使用BufferedStream处理非文本文件的效率较使用FileStream处理非文本文件的效率高
    }
    public static void BufferedCopy(String src, String dest){
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //1、提供读入、写出的文件
            File fileIn = new File(src);
            File fileOut = new File(dest);
            //2、创建相应的节点流的对象：FileInputStream、FileOutputStream
            FileInputStream fileInputStream = new FileInputStream(fileIn);
            FileOutputStream fileOutputStream = new FileOutputStream(fileOut);
            //3、将创建的节点流的对象作为形参传递给BufferedInputStream和BufferedOutputStream
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            //4、具体的实现文件复制的操作
            byte[] b = new byte[5];
            int len;
            while((len = bufferedInputStream.read(b)) != -1){
                bufferedOutputStream.write(b,0,len);
                bufferedOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //5、关闭相应的流
            if(bufferedOutputStream != null){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedInputStream != null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //使用BufferInputStream和BufferedOutputStream实现非文本文件的复制
    @Test
    public void testBufferInputOutputStream(){
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //1、提供读入、写出的文件
            File fileIn = new File("C:\\Users\\13248\\Desktop\\1.jpg");
            File fileOut = new File("C:\\Users\\13248\\Desktop\\2.jpg");
            //2、创建相应的节点流的对象：FileInputStream、FileOutputStream
            FileInputStream fileInputStream = new FileInputStream(fileIn);
            FileOutputStream fileOutputStream = new FileOutputStream(fileOut);
            //3、将创建的节点流的对象作为形参传递给BufferedInputStream和BufferedOutputStream
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            //4、具体的实现文件复制的操作
            byte[] b = new byte[24];
            int len;
            while((len = bufferedInputStream.read(b)) != -1){
                bufferedOutputStream.write(b,0,len);
                bufferedOutputStream.flush();  //一般加上
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //5、关闭相应的流
            if(bufferedOutputStream != null){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedInputStream != null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
