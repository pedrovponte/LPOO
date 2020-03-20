import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Concert {
    private String country;
    private String city;
    private String date;
    private ArrayList<Act> acts;
    private int nextTicket;

    Concert(String city, String country, String date){
        this.city = city;
        this.country = country;
        this.date = date;
        this.acts = new ArrayList<>();
        this.nextTicket = 1;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getDate() {
        return date;
    }

    public void addAct(Act act){
        acts.add(act);
    }

    public List<Act> getActs(){
        return acts;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Concert concert = (Concert) o;
        return Objects.equals(city, concert.city) &&
                Objects.equals(country, concert.country) &&
                Objects.equals(date, concert.date);
    }

    @Override
    public int hashCode(){
        return Objects.hash(city, country, date);
    }

    public boolean isValid(Ticket ticket){
        return this.equals(ticket.getConcert());
    }

    public boolean participates(Artist artist){
        if(acts.contains(artist)) return true;
        for(Act act : acts){
            if(act instanceof Band){
                if(((Band) act).containsArtist(artist))
                    return true;
            }
        }
        return false;
    }

    public int getTicketNumberAndIncrement(){
        return nextTicket++;
    }
}
