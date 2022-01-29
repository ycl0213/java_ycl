package testIO;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class TestFileReader {
    //使用FileReader和FileWriter实现文本文件的复制，对于非文本文件，只能使用字节流；
    @Test
    public void testFileReaderWrite(){
        FileReader fr = null;
        FileWriter fw = null;
        try{
            File src = new File("hello");
            File dest = new File("hello5.txt");
            fr = new FileReader(src);
            fw = new FileWriter(dest);
            char[] c = new char[12];
            int len;
            while ((len = fr.read(c)) != -1) {
                fw.write(c,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void testFileReader(){
        File file = new File("hello");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            char[] c = new char[12];
            int len;
            while((len = fileReader.read(c)) != -1){
                String str = new String(c,0,len);
                System.out.print(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
