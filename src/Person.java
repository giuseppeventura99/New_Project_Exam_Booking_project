import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable
{

    private String name;
    private String surname;
    private int age;
    private String  Nationality;
    private String ID;

    private String password;


    ArrayList<Hotel> user_hotels= new ArrayList<Hotel>();



    public Person(String name, String surname, int age, String nationality, String ID,String password) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.Nationality = nationality;
        this.ID = ID;
        this.password=password;
        this.user_hotels= new ArrayList<Hotel>();
    }


    //getName
    //getSurname
    //getage


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return Nationality;
    }

    public String getID() {
        return ID;
    }
    //aggiungo l'hotel nell'array persona
    public void addHotel_in_userlist(Hotel hotel)
    {
        user_hotels.add(hotel);
    }



    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", Nationality='" + Nationality + '\'' +
                ", ID='" + ID + '\'' +
                ", password='" + password + '\'' +
                '}';



    }
}
