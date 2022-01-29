package interface_application;

import java.util.Scanner;

public class TestEmployee {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入月份");
        int month = s.nextInt();
        Employee[] employees = new Employee[]{new SalariedEmployee("小李",1,
                new MyDate(1991, 2, 2), 10000), new SalariedEmployee("小蓝",2,
                new MyDate(1992, 3, 3), 12000), new HourlyEmployee("小王", 3,
                new MyDate(1993,4,4), 120, 12), new HourlyEmployee("小韩", 4,
                new MyDate(1994,5,5), 130, 10)};
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].toString());
            if(employees[i].getBirthday().getMonth() == month){
                System.out.println("生日福利，工资增加100 ");
            }
        }
    }
}

abstract class Employee{
    private String name;
    private int number;
    private MyDate birthday;
    public abstract double eamings();

    public Employee(String name, int number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", number=" + number +
                ", birthday=" + birthday.toDateString();
    }
}

class MyDate{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String toDateString(){
        return year + "年" + month + "月" + day + "日";
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}

class SalariedEmployee extends Employee{
    private double monthlySalary;

    public SalariedEmployee(String name, int number, MyDate birthday,double monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    @Override
    public double eamings() {
        return this.monthlySalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" + super.toString() +
                "monthlySalary=" + " ," + monthlySalary +
                '}';
    }
}

class HourlyEmployee extends Employee{
    private double wage;
    private int hour;

    public HourlyEmployee(String name, int number, MyDate birthday,double wage, int hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }


    @Override
    public double eamings() {
        return this.wage * this.hour;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{ " + super.toString() + "}";
    }
}

