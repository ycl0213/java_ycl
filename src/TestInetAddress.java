import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress:位于java.net包下
 * 1.InetAddress用来代表IP地址，一个InetAddress的对象就代表一个IP地址
 * 2.创建InetAddress对象：调用getByName()方法创建
 */
public class TestInetAddress {
    public static void main(String[] args) {
        InetAddress inet = null;
        InetAddress inet1 = null;
        try {
            inet = InetAddress.getByName("www.baidu.com");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(inet);
        System.out.println(inet.getHostName());  //获取IP地址对应的域名
        System.out.println(inet.getHostAddress());  //获取IP地址
        System.out.println("================");
        try {
             inet1 = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(inet1);
        System.out.println(inet1.getHostName());
        System.out.println(inet1.getHostAddress());

    }
}
