package thisexercise;

public class Account {
    private int id;//账号
    private double balance; //余额
    private double annualInterestRate;
    public Account(int id, double balance, double annualInterestRate){
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }
    public int getId(){
        return this.id;
    }
    public double getBalance(){
        return this.balance;
    }
    public double getAnnualInterestRate(){
        return this.annualInterestRate;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }
    public void withdraw(double amount){
        if(amount > this.balance){
            System.out.println("余额不足");
        }else{
            this.balance -= amount;
            System.out.println("成功取出: " + amount);
        }
    }
    public void deposit(double amount){
        this.balance += amount;
        System.out.println("成功存入： " + amount);
    }
}
