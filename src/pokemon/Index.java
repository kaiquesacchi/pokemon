package pokemon;

import java.io.IOException;

public class Index {
	public static void main(String[] args) throws IOException{
		Ataque[] ataques = CarregaTxt.leitorAtaque("txt/moves.txt");
		PokemonBase[] pokemons = CarregaTxt.leitorPokemon("txt/pokemons.txt");
		Type tipos = CarregaTxt.leitorTypeChart("txt/type.txt");
		Potion[] potions = CarregaTxt.leitorPotions("txt/Itens/Potion");
		Pokeball[] pokeballs = CarregaTxt.leitorPokeballs("txt/Itens/Pokeball");
		Elixer[] elixeres = CarregaTxt.leitorElixeres("txt/Itens/Elixer");
		BattleItem[] battleItems = CarregaTxt.leitorBattleItems("txt/Itens/BattleItem");
		StatusRestore[] statusRestores = CarregaTxt.leitorStatusRestore("txt/Itens/StatusRestore");
		UsarItem itens1 = new UsarItem(null , battleItems, elixeres, pokeballs, potions, statusRestores);
		System.out.println("Battle items:");
		String[] aux = itens1.getBattleItems();
		for(int a=0;a<aux.length;a++){
			System.out.println("-" + aux[a]);
		}
		System.out.println("Elixeres:");
		aux = itens1.getElixeres();
		for(int a=0;a<aux.length;a++){
			System.out.println("-" + aux[a]);
		}
		System.out.println("Pokeballs:");
		aux = itens1.getPokeballs();
		for(int a=0;a<aux.length;a++){
			System.out.println("-" + aux[a]);
		}
		System.out.println("Potions:");
		aux = itens1.getPotions();
		//System.out.println("aux.lenght== " + aux.length);
		for(int a=0;a<aux.length;a++){
			System.out.println("-" + aux[a]);
		}
		System.out.println("Status Restores:");
		aux = itens1.getStatusRestore();
		for(int a=0;a<aux.length;a++){
			System.out.println("-" + aux[a]);
		}
		
	}
}
