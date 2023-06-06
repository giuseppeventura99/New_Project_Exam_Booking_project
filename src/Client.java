import java.io.*;
import java.net.Socket;
import java.util.Random;
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
            //we can create the MENU
            while(!choose.equals("q"))
            {
                System.out.println("1-Add an user:");
                System.out.println("2-Book an Hotel");
                System.out.println("3-List of users");
                System.out.println("4-Show us your expericence");
                System.out.println("q-Exit");
                System.out.println("------------------------------------------------");
                System.out.println("Select you choose:");
                var InputCommand= input.nextLine();
                switch(InputCommand)
                {
                    case "1":
                        //add an user
                        //login or register?
                        String l_or_r="";
                        System.out.println("L-Login" +"R-Register");
                        l_or_r= input.nextLine();
                        if (l_or_r.equals("L"))
                        {
                            //login
                            //you can enter
                            //and bring me to the menu
                            //I am checking that I am here
                            System.out.println("Name:");
                            var nome= input.nextLine();
                            System.out.println("Surname :");
                            var cognome= input.nextLine();
                            System.out.println("Password:");
                            var keyword= input.nextLine();

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
                        } else if (l_or_r.equals("R"))
                        {//register

                            System.out.println("Name:");
                            System.out.println("Surname:");
                            System.out.println("Age:");
                            System.out.println("Nationality:");
                            System.out.println("ID:");
                            pw.println("ADD_COMMAND_START");
                            pw.flush();
                            String name= input.nextLine();
                            pw.println(name);
                            pw.flush();
                            String surname= input.nextLine();
                            pw.println(surname);
                            pw.flush();
                            String age= input.nextLine();
                            pw.println(age);
                            pw.flush();
                            String nationality= input.nextLine();
                            pw.println(nationality);
                            pw.flush();
                            String ID= input.nextLine();
                            pw.println(ID);
                            pw.flush();
                            //I wanna create a random password that Hotel gives to the user
                            Random random = new Random();
                            int password = random.nextInt(90000) + 10000;
                            System.out.println("Password User is: " + password+" "+name+surname);
                            //converto un intero in una stringa
                            String passwordString = String.valueOf(password);
                            OutputStream outputStream = socket.getOutputStream();
                            outputStream.write(passwordString.getBytes());
                            outputStream.close();
                            pw.println("ADD_COMMAND_END");
                            pw.flush();
                        }
                        else{
                            System.out.println("Choise not recognized.Try more");
                        }


                    case"2":
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
                        System.out.println("Choose one of these cities:");

                        System.out.println("Alghero\nAosta\nBari\nBologna\nCagliari\nCatania\nFirenze\nGenova\nLecce\nMilano\nNapoli\nPerugia\nRimini\nRoma\nTorino\nTrento\nVenezia\nVerona");
                        String selected_city= " ";
                        System.out.println("Choose a city:");
                        selected_city= input.nextLine();
                        if(selected_city.equals("Alghero")||selected_city.equals("ALGHERO")||selected_city.equals("alghero"))
                        {


                        }
                        if(selected_city.equals("Aosta")||selected_city.equals("AOSTA")||selected_city.equals("aosta"))
                        {


                        }
                        if(selected_city.equals("Bari")||selected_city.equals("BARI")||selected_city.equals("bari"))
                        {


                        }
                        if(selected_city.equals("Bologna")||selected_city.equals("BOLOGNA")||selected_city.equals("bologna"))
                        {


                        }
                        if(selected_city.equals("Cagliari")||selected_city.equals("CAGLIARI")||selected_city.equals("cagliari"))
                        {


                        }
                        if(selected_city.equals("Catania")||selected_city.equals("CATANIA")||selected_city.equals("catania"))
                        {


                        }
                        if(selected_city.equals("Firenze")||selected_city.equals("FIRENZE")||selected_city.equals("firenze"))
                        {


                        }
                        if(selected_city.equals("Alghero")||selected_city.equals("ALGHERO")||selected_city.equals("alghero"))
                        {


                        }
                        if(selected_city.equals("Alghero")||selected_city.equals("ALGHERO")||selected_city.equals("alghero"))
                        {


                        }
                        if(selected_city.equals("Alghero")||selected_city.equals("ALGHERO")||selected_city.equals("alghero"))
                        {


                        }
                        if(selected_city.equals("Alghero")||selected_city.equals("ALGHERO")||selected_city.equals("alghero"))
                        {


                        }
                        if(selected_city.equals("Alghero")||selected_city.equals("ALGHERO")||selected_city.equals("alghero"))
                        {


                        }
                        if(selected_city.equals("Alghero")||selected_city.equals("ALGHERO")||selected_city.equals("alghero"))
                        {


                        }
                        if(selected_city.equals("Alghero")||selected_city.equals("ALGHERO")||selected_city.equals("alghero"))
                    {


                    }








                    case "3":

                        //rate hotels




                    case "4":


                }






            }










        }catch(IOException e)
        {
            System.exit(-1);
            System.out.println("Problem");
        }
    }






}
