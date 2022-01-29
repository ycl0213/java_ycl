package testmap;

import com.sun.media.jfxmediaimpl.HostUtils;

import java.rmi.StubNotFoundException;
import java.util.*;

/**
 * 把学生名与考试分数录入Map中，并按分数显示前三名成绩学员的名字
 * 知识点：TreeMap如何实现按照value排序
 */
public class MapExercise {
    public static void main(String[] args) {
        Student s1 = new Student("小花", 78);
        Student s2 = new Student("小名", 88);
        Student s3 = new Student("小蓝", 76);
        Student s4 = new Student("小敏", 90);
        Student s5 = new Student("小华", 98);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(s1.getName(), s1.getScore());
        map.put(s2.getName(), s2.getScore());
        map.put(s3.getName(), s3.getScore());
        map.put(s4.getName(), s4.getScore());
        map.put(s5.getName(), s5.getScore());
        //1、将Map转为List
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        //2、创建实现了Comparator接口的类对象
        Comparator<Map.Entry<String, Integer>> com = new Comparator<Map.Entry<String,Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
        };
        //3、运用Collections工具类中的sort方法对list进行排序
        Collections.sort(list, com);
        System.out.println(list);
        //4、获取键值
        for (int i = 0; i < 3; i++) {
            System.out.println(list.get(i).getKey()); //显示前三名成绩学员的名字
        }
    }
}

class Student{
    private String name;
    private Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name) &&
                score.equals(student.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

}
