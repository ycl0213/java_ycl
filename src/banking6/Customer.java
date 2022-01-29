package banking6;

public class Customer {
    private String firstName;
    private String lastName;
    //private Account account;
    private Account[] accounts;
    private int numberOfAccount;
    public Customer(String f, String l){
        firstName = f;
        lastName = l;
        accounts = new Account[5];

    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void addAccount(Account acct){
        accounts[numberOfAccount] = acct;
        numberOfAccount++;
    }
    public int getNumberOfAccount(){
        return numberOfAccount;
    }
    public Account geAccount(int index){
        return accounts[index];
    }

//    public Account getAccount(){
//        return account;
//    }
//    public void setAccount(Account acct){
//        account = acct;
//    }

}
