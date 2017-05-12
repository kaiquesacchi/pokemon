package pokemon;

import java.io.IOException;

public class PokemonBase {
	//Atributos
	protected String nome;
	protected Status statsSol;
	protected AtkPool atkPool;
	protected String tipo1;
	protected String tipo2;
	protected String id;
	
	//Construtor	
	public PokemonBase(String id, String nome, String tipo1, String tipo2) throws IOException{
		this.nome = nome;
		this.id = id;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
		this.statsSol = new Status(nome);
		this.atkPool = new AtkPool(nome);
	}
	public PokemonBase(String id, String nome, String tipo1) throws IOException{
		this(id, nome, tipo1, null);
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
	public String getId(){
		return id;
	}
	public AtkPool getAtkPool(){
		return atkPool;
	}
	public void printAll(){
		System.out.println("||||");
		System.out.println(id);
		System.out.println(nome);
		System.out.println(tipo1 + "," + tipo2);
		this.atkPool.printAll();
	}
}
