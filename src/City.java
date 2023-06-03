public class City
{
    private String name;
    private int n_hotel;
    private double s_index; //It's satisfation_index


    public City(String name, int n_hotel, double s_index) {
        this.name = name;
        this.n_hotel = n_hotel;
        this.s_index = s_index;
    }


    public String getName() {
        return name;
    }

    public int getN_hotel() {
        return n_hotel;
    }

    public double getS_index() {
        return s_index;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", n_hotel=" + n_hotel +
                ", s_index=" + s_index +
                '}';
    }
}
