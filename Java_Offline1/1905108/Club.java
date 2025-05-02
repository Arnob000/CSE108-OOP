public class Club{
	private String name;
	private int id;
	private int point=0;
	
	public void setName(String name){
		this.name=name;
	}
	public void setId(int id){
		this.id=id;
	}
	public String getName(){
		return name;
	}
	public void setPoint(int point){
		this.point+=point;
	}
	public int getPoint(){
		return point;
	}
        public void deletePoint(){
		this.point=0;
	}

}