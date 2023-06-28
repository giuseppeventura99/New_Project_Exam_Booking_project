import java.time.LocalDate;
import java.util.Date;

public class Booking implements Comparable<Booking>
{
    public Booking(int ID, String personID, int hotelID, int roomID, String startDate, String endDate, String status) {
        this.ID = ID;
        PersonID = personID;
        HotelID = hotelID;
        RoomID = roomID;
        StartDate = startDate;
        EndDate = endDate;
        Status = status;
    }
    public  int ID;
    public  String PersonID;
    public  int HotelID;
    public  int RoomID;
    public String StartDate;
    public String EndDate;
    public String Status;
    @Override
    public int compareTo(Booking o) {
        return 0;
    }
}
