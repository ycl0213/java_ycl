package banking6;

public class Bank {
    private Customer[] customers;
    private int numberOfCustomer;
    private static Bank bank = new Bank();

    private Bank() {
        customers = new Customer[5];
    }

    public static Bank getBanking() {
        return bank;
    }

    public void addCustomer(String f, String l) {
        Customer customer = new Customer(f, l);
        customers[numberOfCustomer] = customer;
        numberOfCustomer++;
    }

    public int getNumberOfCustomer() {
        return numberOfCustomer;
    }

    public Customer getCustomer(int index) {
        return customers[index];
    }
}
