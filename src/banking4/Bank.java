package banking4;

public class Bank {
    private Customer[] customers;
    private int numberOfCustomer;
    public Bank(int size){
        customers = new Customer[size];
    }
    public void addCustomer(String f, String l){
        Customer customer = new Customer(f,l);
        customers[numberOfCustomer] = customer;
        numberOfCustomer++;
    }
    public int getNumberOfCustomer(){
        return numberOfCustomer;
    }
    public Customer getCustomer(int index){
        return customers[index];
    }
}
