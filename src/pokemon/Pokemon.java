package pokemon;

public class Pokemon {
	//Atributos
	private String nome;
	private Status stats;
	private AtkPool atkpool;
	private String tipo;
	private int id;
	
	//Construtor
	public Pokemon(String nome, int id, Status stats, AtkPool atkpool, String tipo){
		this.nome = nome;
		this.id = id;
		this.stats = stats;
		this.atkpool = atkpool;
		this.tipo = tipo;
	}
	
}
