package pokemon;

public class Ataque {
	//Atributos
	private String nome;
	private String tipo;
	private int dano;
	private int precisao;
	private int PPmax;
	private int PPcur;
	private String efeito;
	
	//Métodos
	public void printAll(){
		System.out.println("nome: "+nome);
		System.out.println("tipo: "+tipo);
		System.out.println("dano: "+dano);
		System.out.println("precisao: "+precisao);
		System.out.println("PP: "+PPmax);
		System.out.println("efeito: "+efeito);
	}
	public String getNome(){
		return nome;
	}
	public String getTipo(){
		return tipo;
	}
	public int getDano(){
		return dano;
	}
	public int getPrecisao(){
		return precisao;
	}
	public int getPPmax(){
		return PPmax;
	}
	public int getPPcur(){
		return PPcur;
	}
	public String getEfeito(){
		return efeito;
	}
	public void usePP(){
		PPcur--;
	}
	public void restorePP(int a){
		if(PPcur + a > PPmax) PPcur = PPmax;
		else PPcur+=a;
	}
	
	//Construtor
	public Ataque(String nome, String efeito, int dano, String tipo, int precisao, int PP){
		this.nome = nome;
		this.tipo = tipo;
		this.dano = dano;
		this.precisao = precisao;
		this.PPmax = PP;
		this.PPcur = this.PPmax;
		this.efeito = efeito;
	}
}
