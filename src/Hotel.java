public class Hotel
{
    private String name;
    private double price;

    private String city;

    public Hotel(String name, double price, String city) {
        this.name = name;
        this.price = price;
        this.city = city;
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
