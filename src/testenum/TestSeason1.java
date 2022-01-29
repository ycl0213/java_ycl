package testenum;

public class TestSeason1 {
    public static void main(String[] args) {
//        System.out.println(Season1.SPRING);
//        System.out.println(Season1.SUMMER);
//        System.out.println(Season1.AUTUMN);
//        System.out.println(Season1.WINTER);
        //枚举类的常用方法
        //1、values()方法
        Season1[] season1s = Season1.values(); //Season1.values()方法,返回Season1枚举类中所有对象的一个数组
        for(Season1 s : season1s){
            System.out.println(s);
        }
        //2、valueOf()方法
        String str = "SPRING";
        Season1 season1 = Season1.valueOf(str);//返回str对应的对象
        System.out.println(season1);

        //枚举类实现接口
        Season1 season11 = Season1.SPRING;
        season11.show();  //这是春天
        Season1 season12 = Season1.SUMMER;
        season12.show(); //这是夏天
    }

}
interface Info{
    public void show();
}
//枚举类：使用enum
enum  Season1 implements Info{
    SPRING("春天", "春暖花开"){
        //重写Info接口的show()方法
        public void show(){
            System.out.println("这是春天");
        }
    },  //对象
    SUMMER("夏天", "炎炎夏日"){
        public void show(){
            System.out.println("这是夏天");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        public void show(){
            System.out.println("这是秋天");
        }
    },
    WINTER("冬天", "凌烈寒冬"){
        public void show(){
            System.out.println("这是冬天");
        }
    };

    private final String seasonName;
    private final String seasonDesc;

    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }


    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}

