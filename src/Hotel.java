public class Hotel
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
}
