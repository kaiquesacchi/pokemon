package pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
	 
public class CarregaTxt {
	     
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
	    System.out.println("[CarregaAtaques] Ataques gerados com sucesso");
	    return ataques;
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
    	BattleItem[] battleItems = new BattleItem[7];
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
    	StatusRestore[] statusRestores = new StatusRestore[6];
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
    public static Type leitorTypeChart(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = buffRead.readLine();
        String[] aux2 = (linha.split(","));
        linha = buffRead.readLine();//pula a primeira linha
        String[][] aux = new String[18][19];
        int x=0;
        while (true){
        	if(linha != null){
        		aux[x] = (linha.split(","));	
        	}
        	else break;
        	linha = buffRead.readLine();
        	x++;
        }
        buffRead.close();
        Type aux3 = new Type(aux2, aux);
        System.out.println("[CarregaTypeChart] TypeChart gerada com sucesso");
        return (aux3);
	}
    
    
    public static PokemonBase[] leitorPokemon(String path, Ataque[] ataques) throws IOException{
    	BufferedReader buffRead = new BufferedReader(new FileReader(path));
    	PokemonBase[] pokemons = new PokemonBase[152];
    	for(int i=1; i<=151; i++){
    		
    		//Dados Basicos
    		int id = Integer.parseInt(buffRead.readLine());
    		String nome = buffRead.readLine();
    		String[] tipos = buffRead.readLine().split(",");
    		
    		//Status
    		buffRead.readLine();
    		String[] aux = buffRead.readLine().split(",");
    		Status status = new Status(aux);
    		
    		//Ataques Atuais
    		Ataque[] ataquesAtuais = new Ataque[4];
    		buffRead.readLine();
    		aux = buffRead.readLine().split(",");
    		for(int j=0; j<4; j++){
    			if(j < aux.length){
    				int k = 0;
    	 			while (k < ataques.length && !(ataques[k].getNome().equals(aux[j]))) k++;
    	 			if (k < ataques.length) ataquesAtuais[j] = ataques[k];
    	 			else ataquesAtuais[j] = null;
	        	}
    		}
    	 	 
    		//tms Recebiveis
    		buffRead.readLine();
    		aux = buffRead.readLine().split(",");
    		int[] tmsRecebiveis = new int[aux.length];
    		for(int j=0; j<aux.length; j++){
    			tmsRecebiveis[j] = Integer.parseInt(aux[j]);
    		}
    		
    		//Ataques por nivel
    		buffRead.readLine();
    		String[][] learnSet = new String[10][2];
    		String linha;
    		int j = 0;
    		while(!((linha = buffRead.readLine()).equals("||||"))){
    			aux = linha.split(" - ");
    	 		learnSet[j] = aux;
    	 		j++;
    	 	}
    	 	
    	 	AtkPool atkpool = new AtkPool(ataquesAtuais, tmsRecebiveis, learnSet);
    	 	if(tipos.length == 2 && !(tipos[1].equals("null"))) pokemons[i] = new PokemonBase(id, nome, tipos[0].toUpperCase(), tipos[1].toUpperCase(), status, atkpool);
    	 	else if(tipos.length == 2) pokemons[i] = new PokemonBase(id, nome, tipos[0].toUpperCase(), null, status, atkpool);
    		else pokemons[i] = new PokemonBase(id, nome, tipos[0].toUpperCase(), status, atkpool);
    	 	 
 		 }
    	buffRead.close();
         return pokemons;
    	
    }
    
}
