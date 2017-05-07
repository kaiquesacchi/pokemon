package pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
	 
public class CarregaTxt {
	 
    public static PokemonBase[] leitorPokemon(String path) throws IOException {
    	PokemonBase[] pokemons = new PokemonBase[152];
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = buffRead.readLine();
        int i=1;
        while (true) {
            if (linha != null) {
                String[] aux = linha.split(",");
                if (aux.length == 3)
                	pokemons[i] = new PokemonBase(aux[0], aux[1], aux[2]);
                else
                	pokemons[i] = new PokemonBase(aux[0], aux[1], aux[2], aux[3]); 
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
        linha = buffRead.readLine();
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
	    //System.out.println("[CarregaAtaques] Ataques gerados com sucesso");
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
        		while(j < ataques.length && !(ataques[j].getNome().equals(aux2))){
        			j++;
        		}
        		aux[i] = ataques[j];
        	}
        }
        buffRead.close();
        return aux;
	}
    
    
    
    public static String[][] leitorLearnSet(String path, String nome, Ataque[] ataques) throws IOException {
    	if (nome.equals("Mr. Mime")) nome = "MR MIME";
    	else if (nome.equals("Farfetch'd")) nome = "FARFETCHD";
    	else nome = nome.toUpperCase();
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = buffRead.readLine();
        while (!(nome.equals(linha))) linha = buffRead.readLine(); // Pula linhas até encontrar o pokemon correspondente.
        while (!(linha.equals("Learnset"))) linha = buffRead.readLine();
        String[][] aux = new String[10][2];
        int i=0;
        while (!((linha = buffRead.readLine()).equals("0"))){
        	aux[i] = (linha.split(","));
        	i++;
        }
        buffRead.close();
        return (aux);
	}
    
    
    
    
    
    
    
    public static Potion[] leitorPotions(String path) throws IOException {
    	Potion[] potions = new Potion[8];
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = buffRead.readLine();
        int i=0;
        while (true) {
            if (linha != null) {
                String[] aux = linha.split(",");
                potions[i] = new Potion(aux[0], Integer.parseInt(aux[1]), Integer.parseInt(aux[2]));
            }
            else break;
	        linha = buffRead.readLine();
	        i++;
	    }
	    buffRead.close();
	    System.out.println("[CarregaPotion] Potions geradas com sucesso");
	    return potions;
	}
    
    public static Pokeball[] leitorPokeballs(String path) throws IOException {
    	Pokeball[] pokeballs = new Pokeball[4];
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = buffRead.readLine();
        int i=0;
        while (true) {
            if (linha != null) {
                String[] aux = linha.split(",");
                pokeballs[i] = new Pokeball(aux[0], Integer.parseInt(aux[1]), Integer.parseInt(aux[2]));
            }
            else break;
	        linha = buffRead.readLine();
	        i++;
	    }
	    buffRead.close();
	    System.out.println("[CarregaPokeball] Pokeballs geradas com sucesso");
	    return pokeballs;
	}
    
    public static Elixer[] leitorElixeres(String path) throws IOException {
    	Elixer[] elixeres = new Elixer[4];
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = buffRead.readLine();
        int i=0;
        while (true) {
            if (linha != null) {
                String[] aux = linha.split(",");
                elixeres[i] = new Elixer(aux[0], Integer.parseInt(aux[1]), Integer.parseInt(aux[2]));
            }
            else break;
	        linha = buffRead.readLine();
	        i++;
	    }
	    buffRead.close();
	    System.out.println("[CarregaElixere] Elixeres gerados com sucesso");
	    return elixeres;
	}
    
    public static BattleItem[] leitorBattleItems(String path) throws IOException {
    	BattleItem[] battleItems = new BattleItem[4];
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = buffRead.readLine();
        int i=0;
        while (true) {
            if (linha != null) {
                String[] aux = linha.split(",");
                battleItems[i] = new BattleItem(aux[0], Integer.parseInt(aux[1]), Integer.parseInt(aux[2]));
            }
            else break;
	        linha = buffRead.readLine();
	        i++;
	    }
	    buffRead.close();
	    System.out.println("[CarregaBattleItem] BattleItems gerados com sucesso");
	    return battleItems;
	}
    
    public static StatusRestore[] leitorStatusRestore(String path) throws IOException {
    	StatusRestore[] statusRestores = new StatusRestore[4];
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = buffRead.readLine();
        int i=0;
        while (true) {
            if (linha != null) {
                String[] aux = linha.split(",");
                statusRestores[i] = new StatusRestore(aux[0], Integer.parseInt(aux[1]));
            }
            else break;
	        linha = buffRead.readLine();
	        i++;
	    }
	    buffRead.close();
	    System.out.println("[CarregaStatusRestore] StatusRestores gerados com sucesso");
	    return statusRestores;
	}
    
    
    
    
    
}
