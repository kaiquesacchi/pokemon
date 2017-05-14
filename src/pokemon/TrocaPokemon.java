package pokemon;

public class TrocaPokemon extends Event{
	
	//Atributos
	private int a;
	private PkmPool pool;
	
	//Metodos
	public boolean viavel(){
		return (pool.getPokemon(0).getBindDur() == 0 && pool.getPokemon(0).getThrashPetal() == 0);
	}
	
	public String description(){
		return ("Voce trocou para " + pool.getPokemon(0).getNome());
	}
	
	public void action() {
		pool.switchPokemon(a);
	}
	
	//Construtor

	public TrocaPokemon(int a, PkmPool pool) {
		this.a = a;
		this.pool = pool;
		this.prioridade = 1;
	}
	
}
