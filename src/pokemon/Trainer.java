package pokemon;

public class Trainer {
	//Atributos
	private String nome;
	private PkmPool pool;
	private int gold;
	
	//Metodos
	public String getNome(){
		return nome;
	}
	public PkmPool getPool(){
		return pool;
	}
	public int getGold(){
		return gold;
	}
	
	
	//Construtor
	public Trainer(String nome, PkmPool pool, int gold){
		this.nome=nome;
		this.pool=pool;
		this.gold=gold;
	}

}
