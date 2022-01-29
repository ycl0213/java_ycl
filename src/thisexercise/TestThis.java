package thisexercise;

import java.security.AccessControlContext;

public class TestThis {
    public static void main(String[] args) {
        Customer customer = new Customer("Jane","Smith");
        Account account = new Account(1000,2000,0.0123);
        customer.setAccount(account);
        customer.getAccount().deposit(100);
        customer.getAccount().withdraw(960);
        customer.getAccount().withdraw(2000);
        System.out.println("Customer [" + customer.getFirstName() + " " + customer.getLastName() + "]" + " has a balance: id is " + customer.getAccount().getId()
                + ", annualInterestRate is " + customer.getAccount().getAnnualInterestRate() * 100 + "%" + ", balance is " +customer.getAccount().getBalance());
    }
}

