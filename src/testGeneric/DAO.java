package testGeneric;

import java.util.List;

/**
 * DAO:databass access object 数据库访问对象
 */
//指明为通用的
public class DAO<T>{
    public void add(T t){
        //....
    }
    public T get(int index){
        return null;
    }
    public List<T> getForList(int index){
        return null;
    }
    public void delete(int index){

    }
}
