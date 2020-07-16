package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class ServerThread {
int PortNumber =1342;
ServerSocket serverSocket = null;
ArrayList<RunCode> connections = new ArrayList<RunCode>();

public void runServer() throws IOException{
    try{
        serverSocket = new ServerSocket(PortNumber);
    } catch (IOException e){
        System.out.println(e.getMessage());
    }
    while(true){
        try{
        Socket clientSocket = serverSocket.accept();
        RunCode m = new RunCode(clientSocket);
        new Thread(m).start();
        connections.add(m);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        }
    }
}


