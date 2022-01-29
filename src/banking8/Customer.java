package banking8;

import javax.security.auth.login.AccountExpiredException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {
    private String firstName;
    private String lastName;
    private List<Account> accounts; //使用集合
    public Customer(String f, String l){
        firstName = f;
        lastName = l;
        accounts = new ArrayList<>();

    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void addAccount(Account acct){
        accounts.add(acct);
    }
    public int getNumberOfAccount(){
        return accounts.size();
    }
    public Account getAccount(int index){
        return accounts.get(index);
    }
    public Iterator<Account> getAccounts(){
        return accounts.iterator();
    }

//    public Account getAccount(){
//        return account;
//    }
//    public void setAccount(Account acct){
//        account = acct;
//    }

}
