package pokemon;

public class TrocaPokemon extends Event{
	//Sem atributos adicionais
	//Metodos
	public void action(int a){
		if(pool1.getPokemonX(0).getBindDur() == 0 && pool1.getPokemonX(0).getThrashPetal() == 0)
		pool1.switchPokemon(a);
		else System.out.println("TA PRESO");
	}
	
	public String description(){
		return "Troca a porra do pokemon caralho";
	}
	
	//Construtor
	public TrocaPokemon(PkmPool pool){
		super(pool);
	}

}
