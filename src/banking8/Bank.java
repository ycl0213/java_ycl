package banking8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank {
    private List<Customer> customers; //使用集合
    private static Bank bank = new Bank();

    private Bank() {
        customers = new ArrayList<>();
    }

    public static Bank getBanking() {
        return bank;
    }

    public void addCustomer(String f, String l) {
        Customer customer = new Customer(f, l);
        customers.add(customer);
    }

    public int getNumberOfCustomer() {
        return customers.size();
    }

    public Customer getCustomer(int index) {
        return customers.get(index);
    }
    public Iterator<Customer> getCustomers(){
        return customers.iterator();
    }
}
