package pokemon;

import java.io.IOException;

public class Status {
	//Atributos
		//status constantes
	private int atk;
	private int spAtk;
	private int def;
	private int spDef;
	private int spd;
	private int maxHp;
		//status volateis
	private int curHp;
	private String effect;
	
	//Construtor
	public Status(int atk, int spAtk, int def, int spDef, int spd, int maxHp){
		this.atk = atk;
		this.spAtk = spAtk;
		this.def = def;
		this.spDef = spDef;
		this.spd = spd;
		this.maxHp = maxHp;
		this.curHp = maxHp;
		this.effect = null;		
		}
	
	public Status(String nome) throws IOException{
		int[] aux = CarregaTxt.leitorStatus("txt/baseStats/", nome);
		this.atk = aux[1];
		this.spAtk = aux[4];
		this.def = aux[2];
		this.spDef = aux[4];
		this.spd = aux[3];
		this.maxHp = aux[0];
		this.curHp = this.maxHp;
		this.effect = null;		
	}
	
	//Métodos	
	public int getAtk(){
		return this.atk;
	}
	
	public int getSpAtk(){
		return this.spAtk;
	}
	public int getDef(){
		return this.def;
	}
	public int getSpDef(){
		return this.spDef;
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
}
