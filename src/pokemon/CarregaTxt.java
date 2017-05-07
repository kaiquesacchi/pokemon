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
            String[] aux2 = linha.split(" ", 2);
	        aux[i] = Integer.parseInt(aux2[0]);
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
    
    public static int[] leitorTmsRecebiveis(String path, String nome) throws IOException {
    	if (nome.equals("Mr. Mime")) path += "mrmime.asm";
    	else if (nome.equals("Farfetch'd")) path += "farfetchd.asm";
    	else path += (nome.toLowerCase() + ".asm");
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        for (int i = 0; i<19; i++) buffRead.readLine(); // Pula 20 linhas.
        String linha = buffRead.readLine();
        String[] aux = linha.split(",");
        int[] aux2 = new int[aux.length];
	    for (int i = 1; i<aux.length; i++){
	    	aux2[i-1] = Integer.parseInt(aux[i]);
	    	System.out.println(aux2[i-1]);
	    }
	    buffRead.close();
	    return aux2;
	}
    
    public static Ataque[] leitorAtksBase(String path, String nome, Ataque[] ataques) throws IOException {
    	if (nome.equals("Mr. Mime")) path += "mrmime.asm";
    	else if (nome.equals("Farfetch'd")) path += "farfetchd.asm";
    	else path += (nome.toLowerCase() + ".asm");
    	Ataque[] aux = new Ataque[4];
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        for (int i = 0; i<14; i++) buffRead.readLine(); // Pula 14 linhas.
        for (int i = 0; i<4; i++){
        	String aux2 = buffRead.readLine();
        	if (aux2.equals("0")) aux[i] = null;
        	else {
        		int j = 0;
        		while(!(ataques[j].getNome().equals(aux2)) && j < ataques.length) j++;
        		aux[i] = ataques[j];
        	}
        }
        buffRead.close();
        return aux;
	}
}
