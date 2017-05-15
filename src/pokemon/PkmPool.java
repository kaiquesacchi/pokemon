package pokemon;

public class PkmPool {
	//Atributos
	private Pokemon[] pokemons;
	
	//Métodos
	public boolean dead(int x){
		if(pokemons[x].getCurHp() < 1) return true;
		else return false;
	}
	public boolean lose(){
		int a=0;
		boolean aux=false;
		while(a<6){
			if(pokemons.length < a+1) break;
			System.out.println("pokemon== "+pokemons[a].getNome());
			if(pokemons[a].getStatsVol().getHp() > 0) aux=true;
			++a;
		}
		return (aux);
	}
	public Pokemon getPokemon(int x){
		if(pokemons.length > x)return pokemons[x];
		else return null;
	}
	public int getLenght(){
		return pokemons.length;
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
