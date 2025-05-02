import java.util.ArrayList;
import java.util.List;

public class Country {
    private List<Player> player;

    Country(){
        player= new ArrayList();
    }
    
    public void addCountryPlayer(Player p){
        player.add(p);
    }
    public String getCountryName(){
        return player.get(0).getCountry();
    }
    public void getPCount(){
        System.out.println("\nCountry Wise Player Count:");
        System.out.println("Country Name: "+player.get(0).getCountry());
        System.out.println("Player Number: "+player.size());
        System.out.println();
    } 
    public int searchByClub(String cb){
        int a=-1;
        if(cb.equalsIgnoreCase("ANY")){
            for(Player p: player){
                a=2;
                p.printPlayer();
            }
        }
        else{
            for(Player p: player){
                if(p.getClub().equalsIgnoreCase(cb)){
                    a=2;
                    p.printPlayer();
                }
            }
        }
        return a;
    }
   
}
