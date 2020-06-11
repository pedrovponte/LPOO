import java.util.HashSet;
import java.util.Set;

public class Building extends Facility {
    private String name;
    private int minFloor;
    private int maxFloor;
    Set<Room> roomSet;

    public Building(String name, int minFloor, int maxFloor) throws IllegalArgumentException, DuplicateRoomException {
        super(name, 0);
        if(minFloor > maxFloor)
            throw new IllegalArgumentException();
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.roomSet = new HashSet<>();
    }

    public Building(String name, String name1, int minFloor, int maxFloor, int capacity) throws IllegalArgumentException, DuplicateRoomException {
        super(name, capacity);
        if(minFloor > maxFloor)
            throw new IllegalArgumentException();
        this.name = name1;
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.roomSet = new HashSet<>();
    }

    public int getMinFloor() {
        return minFloor;
    }

    public void setMinFloor(int minFloor) {
        this.minFloor = minFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(int maxFloor) {
        this.maxFloor = maxFloor;
    }

    public String toString() {
        return "Building(" + this.getName() + ")";
    }

    public void addRoom(Room room) throws DuplicateRoomException {
        if(!roomSet.add(room))
            throw new DuplicateRoomException();
        setCapacity(getCapacity() + room.getCapacity());
    }
}
