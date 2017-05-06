package pokemon;

public class Pokemon {
	//Atributos
	private String nome;
	private Status stats;
	private AtkPool atkpool;
	private String tipo1;
	private String tipo2;
	private String id;
	
	//Construtor
	public Pokemon(String nome, String id, Status stats, AtkPool atkpool, String tipo){
		this.nome = nome;
		this.id = id;
		this.stats = stats;
		this.atkpool = atkpool;
		this.tipo1 = tipo;
	}
	
	public Pokemon(String id, String nome, String tipo1, String tipo2){
		this.nome = nome;
		this.id = id;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
	}
	public Pokemon(String id, String nome, String tipo1){
		this(id, nome, tipo1, "");
	}
	
	//Métodos
	public String getNome(){
		return nome;
	}
	
}
