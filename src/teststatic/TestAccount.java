package teststatic;
public class TestAccount {
    public static void main(String[] args) {
        Account a1 = new Account("12345", 200);
        a1.show();
        Account a2 = new Account("123456", 700);
        a2.show();
        Account a3 = new Account("1234567", 500);
        a3.show();

    }



}

class Account{
    private int id;
    private String password;
    private double balance;
    private static double interestRate = 0.05;
    private static double min_balance = 100;
    private static int init = 1000;

    public Account(String password, double balance) {
        this.id = init++;
        this.password = password;
        this.balance = balance;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setMin_balance(double min_balance) {
        this.min_balance = min_balance;
    }


    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getMin_balance() {
        return min_balance;
    }
    public void show(){
        System.out.println("账号： " + id + ",存款余额： " + balance + ", 利率： " + interestRate + "，最小余额： " + min_balance);
    }
}
