package pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
	 
public class CarregaTxt {
	 
    public static Pokemon[] leitorPokemon(String path) throws IOException {
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
    
    
    public static int[] leitorStatus(String path, String nome) throws IOException {
    	if (nome.equals("Mr. Mime")) path += "mrmime.asm";
    	else if (nome.equals("Farfetch'd")) path += "farfetchd.asm";
    	else path += (nome.toLowerCase() + ".asm");
    	int[] aux = new int[5];
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        buffRead.readLine(); // Pula a primeira linha.
        for (int i = 0;i < 5; i++) {
        	String linha = buffRead.readLine();
            String[] aux2 = linha.split(" ", 3);
	        aux[i] = Integer.parseInt(aux2[1]);
	    }
	    buffRead.close();
	    return aux;
	}
    
    public static Ataque[] leitorAtaque(String path) throws IOException {
    	Ataque[] ataques = new Ataque[165];
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = buffRead.readLine();
        int i=0;
        while (true) {
            if (linha != null) {
                String[] aux = linha.split(",");
                ataques[i] = new Ataque(aux[0], aux[1], Integer.parseInt(aux[2]), aux[3], Integer.parseInt(aux[4]), Integer.parseInt(aux[5]));
            }
            else break;
	        linha = buffRead.readLine();
	        i++;
	    }
	    buffRead.close();
	    System.out.println("[CarregaAtaques] Ataques gerados com sucesso");
	    return ataques;
	}
}
