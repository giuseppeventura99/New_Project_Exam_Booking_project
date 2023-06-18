import java.util.ArrayList;

public class Hotel implements Comparable<Hotel>
{
    public String name;
    public double price;

    public String city;
    public int ID_booking;
    int rate;


    public Hotel(String name, double price, String city, int ID_booking,int rate ) {
        this.name = name;
        this.price = price;
        this.city = city;
        this.ID_booking= ID_booking;
        this.rate=rate;

    }


    //--------------------------
    ArrayList<Person>reserved_people= new ArrayList<>();

    public ArrayList<Person> getReserved_people() {
        return reserved_people;
    }

    public void AddReservedPerson(Person person)
    {
        reserved_people.add(person);

    }

    //-------------------------
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


    public void setRate(int rate) {
        this.rate = rate;
    }


    public int getRate() {
        return rate;
    }

    public int getID_booking() {
        return ID_booking;
    }

    public String getCity() {
        return city;
    }



    @Override
    public String toString() {
        return ID_booking + " | " +name + " | " + price + " | " + city + " | " + rate;
    }

    public String OtherString()
    {
        return ID_booking + " | " +name + " | " + price + " | " + city + " - "+ this.getReserved_people();
    }

    @Override
    public int compareTo(Hotel Other_hotel)
    {
        if(this.price< Other_hotel.getPrice())
        {
            return -1;
        }
        else if (this.price> Other_hotel.getPrice())
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }




}