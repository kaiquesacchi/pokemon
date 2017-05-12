package pokemon;

import java.awt.EventQueue;
import java.io.IOException;

public class Index {
	public static void main(String[] args) throws IOException{
		Ataque[] ataques = CarregaTxt.leitorAtaque("txt/moves.txt");
		PokemonBase[] pokemons = CarregaTxt.leitor2Pokemon("resourse/pokemon.txt", ataques);
		Type tipos = CarregaTxt.leitorTypeChart("txt/type.txt");
		Potion[] potions = CarregaTxt.leitorPotions("txt/Itens/Potion");
		Pokeball[] pokeballs = CarregaTxt.leitorPokeballs("txt/Itens/Pokeball");
		Elixer[] elixeres = CarregaTxt.leitorElixeres("txt/Itens/Elixer");
		BattleItem[] battleItems = CarregaTxt.leitorBattleItems("txt/Itens/BattleItem");
		StatusRestore[] statusRestores = CarregaTxt.leitorStatusRestore("txt/Itens/StatusRestore");
		UsarItem itens1 = new UsarItem(null , battleItems, elixeres, pokeballs, potions, statusRestores);
		String[] aux = itens1.getBattleItems();

		/*for(int i=1; i<=151; i++){
			pokemons[i].printAll();
		}*/
		
		
		
		/*
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
		*/
		
		
		
		
		
		Pokemon[] pk1 = new Pokemon[2];
		Pokemon[] pk2 = new Pokemon[5];
		pk1[0] = new Pokemon(pokemons[5]);
		pk1[1] = new Pokemon(pokemons[122]);
		pk2[0] = new Pokemon(pokemons[45]);
		pk2[1] = new Pokemon(pokemons[150]);
		pk2[2] = new Pokemon(pokemons[86]);
		pk2[3] = new Pokemon(pokemons[101]);
		pk2[4] = new Pokemon(pokemons[77]);
		
		
		PkmPool pkmpool = new PkmPool(pk1);
		PkmPool pkmpool2 = new PkmPool(pk2);
		
		Trainer treinador1 = new Trainer("Fernando Collor", pkmpool, 0);
		Trainer treinador2 = new Trainer("Sergio Moro do Top Gear", pkmpool2, 0);
		Atacar ataque1 = new Atacar(treinador1.getPool(), treinador2.getPool(), tipos);
		Atacar ataque2 = new Atacar(treinador2.getPool(), treinador1.getPool(), tipos);
		/*treinador1.getPool().getPokemon(0).getStatsSol().printAll();
		treinador2.getPool().getPokemon(0).getStatsSol().printAll();
		ataque1.action(0);
		treinador1.getPool().getPokemon(0).getStatsVol().printAll();
		ataque2.action(0);
		//treinador1.getPool().getPokemon(0).printAll();
		treinador1.getPool().getPokemon(0).getStatsVol().printAll();
		*/
		
		
		
		
		
		
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI(treinador1, treinador2);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		
	}
}
