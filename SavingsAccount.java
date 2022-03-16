public class SavingsAccount extends Account {
    private double interestRate;
    public SavingsAccount(int idNum, double startBal, double ir)    {
        super(idNum, startBal);
        interestRate = ir;
    }
    public double monthlyInterest() {
        return(super.currentBalance()*interestRate)/12;
    }
}
