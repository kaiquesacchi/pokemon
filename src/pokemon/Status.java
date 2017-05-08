package pokemon;

import java.io.IOException;

public class Status {
	//Atributos
		//status constantes
	private int atk;
	private int def;
	private int spc;
	private int spd;
	private int maxHp;
		//status volateis
	private int curHp;
	private String effect;
	
	//Construtor	
	public Status(String nome) throws IOException{
		int[] aux = CarregaTxt.leitorStatus("txt/baseStats/", nome);
		this.atk = aux[1];
		this.def = aux[2];
		this.spd = aux[3];
		this.spc = aux[4];
		this.maxHp = aux[0];
		this.curHp = this.maxHp;
		this.effect = null;		
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
	public int getMaxHp(){
		return this.maxHp;
	}
	public int getCurHp(){
		return this.curHp;
	}
	public String getEffect(){
		return this.effect;
	}
	
	public void printAll(){
		System.out.println("----------Status-----------");
		System.out.println("atk: " + atk + "   def: " + def + "   spc: " + spc);
		System.out.println("spd: " + spd + "           maxHP: " + maxHp);
	}
}
