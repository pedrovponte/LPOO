import java.util.ArrayList;
import java.util.List;

public class Event {
    private String title;
    private String date;
    private String description;
    private List<Person> people = new ArrayList<>();

    public Event(String title) {
        this.title = title;
        this.date = "";
        this.description = "";
    }

    public Event(String title, String date) {
        this.title = title;
        this.date = date;
        this.description = "";
    }

    public Event(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
    }

    Event(Event event) {
        this.title = event.title;
        this.date = event.date;
        this.description = event.description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return this.title + " is a " + this.description + " and will be held at " + this.date + ".";
    }

    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Event event = (Event) obj;

        return getTitle().equals(event.getTitle()) && getDate().equals(event.getDate()) && getDescription().equals(event.getDescription());
    }

    public void addPerson(Person person) {
        if(!people.contains(person))
            people.add(person);
    }

    public int getAudienceCount() {
        return people.size();
    }

    public List<Person> getPeople() {
        return people;
    }

    public void addEvent(Event event) {
        people.addAll(event.getPeople());
    }
}
