public class Hotel implements Comparable<Hotel>
{
    private String name;
    private double price;

    private String city;
    private int ID_booking;

    public Hotel(String name, double price, String city, int ID_booking) {
        this.name = name;
        this.price = price;
        this.city = city;
        this.ID_booking= ID_booking;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }




    //metodo per scrivere solo gli hotel di quella città
    public  void show_hotels_by_city(String city_name)
    {
        if(this.getName().equals(city_name))
        {
            System.out.println(" "+ this.getID_booking()+" - "+this.getName()+this.getPrice()+ " , "+ this.getCity() );
        }

    }


    //metodo per prenotare
    public void Booking(int selected_ID)
    {
        if(this.getID_booking()==selected_ID)

        {
            //allora dico che una stanza in questo albergo è stata prenotata
            System.out.println("A room in the hotel"+this.getName()+" has been booked");

        }
    }




    public int getID_booking() {
        return ID_booking;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", price=" + price +


                ", city='" + city + '\'' +
                '}';
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
