package pokemon;

import java.io.IOException;

public class PokemonBase {
	//Atributos
	protected String nome;
	protected Status statsSol;
	protected AtkPool atkPool;
	protected String tipo1;
	protected String tipo2;
	protected int id;
	
	//Construtor	
	public PokemonBase(int id, String nome, String tipo1, String tipo2, Status status, AtkPool atkPool) throws IOException{
		this.nome = nome;
		this.id = id;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
		this.statsSol = status;
		this.atkPool = atkPool;
	}

	public PokemonBase(int id, String nome, String tipo1, Status status, AtkPool atkPool) throws IOException{
		this(id, nome, tipo1, null, status, atkPool);
	}
	
	//Métodos
	public String getNome(){
		return nome;
	}
	
	//getStats
	public Status getStatsSol(){
		return statsSol;
	}
	public int getAtk(){
		return statsSol.getAtk();
	}
	public int getDef(){
		return statsSol.getDef();
	}
	public int getSpc(){
		return statsSol.getSpc();
	}
	public int getSpd(){
		return statsSol.getSpd();
	}
	public int getMaxHp(){
		return statsSol.getHp();
	}
	public String getTipo1(){
		return tipo1;
	}
	public String getTipo2(){
		return tipo2;
	}
	public int getId(){
		return id;
	}
	public AtkPool getAtkPool(){
		return atkPool;
	}
	
	//Debug
	public void printAll(){
		System.out.println("||||");
		System.out.println(id);
		System.out.println(nome);
		System.out.println(tipo1 + "," + tipo2);
		this.statsSol.printAll();
		this.atkPool.printAll();
	}
}
