public class Withdrawal extends Transaction {
    public Withdrawal(ATM atm, Session session, Card card, double amount) {
        super(atm, session, card, amount);
    }

    @Override
    public String toString() {
        return "Withdrawal at ATM " + this.getATM().getID() + " (" + this.getATM().getCity() + ", " + this.getATM().getBank() + ") of " + String.format("%.2f", getAmount()).replace(',', '.');
    }
}
