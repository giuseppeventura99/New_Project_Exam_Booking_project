import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class ClientManager implements Runnable {

    Socket client_socket;
    Server my_server;

    ClientManager(Socket client, Server server) {
        System.out.println("Creating a new client manager!");
        this.client_socket = client;
        this.my_server = server;

    }



    public void go() {
        Scanner sc = null;
        try {
            sc = new Scanner(client_socket.getInputStream());
            var pw = new PrintWriter(client_socket.getOutputStream());
            ArrayList<Hotel> list_hotel= new ArrayList<Hotel>();
            list_hotel.add( new Hotel("Hotel Catalunya",60.99,"alghero",1,1));
            list_hotel.add(new Hotel("Hotel Carolos V",70.99,"alghero",02,1));
            list_hotel.add(new Hotel("Hotel Turin",69.99,"aosta",2,1));
            list_hotel.add(new Hotel("Grande Albergo delle Nazioni",50.99,"bari",3,1));
            list_hotel.add( new Hotel("Hotel Metropolitan",50.10,"bologna",4,1));
            list_hotel.add( new Hotel("Hotel Dall'Ara",79.99,"bologna",5,1));
            list_hotel.add( new Hotel("Hotel Sardegna",49.99,"cagliari",6,1));
            list_hotel.add( new Hotel("Hotel Regina Margherita",99.99,"cagliari",7,1));
            list_hotel.add( new Hotel("Hotel Nettuno",45.99,"catania",8,1));
            list_hotel.add( new Hotel("Hotel Brunelleschi",100.99,"firenze",9,1));
            list_hotel.add( new Hotel("Hotel Continentale",89.99,"firenze",10,1));
            list_hotel.add( new Hotel("Hotel Dante",79.99,"firenze",11,1));
            list_hotel.add( new Hotel("Hotel Bristol Palace",60.00,"genova",12,1));
            list_hotel.add(new Hotel("Hotel Risorgimento Palace",50.00,"lecce",13,1));
            list_hotel.add( new Hotel("Hotel Brera",130.00,"milano",14,1));
            list_hotel.add(new Hotel("Hotel Milano Scala",150.99,"milano",15,1));
            list_hotel.add(new Hotel( "Excelsior Hotel Gallia",100.99,"milano",16,1));
            list_hotel.add( new Hotel("Hotel De Laurentis",80.99,"napoli",17,1));
            list_hotel.add( new Hotel("Grand Hotel Vesuvio",79.99,"napoli",18,1));
            list_hotel.add( new Hotel("Hotel Romeo",99.99,"napoli",19,1));
            list_hotel.add( new Hotel("Hotel Brufani Palace",100.00,"perugia,",20,1));
            list_hotel.add( new Hotel("Hotel de Londres",48.99,"rimini",21,1));
            list_hotel.add(new Hotel("Grand Hotel Rimini",71.99,"rimini",22,1));
            list_hotel.add( new Hotel("Hotel Virgilio",119.99,"roma",23,1));
            list_hotel.add( new Hotel("Hotel Hassler",150.99,"roma",24,1));
            list_hotel.add(new Hotel("Hotel Eden",140.00,"roma",25,1));
            list_hotel.add(new Hotel("Hotel Parioli",170.99,"roma",26,1));
            list_hotel.add( new Hotel("Hotel Agnelli",78.95,"torino",27,1));
            list_hotel.add( new Hotel("Hotel Turin Palace",98.95,"torino",28,1));
            list_hotel.add( new Hotel("Grand Hotel Trento",50.00,"trento",29,1));
            list_hotel.add( new Hotel("Hotel Danieli",190.99,"venezia",30,1));
            list_hotel.add( new Hotel("Hotel Palazzo Barbarigo",210.99,"venezia",31,1));
            list_hotel.add( new Hotel("Hotel Venezia",180.00,"venezia",32,1));
            list_hotel.add( new Hotel("Hotel Romeo-Giulietta",140.00,"verona",33,1));
            list_hotel.add( new Hotel("Hotel Due Torri",168.99,"verona",35,1));

            //funzione che deve inviare un array al client

            String received_command = " ";

            while (!received_command.equals("CMD_QUIT")) {
                received_command = sc.nextLine();

                System.out.println("Received command:"+received_command);

                ArrayList<Person>list_user= new ArrayList<>();
                switch (received_command) {
                    case "CMD_ADD_START":
                        var name = sc.nextLine();
                        var surname = sc.nextLine();
                        var age = sc.nextLine();
                        var nationality = sc.nextLine();
                        var ID = sc.nextLine();
                        var password = sc.nextLine();
                        var end_cmd = sc.nextLine();
                        if (!end_cmd.equals("CMD_ADD_END")) {
                            System.out.println("Format error!");
                        }
                        System.out.println("New user credentials: " + name + " " + surname + "  -  " + nationality + " - " + ID);
                        //var someone = new Person(name,surname,Integer.parseInt(age),nationality,ID,password);
                        //my_server.commandAddPerson(someone);
                        break;
                    case "CMD_QUIT":
                        System.out.println("Closing connection... ");
                        break;


                    //------------------------------------
                    case "BOOK_CMD_START":

                        end_cmd = sc.nextLine();
                        var booking_ID = sc.nextInt();
                        if (!end_cmd.equals("BOOK_CMD_END")) {
                            System.out.println("Format error!");
                        }
                        System.out.println("Booking in progress...");
                        for (Hotel h : list_hotel) {

                            if (h.getID_booking() == booking_ID) {
                                System.out.println(h.name + "is about to be booked");
                                pw.println(h);
                                pw.flush();
                                //var somehotel = new Hotel(h.getName(), h.getPrice(), h.getCity(), h.getID_booking(), h.getRate());

                                //my_server.commandAddHotel(somehotel);
                            }

                        }


                        //-------------------------------------------------------------------
                    case "CMD_LOAD":
                        System.out.println("Loading list...");
                        String file_to_load = sc.nextLine();
                        end_cmd = sc.nextLine();
                        if (!end_cmd.equals("END_CMD")) {
                            System.out.println("Format error!");
                        }

                        // Exercise: move the code for loading list into Server with syncronized method
                        /*
                        var fis = new FileInputStream(file_to_load);
                        var ois = new ObjectInputStream(fis);

                        // notice: this will overwrite the previous list
                        // so you should care of saving it if needed
                        try {
                            my_server.list = (ArrayList<Person>) ois.readObject();
                        } catch (ClassNotFoundException e) {
                            System.out.println("Cannot load list");
                        }
                        ois.close();

                         */

                        break;

                    case "CMD_SAVE":
                        System.out.println("Saving list...");
                        String filename = sc.nextLine();
                        end_cmd = sc.nextLine();
                        if (!end_cmd.equals("END_CMD")) {
                            System.out.println("Format error!");
                        }

                        // my_server.commandSaveList(filename);

                        break;

                    case "CMD_LIST_START":
                        end_cmd = sc.nextLine();
                        int dim = 0;
                        var my_city = sc.nextLine();
                        System.out.println(" La città " + my_city + " è stata ricevuta con successo!");
                        if (!end_cmd.equals("CMD_LIST_END")) {
                            System.out.print("Format Error");
                        } else {
                            //prendiamo la lunghezza dell'array considerando la città scelta
                            for (Hotel h : list_hotel) {
                                if (h.getCity().equals(my_city)) {
                                    dim++;
                                }
                            }
                            pw.println(dim);
                            pw.flush();
                            for (Hotel h : list_hotel) {
                                if (h.getCity().equals(my_city)) {
                                    pw.println(h);
                                    pw.flush();
                                }
                            }
                            pw.println(("LIST_DATA_END"));
                            pw.flush();

                        }
                        break;

                    case "ORD_PRICE_START":
                        end_cmd = sc.nextLine();
                        String price_city = sc.nextLine();
                        Collections.sort(list_hotel);
                        if (!end_cmd.equals("ORD_PRICE_END")) {
                            System.out.println("Format error");
                        } else {
                            for (Hotel h : list_hotel) {
                                if (h.getCity().equals(price_city)) {
                                    pw.println(h);
                                    pw.flush();
                                }
                            }

                            pw.println(("LIST_PRICE_DATA_END"));
                            pw.flush();
                        }
                        break;


                    case "ORD_ALPH_START":
                        end_cmd = sc.nextLine();
                        String alph_city = sc.nextLine();
                        Ordina_Alfabetico ord_alph = new Ordina_Alfabetico();
                        Collections.sort(list_hotel, ord_alph);
                        if (!end_cmd.equals("ORD_ALPH_END")) {
                            System.out.println("Format error");
                        } else {
                            for (Hotel h : list_hotel) {
                                if (h.getCity().equals(alph_city)) {
                                    pw.println(h);
                                    pw.flush();
                                }
                            }

                            pw.println(("LIST_ALPH_DATA_END"));
                            pw.flush();
                            break;

                        }

                        if (!received_command.isBlank())
                            System.out.println("Unknown command");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void run() {
        System.out.println("Starting the thread!");
        go();

    }
}