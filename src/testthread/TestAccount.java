package testthread;

/**
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 */
/**
 * 1、是否涉及到多线程？ 是，两个储户（两种方式创建多线程）；
 * 2、是否有共享数据？ 有，同一个账户
 * 3、考虑线程的同步。
 */
//1、实现的方式创建多线程；同步代码块的方式解决线程安全问题
public class TestAccount {
    public static void main(String[] args) {
        Account a = new Account(0);
        Customer c = new Customer(a);
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.setName("储户1");
        t2.setName("储户2");
        t1.start();
        t2.start();
    }
}
class Customer implements Runnable{
    Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }
    }
}
class Account{
    private double balance; //余额

    public Account(int balance) {
        this.balance = balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
    //存钱：实现交替存钱
    public void deposit(double money) {
        synchronized (this) {
            notify();
            this.balance = this.balance + money;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": " + getBalance());
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
