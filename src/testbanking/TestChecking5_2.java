package testbanking;

import banking5_2.*;

public class TestChecking5_2 {
    public static void main(String[] args) {
        Bank bank = new Bank(5);
        Customer customer;
        Account account;
        bank.addCustomer("Jane", "Smith");
        customer = bank.getCustomer(0);
        customer.setSaving(new SavingAccount(500,0.05));
        customer.setChecking(new CheckingAccount(200,customer.getSaving()));

        bank.addCustomer("Owen","Bryant");
        customer = bank.getCustomer(1);
        customer.setChecking(new CheckingAccount(200));

        customer = bank.getCustomer(0);
        account = customer.getChecking();
        System.out.println("Customer [" + customer.getFirstName() + " " + customer.getLastName() + "] has a checking balance of " + account.getBalance());
        account.withdraw(100);
        account.deposit(25);
        account.withdraw(175);
        System.out.println("Customer [" + customer.getFirstName() + " " + customer.getLastName() + "] has a checking balance of " + account.getBalance());

        customer = bank.getCustomer(1);
        account = customer.getChecking();
        System.out.println("Customer [" + customer.getFirstName() + " " + customer.getLastName() + "] has a checking balance of " + account.getBalance());
        account.withdraw(100);
        account.deposit(25);
        account.withdraw(175);
        System.out.println("Customer [" + customer.getFirstName() + " " + customer.getLastName() + "] has a checking balance of " + account.getBalance());

    }
}
