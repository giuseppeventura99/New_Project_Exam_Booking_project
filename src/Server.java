import java.io.*;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Server
{
    ArrayList<Person> list = new ArrayList<>();
   /* PeriodicPrinter pp = new PeriodicPrinter();
    public synchronized ArrayList<Person> getList() {
        // first solution to the concurrent modification exception potentially happening
        // in the client manager when doing the for loop for printing the list

        // return a copy
        var list_copy = new ArrayList<Person>(list);
        return list_copy;
    }

    public synchronized ArrayList<String> getListString() {
        var people = new ArrayList<String>();

        for (Person p: list) {
            people.add(p.toString());
        }

        return people;
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

    public synchronized void commandRemovePerson(Person p) {
        list.remove(p);

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
                Thread.sleep(30000);
                System.out.println("I'm still alive!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }*/

    public static void main(String[] args) {

        var my_server = new Server();

        int port = Integer.parseInt(args[0]);

        try {
            var serverSocket = new ServerSocket(port);

            while (true) {
                System.out.println("SERVER: Waiting for connections...");
                var client_socket = serverSocket.accept();
                System.out.println("SERVER: Accepted connection from "+ client_socket.getRemoteSocketAddress());

               // var cm = new ClientManager(client_socket,my_server);
               // new Thread(cm).start();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



}
