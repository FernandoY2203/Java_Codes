
package entities;

public final class SavingsAccount extends Account{
    private Double interestRate;

    
    public SavingsAccount(Double interestRate, Integer number, String holder, Double balance) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    
    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }
    
    
    public void updateBalance(){
        balance *= 1 + interestRate;
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
    }
}
