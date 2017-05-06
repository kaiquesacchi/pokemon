package pokemon;

import java.io.IOException;

public class Index {
	public static void main(String[] args) throws IOException{
		//Pokemon[] pokemons = CarregaPokemons.leitor("txt/pokemons.txt");
		Ataque[] ataques = CarregaAtaques.leitor("txt/moves.txt");
		ataques[0].printAll();
		ataques[1].printAll();
	}
}
