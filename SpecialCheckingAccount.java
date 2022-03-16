public class SpecialCheckingAccount extends CheckingAccount {
    private double minBal;
    private double interestRate;

    public SpecialCheckingAccount(int idNum, double startBal, double chkCharge, double ir, double min)  {
        super(idNum, startBal, chkCharge);
        interestRate = ir;
        minBal = min;
    }
    public void clearCheck(double amount)   {
        Double curBal = super.currentBalance();
        double min = minBal;
        if(curBal.compareTo(min) >= 0)
            decreaseBalance(amount);
        else
            super.clearCheck(amount);
    }
    public double monthlyInterest() {
        Double curBal = super.currentBalance();
        Double min = minBal;
        if(curBal.compareTo(min) >= 0)
            return (super.currentBalance()*interestRate)/12;
        else
            return super.monthlyInterest();
    }
}
