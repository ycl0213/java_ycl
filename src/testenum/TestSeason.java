package testenum;

public class TestSeason {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);
        System.out.println("===============");
        Season[] seasons = Season.values();  //返回season枚举类中所有对象的一个数组
        for(int i = 0; i < seasons.length; i++){
            System.out.println(seasons[i]);
        }

        System.out.println("----------------");
        String str = "SPRING";
        Season season = Season.valueOf(str);
        System.out.println(season);
    }

}
//枚举类
enum Season{
    SPRING("春天", "春暖花开"),
    SUMMER("夏天", "炎炎夏日"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "凌烈寒冬");

    //1、提供类的属性，声明为private final 类型的
    private final String seasonName;
    private final String seasonDesc;
    //2、提供私有的构造器。在构造器中给声明为final的属性初始化；
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //3、提供公共的方法来调用final的属性
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
