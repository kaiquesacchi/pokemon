package pokemon;

import java.io.IOException;

public class Index {
	public static void main(String[] args) throws IOException{
		Pokemon[] pokemons = CarregaPokemons.leitor("txt/pokemons.txt");
		System.out.println("O pokemon 36 é o: " + pokemons[36].getNome());
	}
}
