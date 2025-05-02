

import java.util.HashMap;
import java.util.Scanner;



public class ListFromThreadServer implements Runnable {

    private Thread thr;
    String name;
    public HashMap<String, NetworkUtil> clientMap;

    public ListFromThreadServer(HashMap<String, NetworkUtil> map, String name) {
        this.clientMap = map;
        this.name = name;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
           
            
                System.out.println("The name of the clients: ");
                NetworkUtil networkUtil = clientMap.get(s[0]);
                if (networkUtil != null) {
                    networkUtil.write(name + ":" + s[0]);
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}



