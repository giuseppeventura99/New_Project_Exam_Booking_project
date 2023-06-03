import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server
{

    ArrayList<Person> users_list = new ArrayList<>();

    public static void main(String[] args) {

        var my_server = new Server();

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
