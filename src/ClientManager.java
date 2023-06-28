import java.io.*;
import java.net.Socket;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

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
            ArrayList<Room> Room_list = new ArrayList<Room>();
            ArrayList<Booking> Book_list = new ArrayList<Booking>();
            list_hotel.add( new Hotel("Hotel Catalunya",60.99,"alghero",1,0.0,1," "));
            list_hotel.add(new Hotel("Hotel Carolos V",70.99,"alghero",2,0.0,1," "));
            list_hotel.add(new Hotel("Hotel Turin",69.99,"aosta",3,0.0,1," "));
            list_hotel.add(new Hotel("Grande Albergo delle Nazioni",50.99,"bari",4,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Metropolitan",50.10,"bologna",5,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Dall'Ara",79.99,"bologna",6,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Sardegna",49.99,"cagliari",7,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Regina Margherita",99.99,"cagliari",8,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Nettuno",45.99,"catania",9,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Brunelleschi",100.99,"firenze",10,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Continentale",89.99,"firenze",11,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Dante",79.99,"firenze",12,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Bristol Palace",60.00,"genova",13,0.0,1," "));
            list_hotel.add(new Hotel("Hotel Risorgimento Palace",50.00,"lecce",14,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Brera",130.00,"milano",15,0.0,1," "));
            list_hotel.add(new Hotel("Hotel Milano Scala",150.99,"milano",16,0.0,1," "));
            list_hotel.add(new Hotel( "Excelsior Hotel Gallia",100.99,"milano",17,0.0,1," "));
            list_hotel.add( new Hotel("Hotel De Laurentis",80.99,"napoli",18,0.0,1," "));
            list_hotel.add( new Hotel("Grand Hotel Vesuvio",79.99,"napoli",19,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Romeo",99.99,"napoli",20,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Brufani Palace",100.00,"perugia,",21,0.0,1," "));
            list_hotel.add( new Hotel("Hotel de Londres",48.99,"rimini",22,0.0,1," "));
            list_hotel.add(new Hotel("Grand Hotel Rimini",71.99,"rimini",23,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Virgilio",119.99,"roma",24,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Hassler",150.99,"roma",25,0.0,1," "));
            list_hotel.add(new Hotel("Hotel Eden",140.00,"roma",26,0.0,1," "));
            list_hotel.add(new Hotel("Hotel Parioli",170.99,"roma",27,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Agnelli",78.95,"torino",28,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Turin Palace",98.95,"torino",29,0.0,1," "));
            list_hotel.add( new Hotel("Grand Hotel Trento",50.00,"trento",30,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Danieli",190.99,"venezia",31,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Palazzo Barbarigo",210.99,"venezia",32,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Venezia",180.00,"venezia",33,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Romeo-Giulietta",140.00,"verona",34,0.0,1," "));
            list_hotel.add( new Hotel("Hotel Due Torri",168.99,"verona",35,0.0,1," "));
            my_server.commandAddHotel(list_hotel);
            Room_list.add(new Room(1,"(suite 1)","Single Bed","001",2,1));
            Room_list.add(new Room(2,"(suite 2)","Double Beds","002",4,1));
            Room_list.add(new Room(3,"(suite 3)","Triple Beds","003",6,1));
            Room_list.add(new Room(4,"(suite 1)","Single Bed","004",2,2));
            Room_list.add(new Room(5,"(suite 2)","Double Beds","005",4,2));
            Room_list.add(new Room(6,"(suite 3)","Triple Beds","006",6,2));
            Room_list.add(new Room(7,"(suite 1)","Single Bed","007",2,3));
            Room_list.add(new Room(8,"(suite 2)","Double Beds","008",4,3));
            Room_list.add(new Room(9,"(suite 3)","Triple Beds","009",6,3));
            Room_list.add(new Room(10,"(suite 1)","Single Bed","010",2,4));
            Room_list.add(new Room(11,"(suite 2)","Double Beds","011",4,4));
            Room_list.add(new Room(12,"(suite 3)","Triple Beds","012",6,4));
            Room_list.add(new Room(13,"(suite 1)","Single Bed","013",2,5));
            Room_list.add(new Room(14,"(suite 2)","Double Beds","014",4,5));
            Room_list.add(new Room(15,"(suite 3)","Triple Beds","015",6,5));
            Room_list.add(new Room(16,"(suite 1)","Single Bed","016",2,6));
            Room_list.add(new Room(17,"(suite 2)","Double Beds","017",4,6));
            Room_list.add(new Room(18,"(suite 3)","Triple Beds","018",6,6));
            Room_list.add(new Room(19,"(suite 1)","Single Bed","019",2,7));
            Room_list.add(new Room(20,"(suite 2)","Double Beds","020",4,7));
            Room_list.add(new Room(21,"(suite 3)","Triple Beds","021",6,7));
            Room_list.add(new Room(22,"(suite 1)","Single Bed","022",2,8));
            Room_list.add(new Room(23,"(suite 2)","Double Beds","023",4,8));
            Room_list.add(new Room(24,"(suite 3)","Triple Beds","024",6,8));
            Room_list.add(new Room(25,"(suite 1)","Single Bed","025",2,9));
            Room_list.add(new Room(26,"(suite 2)","Double Beds","026",4,9));
            Room_list.add(new Room(27,"(suite 3)","Triple Beds","027",6,9));
            Room_list.add(new Room(28,"(suite 1)","Single Bed","028",2,10));
            Room_list.add(new Room(29,"(suite 2)","Double Beds","029",4,10));
            Room_list.add(new Room(30,"(suite 3)","Triple Beds","030",6,10));
            Room_list.add(new Room(31,"(suite 1)","Single Bed","031",2,11));
            Room_list.add(new Room(32,"(suite 2)","Double Beds","032",4,11));
            Room_list.add(new Room(33,"(suite 3)","Triple Beds","033",6,11));
            Room_list.add(new Room(34,"(suite 1)","Single Bed","034",2,12));
            Room_list.add(new Room(35,"(suite 2)","Double Beds","035",4,12));
            Room_list.add(new Room(36,"(suite 3)","Triple Beds","036",6,12));
            Room_list.add(new Room(37,"(suite 1)","Single Bed","037",2,13));
            Room_list.add(new Room(38,"(suite 2)","Double Beds","038",4,13));
            Room_list.add(new Room(39,"(suite 3)","Triple Beds","039",6,13));
            Room_list.add(new Room(40,"(suite 1)","Single Bed","040",2,14));
            Room_list.add(new Room(41,"(suite 2)","Double Beds","041",4,14));
            Room_list.add(new Room(42,"(suite 3)","Triple Beds","042",6,14));
            Room_list.add(new Room(43,"(suite 1)","Single Bed","043",2,15));
            Room_list.add(new Room(44,"(suite 2)","Double Beds","044",4,15));
            Room_list.add(new Room(45,"(suite 3)","Triple Beds","045",6,15));
            Room_list.add(new Room(46,"(suite 1)","Single Bed","046",2,16));
            Room_list.add(new Room(47,"(suite 2)","Double Beds","047",4,16));
            Room_list.add(new Room(48,"(suite 3)","Triple Beds","048",6,16));
            Room_list.add(new Room(49,"(suite 1)","Single Bed","049",2,17));
            Room_list.add(new Room(50,"(suite 2)","Double Beds","050",4,17));
            Room_list.add(new Room(51,"(suite 3)","Triple Beds","051",6,17));
            Room_list.add(new Room(52,"(suite 1)","Single Bed","052",2,18));
            Room_list.add(new Room(53,"(suite 2)","Double Beds","053",4,18));
            Room_list.add(new Room(54,"(suite 3)","Triple Beds","054",6,18));
            Room_list.add(new Room(55,"(suite 1)","Single Bed","055",2,19));
            Room_list.add(new Room(56,"(suite 2)","Double Beds","056",4,19));
            Room_list.add(new Room(57,"(suite 3)","Triple Beds","057",6,19));
            Room_list.add(new Room(58,"(suite 1)","Single Bed","058",2,20));
            Room_list.add(new Room(59,"(suite 2)","Double Beds","059",4,20));
            Room_list.add(new Room(60,"(suite 3)","Triple Beds","060",6,20));
            Room_list.add(new Room(61,"(suite 1)","Single Bed","061",2,21));
            Room_list.add(new Room(62,"(suite 2)","Double Beds","062",4,21));
            Room_list.add(new Room(63,"(suite 3)","Triple Beds","063",6,21));
            Room_list.add(new Room(64,"(suite 1)","Single Bed","064",2,22));
            Room_list.add(new Room(65,"(suite 2)","Double Beds","065",4,22));
            Room_list.add(new Room(66,"(suite 3)","Triple Beds","066",6,22));
            Room_list.add(new Room(67,"(suite 1)","Single Bed","067",2,23));
            Room_list.add(new Room(68,"(suite 2)","Double Beds","068",4,23));
            Room_list.add(new Room(69,"(suite 3)","Triple Beds","069",6,23));
            Room_list.add(new Room(70,"(suite 1)","Single Bed","070",2,24));
            Room_list.add(new Room(71,"(suite 2)","Double Beds","071",4,24));
            Room_list.add(new Room(72,"(suite 3)","Triple Beds","072",6,24));
            Room_list.add(new Room(73,"(suite 1)","Single Bed","073",2,25));
            Room_list.add(new Room(74,"(suite 2)","Double Beds","074",4,25));
            Room_list.add(new Room(75,"(suite 3)","Triple Beds","075",6,25));
            Room_list.add(new Room(76,"(suite 1)","Single Bed","076",2,26));
            Room_list.add(new Room(77,"(suite 2)","Double Beds","077",4,26));
            Room_list.add(new Room(78,"(suite 3)","Triple Beds","078",6,26));
            Room_list.add(new Room(79,"(suite 1)","Single Bed","079",2,27));
            Room_list.add(new Room(80,"(suite 2)","Double Beds","080",4,27));
            Room_list.add(new Room(81,"(suite 3)","Triple Beds","081",6,27));
            Room_list.add(new Room(82,"(suite 1)","Single Bed","082",2,28));
            Room_list.add(new Room(83,"(suite 2)","Double Beds","083",4,28));
            Room_list.add(new Room(84,"(suite 3)","Triple Beds","084",6,28));
            Room_list.add(new Room(85,"(suite 1)","Single Bed","085",2,29));
            Room_list.add(new Room(86,"(suite 2)","Double Beds","086",4,29));
            Room_list.add(new Room(87,"(suite 3)","Triple Beds","087",6,29));
            Room_list.add(new Room(88,"(suite 1)","Single Bed","088",2,30));
            Room_list.add(new Room(89,"(suite 2)","Double Beds","089",4,30));
            Room_list.add(new Room(90,"(suite 3)","Triple Beds","090",6,30));
            Room_list.add(new Room(91,"(suite 1)","Single Bed","091",2,31));
            Room_list.add(new Room(92,"(suite 2)","Double Beds","092",4,31));
            Room_list.add(new Room(93,"(suite 3)","Triple Beds","093",6,31));
            Room_list.add(new Room(94,"(suite 1)","Single Bed","094",2,32));
            Room_list.add(new Room(95,"(suite 2)","Double Beds","095",4,32));
            Room_list.add(new Room(96,"(suite 3)","Triple Beds","096",6,32));
            Room_list.add(new Room(97,"(suite 1)","Single Bed","097",2,33));
            Room_list.add(new Room(98,"(suite 2)","Double Beds","098",4,33));
            Room_list.add(new Room(99,"(suite 3)","Triple Beds","099",6,33));
            Room_list.add(new Room(100,"(suite 1)","Single Bed","100",2,34));
            Room_list.add(new Room(101,"(suite 2)","Double Beds","101",4,34));
            Room_list.add(new Room(102,"(suite 3)","Triple Beds","102",6,34));
            Room_list.add(new Room(103,"(suite 1)","Single Bed","103",2,35));
            Room_list.add(new Room(104,"(suite 2)","Double Beds","104",4,35));
            Room_list.add(new Room(105,"(suite 3)","Triple Beds","105",6,35));
            my_server.commandAddRoomlist(Room_list);
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
                        System.out.println(passwordString);
                        prova_persona.setName(name);
                        prova_persona.setSurname(surname);
                        prova_persona.setAge(Integer.parseInt(age));
                        prova_persona.setNationality(nationality);
                        prova_persona.setID(ID);
                        prova_persona.setPassword(passwordString);
                        var someone = new Person(name,surname,Integer.parseInt(age),nationality,ID,passwordString);
                        my_server.commandAddPerson(someone);
                        break;
                    case "CMD_ADD_Login":
                        var username = sc.nextLine();
                        var password = sc.nextLine();
                        var end_cmmd  = sc.nextLine();
                        if (!end_cmmd.equals("CMD_ADD_END")) {
                            System.out.println("Format error!");
                        }
                        var isauth = my_server.checkAuthentication(username,password) ? my_server.checkAuthentication(username,password) : false;
                        if(isauth == true){
                            System.out.println("Successful Login");
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
                                for (Room r : Room_list) {
                                    if (r.Hotel_ID ==h.ID_booking) {
                                        pw.println( "### Title : " + r.Title + " - RoomType : "+ r.Type + " - Number of guests : " + r.Capacity + " - Room Numebr :" + r.RoomNumber);
                                        pw.println(" **** ID per Reservation qui = " + r.ID + " ****");
                                        pw.flush();
                                    }
                                }

                                pw.println(("LIST_ROOM_DATA_END"));
                                pw.flush();

                            }
                        }
                        var Room_ID = sc.nextInt();
                        System.out.println(Room_ID);
                        var StartDate= sc.next();
                        var EndDate= sc.next();
                        System.out.println(StartDate);
                        System.out.println(EndDate);
                        if(StartDate != null  &&  EndDate != null){
                            System.out.println("The Client manager StartDate = " + StartDate);
                            var result = my_server.HasAnyRoomReserved(StartDate,EndDate,Room_ID);

                            if(result){
                                pw.println("ERROR !!!! You Cannot Book The Room. The room is already booked in these dates ");
                                pw.flush();

                            }else{
                                var Book = new Booking(1,prova_persona.getID(),booking_ID,Room_ID,StartDate,EndDate,"Reserved");
                                Book_list.add(Book);
                                my_server.commandAddBooking(Book);
                                pw.println("SUCCESS -- The room is reserved in the specific date successfully");
                                pw.flush();
                            }
                            //System.out.println(prova_persona + " just booked a room number"+ Hotel_Room +  "in " + hotel_booked + "from this date" + "" + "" + "to date" + "" + "");
                        }
                        /* h.AddReservedPerson(prova_persona);
                        ultimate_list.add(h.OtherString());*/
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
                            for(Booking s:my_server.getBook_list())
                            {
                                var PersonName = my_server.GetPersonName(s.PersonID);
                                var RoomName = my_server.GetRoomName(s.RoomID);
                                var HotelName = my_server.GetHotelName(s.HotelID);
                                //pw.println(s.replaceAll("\\[|\\]", ""));
                               if(PersonName != null && RoomName != null){
                                pw.println("The room " + RoomName  + " is reserved in Hotel : "  + HotelName +  " in our agency from date : " + s.StartDate + " to date : " + s.EndDate + " By person :  " + PersonName);
                                pw.flush();
                               }
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
                        String file_name = sc.nextLine();
                        end_cmd  = sc.nextLine();
                        if (!end_cmd.equals("END_CMD")) {
                            System.out.println("Format error!");
                        }
                        var fos = new FileOutputStream(file_name);
                        var oos = new ObjectOutputStream(fos);
                        oos.writeObject(ultimate_list);
                        oos.close();
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
                        break;
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