import java.io.*;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Date;


public class Server{

    private ArrayList<Person> list = new ArrayList<>();
    private ArrayList<Hotel>hotel_list= new ArrayList<>();

    PeriodicPrinter pp = new PeriodicPrinter();


    public synchronized ArrayList<Person> getList() {
        // first solution to the concurrent modification exception potentially happening
        // in the client manager when doing the for loop for printing the list

        // return a copy
        var list_copy = new ArrayList<Person>(list);
        return list_copy;
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
    public synchronized void commandAddHotel(Hotel h) {
        hotel_list.add(h);
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
                Thread.sleep(3000);
                System.out.println("I'm still alive!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void main(String[] args) {


        /* for(Hotel h:list_hotel)
        {
         System.out.println("" +h.getID_booking()+h.getName()+"" +
                 "" +h.getPrice()+h.getCity());
        }*/
        var my_server = new Server();
        //new Thread(my_server.pp).start();
        Runnable r = ()-> my_server.periodicPrint();
        new Thread(r).start();
        new Thread(
                ()-> {
                    while (true) {
                        try {
                            Thread.sleep(60000);
                            my_server.commandSaveList("periodic_save_"+new Date().toString());
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
