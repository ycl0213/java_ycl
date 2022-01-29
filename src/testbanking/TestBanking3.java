package testbanking;

import banking3.Account;
import banking3.Customer;

public class TestBanking3 {
    public static void main(String[] args) {
        Customer customer;
        Account account;
        //创建一个账户，余额为500元
        account = new Account(500);
        System.out.println("当前账户余额为： " + account.getBalance());
        //创建一个customer
        customer = new Customer("Jane","Smith");
        //将人与账户关联
        customer.setAccount(account);
        //取钱
        customer.getAccount().withdraw(150);
        System.out.println("取150元后账户余额为：" + customer.getAccount().getBalance());
        //存钱
        customer.getAccount().deposit(22.50);
        System.out.println("存22.5元后账户余额为： " + customer.getAccount().getBalance());
        //取钱
        customer.getAccount().withdraw(47.62);
        System.out.println("取47.62元后账户余额为：" + customer.getAccount().getBalance());

        System.out.println("customer [" + customer.getFirstName() + " " + customer.getLastName() + "] " + "的账户余额为： " + customer.getAccount().getBalance());


    }
}
