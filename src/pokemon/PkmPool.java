package pokemon;

public class PkmPool {
	//Atributos
	private Pokemon[] pokemons;
	
	//Métodos
	public Pokemon getPokemonX(int x){
		return pokemons[x];
	}
	
	//Construtor
	public PkmPool(Pokemon[] pokemons){
		this.pokemons = pokemons;
	}
}
