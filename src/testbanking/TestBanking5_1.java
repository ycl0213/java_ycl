package testbanking;

import banking5_1.*;

public class TestBanking5_1 {
    public static void main(String[] args) {
        Bank b = new Bank(5);
        Customer customer;
        b.addCustomer("Jane","Smith");
        customer = b.getCustomer(0);
        customer.addAccount(new SavingAccount(500, 0.05));
        customer.addAccount(new CheckingAccount(200,400));

        b.addCustomer("Maria", "Bryant");
        customer = b.getCustomer(1);
        customer.addAccount(new CheckingAccount(200));

        b.addCustomer("Tim", "Soley");
        customer = b.getCustomer(2);
        customer.addAccount(new SavingAccount(1500,0.05));
        customer.addAccount(new CheckingAccount(200));

        b.addCustomer("Maria", "Soley");
        customer = b.getCustomer(3);
        customer.addAccount(b.getCustomer(2).geAccount(1));
        customer.addAccount(new SavingAccount(150,0.05));

        for (int i = 0; i < b.getNumberOfCustomer(); i++) {
            System.out.println("customer: " + b.getCustomer(i).getFirstName() + " " + b.getCustomer(i).getLastName());
            for (int j = 0; j < b.getCustomer(i).getNumberOfAccount(); j++) {
                Account account = b.getCustomer(i).geAccount(j);
                String account_type = "";
                if(account instanceof SavingAccount){
                    account_type = "SavingAccount";
                }
                if(account instanceof CheckingAccount){
                    account_type = "CheckingAccount";
                }
                System.out.println(account_type + ": current balance is " + account.getBalance());
            }
            System.out.println();
        }

    }
}
