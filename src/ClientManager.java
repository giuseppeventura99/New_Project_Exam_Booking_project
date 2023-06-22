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
            list_hotel.add( new Hotel("Hotel Catalunya",60.99,"alghero",1,0.0,1," "));
            list_hotel.add(new Hotel("Hotel Carolos V",70.99,"alghero",02,0.0,1," "));
            list_hotel.add(new Hotel("Hotel Turin",69.99,"aosta",2,0.0,1," "));
            list_hotel.add(new Hotel("Grande Albergo delle Nazioni",50.99,"bari",3,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Metropolitan",50.10,"bologna",4,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Dall'Ara",79.99,"bologna",5,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Sardegna",49.99,"cagliari",6,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Regina Margherita",99.99,"cagliari",7,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Nettuno",45.99,"catania",8,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Brunelleschi",100.99,"firenze",9,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Continentale",89.99,"firenze",10,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Dante",79.99,"firenze",11,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Bristol Palace",60.00,"genova",12,0.0,1," "));
            list_hotel.add(new Hotel("Hotel Risorgimento Palace",50.00,"lecce",13,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Brera",130.00,"milano",14,0.0,1," "));
            list_hotel.add(new Hotel("Hotel Milano Scala",150.99,"milano",15,0.0,1, " "));
            list_hotel.add(new Hotel( "Excelsior Hotel Gallia",100.99,"milano",16,0.0,1," "));
            list_hotel.add( new Hotel("Hotel De Laurentis",80.99,"napoli",17,0.0,1," "));
            list_hotel.add( new Hotel("Grand Hotel Vesuvio",79.99,"napoli",18,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Romeo",99.99,"napoli",19,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Brufani Palace",100.00,"perugia,",20,0.0,1," "));
            list_hotel.add( new Hotel("Hotel de Londres",48.99,"rimini",21,0.0,1," "));
            list_hotel.add(new Hotel("Grand Hotel Rimini",71.99,"rimini",22,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Virgilio",119.99,"roma",23,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Hassler",150.99,"roma",24,0.0,1," "));
            list_hotel.add(new Hotel("Hotel Eden",140.00,"roma",25,0.0,1," "));
            list_hotel.add(new Hotel("Hotel Parioli",170.99,"roma",26,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Agnelli",78.95,"torino",27,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Turin Palace",98.95,"torino",28,0.0,1," "));
            list_hotel.add( new Hotel("Grand Hotel Trento",50.00,"trento",29,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Danieli",190.99,"venezia",30,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Palazzo Barbarigo",210.99,"venezia",31,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Venezia",180.00,"venezia",32,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Romeo-Giulietta",140.00,"verona",33,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Due Torri",168.99,"verona",35,0.0,1," "));
            var prova_persona=new Person("","",1," ","","");
            ArrayList<String> ultimate_list= new ArrayList<>();
            //funzione che deve inviare un array al client
            String received_command = "";
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
                        var passwordString = sc.nextLine();
                        var end_cmd  = sc.nextLine();
                        if (!end_cmd.equals("CMD_ADD_END")) {
                            System.out.println("Format error!");
                        }
                        System.out.println("New user credentials: "+name+" "+surname+" " +nationality+" - "+ ID);
                       var persona= new Person(name,surname, Integer.parseInt(age),nationality,ID,passwordString);
                       list_user.add(persona);
                        System.out.println(passwordString);
                        prova_persona.setName(name);
                        prova_persona.setSurname(surname);
                        prova_persona.setAge(Integer.parseInt(age));
                        prova_persona.setNationality(nationality);
                        prova_persona.setID(ID);
                        prova_persona.setPassword(passwordString);


                        break;
                    case "CMD_ADD_Login":
                        var username = sc.nextLine();
                        var usersurname= sc.nextLine();
                        var password = sc.nextLine();
                        var end_cmmd  = sc.nextLine();
                        if (!end_cmmd.equals("CMD_END_Login")) {
                            System.out.println("Format error!");
                        }

                        var isauth = my_server.checkAuthentication(username,password) ? my_server.checkAuthentication(username,password) : false;
                        if(isauth == true){
                            System.out.println("Successful Login");
                            prova_persona.setName(username);
                            prova_persona.setSurname(usersurname);

                            break;
                        }else{
                            System.out.println("Error Login");
                            break;
                        }
                    case "CMD_QUIT":
                        System.out.println("Closing connection... ");
                        break;


                    case "BOOK_CMD_START":
                        end_cmd=sc.nextLine();
                        String booking_city= sc.nextLine();
                        String person= prova_persona.reducedtoString();

                        pw.println(person);
                        pw.flush();

                        if(!end_cmd.equals("BOOK_CMD_END"))
                        {
                            System.out.println("Format error!");
                        }
                        System.out.println("Booking in progress...");
                        for (Hotel h : list_hotel) {
                            if (h.getCity().equals(booking_city)) {
                                pw.println(h);
                                pw.flush();
                            }
                        }

                        pw.println(("LIST_BOOK_DATA_END"));
                        pw.flush();

                        int booking_ID= sc.nextInt();

                        for(Hotel h:list_hotel)
                        {
                            if (h.getID_booking() == booking_ID) {
                                pw.println(h.name);
                                pw.flush();
                                h.AddReservedPerson(prova_persona);
                                ultimate_list.add(h.OtherString());


                            }
                        }

                        break;


                        //lista di hotel
                    case "READ_LIST_START":
                        end_cmd=sc.nextLine();
                        if(!end_cmd.equals("READ_LIST_END"))
                        {
                            System.out.println("Error in read list ");
                        }
                        else
                        {
                            for(String s:ultimate_list)
                            {

                                pw.println(s.replaceAll("\\[|\\]", ""));
                                pw.flush();
                            }
                        }
                        pw.println("READ_DATA_END");
                        pw.flush();
                        break;


                    case "CMD_LOAD":
                        System.out.println("Loading list...");
                        String file_to_load = sc.nextLine();
                        end_cmd  = sc.nextLine();
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
                        end_cmd  = sc.nextLine();
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

                        //----------------------
                    case "CMD_RATE_START":
                        end_cmd=sc.nextLine();
                        String rate_city=sc.nextLine();
                        if(!end_cmd.equals("CMD_RATE_END"))
                        {
                            System.out.println("Format Error in Rate case");
                        }
                        else
                        {
                            for(Hotel h: list_hotel)
                            {
                                if(h.getCity().equals(rate_city))
                                {
                                    System.out.println(h.name +"inserito");
                                    pw.println(h.PresentationString());
                                    pw.flush();
                                }
                            }
                            pw.println("LIST_RATE_DATA_END");
                            pw.flush();

                            //ho appena fatto vedere all'utente l'array
                            int rate_ID= sc.nextInt();
                            int rate_hotel =sc.nextInt();
                            sc.nextLine();
                            var my_comment= sc.nextLine();
                            System.out.println(rate_hotel);
                            System.out.println(my_comment);
                            double updated_rate;
                            String updated_comment;

                            for(Hotel h: list_hotel)
                            {
                                if(h.ID_booking==rate_ID)
                            {
                                updated_rate= (((double)rate_hotel+h.getRate())/h.getNumber_rating());
                                //I change this hotel's rate
                                h.setRate(updated_rate);
                                updated_comment= h.getComment() + " , " + my_comment;
                                h.setComment(updated_comment);
                                h.number_rating++;
                            }}
                            //Show the update
                            Rate_Compare rateCompare= new Rate_Compare();
                            Collections.sort(list_hotel,rateCompare);
                            for(Hotel h: list_hotel)
                            {
                                if(h.getCity().equals(rate_city))
                                {
                                    pw.println(h);
                                    pw.flush();
                                }
                            }
                            pw.println("LIST_RATE_DATA_UP");
                            pw.flush();
                        }//parentesi di else
                        break;
                        //---------------------------
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

                        }
                    default:
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