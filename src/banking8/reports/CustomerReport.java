package banking8.reports;

import banking8.*;

import java.util.Iterator;

/**
 * 使用Iterator实现集合的遍历
 */
public class CustomerReport {
    Bank b = Bank.getBanking();
    Customer customer;

    public void generateReport() {
        Iterator<Customer> iterator = b.getCustomers();
        while (iterator.hasNext()) {
            Customer cus = iterator.next();
            System.out.println("customer: " + cus.getFirstName() + " " + cus.getLastName());
            Iterator<Account> iterator1 = cus.getAccounts();
            while (iterator1.hasNext()) {
                Account account = iterator1.next();
                String account_type = "";
                if (account instanceof SavingAccount) {
                    account_type = "SavingAccount";
                }
                if (account instanceof CheckingAccount) {
                    account_type = "CheckingAccount";
                }
                System.out.println(account_type + ": current balance is " + account.getBalance());
            }
            System.out.println();
        }

    }

}

