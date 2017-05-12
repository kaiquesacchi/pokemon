package pokemon;

public class PkmPool {
	//Atributos
	private Pokemon[] pokemons;
	
	//Métodos
	public Pokemon getPokemon(int x){
		return pokemons[x];
	}
	public void switchPokemon(int a){
		Pokemon aux = pokemons[a];
		pokemons[a] = pokemons[0];
		pokemons[0] = aux;
	}
	
	//Construtor
	public PkmPool(Pokemon[] pokemons){
		this.pokemons = pokemons;
	}
}
