package testbanking;

import banking.Account;

public class TestBanking1 {
    public static void main(String[] args) {
        Account account;
        //创建一个有500余额的账户
        account = new Account(500);
        System.out.println("Creating an account with a 500.00 balance.");
        System.out.println(account.getBalance());
        //取150元
        account.withdraw(150);
        System.out.println("取150元后账户余额为： " + account.getBalance());
        //存22.5元
        account.deposit(22.5);
        System.out.println("存22.5元后账户余额为: " + account.getBalance());
        //取47.62元
        account.withdraw(47.62);
        System.out.println("取47.62元后账户余额为：" + account.getBalance());
    }


}
