package pokemon;

public class BattleItem extends Item{
	//Atributos
	private int multiplicador;
	//Metodos
	public int getMultiplicador(){
		return multiplicador;
	}
	//Construtor
	public BattleItem(String nome, int preco, int multiplicador){
		super(nome,preco);
		this.multiplicador=multiplicador;
	}
}
