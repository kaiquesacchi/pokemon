package pokemon;

import java.io.IOException;

public class Pokemon extends PokemonBase{
	//Atributos
	private int lv;
	private int curHp;
	private boolean[] effect = new boolean[6]; //paralyze, poison, burn, freeze, sleep, confuse
	private Status statsVol;
	//Atrobutos de batalha
	private boolean chargeEffect;
	private Ataque habChargeEffect;
	private boolean invulneravel;
	private int bindDur;
	private Ataque habBind;
	private boolean flinch; //always reset
	private int thrashPetal;
	private Ataque habThrashPetal;
	private int disable;
	private Ataque habDisable;
	private boolean recharge;
	private boolean leechSeed;
	private boolean lightScreen;
	private boolean reflect;
	
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
		public double calcStatusAdd(String stat){
			Status auxSol = this.getStatsSol();
			Status auxVol = this.getStatsVol();
			switch(stat){
			case "ATTACK":
				if(auxSol.getAtk() * 3.6 > auxVol.getAtk()) return (int)(auxSol.getAtk() * 0.5);
				else return 0;
			case "DEFENSE":
				if(auxSol.getDef() * 3.6 > auxVol.getDef()) return (int)(auxSol.getDef() * 0.5);
				else return 0;
			case "SPECIAL":
				if(auxSol.getSpc() * 3.6 > auxVol.getSpc()) return (int)(auxSol.getSpc() * 0.5);
				else return 0;
			case "SPEED":
				if(auxSol.getSpd() * 3.6 > auxVol.getSpd()) return (int)(auxSol.getSpd() * 0.5);
				else return 0;
			case "ACCURACY":
				if(3.6 > auxVol.getAccuracy())return 0.5;
				else return 0;
			case "EVASION":
				if(3.6 > auxVol.getEvasion())return 0.5;
				else return 0;
			default:
				throw new IllegalArgumentException("Invalid Status: " + stat);
			}
		}
		public double calcStatusSub(String stat){
			Status auxSol = this.getStatsSol();
			Status auxVol = this.getStatsVol();
			switch(stat){
			case "ATTACK":
				if(auxSol.getAtk() * 0.29 < auxVol.getAtk()) return -(int)(auxSol.getAtk() * 0.15);
				else return 0;
			case "DEFENSE":
				if(auxSol.getDef() * 0.29 < auxVol.getDef()) return -(int)(auxSol.getDef() * 0.15);
				else return 0;
			case "SPECIAL":
				if(auxSol.getSpc() * 0.29 < auxVol.getSpc()) return -(int)(auxSol.getSpc() * 0.15);
				else return 0;
			case "SPEED":
				if(auxSol.getSpd() * 0.29 < auxVol.getSpd()) return -(int)(auxSol.getSpd() * 0.15);
				else return 0;
			case "ACCURACY":
				if(0.29 < auxVol.getAccuracy())return -0.15;
				else return 0;
			case "EVASION":
				if(0.29 < auxVol.getEvasion())return -0.15;
				else return 0;
			default:
				throw new IllegalArgumentException("Invalid Status: " + stat);
			}
		}
		public void addLv(){
			lv++;
		}
		public void takeDamage(int dmg){
			if(curHp>=dmg){
				statsVol.addHp(-dmg);
				curHp-=dmg;
			}
			
			else {
				statsVol.addHp(-(curHp));
				curHp=0;
			}
		}
		public void heal(int life){
			if(curHp+life < statsSol.getHp()){
				statsVol.addHp(life);
				curHp+=life;
			}
			else{
				statsVol.addHp(statsSol.getHp()-curHp);
				curHp=statsSol.getHp();
			}
		}
		public boolean chargeEffect(){
			return chargeEffect;
		}
		public Ataque getChargeEffect(){
			return habChargeEffect;
		}
		public void addChargeEffect(Ataque hab){
			chargeEffect = true;
			habChargeEffect = hab;
			
		}
		public void removeChargeEffect(){
			chargeEffect = false;
			habChargeEffect = null;
		}
		public boolean getInvulneravel(){
			return invulneravel;
		}
		public void addInvulneravel(){
			invulneravel=true;
		}
		public void removeInvulneravel(){
			invulneravel=false;
		}
		public int getBindDur(){
			return bindDur;
		}
		public void addBind(Ataque hab, int a){
			habBind = hab;
			bindDur = a;
		}
		public void removeBind(int a){
			bindDur-=a;
		}
		public Ataque getHabBind(){
			return habBind;
		}
		public void addFlinch(){
			flinch=true;
		}
		public boolean getFlinch(){
			return flinch;
		}
		public void removeFlinch(){
			flinch = false;
		}
		public void addThrashPetal(Ataque hab, int a){
			habThrashPetal = hab;
			thrashPetal=a;
		}
		public int getThrashPetal(){
			return thrashPetal;
		}
		public Ataque getHabThrashPetal(){
			return habThrashPetal;
		}
		public void removeThrashPetal(int a){
			thrashPetal-=a;
		}
		public void addDisable(Ataque hab, int a){
			habDisable=hab;
			disable=a;
		}
		public int getDisable(){
			return disable;
		}
		public Ataque getHabDisable(){
			return habDisable;
		}
		public void removeDisable(int a){
			disable-=a;
		}
		public void addRecharge(){
			recharge=true;
		}
		public boolean getRecharge(){
			return recharge;
		}
		public void removeRecharge(){
			recharge=false;
		}
		public void addLeechSeed(){
			leechSeed=true;
		}
		public boolean getLeechSeed(){
			return leechSeed;
		}
		public void removeLeechSeed(){
			leechSeed=false;
		}
		public void addLightScreen(){
			lightScreen=true;
		}
		public boolean getLightScreen(){
			return lightScreen;
		}
		public void removeLightScreen(){
			lightScreen=false;
		}
		public void addReflect(){
			reflect=true;
		}
		public boolean getReflect(){
			return reflect;
		}
		public void removeReflect(){
			reflect=false;
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
			case "SLEEP":
				this.effect[4]=true;
				break;
			case "CONFUSE":
				this.effect[5]=true;
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
			case "SLEEP":
				this.effect[4]=false;
				break;
			case "CONFUSE":
				this.effect[5]=false;
				break;
			case "ALL":
				for(int i=0;i<5;i++) this.effect[i] = false;
			default:
	             throw new IllegalArgumentException("Invalid Status Effect: " + effect);
			}
			
		}
		public void resetStats(){
			this.statsVol=this.getStatsSol();
		}
	//Construtor
	public Pokemon(PokemonBase base) throws IOException{
		super(base.getId(), base.getNome(), base.getTipo1(), base.getTipo2(), base.statsSol, base.getAtkPool());
		this.lv=1;
		this.curHp=base.getMaxHp();
		for(int a=0;a<6;a++) this.effect[a] = false;
		this.statsVol=new Status(nome);
		statsVol.attr(statsSol);
		this.chargeEffect=false;
		this.habChargeEffect=null;
		this.invulneravel=false;
		this.bindDur=0;
		this.habBind=null;
		this.flinch=false;
		this.thrashPetal=0;
		this.disable=0;
		this.habDisable=null;
		this.recharge=false;
		this.leechSeed=false;
		this.lightScreen=false;
	}
	
	
	
}
