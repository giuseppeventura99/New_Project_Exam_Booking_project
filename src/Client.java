import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
    //let'so to add a new user!
    //so I need to an IP numeber and port
    public static void main(String[] args) {

        if (args.length!= 2) {
            System.out.println("Error , wrong number of arguments! use IP and PORT");
            System.exit(-1);
        }
        String ip = args[0];
        int port = Integer.parseInt(args[1]);

        ArrayList<Person>persone= new ArrayList<Person>();
        System.out.println("Trying to connet to " + ip + "at port " + port);
        try {
            var socket = new Socket(ip, port);
            //i need a stream
            var is= socket.getInputStream();
            var os = socket.getOutputStream();
            //scream about teh scanner if Wanna digit from the keyboard
            var sc = new Scanner(is);
            var pw = new PrintWriter(os);
            var input = new Scanner(System.in);
            String choose ="";
            System.out.println("Let's go!");
            //we can create the MENU
            ArrayList<Hotel> list_hotel= new ArrayList<>();
            //metodo per acquisire la lista

            //-----------------------------
            while(!choose.equals("q")) {
                System.out.println("1-Add an user:");
                System.out.println("2-Book an Hotel");
                System.out.println("3-List of users");
                System.out.println("4-Show us your expericence");
                System.out.println("q-Exit");
                System.out.println("------------------------------------------------");
                System.out.println("Select you choose:");
                var InputCommand = input.nextLine();
                switch (InputCommand) {
                    case "1":
                        //add an user
                        //login or register?
                        String l_or_r = "";
                        System.out.println("L-Login" + "R-Register");
                        l_or_r = input.nextLine();
                        if (l_or_r.equals("L")) {
                            //login
                            //you can enter
                            //and bring me to the menu
                            //I am checking that I am here
                            System.out.println("Name:");
                            var nome = input.nextLine();
                            System.out.println("Surname :");
                            var cognome = input.nextLine();
                            System.out.println("Password:");
                            var keyword = input.nextLine();

                            //HANIF PART
                            /* I wanna check if the user is inside or not!

                            The objective of this part is to write a code so that the program can  recognize the name,

                            surname and keyword that the client, in the registration part, sent to the server.
                            So they should return name, surname and password from the server to the client and match them
                            to the instances just requested from the user and which are typed from the keyboard.
                             If there is equality, the program goes on and the menu reappears, otherwise the program
                             says that the user is  not registered and that he must register
                             I need a code in both the Client class and the Server class.

                             */
                        } else if (l_or_r.equals("R")) {//register

                            pw.println("CMD_ADD_START");
                            pw.flush();
                            System.out.println("Name:");
                            var name = input.nextLine();
                            pw.println(name);
                            pw.flush();
                            System.out.println("Surname:");
                            var surname = input.nextLine();
                            pw.println(surname);
                            pw.flush();
                            System.out.println("Age:");
                            var age = input.nextLine();
                            pw.println(age);
                            pw.flush();
                            System.out.println("Nationality:");
                            var nationality = input.nextLine();
                            pw.println(nationality);
                            pw.flush();
                            System.out.println("ID:");
                            var ID = input.nextLine();
                            pw.println(ID);
                            pw.flush();
                            //I wanna create a random password that Hotel gives to the user

                            Random random = new Random();
                            int password = random.nextInt(90000) + 10000;
                            System.out.println("Password User is: " + password + " " + name + surname);

                            pw.println(password);
                            pw.flush();

                            pw.println("CMD_ADD_END");
                            pw.flush();
                        } else {
                            System.out.println("Choise not recognized.Try more");
                        }
                    case "2":
                        //booking hotel
                        //Choose the city
                        //List of many city
                        //ROMA, milano, catania.etc..
                        //Switch inside switch
                        /*
                        for example
                        1-ROMA:
                        //Add many Hotels(we can suggest some hotels)
                        //Order from the lowest price to the highest one
                        //Order from the lowest stars to the highest ones

                         */
                        //funzione che chiede al server di darmi una lista di hotel
                        System.out.println("Choose one of these cities:");

                        System.out.println("Alghero\nAosta\nBari\nBologna\nCagliari\nCatania\nFirenze\nGenova\nLecce\nMilano\nNapoli\nPerugia\nRimini\nRoma\nTorino\nTrento\nVenezia\nVerona");
                        String selected_city = "";
                        System.out.println("Choose a city:");
                        selected_city = input.nextLine();
                        // if (selected_city.equals("Alghero") || selected_city.equals("ALGHERO") || selected_city.equals("alghero")) {

                        // String our_city = "alghero";
                        String menu_choise = "";
                        System.out.println("Discover " + selected_city + " hotels!");
                        while (!choose.equals("q")) {
                            System.out.println("A-hotel list:");
                            System.out.println("B-From the lower price to the highter:");
                            System.out.println("C-Alphabetical Order");
                            System.out.println("D-Book an hotel");
                            System.out.println("q-Exit");
                            System.out.println("------------------------------------------------");
                            System.out.println("Make your choise:");



                            menu_choise = input.nextLine();
                            switch (menu_choise) {
                                case "A":
                                    //chiedo al server l'array di hotel della città che ho scelto
                                    var my_city = selected_city.toLowerCase();
                                    int dim;
                                    pw.println("CMD_LIST_START");
                                    pw.flush();
                                    pw.println("CMD_LIST_END");
                                    pw.flush();
                                    //invio la città
                                    pw.println(my_city);
                                    pw.flush();
                                    //ricevo la lunghezza dell'array hotel
                                    dim = sc.nextInt();
                                    //la stampo
                                    System.out.print(dim);
                                    //ricevo dal server quello che mi è stato inviato
                                    for (int i = 0; i < dim; i++) {

                                        var my_name = sc.nextLine();
                                        var my_price = sc.nextLine();
                                        var my_hotel_city = sc.nextLine();
                                        var my_ID = sc.nextLine();
                                        var my_rate = sc.nextLine();
                                        System.out.println("___________________________");
                                        System.out.print(my_name);
                                        System.out.print("|");
                                        System.out.print(my_ID);
                                        System.out.print("|");
                                        System.out.print(my_price);
                                        System.out.print("|");
                                        System.out.print(my_rate);
                                        System.out.print("|");
                                        System.out.print(my_hotel_city);
                                        System.out.println("|");
                                        System.out.println(" ");


                                    }
                                    //---------------------------------------------
                                case "B":
                                    int lenght;
                                    ArrayList<Hotel> price_list = new ArrayList<>();
                                    my_city = selected_city.toLowerCase();
                                    pw.println("PRICE_START");
                                    pw.flush();
                                    pw.println("PRICE_END");
                                    pw.flush();
                                    pw.println(my_city);
                                    pw.flush();
                                    //ricevo la lunghezza dal server
                                    lenght = sc.nextInt();
                                    System.out.println(lenght + "nel caso B");
                                    for (int i = 0; i < lenght; i++) {
                                        System.out.println("-----------------------------");
                                        var id = sc.nextInt();
                                        var name = sc.nextLine();
                                        var price = sc.nextDouble();
                                        var city = sc.nextLine();
                                        System.out.print(id);
                                        System.out.print("|");
                                        System.out.print(name);
                                        System.out.print("|");
                                        System.out.print(city);
                                        System.out.print("|");
                                        System.out.println(price);

                                    }
                                    break;


                            }
                        }
                    case "4":
                        ArrayList<Hotel>rating= new ArrayList<>();
                        System.out.println("Show us your experience!");
                        System.out.println("Find an hotel. Give the city:");
                        var my_city=input.nextLine();
                        //chiedo al server di inviarmi l'array
                        pw.println("CMD_LIST_START");
                        pw.flush();
                        pw.println("END_LIST_CMD");
                        pw.flush();
                        pw.println(my_city);
                        pw.flush();
                        int size = sc.nextInt();
                        for(int i=0;i<size;i++)
                        {
                            var ID__hotel = sc.nextInt();
                            System.out.print(ID__hotel);
                            System.out.print("|");
                            var name_hotel = sc.nextLine();
                            System.out.print(name_hotel);
                            System.out.print("|");
                            var price_hotel = sc.nextDouble();
                            System.out.print(price_hotel);
                            System.out.print("|");
                            var city_hotel = sc.nextLine();
                            System.out.print(city_hotel);
                            System.out.print("|");
                            var rate_hotel = sc.nextInt();
                            System.out.print(rate_hotel);
                            System.out.print("|");
                            //var rate_hotel= sc.nextLine();
                            System.out.println("-------------------------");
                            rating.add(new Hotel(name_hotel,price_hotel,city_hotel,ID__hotel,rate_hotel));


                        }
                        //chiedo l'ID
                        System.out.println("Give me the ID:");
                        var ID_rating= input.nextInt();
                        pw.println("CMD_RATE_START");
                        pw.flush();
                        pw.println("CMD_RATE_END");
                        pw.flush();
                        pw.println(ID_rating);
                        pw.flush();
                        for(Hotel h: rating)
                        {
                            if(ID_rating==h.getID_booking())
                            {
                                //ok.Ora metto un voto
                                System.out.println("Give a rate:");
                                var new_rate = input.nextInt();
                                h.setRate(new_rate);
                                pw.println(new_rate);
                                pw.flush();

                            }
                            else
                            {System.out.println("ID not founded");}


                            System.out.println("Updated list:");
                            Rate_Compare rateCompare = new Rate_Compare();
                            Collections.sort(rating,rateCompare);
                            //stampo il nuovo array di hotel
                            for(Hotel r:rating)
                            {
                                System.out.print(h.getID_booking());
                                System.out.print("|");
                                System.out.print(h.getName());
                                System.out.print("|");
                                System.out.print(h.getPrice());
                                System.out.print("|");
                                System.out.print(h.getCity());
                                System.out.print("|");
                                System.out.print(h.getRate());
                                System.out.println("|");
                                System.out.println("---------------------------");


                            }


                            //ora posso dare il voto cambiato alla lista




                        }break;
                    case "3":

                break;
                }}
        }catch(IOException e)
        {
            System.out.println("Cannot connect to "+ip);
            System.exit(-1);
        }

    }


}