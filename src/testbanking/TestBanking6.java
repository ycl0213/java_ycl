package testbanking;


import banking6.Bank;
import banking6.CheckingAccount;
import banking6.Customer;
import banking6.SavingAccount;
import banking6.reports.CustomerReport;

public class TestBanking6 {
    public static void main(String[] args) {
        Bank b = Bank.getBanking();
        Customer customer;
        CustomerReport report = new CustomerReport();

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
        report.generateReport();


    }
}
