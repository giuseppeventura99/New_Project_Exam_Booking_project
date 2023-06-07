import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
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

            String received_command = "";

            while (!received_command.equals("CMD_QUIT")) {
                received_command = sc.nextLine();

                System.out.println("Receivd command "+received_command);

                switch (received_command) {
                    case "CMD_ADD_PERSON":
                        var name = sc.nextLine();
                        var surname = sc.nextLine();
                        var age = sc.nextLine();
                        var nationality = "";
                        var ID = "";
                        var password = ";";
                        var end_cmd  = sc.nextLine();
                        if (!end_cmd.equals("END_CMD")) {
                            System.out.println("Format error!");
                        }
                        System.out.println("Adding person "+name+" "+surname+" "+age);

                        var someone = new Person(name,surname,Integer.parseInt(age),nationality,ID,password);
                        my_server.commandAddPerson(someone);

                        break;
                    case "CMD_QUIT":
                        System.out.println("Closing connection... ");
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

                        my_server.commandSaveList(filename);

                        break;

                    case "CMD_LIST":
                        end_cmd  = sc.nextLine();
                        if (!end_cmd.equals("END_CMD")) {
                            System.out.println("Format error!");
                        }


                        // solution 1: a copy of the list
                        for (Person p: my_server.getList()) {
                            pw.println(p);
                            pw.flush();
                        }


                        // the conversion of each person to string is done on the server side
                        for (String s:my_server.getListString()) {
                            pw.println(s);
                            pw.flush();

                        }

                        // 3rd solution
                        my_server.commandPrint(pw);

                        pw.println("END_DATA");
                        pw.flush();
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