package banking6;

public class CheckingAccount extends Account {
    protected double overDraftProtection;
    public CheckingAccount(double balance){
        super(balance);
    }
    public CheckingAccount(double balance, double overDraftProtection){
        super(balance);
        this.overDraftProtection = overDraftProtection;
    }

    public void setOverDraftProtection(double overDraftProtection) {
        this.overDraftProtection = overDraftProtection;
    }

    public double getOverDraftProtection() {
        return overDraftProtection;
    }

    public boolean withdraw(double amt){
        if(balance >= amt){
            balance -= amt;
            return true;
        }else if(amt - balance <= overDraftProtection){
            overDraftProtection -= (amt-balance);
            balance = 0;
            return true;
        }else{
            //System.out.println("取款失败");
            return false;
        }
    }
}
