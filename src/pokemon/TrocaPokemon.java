package pokemon;

public class TrocaPokemon extends Event{
	//Sem atributos adicionais
	//Metodos
	public void action(int a){
		pool1.switchPokemon(a);
	}
	
	public String description(){
		return "Troca a porra do pokemon caralho";
	}
	
	//Construtor
	public TrocaPokemon(PkmPool pool){
		super(pool);
	}

}
