package pokemon;

import java.io.IOException;

abstract public class Index2 {
	//Atributos
	static private boolean[][] mapa;
	static private int[] posicao = new int[2];
	
	//Metodos
	
	
	static public void actRes(int act, Atacar ataque1, Atacar ataque2, UsarItem itens, PkmPool pool, PkmPool pool2, int skill, int troca){
		//cria um evento, dependendo da decisao tomada em battle
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
			//System.out.println("trocou "+pool.getPokemon(0).getNome()+" por "+pool.getPokemon(troca).getNome());
			TrocaPokemon.action(troca, pool);
			break;
		case 3:
			System.out.println("VOCE JOGOU UMA POKEBOLA NO GLAUCINHO");
			if(Math.random() * pool2.getPokemon(0).getStatsSol().getHp() > pool2.getPokemon(0).getCurHp()){
				System.out.println("VOCE CAPTUROU O GLAUCINHO SEU MONSTRO");
				pool2.getPokemon(0).takeDamage(300);
			}
			else System.out.println("GLAUCINHO ESCAPOU, É MUITO SAGAZ PRA VOCE");
			break;
		default:
			System.out.println("Ocorreu um problema... "+act);
		}
	}
	
	static public void battle(Trainer trainer1, Trainer trainer2, Type tipos, UsarItem itens1, UsarItem itens2){
		PkmPool pool1 = trainer1.getPool(), pool2 = trainer2.getPool();
		//inicializa ataques e itens
		Atacar ataque1 = new Atacar(pool1, pool2, tipos);
		Atacar ataque2 = new Atacar(pool2, pool1, tipos);
		itens1.setPool(pool1);
		itens2.setPool(pool2);
		int potions1=2, potions2=2;
		int act1, act2, aux, cont=0;
		System.out.println("trainer1== "+trainer1.getNome());
		System.out.println("trainer2== "+trainer2.getNome());
		while(trainer1.lose() && trainer2.lose()){
			//se estiver com pouca vida, usa poção
			if(pool1.getPokemon(0).getStatsVol().getHp() < 15 && potions1 > 0){
				potions1--;
				act1=1;
			}
			else if(pool2.getPokemon(0).getCurHp() < 30) act1=3;
				else act1=0;
			if(pool2.getPokemon(0).getStatsVol().getHp() < 15 && potions2 > 0){
				potions2--;
				act2=1;
			}
			else act2=0;
			if(act1 > act2 || (act1==act2 && pool1.getPokemon(0).getSpd() >= pool2.getPokemon(0).getSpd())){
				//decide quem tem prioridade
				actRes(act1, ataque1, ataque2, itens1, pool1, pool2, 0, 0);
				if(pool2.getPokemon(0).getStatsVol().getHp() > 0){
					actRes(act2, ataque2, ataque1, itens2, pool2,pool1, 0, 0);
				}
				else{
					break;
				}
				if(pool1.getPokemon(0).getCurHp() < 1){
					aux=1;
					while(pool1.dead(aux)){
						aux++;
						if(aux>pool1.getLenght()-1) break;
					}
					if(aux>pool1.getLenght()) break; //termina a batalha
					//System.out.println("Morreu, trocando por "+pool1.getPokemon(aux).getNome());
					actRes(2, ataque1, ataque2, itens1, pool1, pool2, 0, aux);
					ataque1 = new Atacar(pool1, pool2, tipos);
					ataque2 = new Atacar(pool2, pool1, tipos);
				}
			}
			else{
				actRes(act2, ataque2, ataque1, itens2, pool2, pool1, 0, 0);
				if(pool1.getPokemon(0).getStatsVol().getHp() > 0){
					actRes(act1, ataque1, ataque2, itens1, pool1, pool2, 0, 0);
				}
				else{
					aux=1;
					while(pool1.dead(aux)){
						aux++;
						if(aux>pool1.getLenght()-1) break;
					}
					if(aux>pool1.getLenght()-1) break; //termina a batalha
					System.out.println("Morreu, trocando por "+pool1.getPokemon(aux).getNome());
					actRes(2, ataque1, ataque2, itens1, pool1, pool2, 0, aux);
					ataque1 = new Atacar(pool1, pool2, tipos);
					ataque2 = new Atacar(pool2, pool1, tipos);
				}
				System.out.println("Poke "+pool2.getPokemon(0).getNome()+" curhp== "+pool2.getPokemon(0).getCurHp());
				if(pool2.getPokemon(0).getCurHp() < 1){
				
					break;
				}
			}
			System.out.println("Hp "+pool1.getPokemon(0).getNome()+" == "+pool1.getPokemon(0).getStatsVol().getHp()+"/"+pool1.getPokemon(0).getStatsSol().getHp());
			System.out.println("Hp "+pool2.getPokemon(0).getNome()+" == "+pool2.getPokemon(0).getStatsVol().getHp()+"/"+pool2.getPokemon(0).getStatsSol().getHp());
		cont++;
		if(cont>100){
			System.out.println("deve ter entrado em loop");
			break;
		}
		}
		if(trainer1.lose()) System.out.println(trainer1.getNome()+" ganhou");
		else System.out.println(trainer2.getNome()+" ganhou");
		
		
	}

	
	
	
	static public void andar(int[] posicao, boolean[][] mapa, Trainer trainer1, Trainer wild, Type tipos, UsarItem itens1, UsarItem itens2){
		int a;
		while(true){
			a =(int)(Math.random()*4);
			switch(a){
			case 0:
				if(posicao[0] > 0)
					posicao[0]--;
				break;
			case 1:
				if(posicao[1] > 0)
					posicao[1]--;
				break;
			case 2:
				if(posicao[0] < 9)
					posicao[0]++;
				break;
			case 3:
				if(posicao[1] < 7)
					posicao[1]++;
				break;
			default:
				System.out.println("bug");
			}
			if(mapa[posicao[0]][posicao[1]]){
				if(Math.random() >= 0.3){
					battle(trainer1, wild, tipos, itens1, itens2);
					break;
				}
			}
			
		}
		System.out.println("Terminou");
		
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
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
		
		Pokemon[] pk2 = new Pokemon[2];
		Pokemon[] pkWild = new Pokemon[1];
		pkWild[0] = new Pokemon(pokemons[83]);
		pk2[1] = new Pokemon(pokemons[150]);
		pk2[0] = new Pokemon(pokemons[38]);
		pk2[0].setHab(0, hab10);
		pk2[1].setHab(0, hab11);
		PkmPool pkmpool2 = new PkmPool(pk2);
		PkmPool pkmpool1 = new PkmPool(pkWild);
		pkmpool1.getPokemon(0).getStatsSol().addHp(30);
		pkmpool1.getPokemon(0).getStatsVol().addHp(30);
		pkmpool1.getPokemon(0).addCurHp(30);
		
		pkmpool2.getPokemon(1).getStatsSol().addHp(300);
		pkmpool2.getPokemon(1).getStatsVol().addHp(300);
		pkmpool2.getPokemon(1).addCurHp(300);
		Trainer trainer1 = new Trainer("Sergio Moro do Top Gear", pkmpool2, 0);
		Trainer wild = new Trainer("GLAUCINHO TERRA", pkmpool1, -15);
		
		mapa = new boolean[8][10];
		posicao[0]=posicao[1]=0;
		for(int a = 0; a<8; a++){
			for(int b = 0; b<10; b++){
				mapa[a][b]=((a*b)%2==0);
			}
		}
		andar(posicao, mapa, trainer1, wild, tipos, itens1, itens2);
		
		
		
		

	}

}
