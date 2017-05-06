package pokemon;

import java.io.IOException;

public class Index {
	public static void main(String[] args) throws IOException{
		Pokemon[] pokemons = CarregaTxt.leitorPokemon("txt/pokemons.txt");
		Ataque[] ataques = CarregaTxt.leitorAtaque("txt/moves.txt");
	}
}
