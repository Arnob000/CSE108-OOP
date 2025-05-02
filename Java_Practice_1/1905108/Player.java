public class Player {
    private int number;
    private String name;
    private double salary;

	// you are not allowed to write any other constructor
    public Player(int number, String name) {
        setNumber(number);
        setName(name);
    }

    public void setNumber(int number){
    this.number=number;
    }
    public void setName(String name){
    this.name=name;
}
public void setSalary(double sal){
    salary=sal;
}
public double getSalary(){
    return salary;
}

}
