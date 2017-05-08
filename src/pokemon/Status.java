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
	
	//Construtor	
	public Status(String nome) throws IOException{
		int[] aux = CarregaTxt.leitorStatus("txt/baseStats/", nome);
		this.atk = aux[1];
		this.def = aux[2];
		this.spd = aux[3];
		this.spc = aux[4];
		this.maxHp = aux[0];		
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
	public void printAll(){
		System.out.println("----------Status-----------");
	}
}
