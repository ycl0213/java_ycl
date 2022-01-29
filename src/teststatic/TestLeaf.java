package teststatic;

public class TestLeaf {
    public static void main(String[] args) {
        new Leaf();
        //Root的静态初始化块
        //Mid的静态初始化块
        //Leaf的静态初始化块
        //Root的普通初始化块
        //Root的无参构造器
        //Mid的普通初始化块
        //Mid的无参构造器
        //Mid的带参数构造器，参数为：测试
        //Leaf的普通初始化块
        //执行Leaf的构造器
        System.out.println();
        new Leaf();
        //Root的普通初始化块
        //Root的无参构造器
        //Mid的普通初始化块
        //Mid的无参构造器
        //Mid的带参数构造器，参数为：测试
        //Leaf的普通初始化块
        //执行Leaf的构造器
    }
}
class Root{
    static {
        System.out.println("Root的静态初始化块");
    }
    {
        System.out.println("Root的普通初始化块");
    }
    public Root(){
        System.out.println("Root的无参构造器");
    }
}

class Mid extends Root{
    static {
        System.out.println("Mid的静态初始化块");
    }
    {
        System.out.println("Mid的普通初始化块");
    }
    public Mid(){
        System.out.println("Mid的无参构造器");
    }
    public Mid(String msg){
        this();
        System.out.println("Mid的带参数构造器，参数为：" + msg);
    }
}

class Leaf extends Mid{
    static {
        System.out.println("Leaf的静态初始化块");
    }
    {
        System.out.println("Leaf的普通初始化块");
    }
    public Leaf(){
        super("测试");
        System.out.println("执行Leaf的构造器");
    }
}
