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
	public Pokemon(String id, String nome, String tipo1, String tipo2){
		this.nome = nome;
		this.id = id;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
		this.stats = new Status();
	}
	public Pokemon(String id, String nome, String tipo1){
		this(id, nome, tipo1, "");
	}
	
	//Métodos
	public String getNome(){
		return nome;
	}
	
	public void printAll(){
		System.out.println(id + "_" + nome + "_" + tipo1 + "_" + tipo2 + "_" + stats.getAtk());
	}
}
