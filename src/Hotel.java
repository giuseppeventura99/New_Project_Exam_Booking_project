public class Hotel implements Comparable<Hotel>
{
    public String name;
    public double price;

    public String city;
    public int ID_booking;
    double rate;

    public Hotel(String name, double price, String city, int ID_booking,double rate) {
        this.name = name;
        this.price = price;
        this.city = city;
        this.ID_booking= ID_booking;
        this.rate=rate;
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
        if(this.getCity().equals(city_name))
        {
            System.out.println(" "+ this.getID_booking()+" - "+this.getName()+this.getPrice()+ " , "+ this.getCity() );
        }

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