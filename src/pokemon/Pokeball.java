package pokemon;

public class Pokeball extends Item {
	//Atributos
	private double catchRate;
	//Metodos
	public double getCatchRate(){
		return catchRate;
	}
	//Construtor
	public Pokeball(String nome, int preco, double catchRate){
		super(nome,preco);
		this.catchRate=catchRate/10;
	}
}
