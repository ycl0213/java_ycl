package banking8;

public class CheckingAccount extends Account {
    protected Double overDraftProtection;
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

    public void withdraw(double amt) throws OverdraftException{
        if(balance >= amt){
            balance -= amt;
        } else if(overDraftProtection == null){
            throw new OverdraftException(amt - balance,"没有透支账户");
        } else if(amt - balance <= overDraftProtection){
            overDraftProtection -= (amt-balance);
            balance = 0;
        }else{
            throw new OverdraftException(amt - balance - overDraftProtection, "资金不足");
        }
    }
}
