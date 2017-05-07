package pokemon;

public class Potion extends Item {
	//Atributos
	private int heal;
	//Metodos
	public int getHeal(){
		return heal;
	}
	//Construtor
	public Potion(String nome, int preco, int heal){
		super(nome, preco);
		this.heal=heal;
	}
}
