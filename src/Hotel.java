import java.util.ArrayList;

public class Hotel implements Comparable<Hotel>
{
    public String name;
    public double price;

    public String city;
    public int ID_booking;
    double rate;
    int number_rating;
    String comment;



    public Hotel(String name, double price, String city, int ID_booking, double rate, int number_rating, String comment) {
        this.name = name;
        this.price = price;
        this.city = city;
        this.ID_booking = ID_booking;
        this.rate = rate;
        this.number_rating = number_rating;
        this.comment=comment;


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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }




    public String StringConcatenation(String str1, String str2) {

            return str1 + "|" +str2;
        }


    //metodo per prenotare
    public void Booking(String user_name,String user_surname,int selected_ID)
    {
        if(this.getID_booking()==selected_ID)

        {
            //allora dico che una stanza in questo albergo è stata prenotata
            System.out.println(  user_name+ " "+user_surname+ " booked a room in "+this.getName()+" ");

        }
    }


    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public int getID_booking() {
        return ID_booking;
    }

    public int getNumber_rating() {
        return number_rating;
    }

    public void setNumber_rating(int number_rating) {
        this.number_rating = number_rating;
    }

    public String getCity() {
        return city;
    }


    @Override
    public String toString() {
        return ID_booking + " | " +name + " | " + price + " | " + city + " | " + rate+ " Comments:"+comment+"";
    }

    public String OtherString()
    {
        return ID_booking + " | " +name + " | " + price + " | " + city + " - "+ this.getReserved_people();
    }

    public String PresentationString() {
        return ID_booking + " | " +name + " | " + price + " | " + city ;
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