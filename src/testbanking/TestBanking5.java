package testbanking;

import banking5.*;

public class TestBanking5 {
    public static void main(String[] args) {
        Bank b = new Bank(5);
        Customer customer;
        Account account;

        b.addCustomer("Jane","Smith");
        account = new SavingAccount(500,0.03);
        customer = b.getCustomer(0);
        customer.setAccount(account);
        System.out.println("Creating the customer " + customer.getFirstName() + " " + customer.getLastName());
        System.out.println("Creating her Savings Account with a " + account.getBalance() + " balance and 3% interest");

        b.addCustomer("Owen","Bryant");
        account = new CheckingAccount(500,500);
        customer = b.getCustomer(1);
        customer.setAccount(account);
        System.out.println("Creating the customer " + customer.getFirstName() + " " + customer.getLastName());
        System.out.println("Creating her Savings Account with a " + account.getBalance() + " balance and  no overdraft protection");

        b.addCustomer("Tim","Soley");
        account = new CheckingAccount(500,500);
        customer = b.getCustomer(2);
        customer.setAccount(account);
        System.out.println("Creating the customer " + customer.getFirstName() + " " + customer.getLastName());
        System.out.println("Creating her Savings Account with a " + account.getBalance() + " balance and 500.0 in overdraft protection");

        b.addCustomer("Maria","Soley");
        customer = b.getCustomer(3);
        customer.setAccount(account);
        System.out.println("Maria shares her Checking Account with her husband Tim");


        customer = b.getCustomer(0);
        System.out.println("Retrieving the customer " + customer.getFirstName() + " " + customer.getLastName() + " with her Savings account.");
        account = customer.getAccount();

        System.out.println("withDraw 150" + ": " + account.withdraw(150));

        System.out.println("deposit 22.5" + ": " + account.deposit(22.5));

        System.out.println("withDraw 47.62" + ": " + account.withdraw(47.62));

        System.out.println("withDraw 400" + ": " + account.withdraw(400));
        System.out.println("Customer [" + customer.getFirstName() + " " + customer.getLastName() + "] has a balance of " + account.getBalance());

        customer = b.getCustomer(1);
        System.out.println("Retrieving the customer " + customer.getFirstName() + " " + customer.getLastName() + " with her Checking account.");
        account = customer.getAccount();

        System.out.println("withDraw 150" + ": " + account.withdraw(150));

        System.out.println("deposit 22.5" + ": " + account.deposit(22.5));

        System.out.println("withDraw 47.62" + ": " + account.withdraw(47.62));

        System.out.println("withDraw 400" + ": " + account.withdraw(400));
        System.out.println("Customer [" + customer.getFirstName() + " " + customer.getLastName() + "] has a balance of " + account.getBalance());



    }
}
