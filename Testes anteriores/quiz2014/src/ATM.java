import java.util.Objects;

public class ATM {
    private int ID;
    private String city;
    private String bank;

    public ATM(int ID, String city, String bank) {
        this.ID = ID;
        this.city = city;
        this.bank = bank;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        this.ID = ID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ATM atm = (ATM) o;
        return ID == atm.ID &&
                Objects.equals(city, atm.city) &&
                Objects.equals(bank, atm.bank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, city, bank);
    }
}
