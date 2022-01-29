package banking4;

public class Account {
    private double balance; //账户余额
    public Account(double init_balance){
        balance = init_balance;

    }
    public double getBalance(){
        return balance;
    }
    //存钱
    public void deposit(double amt){
        balance += amt;

    }
    //取钱
    public void withdraw(double amt){
        if(balance >= amt) {
            balance -= amt;
        }else{
            System.out.println("余额不足！");
        }

    }
}
