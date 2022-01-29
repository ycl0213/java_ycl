package testDAO;

import org.junit.Test;

import java.util.*;

public class TestDAO {
    @Test
    public void test(){
        DAO<User> dao = new DAO<>();
        dao.save("11", new User(1,23,"AA"));
        dao.save("12", new User(2,24,"BB"));
        dao.save("13", new User(3,24,"CC"));
        System.out.println(dao.map);
        System.out.println("========");
        System.out.println(dao.get("12"));
        System.out.println("=========");
        dao.update("11", new User(6, 18, "DD"));
        System.out.println(dao.map);
        List<User> l = dao.list();
        System.out.println(l);
        System.out.println("========");
        dao.delete("11");
        System.out.println(dao.map);
    }
}
//自定义的泛型类DAO
class DAO<T>{
    Map<String, T> map = new HashMap<>();
    public void save(String id, T entity){
        map.put(id, entity);
    }
    public T get(String id){
        return map.get(id);
    }
    public void update(String id, T entity){
        map.put(id, entity);
    }
    public List<T> list(){
        List<T> list = new ArrayList<>();
        for(String s : map.keySet()){
            list.add(map.get(s));
        }
        return list;
    }
    public void delete(String id){
        map.remove(id);
    }
}

//User类
class User{
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                age == user.age &&
                name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name);
    }
}