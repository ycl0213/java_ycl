package interface_application;

/**
 * 工厂方法
 */
public class TestFactoryMethod {
    public static void main(String[] args) {
        IWorkFactory i= new StudentWorkFactory();
        i.getWork().doWork();  //编译的时候都是接口在执行操作，运行的时候是具体的实现类在执行操作
        IWorkFactory i1 = new TeacherWorkFactory();
        i1.getWork().doWork();

    }
}
//Work接口
interface Work{
    void doWork();
}

//StudentWork类实现Work接口
class StudentWork implements Work{

    @Override
    public void doWork() {
        System.out.println("学生写作业");
    }
}
//TeacherWork类实现Work接口
class TeacherWork implements Work{

    @Override
    public void doWork() {
        System.out.println("老师批改作业");
    }
}

//IWorkFactory接口
interface IWorkFactory{
    Work getWork(); //返回Work类型 在工厂对象上调用的是创建方法
}

//StudentWorkFactory类实现IWorkFactory接口
class StudentWorkFactory implements IWorkFactory{

    @Override
    public Work getWork() {
        return new StudentWork();
    }
}

//TeacherWorkFactory类实现IWorkFactory接口
class TeacherWorkFactory implements IWorkFactory{

    @Override
    public Work getWork() {
        return new TeacherWork();
    }
}

