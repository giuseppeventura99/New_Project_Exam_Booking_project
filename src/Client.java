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
                System.out.println("2-List of hotel");
                System.out.println("3-Show us your experience");
                System.out.println("4-Book a hotel");
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
                        while (!menu_choise.equals("q")) {
                            System.out.println("A-hotel list:");
                            System.out.println("B-From the lower price to the highter:");
                            System.out.println("C-Alphabetical Order");
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
                                    boolean continue_list = true;
                                    while (continue_list) {
                                        String line = sc.nextLine();
                                        if (line.equals("LIST_DATA_END")) {
                                            continue_list = false;
                                        } else {
                                            System.out.println(line);
                                            System.out.println("-----------------------------------------------------");
                                        }

                                    }
                                    break;


                                case "B":
                                    System.out.println("From lowest to highest price...");
                                    System.out.println("  ");
                                    String my_price_city = selected_city.toLowerCase();
                                    pw.println("ORD_PRICE_START");
                                    pw.flush();
                                    pw.println("ORD_PRICE_END");
                                    pw.flush();
                                    //invio la città
                                    pw.println(my_price_city);
                                    pw.flush();
                                    //ricevo la lunghezza dell'array hotel
                                    dim = sc.nextInt();
                                    //la stampo
                                    System.out.print(dim);
                                    boolean continue_list_price = true;
                                    while (continue_list_price) {
                                        String line = sc.nextLine();
                                        if (line.equals("LIST_PRICE_DATA_END")) {
                                            continue_list = false;
                                        } else {
                                            System.out.println(line);
                                            System.out.println("-----------------------------------------------------");
                                        }

                                    }
                                    break;


                                //---------------------------
                                case "C":
                                    String my_alphabet_city = selected_city.toLowerCase();
                                    pw.println("ORD_ALPH_START");
                                    pw.flush();
                                    pw.println("ORD_ALPH_END");
                                    pw.flush();
                                    //invio la città
                                    pw.println(my_alphabet_city);
                                    pw.flush();
                                    //ricevo la lunghezza dell'array hotel
                                    boolean continue_list_alphabet = true;
                                    while (continue_list_alphabet) {
                                        String line = sc.nextLine();
                                        if (line.equals("LIST_ALPH_DATA_END")) {
                                            continue_list_alphabet = false;
                                        } else {
                                            System.out.println(line);
                                            System.out.println("-----------------------------------------------------");
                                        }

                                    }
                                    break;
                                default:
                                    System.out.println("Choise not valid!");


                            }

                        }
                        break;

                    //--------------------------
                    case "3":
                        System.out.println("Show us your experience!");
                        System.out.println("Find an hotel. Give the city:");
                        pw.println("CMD_RATE_START");
                        pw.flush();
                        pw.println("CMD_RATE_END");
                        pw.flush();
                        //I send to the server the rate_city
                        String city = input.nextLine();
                        String rate_city = city.toLowerCase();
                        pw.println(rate_city);
                        pw.flush();
                        boolean continue_list_rate = true;
                        while (continue_list_rate) {
                            String line = sc.nextLine();
                            if (line.equals("LIST_RATE_DATA_END")) {
                                continue_list_rate = false;
                            } else {
                                System.out.println(line);
                                System.out.println("-----------------------------------------------------");
                            }

                        }
                        //I showed the list
                        //I ask ID
                        System.out.println("Give me the ID:");
                        int ID_rating = input.nextInt();
                        pw.println(ID_rating);
                        pw.flush();
                        System.out.println("Give a rate(from 1 to 5):");
                        int rate_hotel = input.nextInt();
                        pw.println(rate_hotel);
                        pw.flush();
                        System.out.println("The best " + rate_city + " hotels according to your experience");
                        //the program show us the updated list
                        boolean continue_list_updated = true;
                        while (continue_list_updated) {
                            String line = sc.nextLine();
                            if (line.equals("LIST_RATE_DATA_UP")) {
                                continue_list_updated = false;
                            } else {
                                System.out.println(line);
                                System.out.println("-----------------------------------------------------");
                            }

                        }
                        break;


                    case "4":
                        //Booking
                        //I ask to the user the ID of the hotel I wanna book
                        //Client send ID to Server and us the hotel I booked
                        int ID_booking;
                        System.out.println("BOOKING!");
                        pw.println("BOOK_CMD_START");
                        pw.flush();
                        pw.println("BOOK_CMD_END");
                        pw.flush();
                        System.out.println("Choise a city:");
                        String booking__city = sc.nextLine();
                        String booking_city= booking__city.toLowerCase();
                        pw.println(booking_city);
                        pw.flush();
                        //show array
                        boolean continue_list_booking = true;
                        while (continue_list_booking) {
                            String line = sc.nextLine();
                            if (line.equals("LIST_BOOK_DATA_UP")) {
                                continue_list_booking = false;
                            } else {
                                System.out.println(line);
                                System.out.println("-----------------------------------------------------");
                            }
                        }

                        //--------------

                        System.out.println("Choise the ID:");
                        ID_booking = input.nextInt();
                        pw.println(ID_booking);
                        pw.flush();
                        String hotel_booked = sc.nextLine();
                        System.out.println(hotel_booked + " has been booked!");
                }




            }
        }catch(IOException e)
        {
            System.out.println("Cannot connect to "+ip);
            System.exit(-1);
        }

    }


}