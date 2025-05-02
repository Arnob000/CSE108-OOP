

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
public class Server {

    private ServerSocket serverSocket;
    public HashMap<String, NetworkUtil> clientMap;
    private List clname;

    Server() {
        clientMap = new HashMap<>();
        try {
            serverSocket = new ServerSocket(33333);
            new ListFromThreadServer(clientMap,clname);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) throws IOException, ClassNotFoundException {
        NetworkUtil networkUtil = new NetworkUtil(clientSocket);
        String clientName = (String) networkUtil.read();
        clname.add(clientName);
        clientMap.put(clientName, networkUtil);
        new ReadThreadServer(clientMap, networkUtil);
    }

    public static void main(String args[]) {
        Server server = new Server();
    }
}
