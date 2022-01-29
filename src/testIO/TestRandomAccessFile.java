package testIO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TestRandomAccessFile {
    //更通用的方法：
    @Test
    public void test4(){
        RandomAccessFile raf = null;
        try{
            raf = new RandomAccessFile("hello8", "rw");
            raf.seek(7); //将指针移到指定位置
            byte[] b = new byte[5]; //读取当前指针位置后的内容
            int len;
            StringBuffer sb = new StringBuffer();
            while((len = raf.read(b)) != -1){
                sb.append(new String(b,0,len));
            }
            raf.seek(7);
            raf.write("xy".getBytes());
            raf.write(sb.toString().getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(raf != null){
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //从任意位置读取、写入：实现插入的效果
    @Test
    public void test3(){
        RandomAccessFile raf = null;
        try{
            raf = new RandomAccessFile("hello8", "rw");
            raf.seek(4); //将指针移到指定位置
            String str = raf.readLine();//读取指针位置后的一行存入str
            long pointer = raf.getFilePointer(); //此时指针位置为末尾处
            raf.seek(4);
            raf.write("o".getBytes()); //插入“o”
            raf.write(str.getBytes()); //将str的内容写入后面
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(raf != null){
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //从任意位置读取、写入：实现的实际上是覆盖操作
    @Test
    public void test2(){
        RandomAccessFile raf = null;
        try{
            raf = new RandomAccessFile("hello8", "rw");
            raf.seek(4); //将指针移到指定位置
            raf.write("ycl".getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(raf != null){
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //进行文件的读写
    @Test
    public void test1(){
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("hello1"), "r");
            raf2 = new RandomAccessFile("hello8", "rw");
            byte[] b = new byte[5];
            int len;
            while ((len = raf1.read(b)) != -1) {
                raf2.write(b,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(raf2 != null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
