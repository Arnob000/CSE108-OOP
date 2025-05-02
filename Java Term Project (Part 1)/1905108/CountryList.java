import java.util.ArrayList;
import java.util.List;

public class CountryList {
    private List<Country> countryList;

    CountryList(){
        countryList=new ArrayList();
    }

    public void addCountryList(Player p){
        for(Country c: countryList){
           if(c.getCountryName().equalsIgnoreCase(p.getCountry())){
                c.addCountryPlayer(p);
                return;
            }
        }
        Country C=new Country();
        C.addCountryPlayer(p);
        countryList.add(C);
    }

    public void getPlayerCount(){
        for(int i=0; i<countryList.size(); i++){
            Country C=new Country();
            C=countryList.get(i);
            C.getPCount();
        }
    }
        
    
    public int searchByClubCountry(String cty, String cb){
        int a=-1;    
        for (Country c: countryList){
            if(c.getCountryName().equalsIgnoreCase(cty))
                a=c.searchByClub(cb);
        }
        return a;
    }


}