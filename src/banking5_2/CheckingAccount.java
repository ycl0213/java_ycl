package banking5_2;

public class CheckingAccount extends Account {
    protected SavingAccount protectedBy;
    public CheckingAccount(double balance){
        super(balance);
    }

    public CheckingAccount(double init_balance, SavingAccount protectedBy) {
        super(init_balance);
        this.protectedBy = protectedBy;
    }

    public SavingAccount getProtectedBy() {
        return protectedBy;
    }

    public void setProtectedBy(SavingAccount protectedBy) {
        this.protectedBy = protectedBy;
    }

    public boolean withdraw(double amt){
        if(balance >= amt){
            balance -= amt;
            return true;
        }else if(protectedBy != null && amt - balance <= protectedBy.getBalance()){
            protectedBy.withdraw(amt - balance);
            balance = 0;
            return true;
        }else{
            //System.out.println("取款失败");
            return false;
        }
    }
}
