import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Club[] clubs=new Club[5];
    public static int clubCount=0;
    public static int exCOUNT=-1;
    public static CountryList ctylist=new CountryList();
     

    public static List<Player> readPlayerInfo() throws Exception{     //reading from file
        List<Player> plrList = new ArrayList();
        FileReader fplr = new FileReader("players.txt");
        Scanner scn=new Scanner(fplr);
        while(true){
            if(!scn.hasNextLine())
                break;
            String line = scn.nextLine();

            String[] tokens= line.split(",");
            Player p = new Player();
            p.setName(tokens[0]);
            p.setCountry(tokens[1]);
            p.setAge(Integer.parseInt(tokens[2]));
            p.setHeight(Double.parseDouble(tokens[3]));
            p.setClub(tokens[4]);
            p.setPosition(tokens[5]);
            p.setNumber(Integer.parseInt(tokens[6]));
            p.setWeeklySalary(Double.parseDouble(tokens[7]));
      
            plrList.add(p);
        }
        fplr.close();

        return plrList;
    }
   /* public static void writePlayerInfo(List<Player> list) throws Exception{         //writing in the filw
        FileWriter writer = new FileWriter("players.txt");
        
        for(Player p: list){
            writer.write(p.getName()+","+p.getCountry()+","+p.getAge()+","+p.getHeight()+","+p.getClub()+","+p.getPosition()+","+p.getNumber()+","+p.getWeeklySalary()+"\n");
        }
        writer.close();

    }*/

    public static void addClubPlayer(Player p){                //creating club+ adding player
        for(int i=0; i<clubCount; i++){
            if(clubs[i].getClubName().equalsIgnoreCase(p.getClub())){
                exCOUNT=clubs[i].addPlayer(p);
                return;
            }
        }
        if(clubCount>=5){
            System.out.println("Maximum Numbers of Club Exceeded! Can't Add Anymore!");
            exCOUNT=1;
        }          
        else{  
            clubs[clubCount]=new Club();
            clubs[clubCount].addPlayer(p);
            clubCount++;
        }
    }


    public static void main(String[] args) throws Exception{
        List<Player> playerList = readPlayerInfo();
        Search search= new Search();
                
        for(Player p: playerList)             //creating club+ adding player 
            addClubPlayer(p);
        for(Club c: clubs)                    //adding club in search
            search.addClub(c);
        for(Player p: playerList)             // adding player in country
            ctylist.addCountryList(p);
      
        while(true){                                  //option
            System.out.println("\nMain Menu:");
            System.out.println("(1) Search Players");
            System.out.println("(2) Search Clubs");
            System.out.println("(3) Add Player");
            System.out.println("(4) Exit System");
            System.out.print("\nOption: ");
            
            Scanner sc = new Scanner(System.in);
            int op = sc.next();
                                    
            if (op==1){                           //player searching option
                while(true){
                    System.out.println("\nPlayer Searching Options:");
                    System.out.println("(1) By Player Name");
                    System.out.println("(2) By Club and Country");
                    System.out.println("(3) By Position");
                    System.out.println("(4) By Salary Range");
                    System.out.println("(5) Country-wise Player Count");
                    System.out.println("(6) Back to Main Manu");
                    System.out.print("\nOption: ");
                    
                    int pp = sc.nextInt();
                    
                    if(pp==1){                         //by player name
                        Scanner scn=new Scanner(System.in);
                        System.out.print("\nEnter Player Name:");
                        String n=scn.nextLine();
                        int sr=search.searchByPlayerName(n);
                        if(sr<0){
                            System.out.println("No such player with this name");
                        }     
                        System.out.println("\nPress Enter To Return");
                        scn.nextLine();
                    }
                        
                    else if(pp==2){                     //by club and country
                        Scanner scn=new Scanner(System.in);
                        System.out.print("\nEnter Country Name:");
                        String cty=scn.nextLine();
                        System.out.print("\nEnter Club Name:");
                        String cb=scn.nextLine();
                        System.out.println();
                        int a=ctylist.searchByClubCountry(cty, cb);
                        if(a<0)
                            System.out.println("\nNo such player with this country and club");

                        System.out.println("\nPress Enter To Return");
                        scn.nextLine();
    
                    }
                    else if(pp==3){                     // by position
                        Scanner scn=new Scanner(System.in);
                        System.out.print("\nEnter Position:");
                        String pos=scn.next();
                        System.out.println();
                        int sr=search.searchByPosition(pos);
                        if(sr<0)
                            System.out.println("\nNo such player with this position");

                        System.out.println("\nPress Enter To Return");
                        scn.nextLine();
                        scn.nextLine();
                    }
                        
                    else if(pp==4){                     //by salary
                        Scanner scn=new Scanner(System.in);
                        System.out.print("\nEnter First Salary Value:");
                        double sal1=scn.nextDouble();
                        System.out.print("\nEnter Second Salary Value:");
                        double sal2=scn.nextDouble();
                        System.out.println();
                        int sr=search.searchBySalary(sal1, sal2);
                        if(sr<0)
                            System.out.println("\nNo such player with this weekly salary range");

                        System.out.println("\nPress Enter To Return");
                        scn.nextLine();
                        scn.nextLine();
                    }
                        
                    else if(pp==5)                      //country wise player
                        countryWisePlayer(playerList);
                    else if(pp==6)                      //back to main
                        break;
                    else 
                        System.out.println("To Back to Main Manu Enter 6\nOr, Enter Number Between 1 to 5");    
                                                          
                }
            }
            else if (op==2){                            //club searching option
                while(true){
                    System.out.println("\nClub Searching Options:");
                    System.out.println("(1) Player(s) with the maximum salary of a club ");
                    System.out.println("(2) Player(s) with the maximum age of a club ");
                    System.out.println("(3) Player(s) with the maximum height of a club ");
                    System.out.println("(4) Total yearly salary of a club ");
                    System.out.println("(5) Back to Main Menu ");
                    System.out.print("\nOption: ");
                   
                    int cc = sc.nextInt();
                    
                    if(cc==1){                             //max salary
                        Scanner scn=new Scanner(System.in);
                        System.out.print("\nEnter Club Name:");
                        String cbname=scn.nextLine();
                        int sr=search.searchMaxSalaryPlayer(cbname);
                        if(sr<0)
                            System.out.println("\nNo such club with this name");
        
                        System.out.println("\nPress Enter To Return");
                        scn.nextLine();
                    }
                    else if(cc==2){                        //max age
                        Scanner scn=new Scanner(System.in);
                        System.out.print("\nEnter Club Name:");
                        String cbname=scn.nextLine();
                        int sr=search.searchMaxAgePlayer(cbname);
                        if(sr<0)
                            System.out.println("\nNo such club with this name");
        
                        System.out.println("\nPress Enter To Return");
                        scn.nextLine();
                    }
                    else if(cc==3){                       //max height
                        Scanner scn=new Scanner(System.in);
                    System.out.print("\nEnter Club Name:");
                    String cbname=scn.nextLine();
                    int sr=search.searchMaxHeightPlayer(cbname);
                    if(sr<0)
                        System.out.println("\nNo such club with this name");
        
                    System.out.println("\nPress Enter To Return");
                    scn.nextLine();
                    }
                    else if(cc==4){                     //total salary
                        Scanner scn=new Scanner(System.in);
                        System.out.print("\nEnter Club Name:");
                        String cbname=scn.nextLine();
                        int sr=search.searchTotalYearSalary(cbname);
                        if(sr<0)
                            System.out.println("\nNo such club with this name");
        
                        System.out.println("\nPress Enter To Return");
                        scn.nextLine();
                    }
                    else if(cc==5)                    //back to main
                        break;
                    else 
                        System.out.println("To Back to Main Manu Enter 5\nOr, Enter Number Between 1 to 4");    
                    
                }
            }
            
            else if(op==3){                         //adding player
                Player p = new Player(); 
                int m=-1;
                sc.nextLine();
                System.out.println("\nAdding Player:");
                while(true){
                    System.out.print("\nPlayer's Name:");
                    String match = sc.nextLine();
                    
                    for(Player t: playerList){
                        if(t.getName().equalsIgnoreCase(match)){
                            m=1;
                            break;
                        }
                    }
                    if(m<0){
                        p.setName(match);
                            break;
                    }
                    else{
                        System.out.println("Given Player Name Matched!\nTo Try Again Press Enter.");
                        System.out.println("To Exit Press Q(Quit)");
                        System.out.print("\nOption: ");
                        String s=sc.nextLine();
                        if(s.equalsIgnoreCase("Q")||s.equalsIgnoreCase("QUIT")){
                            break;
                        }
                        else{
                            m=-1;
                            continue;
                        } 
                    }
                }
                if(m<0){
                    System.out.print("\nPlayer's Country:");
                    p.setCountry(sc.next());
                    System.out.print("\nPlayer's Age:");
                    p.setAge(sc.nextInt());
                    System.out.print("\nPlayer's Height:");
                    p.setHeight(sc.nextDouble());
                    System.out.print("\nPlayer's Club:");
                    sc.nextLine();
                    p.setClub(sc.nextLine());
                    System.out.print("\nPlayer's Position:");
                    p.setPosition(sc.next());
                    System.out.print("\nPlayer's Number:");
                    p.setNumber(sc.nextInt());
                    System.out.print("\nPlayer's Weekly Salary:");
                    p.setWeeklySalary(sc.nextDouble());
                    
                    addClubPlayer(p);
                    if(exCOUNT>0){
                        exCOUNT=-1;
                    }
                    else
                        playerList.add(p);
                    
                }
            }
            else if(op==4)                  //exit
                break;
            else
                System.out.println("To Exit Enter 4\nOr, Enter Number Between 1 to 3");
        }
       

       // writePlayerInfo(playerList);
        FileWriter writer = new FileWriter("players.txt");          //write to file
        for(Club c: clubs){
            c.CWrite(writer);
        }
        writer.close();
        
    }
  
    public static void countryWisePlayer(List<Player> playerList){    //country wise player
        ctylist.getPlayerCount();
    }
}
