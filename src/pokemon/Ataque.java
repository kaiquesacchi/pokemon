package pokemon;

public class Ataque {
	//Atributos
	private String nome;
	private String tipo;
	private int dano;
	private int precisao;
	private int PP;
	private String efeito;
	
	//Métodos
	public void printAll(){
		System.out.println("nome: "+nome);
		System.out.println("tipo: "+tipo);
		System.out.println("dano: "+dano);
		System.out.println("precisao: "+precisao);
		System.out.println("PP: "+PP);
		System.out.println("efeito: "+efeito);
	}
	
	//Construtor
	public Ataque(String nome, String efeito, int dano, String tipo, int precisao, int PP){
		this.nome = nome;
		this.tipo = tipo;
		this.dano = dano;
		this.precisao = precisao;
		this.PP = PP;
		this.efeito = efeito;
	}
}
