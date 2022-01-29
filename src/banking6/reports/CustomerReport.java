package banking6.reports;

import banking6.Account;
import banking6.CheckingAccount;
import banking6.SavingAccount;
import banking6.Bank;
import banking6.Customer;

public class CustomerReport {
    Bank b = Bank.getBanking();
    public void generateReport(){
        for(int i = 0; i < b.getNumberOfCustomer(); i++) {
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
