package pokemon;

import java.io.IOException;

public class Pokemon {
	//Atributos
	private String nome;
	private Status stats;
	private AtkPool atkPool;
	private String tipo1;
	private String tipo2;
	private String id;
	
	//Construtor	
	public Pokemon(String id, String nome, String tipo1, String tipo2) throws IOException{
		this.nome = nome;
		this.id = id;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
		this.stats = new Status(nome);
	}
	public Pokemon(String id, String nome, String tipo1) throws IOException{
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
	public int getSpAtk(){
		return stats.getSpAtk();
	}
	public int getDef(){
		return stats.getDef();
	}
	public int getSpDef(){
		return stats.getSpDef();
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
	public Ataque[] getAtkPool(){
		return atkPool.getAtaques();
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
		System.out.println(id + "_" + nome + "_" + tipo1 + "_" + tipo2 + "_" + stats.getAtk());
	}
}
