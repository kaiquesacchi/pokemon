package pokemon;

public class TrocaPokemon extends Event{
	//Atributos
	int a;
	PkmPool pool;
	//Metodos
	public int action(){
		if(pool.getPokemon(0).getBindDur() == 0 && pool.getPokemon(0).getThrashPetal() == 0){
			pool.switchPokemon(a);
			return 0;
		}
		System.out.println("TA PRESO");
		return 1;
	}
	
	public String description(){
		return ("Voce trocou para " + pool.getPokemon(a).getNome());
	}

	public TrocaPokemon(int a, PkmPool pool) {
		this.a = a;
		this.pool = pool;
	}	
}
