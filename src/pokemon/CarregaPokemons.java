package pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
	 
public class CarregaPokemons {
	 
    public static Pokemon[] leitor(String path) throws IOException {
    	Pokemon[] pokemons = new Pokemon[152];
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = buffRead.readLine();
        int i=1;
        while (true) {
            if (linha != null) {
                String[] aux = linha.split(",");
                if (aux.length == 3)
                	pokemons[i] = new Pokemon(aux[0], aux[1], aux[2]);
                else
                	pokemons[i] = new Pokemon(aux[0], aux[1], aux[2], aux[3]); 
	        } 
            else break;
	        linha = buffRead.readLine();
	        i++;
	    }
	    buffRead.close();
	    System.out.println("[CarregaPokemons] Pokemons gerados com sucesso");
	    return pokemons;
	}
}
