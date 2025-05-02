public class League {
    private Match[] matches;
    private int matchCount;
    private int clubCount;
    // add your variables here, if required
    private String name;
    private Club[] clubs;
    private Club[] cx;
    
    public League() {
        // assume a league can have at most 5 clubs, add code for initialization accordingly
        clubs=new Club[5];
        clubCount = 0;
        matchCount = 0;
    }

    public void printLeagueInfo(){
        System.out.println("League : " + name);
        printClubs();
    }

    public void printClubs(){
        System.out.println("Clubs:");
        // print the name of the clubs of this league, eachoneonaline
	for(int i=0; i<clubCount; i++){
            System.out.println(clubs[i].getName());
	}
    }

    public void scheduleMatches(){
        matchCount = (clubCount*(clubCount-1));
        matches = new Match[matchCount];
        int matchNo = 0;
        for (int i=0; i<clubCount; i++){
            for (int j=0; j<clubCount; j++){
                // check the constructor of the Match class and add your code here
                // note that there will be two matches between club A and club B
                // in the first match, club A will play as the home team and in the second match, as the away team
		
		if(i==j)
                    continue;
		else{
                    matches[matchNo]=new Match(matchNo, clubs[i], clubs[j]);
                    matchNo++;
                    clubs[i].deletePoint();
                    clubs[j].deletePoint();
                }
           
	    }
        }
    }

    public void simulateMatches(){
        for (int i=0; i<matchCount; i++){
            matches[i].play();
        }
    }

    public void showStandings(){
        // sort the clubs in descending order of points
        // note that, the sequence in which clubs were added to the league, should be unchanged
        // check the given sample output for clarification
        // (carefully observe the output of showStandings() followed by printLeagueInfo() method calls
        // you can use additional arrays if needed
        
        cx=new Club[clubCount];
        for(int i=0; i<clubCount; i++){
            cx[i]=clubs[i];
        }
        
        System.out.println("Sl. - Club - Points");
        // print the clubs in descending order of points
            for(int j=0; j<clubCount; j++){
                int max=j;
                for(int i=j+1; i<clubCount; i++){
                	if(cx[max].getPoint() < cx[i].getPoint()){
                            max=i;  
			}
                }
                Club t=new Club();
                t=cx[max];
                cx[max]=cx[j];
                cx[j]=t;
            }
        
        for(int i=0; i<clubCount; i++){        
		System.out.println((i+1)+".     "+cx[i].getName()+"      "+cx[i].getPoint());
        }
    }

    // add your methods here, if required
    public void setName(String name){          //LeagueName
	this.name=name;
    }
    
    public void addClub(Club c){              //adding clubs to league
	clubs[clubCount]=c;
	clubCount++;
    }
    
    public void removeClub(Club c){          //removing clubs from league
	for(int i=0; i<clubCount; i++){
            if(clubs[i]==c){
	     	for(int j=i; j<clubCount-1; j++){
                    clubs[j]=clubs[j+1];
		}
		clubs[clubCount-1]=null;
		clubCount--;
		break;
            }
	}
    }
    
    public void printMatches(){
	System.out.println("Matches:");
	for(int i=0; i<matchCount; i++){
            matches[i].showResult();	
	}
    }
}


