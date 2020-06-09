import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Concert {
    private String city;
    private String country;
    private String date;
    private List<Act> acts = new ArrayList<>();
    private int id = 1;

    public Concert(String city, String country, String date) {
        this.city = city;
        this.country = country;
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Act> getActs() {
        return acts;
    }

    public void setActs(List<Act> acts) {
        this.acts = acts;
    }

    public void addAct(Act act) {
        this.acts.add(act);
    }

    public boolean equals(Object obj) {
        Concert concert = (Concert) obj;

        return getCity().equals(concert.getCity()) && getCountry().equals(concert.getCountry()) && getDate().equals(concert.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, date);
    }

    public boolean isValid(Ticket ticket) {
        return this.equals(ticket.getConcert());
    }

    public boolean participates(Artist artist) {
        for(Act act : acts) {
            if(act instanceof Band && ((Band) act).getArtists().contains(artist))
                return true;
            else if(act.equals(artist))
                return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void incrementId() {
        id++;
    }
}
