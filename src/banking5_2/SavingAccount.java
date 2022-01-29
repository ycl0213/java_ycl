package banking5_2;

public class SavingAccount extends Account {
    protected double IntereseRate;
    public SavingAccount(double balance, double interest_rate){
        super(balance);
        this.IntereseRate = interest_rate;
    }

    public void setIntereseRate(double intereseRate) {
        IntereseRate = intereseRate;
    }

    public double getIntereseRate() {
        return IntereseRate;
    }
}
