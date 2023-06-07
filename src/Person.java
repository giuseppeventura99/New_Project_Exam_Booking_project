import java.io.Serializable;

public class Person implements Serializable
{

    private String name;
    private String surname;
    private int age;
    private String  Nationality;
    private String ID;

    private String password;



    public Person(String name, String surname, int age, String nationality, String ID,String password) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.Nationality = nationality;
        this.ID = ID;
        this.password=password;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNationality() {
        return Nationality;
    }

    public String getID() {
        return ID;
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
