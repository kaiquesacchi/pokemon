package pokemon;

public class Elixer extends Item{
	//Atributos
	private int PPRestore;
	//Metodos
	public int getPPRestore(){
		return PPRestore;
	}
	//Construtor
	public Elixer(String nome, int preco, int PPRestore){
		super(nome,preco);
		this.PPRestore=PPRestore;
	}
}
