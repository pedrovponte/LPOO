import java.util.Objects;

public class Room extends Facility {
    private Building building;
    private String number;
    private int floor;

    public Room(Building building, String number, int floor) throws IllegalArgumentException, DuplicateRoomException {
        super(building.getName(), 0);
        if(floor > building.getMaxFloor())
            throw new IllegalArgumentException();
        this.building = building;
        this.number = number;
        this.floor = floor;
        this.building.addRoom(this);
    }

    public Room(Building building, String number, int floor, int capacity) throws IllegalArgumentException, DuplicateRoomException {
        super(building.getName(), capacity);
        if(floor > building.getMaxFloor())
            throw new IllegalArgumentException();
        this.building = building;
        this.number = number;
        this.floor = floor;
        this.building.addRoom(this);
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String getName() {
        return this.building.getName() + this.getNumber();
    }

    public String toString() {
        return "Room(" + this.building.getName() + "," + this.getNumber() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return floor == room.floor &&
                Objects.equals(building, room.building) &&
                Objects.equals(number, room.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(building, number, floor);
    }

    @Override
    public void authorize(User user) {
        super.authorize(user);
        this.building.authorize(user);
    }
}
