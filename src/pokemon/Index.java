package pokemon;

import java.awt.EventQueue;
import java.io.IOException;

public class Index {
	
	static public void actRes(int act, Atacar ataque1, Atacar ataque2, UsarItem itens, PkmPool pool, int skill, int troca){
		//Esta função cria um evento, dependendo da decisão (act - action) tomada na battle
		switch(act){
		case 0:
			System.out.println("Pokemon "+pool.getPokemon(0).getNome()+" atacou");
			ataque1.action(skill);
			break;
		case 1:
			System.out.println("Pokemon "+pool.getPokemon(0).getNome()+" healou 20 hp");
			itens.action("Potion", "POTION",0, 0);
			break;
		case 2:
			System.out.println("trocou "+pool.getPokemon(0).getNome()+" por "+pool.getPokemon(troca).getNome());
			TrocaPokemon.action(troca, pool);
			break;
		default:
			System.out.println("Ocorreu um problema: "+act);
		}
	}
	
	static public void battle(Trainer trainer1, Trainer trainer2, Type tipos, UsarItem itens1, UsarItem itens2){
		//Esta função gerencia toda a batalha. Como a atividade pedia um resultado deterministico, usa-se sempre o mesmo ataque 
		//em cada pokemon... Os ataques foram selecionados de forma a evitar variaveis, como efeitos de contato, precisão etc.
		PkmPool pool1 = trainer1.getPool(), pool2 = trainer2.getPool();
		//Inicializa ataques e itens
		Atacar ataque1 = new Atacar(pool1, pool2, tipos);
		Atacar ataque2 = new Atacar(pool2, pool1, tipos);
		itens1.setPool(pool1);
		itens2.setPool(pool2);
		int potions1=2, potions2=2;
		
		int act1, act2, aux, cont=0;
		while(trainer1.lose() && trainer2.lose()){
			//Enquanto ninguem perder...
			if(pool1.getPokemon(0).getStatsVol().getHp() < 15 && potions1 > 0){
				//Se estiver com pouca vida, usa uma poção
				potions1--;
				act1=1;
			}
			else act1=0; //Caso nao, usa um ataque
			if(pool2.getPokemon(0).getStatsVol().getHp() < 15 && potions2 > 0){
				//mesma coisa, para o treinador 2
				potions2--;
				act2=1;
			}
			else act2=0;
			if(act1 > act2 || (act1==act2 && pool1.getPokemon(0).getSpd() >= pool2.getPokemon(0).getSpd())){
				//decide quem tem prioridade
				
				//se o treinador 1 tiver prioridade:
				actRes(act1, ataque1, ataque2, itens1, pool1, 0, 0);
				if(pool2.getPokemon(0).getStatsVol().getHp() > 0){
					//se o pokemon do treinador 2 sobreviver à ação do pokemon do 1
					actRes(act2, ataque2, ataque1, itens2, pool2, 0, 0);
				}
				else{
					aux=1;
					while(pool2.dead(aux)){
						//procura próximo pokemon ainda vivo
						aux++;
						if(aux>pool2.getLenght()-1) break;
					}
					if(aux>pool2.getLenght()-1) break; //termina a batalha se todos morreram
					System.out.println("Morreu, trocando por "+pool2.getPokemon(aux).getNome());
					actRes(2, ataque2, ataque1, itens2, pool2, 0, aux);
					ataque1 = new Atacar(pool1, pool2, tipos);
					ataque2 = new Atacar(pool2, pool1, tipos);
				}
				if(pool1.getPokemon(0).getCurHp() < 1){
					// caso o pokemon do treinador 1 morra:
					aux=1;
					while(pool1.dead(aux)){
						aux++;
						if(aux>pool1.getLenght()) break;
					}
					if(aux>pool1.getLenght()) break; //termina a batalha
					System.out.println("Morreu, trocando por "+pool1.getPokemon(aux).getNome());
					actRes(2, ataque1, ataque2, itens1, pool1, 0, aux);
					ataque1 = new Atacar(pool1, pool2, tipos);
					ataque2 = new Atacar(pool2, pool1, tipos);
				}
			}
			else{
				//mesma coisa, para o caso do treinador 2 ter prioridade
				actRes(act2, ataque2, ataque1, itens2, pool2, 0, 0);
				if(pool1.getPokemon(0).getStatsVol().getHp() > 0){
					actRes(act1, ataque1, ataque2, itens1, pool1, 0, 0);
				}
				else{
					aux=1;
					while(pool1.dead(aux)){
						aux++;
						if(aux>pool1.getLenght()-1) break;
					}
					if(aux>pool1.getLenght()-1) break; //termina a batalha
					System.out.println("Morreu, trocando por "+pool1.getPokemon(aux).getNome());
					actRes(2, ataque1, ataque2, itens1, pool1, 0, aux);
					ataque1 = new Atacar(pool1, pool2, tipos);
					ataque2 = new Atacar(pool2, pool1, tipos);
				}
				System.out.println("Poke "+pool2.getPokemon(0).getNome()+" curhp== "+pool2.getPokemon(0).getCurHp());
				if(pool2.getPokemon(0).getCurHp() < 1){
					aux=1;
					while(pool2.dead(aux)){
						aux++;
						if(aux>pool2.getLenght()) break;
					}
					if(aux>pool2.getLenght()) break; //termina a batalha
					System.out.println("Morreu, trocando por "+pool2.getPokemon(aux).getNome());
					actRes(2, ataque2, ataque1, itens2, pool2, 0, aux);
					ataque1 = new Atacar(pool1, pool2, tipos);
					ataque2 = new Atacar(pool2, pool1, tipos);
				}
			}
			System.out.println("Hp "+pool1.getPokemon(0).getNome()+" == "+pool1.getPokemon(0).getStatsVol().getHp()+"/"+pool1.getPokemon(0).getStatsSol().getHp());
			System.out.println("Hp "+pool2.getPokemon(0).getNome()+" == "+pool2.getPokemon(0).getStatsVol().getHp()+"/"+pool2.getPokemon(0).getStatsSol().getHp());
			cont++;
			if(cont>100){
				//caso a batalha seja extremamente longa
				System.out.println("Batalha longa demais... Abortando...");
				break;
			}
		}
		if(trainer1.lose()) System.out.println(trainer1.getNome()+" ganhou");
		else System.out.println(trainer2.getNome()+" ganhou");
		
	}
	
	public static void main(String[] args) throws IOException{
		//Carregadores de banco de dados
		Ataque[] ataques = CarregaTxt.leitorAtaque("txt/moves.txt");
		PokemonBase[] pokemons = CarregaTxt.leitorPokemon("resource/pokemon.txt", ataques);
		Type tipos = CarregaTxt.leitorTypeChart("txt/type.txt");
		Potion[] potions = CarregaTxt.leitorPotions("txt/Itens/Potion");
		Pokeball[] pokeballs = CarregaTxt.leitorPokeballs("txt/Itens/Pokeball");
		Elixer[] elixeres = CarregaTxt.leitorElixeres("txt/Itens/Elixer");
		BattleItem[] battleItems = CarregaTxt.leitorBattleItems("txt/Itens/BattleItem");
		StatusRestore[] statusRestores = CarregaTxt.leitorStatusRestore("txt/Itens/StatusRestore");
		UsarItem itens1 = new UsarItem(null , battleItems, elixeres, pokeballs, potions, statusRestores);
		UsarItem itens2 = new UsarItem(null , battleItems, elixeres, pokeballs, potions, statusRestores);
		Ataque hab01 =  new Ataque("THUNDERSHOCK", "NO ADDITIONAL EFFECT", 90, "ELECTRIC", 100, 15);
		Ataque hab10 =  new Ataque("FLAMMENWERFER", "NO ADDITIONAL EFFECT", 80, "FIRE", 100, 20);
		Ataque hab11 =  new Ataque("PSYCHIC", "NO ADDITIONAL EFFECT", 120, "PSYCHIC", 100, 15);

		
		Pokemon[] pk1 = new Pokemon[2];
		Pokemon[] pk2 = new Pokemon[2];
		pk1[0] = new Pokemon(pokemons[6]);
		pk1[1] = new Pokemon(pokemons[25]);
		pk2[1] = new Pokemon(pokemons[150]);
		pk2[0] = new Pokemon(pokemons[38]);

		
		
		PkmPool pkmpool = new PkmPool(pk1);
		PkmPool pkmpool2 = new PkmPool(pk2);
		pk1[1].setHab(0, hab01);
		pk2[0].setHab(0, hab10);
		pk2[1].setHab(0, hab11);
		
		Trainer treinador1 = new Trainer("Fernando Collor", pkmpool, 0);
		Trainer treinador2 = new Trainer("Sergio Moro do Top Gear", pkmpool2, 0);

		battle(treinador1, treinador2, tipos, itens1, itens2);

		
	}
}
