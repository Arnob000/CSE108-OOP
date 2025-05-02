

import java.util.Scanner;

public class Client {
	private String clientName;
	private NetworkUtil networkUtil;
    public Client(String serverAddress, int serverPort) {
        try {
        	System.out.print("Enter name of the client: ");
    		Scanner scanner = new Scanner(System.in);
			clientName = scanner.nextLine();
        	while(true) {
        		System.out.println("1.Connect ");
        		System.out.println("2.GetList ");
        		System.out.println("3.Send message ");
        		System.out.println("4.Broadcast ");
        		
        		int choice= scanner.nextInt();
        		
        		if(choice==1) {
        			
        			networkUtil = new NetworkUtil(serverAddress, serverPort);
                    networkUtil.write(clientName);
        		}
        		
        		else if(choice==2) {
        			new getList(networkUtil);
        			
        		}
        		
        		else if(choice==3) {
        			new ReadThreadClient(networkUtil);
                    new WriteThreadClient(networkUtil, clientName);
        		}
        		
        		else {
        			new WriteThreadClient(networkUtil, clientName);
        		}
        	}
         
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        String serverAddress = "127.0.0.1";
        int serverPort = 33333;
        Client client = new Client(serverAddress, serverPort);
    }
}


