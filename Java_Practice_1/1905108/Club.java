public class Club {
    private int id;
    private String name;
    private Player[] players;
    // add your code here

	// you are not allowed to write any other constructor
    public Club() {
        this.players = new Player[11];
    }

	public double getSalary() {
        double total = 0;
        for (int i = 0; i < playerCount; i++) {
            total += players[i].getSalary();
        }
        return total;
    }
	
	// add your code here
public void setId(int i){
    id=i;
}
public void setName(String n){
    name=n;
}
public int getId(){
    return id;
}
public String getName(){
    return name;
}
public void addPlayer(Player){
    }
}