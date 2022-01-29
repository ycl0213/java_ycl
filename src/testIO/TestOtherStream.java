package testIO;

import org.junit.Test;

import java.io.*;
import java.util.TreeSet;

public class TestOtherStream {
    //读取数据
    @Test
    public void testData1(){
        DataInputStream dis = null;
        try{
            dis = new DataInputStream(new FileInputStream(new File("data.txt")));
            String str = dis.readUTF();
            System.out.println(str);
            boolean b = dis.readBoolean();
            System.out.println(b);
            int i = dis.readInt();
            System.out.println(i);
            long l = dis.readLong();
            System.out.println(l);

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(dis != null){
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //数据流（处理流）：用于读取和写出基本数据类型的数据
    @Test
    public void testData(){
        DataOutputStream dos = null;
        try {
            FileOutputStream fos = new FileOutputStream("data.txt");
            dos = new DataOutputStream(fos);
            dos.writeUTF("中国");
            dos.writeBoolean(true);
            dos.writeInt(23);
            dos.writeLong(12345L);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(dos != null){
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //打印流（处理流）：字节流：PrintStream  字符流：PrintWreter
    @Test
    public void testPringStream(){
        FileOutputStream bw = null;
        try{
            bw = new FileOutputStream(new File("print.txt"));
        }catch (IOException e){
            e.printStackTrace();
        }
        //创建打印输出流，设置为自动刷新模式（写入换行符或者字节“\n”时都会刷新输出缓冲区）
        PrintStream ps = new PrintStream(bw, true);
        if(ps != null){
            System.setOut(ps); //把标准输出流（控制台）改成文件
        }
        for (int i = 0; i < 255; i++) {
            System.out.print((char)i);
            if(i % 50 == 0){
                System.out.println();
            }
        }

    }
      //标准的输入流：System.in
    @Test
    public void testSystemIn(){
        BufferedReader bufferedReader = null;
        try {
            InputStream is = System.in;
            InputStreamReader inputStreamReader = new InputStreamReader(is);
            bufferedReader = new BufferedReader(inputStreamReader);
            String str;
            while(true){
                System.out.println("请输入：");
                str = bufferedReader.readLine();
                if(str.equalsIgnoreCase("e") || str.equalsIgnoreCase("exit")) {
                    break;
                }
                String str1 = str.toUpperCase();
                System.out.println(str1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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
    public void test1(){
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            //解码:字节数组----->字符型
            File file = new File("hello");
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "GBK");
            bufferedReader = new BufferedReader(inputStreamReader);
            //编码：字符型--->字节数组
            File file1 = new File("hello7");
            FileOutputStream fileOutputStream = new FileOutputStream(file1);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"GBK");
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            String str;
            while((str = bufferedReader.readLine()) != null){
                bufferedWriter.write(str);
                bufferedWriter.newLine();
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
}
