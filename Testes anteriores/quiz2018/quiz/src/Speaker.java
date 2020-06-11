public class Speaker extends Person {
    private int fee;

    public Speaker(String name) {
        super(name);
        this.fee = 0;
    }

    public Speaker(String name, int age) {
        super(name, age);
        this.fee = 0;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String toString() {
        return "Speaker " + this.getName() + " has a fee value of " + this.getFee() + ".";
    }
}
