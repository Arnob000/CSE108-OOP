

import java.io.IOException;

public class getList implements Runnable {
    private Thread thr;
    private NetworkUtil networkUtil;

    public getList(networkUtil) {
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                String s = (String) networkUtil.read();
                System.out.println("Received: " + s);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



