import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.concurrent.ForkJoinPool;

public class Server {

    private ArrayList<Person> list = new ArrayList<>();
    private ArrayList<Hotel>hotel_list= new ArrayList<>();
    private ArrayList<Booking> Book_list = new ArrayList<Booking>();
    private  ArrayList<Room> Room_list = new ArrayList<Room>();
    PeriodicPrinter pp = new PeriodicPrinter();

    public synchronized ArrayList<Booking> getBook_list() {

        var booking_list_copy = new ArrayList<Booking>(Book_list);
        return booking_list_copy;
    }

    public synchronized ArrayList<Person> getList() {
        // first solution to the concurrent modification exception potentially happening
        // in the client manager when doing the for loop for printing the list
        // return a copy
        var list_copy = new ArrayList<Person>(list);
        return list_copy;
    }
    public synchronized  boolean checkAuthentication(String username, String password) {
        var person = list.stream().filter(c -> c.getFullname() == username && c.getPassword() == password);
        if(person!= null){
            return true;
        } else {
            return false;
        }
    }

    public  synchronized boolean HasAnyRoomReserved(String FromDate,String ToDate,int roomID){
        //conversion startdate and enddate
        Date StartDate = null;
        var result = false;
        System.out.println("The Server" + FromDate);
        if (FromDate != null && FromDate != ""){

            try {
                StartDate = new SimpleDateFormat("dd/MM/yyyy").parse(FromDate);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        }
        Date EndDate = null;
        if (ToDate != null && ToDate != ""){


            try {
                EndDate = new SimpleDateFormat("dd/MM/yyyy").parse(ToDate);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        }
        //for in booking list : startdate and enddate convert
        for (Booking b  : getBook_list()){
            if(b.RoomID != roomID){


                result = false;
            }
            else {


                Date B_StartDate = null;
                if (b.StartDate != null && b.StartDate != ""){
                    System.out.println("State5");

                    try {
                        B_StartDate = new SimpleDateFormat("dd/MM/yyyy").parse(b.StartDate);
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    }
                }
                Date B_EndDate = null;
                if (b.EndDate != null && b.EndDate != ""){


                    try {
                        B_EndDate = new SimpleDateFormat("dd/MM/yyyy").parse(b.EndDate);
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    }
                }
                if((StartDate.compareTo(B_StartDate)  <= 0  && EndDate.compareTo(B_StartDate) <= 0 ) || (StartDate.compareTo(B_EndDate) >= 0 && EndDate.compareTo(B_EndDate) >= 0 )){


                    result = false;
                }
                else {


                    result = true;
                    break;
                }
            }
        }


        return result;
        // check the dates
        //tow condition if stratdate entry > enddate of booklist  || startdare and endate entry <= start date booklist
        // retern false --- room reserve nashode
        // return true reserved

    }

    public synchronized String GetPersonName(String ID){
        var result = "";
       for(Person P : list){
           if(ID == P.getID()){
               result = P.getFullname();
               break;
           }
       }
       return  result;
    }


    public synchronized String GetHotelName(int ID){
        var result = "";
        for(Hotel H : hotel_list){
            if(ID == H.ID_booking){
                result = H.name;
                break;
            }
        }
        return  result;
    }


    public synchronized String GetRoomName(int ID){
        var result = "";
        for(Room R : Room_list){
            if(ID == R.ID){
                result = R.Title;
                break;
            }
        }
        return  result;
    }



    public synchronized ArrayList<Hotel> get_Hotel_List() {
        // first solution to the concurrent modification exception potentially happening
        // in the client manager when doing the for loop for printing the list

        // return a copy
        var list_hotel_copy = new ArrayList<Hotel>(hotel_list);
        return list_hotel_copy;
    }
    public synchronized ArrayList<String> getListString() {
        var people = new ArrayList<String>();

        for (Person p: list) {
            people.add(p.toString());
        }

        return people;
    }
    public synchronized ArrayList<String> getListHotelString() {
        var hotels = new ArrayList<String>();

        for (Hotel h: hotel_list) {
            hotels.add(h.toString());
        }

        return hotels;
    }
    // Anita version
    // use the specific pw for directly send the persons to the client
    public synchronized void commandPrint(PrintWriter pw) {

        for (Person p:list) {
            pw.println(p);
            pw.flush();
        }
    }
    // Called by client managers
    // Syncronized so that only one client manager at once can modifiy list
    public synchronized void commandAddPerson(Person p) {
        list.add(p);
    }

    public synchronized  void commandAddRoomlist(ArrayList<Room> listRoom){
        Room_list.addAll(listRoom);
    }

    public  synchronized  void commandAddBooking(Booking b){
        Book_list.add(b);
    }
    public synchronized void commandAddHotel(ArrayList<Hotel>  h) {
        hotel_list.addAll(h);
    }

    public synchronized void commandRemovePerson(Person p) {
        list.remove(p);
    }
    public synchronized void commandRemoveHotel(Hotel h) {
        hotel_list.remove(h);
    }
    public synchronized void commandSaveList(String filename) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(filename);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void periodicPrint() {
        while (true) {
            try {
                Thread.sleep(300000);
                System.out.println("I'm still alive!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) {
        var my_server = new Server();
        //new Thread(my_server.pp).start();
        Runnable r = ()-> my_server.periodicPrint();
        //new Thread(r).start();
        new Thread(
                ()-> {
                    while (true) {
                        try {
                            Thread.sleep(6000);
                            my_server.commandSaveList("periodic_save_");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        ).start();
        /*
        new Thread( ()-> {
            while (true) {
                System.out.println("Some is happening !");
            }
        }).start();
       */
        int port = Integer.parseInt(args[0]);
        try {
            var serverSocket = new ServerSocket(port);
            while (true) {
                System.out.println("SERVER: Waiting for connections...");
                var client_socket = serverSocket.accept();
                System.out.println("SERVER: Accepted connection from "+ client_socket.getRemoteSocketAddress());
                var cm = new ClientManager(client_socket,my_server);
                new Thread(cm).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}