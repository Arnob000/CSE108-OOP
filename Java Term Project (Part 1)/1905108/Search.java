
public class Search {
    private Club[] clubs;
    private int clubCount;

    public Search(){
        clubs= new Club[5];
        clubCount=0;
    }

    public void addClub(Club c){           //adding club in search
        if(clubCount >= 5){
            System.out.println("Maximum Numbers of Club Exceeded! Can't Add Anymore!");
        }
        this.clubs[clubCount]=new Club();
        this.clubs[clubCount]=c;
        clubCount++;
        
    } 
    
    public int searchByPlayerName(String n){
        
        int a=-1;
        for(Club c: clubs){
            a=c.searchPlayer(n);
            if(a==1)
                return a;
        }
        return a;
        
    } 

    public int searchByPosition(String pos){
        int a=-1;
                
        for(Club c: clubs){
            int b=-1;
            b=c.searchPosition(pos);
            if(b>0)
                a=1;
        }
        return a;
    }
    
    public int searchBySalary(double s1, double s2){
        int a=-1;
              
        for(Club c: clubs){
            int b=-1;
            b=c.searchSalary(s1,s2);
            if(b>0)
                a=1;
        }
        return a;
        
    }
    
    public int searchMaxSalaryPlayer(String cbname){
        int a=-2;
        
        for(Club c: clubs){
            if(c.getClubName().equalsIgnoreCase(cbname)){
                c.maxSalaryPlayer();
                    a=1;
            }
        }
        return a;
                          
    }
    
    public int searchMaxAgePlayer(String cbname){
        int a=-2;
        
        for(Club c: clubs){
            if(c.getClubName().equalsIgnoreCase(cbname)){
                c.maxAgePlayer();
                    a=1;
            }
        }
        return a;
        
                          
   }

    public int searchMaxHeightPlayer(String cbname){
        int a=-2;
        
        for(Club c: clubs){
            if(c.getClubName().equalsIgnoreCase(cbname)){
                c.maxHeightPlayer();
                    a=1;
            }
        }
        return a;
                          
    }
    
    public int searchTotalYearSalary(String cbname){
        int a=-2;
        
        for(Club c: clubs){
            if(c.getClubName().equalsIgnoreCase(cbname)){
                System.out.println("Total Year Salary of "+cbname+": "+c.getTotalYearSalary());
                a=1;
            }
        }
        return a;
                          
    }
    
        
}
