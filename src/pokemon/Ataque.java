package pokemon;

public class Ataque {
	//Atributos
	private String nome;
	private String tipo;
	private int dano;
	private int precisao;
	private int PP;
	private String efeito;
	
	//Construtor
	public Ataque(String nome, String tipo, int dano, int precisao, int PP, String efeito){
		this.nome = nome;
		this.tipo = tipo;
		this.dano = dano;
		this.precisao = precisao;
		this.PP = PP;
		this.efeito = efeito;
	}
}
