package pokemon;

import java.io.IOException;

public class Status {
	//Atributos
		//status constantes
	private int atk;
	private int def;
	private int spc;
	private int spd;
	private int hp;
		//status volateis
	private double accuracy;
	private double evasion;
	//Construtor	
	public Status(String[] stats) throws IOException{
		this.atk = Integer.parseInt(stats[0]);
		this.def = Integer.parseInt(stats[1]);
		this.spd = Integer.parseInt(stats[2]);
		this.spc = Integer.parseInt(stats[3]);
		this.hp  = Integer.parseInt(stats[4]);
		accuracy=1;
		evasion=1;
	}
	
	//Métodos	
	public int getAtk(){
		return this.atk;
	}
	public int getDef(){
		return this.def;
	}
	public int getSpc(){
		return this.spc;
	}
	public int getSpd(){
		return this.spd;
	}
	public int getHp(){
		return this.hp;
	}
	public double getAccuracy(){
		return accuracy;
	}
	public double getEvasion(){
		return evasion;
	}
	public void addAtk(int a){
		atk+=a;
	}
	public void addDef(int a){
		def+=a;
	}
	public void addSpc(int a){
		spc+=a;
	}
	public void addSpd(int a){
		spd+=a;
	}
	public void addHp(int a){
		//System.out.println("hp inicial: "+hp);
		hp+=a;
		//System.out.println("dano: "+(-a));
		//System.out.println("here3");
		//System.out.println("hp final: "+hp);
	}
	public void addAccuracy(double a){
		accuracy+=a;
	}
	public void addEvasion(double a){
		evasion+=a;
	}
	public void printAll(){
		System.out.println("----------Status-----------");
		System.out.println(atk+ "," + def + "," + spc + "," + spd + "," + hp);
	}
}
