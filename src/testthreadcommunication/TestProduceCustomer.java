package testthreadcommunication;

/**
 * 生产者/消费者问题
 * 生产者(Productor)将产品交给店员(Clerk)，
 * 而消费者(Customer)从店员处取走产品，店员一次只能持有固定数量的产品(比如:20），
 * 如果生产者试图生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；
 * 如果店中没有产品了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 */

/**
 * 分析：
 * 1、是否是多线程？ 是！ 生产者、消费者
 * 2、是否有共享数据？ 有！ 考虑线程安全问题
 * 3、共享数据是谁？ 产品
 * 4、是否存在线程通信？ 存在！生产者与消费者
 */
public class TestProduceCustomer {
    public static void main(String[] args) {
        Clerk cl = new Clerk();
        Producer p = new Producer(cl);
        Customer c = new Customer(cl);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        Thread t3 = new Thread(p);
        t1.setName("生产者1");
        t2.setName("消费者1");
        t3.setName("生产者2");
        t1.start();
        t2.start();
        t3.start();
    }
}

//包含共享数据的类
class Clerk{
    int number;
    public synchronized void addNumber(){ //同步方法  生产者生产产品
        if(number >= 20){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            number++;
            notifyAll();
            System.out.println(Thread.currentThread().getName() + "生产了" + number +"个产品");
        }
    }
    public synchronized void consumeNumber(){  //消费者消费产品
        if(number <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(Thread.currentThread().getName() + "消费了" + number +"个产品");
            number--;
            notifyAll();
        }
    }
}
//生产者
class Producer implements Runnable{
    Clerk clerk;
    public Producer(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("生产者开始生产产品");
            clerk.addNumber();
        }
    }
}
//消费者
class Customer implements Runnable{
    Clerk clerk;
    public Customer(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("消费者开始消费产品");
            clerk.consumeNumber();
        }
    }
}
