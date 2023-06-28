import java.security.PublicKey;
import java.util.ArrayList;


public class Room implements Comparable<Room> {

    public Room(int ID, String title, String type, String roomNumber, int capacity, int hotel_ID) {
        this.ID = ID;
        Title = title;
        Type = type;
        RoomNumber = roomNumber;
        Capacity = capacity;
        Hotel_ID = hotel_ID;
    }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public int ID;
    public String Title;
    public String Type;
    public String RoomNumber;
    public  int Capacity;
    public int Hotel_ID;


    @Override
    public int compareTo(Room o) {
        return 0;
    }
}
