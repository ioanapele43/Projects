package data;


public class Task {
	private int sosire;
	private int plecare;
	private int timpAsteptare;
	private String nume;
	private int id;
	public Task(int n,int s,int a) {
		sosire=s;
		plecare=s+a;
		timpAsteptare=a;
		id=n;
		setNume("client "+n);
	}
	public Task() {
		sosire=0;
		plecare=0;
		timpAsteptare=0;
		setNume("client ");
	}
	
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public int getSosire() {
		return sosire;
	}
	public void setSosire(int sosire) {
		this.sosire = sosire;
	}
	public int getPlecare() {
		return plecare;
	}
	public void setPlecare(int plecare) {
		this.plecare = plecare;
	}
	public int getTimpAsteptare() {
		return timpAsteptare;
	}
	public void setTimpAsteptare(int timpAsteptare) {
		this.timpAsteptare = timpAsteptare;
	}
	public int getId() {
		return id;
	}
	
	
	
}
