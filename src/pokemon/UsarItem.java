package pokemon;

public class UsarItem extends Event {
	//Atributos
	private String typeOfItem;
	private BattleItem [] battleItems;
	private Elixer [] elixeres;
	private Pokeball [] pokeballs;
	private Potion [] potions;
	private StatusRestore [] statusRestores;
	private String itemName;
	private int pke;
	private int skill;
	private PkmPool pool1;
	
	//Métodos
	public String[] getBattleItems(){
		String[] aux = new String[7];
		for(int a=0;a<7;a++){
			aux[a] = battleItems[a].getNome(); 
		}
		return aux;
	}
	public String[] getElixeres(){
		String[] aux = new String[4];
		for(int a=0;a<4;a++){
			aux[a] = elixeres[a].getNome();
		}
		return aux;
	}
	public String[] getPokeballs(){
		String[] aux = new String[4];
		for(int a=0;a<4;a++){
			aux[a] = pokeballs[a].getNome();
		}
		return aux;
	}
	public String[] getPotions(){
		String[] aux = new String[8];
		for(int a=0;a<8;a++){
			aux[a] = potions[a].getNome();
		}
		return aux;
	}
	public String[] getStatusRestore(){
		String[] aux = new String[6];
		for(int a=0;a<6;a++){
			aux[a]=statusRestores[a].getNome();
		}
		return aux;
	}
	public int action(){
		Pokemon poke = pool1.getPokemon(pke);
		switch(typeOfItem){
		case "BattleItem":
			switch(itemName){
			case "X ATTACK":
				poke.getStatsVol().addAtk((int)(poke.calcStatusAdd("ATTACK")));
				break;
			case "X DEFEND":
				poke.getStatsVol().addDef((int)(poke.calcStatusAdd("DEFENSE")));
				break;
			case "X SPEED":
				poke.getStatsVol().addSpd((int)(poke.calcStatusAdd("SPEED")));
				break;
			case "X SPECIAL":
				poke.getStatsVol().addSpc((int)(poke.calcStatusAdd("SPECIAL")));
				break;
			case "X ACCURACY":
				poke.getStatsVol().addSpc((int)(poke.calcStatusAdd("ACCURACY")));
				break;
			case "DIRE HIT": //FALTA IMPLEMENTAR CRITICO
				break;
			case "GUARD SPEC": //falta implementar, impede reducao de status pelo oponente por 5 turnos
				break;
			}
			break;
		case "Elixer":
			switch(itemName){
			case "ETHER":
				poke.getAtkPool().getAtaqueAtualX(skill).restorePP(10);
				break;
			case "MAX ETHER":
				poke.getAtkPool().getAtaqueAtualX(skill).restorePP(100);
				break;
			case "ELIXER":
				for(int a=0;a<4;a++){
					poke.getAtkPool().getAtaqueAtualX(skill).restorePP(10);
				}
				break;
			case "MAX ELIXER":
				for(int a=0;a<4;a++){
					poke.getAtkPool().getAtaqueAtualX(skill).restorePP(100);
				}
				break;
			}
			break;
		case "Pokeball":  //FALTA IMPLEMENTAR CAPTURA
			switch(itemName){
			case "POKE BALL":
			case "GREAT BALL":
			case "ULTRA BALL":
			case "MASTURBALL":
			}
			break;
		case "Potion":
			switch(itemName){
			case "POTION":
				poke.heal(20);
				break;
			case "SUPER POTION":
				poke.heal(50);
				break;
			case "HYPER POTION":
				poke.heal(200);
				break;
			case "MAX POTION":
				poke.heal(10000);
				break;
			case "FULL RESTORE":
				poke.heal(10000);
				poke.removeEffect("ALL");
				break;
			case "FRESH WATER":
				poke.heal(50);
				break;
			case "SODA POP":
				poke.heal(60);
				break;
			case "LEMONADE":
				poke.heal(80);
				break;
			}
			break;
		case "StatusRestore":
			switch(itemName){
			case "ANTIDOTE":
				poke.removeEffect("POISON");
				break;
			case "PARALYZ HEAL":
				poke.removeEffect("PARALYZE");
				break;
			case "AWAKENING":
				poke.removeEffect("SLEEP");
				break;
			case "BURN HEAL":
				poke.removeEffect("BURN");
				break;
			case "ICE HEAL":
				poke.removeEffect("FREEZE");
				break;
			case "FULL HEAL":
				poke.removeEffect("ALL");
				break;
			}
			break;
		default:
			System.out.println("deu bosta no UsarItemAction");
		}
		return 0;
	}
	public String description(){
		return("Voce usou " + itemName);
	}
	
	

	//Construtor
	public UsarItem(PkmPool pool, BattleItem[] battleItems, Elixer[] elixeres, Pokeball[] pokeballs, Potion[] potions, StatusRestore[] statusRestores){
		this.pool1 = pool;
		this.battleItems = battleItems;
		this.elixeres = elixeres;
		this.pokeballs = pokeballs;
		this.potions = potions;
		this.statusRestores = statusRestores;
	}
	public UsarItem(String typeOfItem, BattleItem[] battleItems, Elixer[] elixeres, Pokeball[] pokeballs,
			Potion[] potions, StatusRestore[] statusRestores, String itemName, int pke, int skill, PkmPool pool1) {
		this.typeOfItem = typeOfItem;
		this.battleItems = battleItems;
		this.elixeres = elixeres;
		this.pokeballs = pokeballs;
		this.potions = potions;
		this.statusRestores = statusRestores;
		this.itemName = itemName;
		this.pke = pke;
		this.skill = skill;
		this.pool1 = pool1;
		
	}
	

}
