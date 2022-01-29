package extend;

public class TestAccount {
    public static void main(String[] args) {
        Account a = new Account(1122,20000,0.045);
        a.withDraw(30000);
        System.out.println("当前余额为： " + a.getBalance());
        a.withDraw(2500);
        a.deposit(3000);
        System.out.println("当前余额为： " + a.getBalance());
        System.out.println("月利率为： " + a.getMonthlyInterest());
        System.out.println("======");

        CheckAccount ca = new CheckAccount(1122,20000,0.045,5000);
        ca.withDraw(5000);
        System.out.println("当前余额为： " + ca.getBalance());
        System.out.println("可透支限额为： " + ca.getOverdraft());

        ca.withDraw(18000);
        System.out.println("当前余额为： " + ca.getBalance());
        System.out.println("可透支限额为： " + ca.getOverdraft());

        ca.withDraw(3000);
        System.out.println("当前余额为： " + ca.getBalance());
        System.out.println("可透支限额为： " + ca.getOverdraft());

    }
}
class Account{
    private int id;
    private double balance;
    private double annualInterestRate;

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    public double getMonthlyInterest(){
        return this.annualInterestRate / 12;
    }
    //取钱
    public void withDraw(double m){
      if(balance >= m){
          balance -= m;
      }else{
          System.out.println("余额不足，取款失败！");
      }
    }
    //存钱
    public void deposit(double m){
        balance += m;
    }
}

class CheckAccount extends Account{
    private double overdraft; //可透支限额

    public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    //重写withDraw方法
    public void withDraw(double m){
        if(m <= super.getBalance()){
            super.setBalance(super.getBalance() - m);
        }else if(m > super.getBalance()){
            double over = m - super.getBalance();
            if(over <= overdraft){
                super.setBalance(0);
                overdraft -= over;
            }else{
                System.out.println("超过可透支的限额！");
            }
        }

    }
}
