package equals;

public class TestMyDate {
    public static void main(String[] args) {
        MyDate myDate1 = new MyDate(2020,9,17);
        MyDate myDate2 = new MyDate(2020,8,17);
        System.out.println(myDate1.equals(myDate2));
    }
}

class MyDate{
    private long year;
    private int month;
    private int day;

    public MyDate(long year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public long getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj instanceof MyDate){
            MyDate myDate = (MyDate)obj;
            return this.year == myDate.year && this.month == myDate.month && this.day == myDate.day;
        }
        return false;
    }
}

