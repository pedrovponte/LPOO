public class Artist extends Act {
    Artist(String name, String country) {
        super(name, country);
    }

    public boolean equals(Object o){
        if(o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

}
