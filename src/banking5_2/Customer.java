package banking5_2;

public class Customer {
    private String firstName;
    private String lastName;
    private SavingAccount savingAccount; //储蓄账户
    private CheckingAccount checkingAccount; //支票账户
    public Customer(String f, String l){
        firstName = f;
        lastName = l;
    }

    public void setSaving(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    public void setChecking(CheckingAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public SavingAccount getSaving() {
        return savingAccount;
    }

    public CheckingAccount getChecking() {
        return checkingAccount;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

}
