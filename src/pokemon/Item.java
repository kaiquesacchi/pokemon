package pokemon;

public abstract class Item {
	//Atributos
	private String nome;
	private int preco;
	//metodos
	public String getNome(){
		return nome;
	}
	public int getPreco(){
		return preco;
	}
	//construtor
	public Item(String nome, int preco){
		this.nome=nome;
		this.preco=preco;
	}
}
