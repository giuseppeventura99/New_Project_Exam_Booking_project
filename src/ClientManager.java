import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


class ClientManager implements Runnable {
    Server my_server;//it's a virtual server that I am creating
    Socket client_socket;
//costructor
    public ClientManager( Socket client_socket, Server my_server) {
        this.my_server = my_server;
        this.client_socket = client_socket;
    }

    //streams
public void go()

{

    try {
        //these are the streams which belongs to clients
        var sc = new Scanner(client_socket.getInputStream());
        var pw = new PrintWriter(client_socket.getOutputStream());
        String received_command = "";
        switch (received_command)
        {
            case"ADD_COMMAND_START":
                var name= sc.nextLine();
                var surname = sc.nextLine();
                var age = sc.nextLine();
                var nationality = sc.nextLine();
                var ID = sc.nextLine();
                InputStream inputStream= client_socket.getInputStream();
                //I'm creating an array called buffer with a size of 1024 elements.
                //It's used to memorize bytes which can be letters or numbers
                //1024 is the maximum numbers of byte of the array buffer
                byte[] buffer = new byte[1024];
                //read the number of received bytes
                int bytesRead = inputStream.read(buffer);
                //I can reach the string that the client sent thought the array of buffer and the numberofbytesread
                String password_ricevuta = new String(buffer, 0, bytesRead);
                inputStream.close();
                var end_command=sc.nextLine();
                if(!end_command.equals("ADD_COMMAND_END"))
                {
                    System.out.println("Errore ");
                }
                client_socket.close();
                System.out.println(name+surname+"registered in the website!");

                var user= new Person(name,surname, Integer.parseInt(age),nationality,ID,password_ricevuta);
                my_server.users_list.add(user);












        }

    }catch(IOException e)
    {
        System.out.println(" ");


    }
}


    @Override
    public void run() {

    }
}