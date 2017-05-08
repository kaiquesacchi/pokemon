package pokemon;

import java.io.IOException;

public class PokemonBase {
	//Atributos
	private String nome;
	private Status stats;
	private AtkPool atkPool;
	private String tipo1;
	private String tipo2;
	private String id;
	
	//Construtor	
	public PokemonBase(String id, String nome, String tipo1, String tipo2) throws IOException{
		this.nome = nome;
		this.id = id;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
		this.stats = new Status(nome);
		this.atkPool = new AtkPool(nome);
	}
	public PokemonBase(String id, String nome, String tipo1) throws IOException{
		this(id, nome, tipo1, "");
	}
	
	//Métodos
	public String getNome(){
		return nome;
	}
	//getStats
	public int getAtk(){
		return stats.getAtk();
	}
	public int getDef(){
		return stats.getDef();
	}
	public int getSpc(){
		return stats.getSpc();
	}
	public int getSpd(){
		return stats.getSpd();
	}
	public int getMaxHp(){
		return stats.getMaxHp();
	}
	public int getCurHp(){
		return stats.getCurHp();
	}
	public String getEffect(){
		return stats.getEffect();
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
	public void printAll(){
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("["+id+"]  " + nome);
		System.out.println(tipo1 + "||" + tipo2);
		this.stats.printAll();
		this.atkPool.printAll();
	}
}
