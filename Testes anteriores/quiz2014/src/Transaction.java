public abstract class Transaction {
    private ATM atm;
    private Session session;
    private Card card;
    private double amount;

    public Transaction(ATM atm, Session session, Card card, double amount) {
        this.atm = atm;
        this.session = session;
        this.card = card;
        this.amount = amount;
    }

    public ATM getATM() {
        return atm;
    }

    public void setATM(ATM atm) {
        this.atm = atm;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
