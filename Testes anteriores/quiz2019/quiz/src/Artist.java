public class Artist extends Act {

    public Artist(String name, String country) {
        super(name, country);
    }

    public boolean equals(Object obj) {
        Artist artist = (Artist) obj;

        return getName().equals(artist.getName()) && getCountry().equals(artist.getCountry());
    }
}
