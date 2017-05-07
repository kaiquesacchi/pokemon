package pokemon;

import java.io.IOException;

public class Index {
	public static void main(String[] args) throws IOException{
		Ataque[] ataques = CarregaTxt.leitorAtaque("txt/moves.txt");
		Pokemon[] pokemons = CarregaTxt.leitorPokemon("txt/pokemons.txt");
	}
}
