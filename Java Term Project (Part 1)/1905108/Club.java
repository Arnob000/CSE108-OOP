import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Club {
    private Player[] player;
    private int playerCount;
    private double totalySalary;

    Club(){
        player= new Player[7];
        playerCount=0;
        totalySalary=0.00;
    }

    public int addPlayer(Player p){
        if(playerCount >= 7){
            System.out.println("Maximum Numbers of Player Exceeded! Can't Add Anymore!");
            return 1;
        }
        this.player[playerCount]=new Player();
        this.player[playerCount]=p;
        playerCount++;
        return -1;
    } 
    
   
    public String getClubName(){
        return player[0].getClub();
    }
    
    public int searchPlayer(String name){
        int a=-1;
        for(int i=0; i<playerCount; i++){
            if(player[i].getName().equalsIgnoreCase(name)){
                a=1;
                player[i].printPlayer();
            }
        }
        return a;
    }

    public int searchPosition(String pos){
        int a=-1;
        for(int i=0; i<playerCount; i++){
            if(player[i].getPosition().equalsIgnoreCase(pos)){
                a=1;
                player[i].printPlayer();
            }
        }
        return a;
    
    }
    
     public int searchSalary(double s1, double s2){
        int a=-1;
        for(int i=0; i<playerCount; i++){
            if(player[i].getWeeklySalary()>=s1 && player[i].getWeeklySalary()<=s2){
                a=1;
                player[i].printPlayer();
            }
        }
        return a;
    
    }

    public void maxSalaryPlayer(){
        double find=0.00;
        
        for(int i=0; i<playerCount; i++){
            if(find < player[i].getWeeklySalary())
                find=player[i].getWeeklySalary();
        }
        System.out.println("\nPlayer(s) with maximum salary:");
        for(int i=0; i<playerCount; i++){
            if(player[i].getWeeklySalary() == find)
                player[i].printPlayer();
        }
    }

     public void maxAgePlayer(){
        int find=0;
        
        for(int i=0; i<playerCount; i++){
            if(find < player[i].getAge())
                find=player[i].getAge();
        }
        System.out.println("\nPlayer(s) with maximum age:");
        for(int i=0; i<playerCount; i++){
            if(player[i].getAge() == find)
                player[i].printPlayer();
        }
    }

     public void maxHeightPlayer(){
        double find=0.00;
        
        for(int i=0; i<playerCount; i++){
            if(find < player[i].getHeight())
                find=player[i].getHeight();
        }
        System.out.println("\nPlayer(s) with maximum height:");
        for(int i=0; i<playerCount; i++){
            if(player[i].getHeight() == find)
                player[i].printPlayer();
        }
    }
    
    public double getTotalYearSalary(){
        for(int j=0; j < playerCount; j++){
            totalySalary+=player[j].getYearSalary();
        }
        return totalySalary;
    }

    public void CWrite(FileWriter writer) throws Exception{     //writing to file
        
        for(int j=0; j< playerCount; j++){
            writer.write(player[j].getName()+","+player[j].getCountry()+","+player[j].getAge()+","+player[j].getHeight()+","+player[j].getClub()+","+player[j].getPosition()+","+player[j].getNumber()+","+player[j].getWeeklySalary()+"\n");
        }
        
    }
}
