import java.util.Objects;

abstract class Act {

    private String name;
    private String country;

    Act(String name, String country){
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Act)) return false;
        Act act = (Act) o;
        return Objects.equals(name, act.name) && Objects.equals(country, act.country);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, country);
    }
}
