package pokemon;

import java.io.IOException;

public class Pokemon extends PokemonBase{
	//Atributos
	private int lv;
	private int curHp;
	private boolean[] effect = new boolean[5]; //paralyze, poison, burn, freeze, confuse
	private Status statsVol;
	
	//Metodos
		//getters
		public int getLv(){
			return lv;
		}
		public int getCurHp(){
			return curHp;
		}
		public boolean[] getEffect(){
			return effect;
		}
		public Status getStatsVol(){
			return statsVol;
		}
		//adders
		public void addLv(){
			lv++;
		}
		public void takeDamage(int dmg){
			if(curHp>=dmg)
				curHp-=dmg;
			else 
				curHp=0;
		}
		public void addEffect(String effect){
			switch (effect){
			case "PARALYZE":
				this.effect[0]=true;
				break;
			case "POISON":
				this.effect[1]=true;
				break;
			case "BURN":
				this.effect[2]=true;
				break;
			case "FREEZE":
				this.effect[3]=true;
				break;
			case "CONFUSE":
				this.effect[4]=true;
				break;
			default:
	             throw new IllegalArgumentException("Invalid Status Effect: " + effect);
			}
		}
		public void removeEffect(String effect){
			switch (effect){
			case "PARALYZE":
				this.effect[0]=false;
				break;
			case "POISON":
				this.effect[1]=false;
				break;
			case "BURN":
				this.effect[2]=false;
				break;
			case "FREEZE":
				this.effect[3]=false;
				break;
			case "CONFUSE":
				this.effect[4]=false;
				break;
			case "ALL":
				for(int i=0;i<5;i++) this.effect[i] = false;
			default:
	             throw new IllegalArgumentException("Invalid Status Effect: " + effect);
			}
			
		}
	//Construtor
	public Pokemon(PokemonBase base) throws IOException{
		super(base.getId(), base.getNome(), base.getTipo1(), base.getTipo2());
		this.lv=1;
		this.curHp=base.getMaxHp();
		this.effect=null;
		this.statsVol=null;
	}
	
	
	
}
