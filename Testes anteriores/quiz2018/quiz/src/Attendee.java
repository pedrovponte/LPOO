public class Attendee extends Person{
    private boolean paid;

    public Attendee(String name) {
        super(name);
        this.paid = false;
    }

    public Attendee(String name, int age) {
        super(name, age);
        this.paid = false;
    }

    public boolean hasPaid() {
        return this.paid;
    }

    public String toString() {
        return "Attendee " + this.getName() + (this.hasPaid() ? " has" : " hasn't") + " paid its registration.";
    }
}
