package testbanking;

import banking4.Bank;
import banking4.Customer;

public class TestBanking4 {
    public static void main(String[] args) {
        Bank b = new Bank(5);
        b.addCustomer("Jane","Smith");
        b.addCustomer("Owen","Bryant");
        b.addCustomer("Tim","Soley");
        b.addCustomer("Maria","Soley");
        for (int i = 0; i < b.getNumberOfCustomer() ; i++) {
            Customer customer = b.getCustomer(i);
            System.out.println("Customer [" + (i + 1) + "] is " + customer.getFirstName() + " " + customer.getLastName());
        }
    }
}
