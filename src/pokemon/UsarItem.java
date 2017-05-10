package pokemon;

public class UsarItem extends Event {
	//Atributos
	private String typeOfItem;
	private BattleItem [] battleItems;
	private Elixer [] elixeres;
	private Pokeball [] pokeballs;
	private Potion [] potions;
	private StatusRestore [] statusRestores;
	
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
	/*public void action(String typeOfItem){
		
	}*/
	public String description(){
		return("Usa um item de batalha");
	}
	
	
	//Construtor
	public UsarItem(PkmPool pool, BattleItem[] battleItems, Elixer[] elixeres, Pokeball[] pokeballs, Potion[] potions, StatusRestore[] statusRestores){
		super(pool);
		this.battleItems = battleItems;
		this.elixeres = elixeres;
		this.pokeballs = pokeballs;
		this.potions = potions;
		this.statusRestores = statusRestores;
		
	}
	

}
