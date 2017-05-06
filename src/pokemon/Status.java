package pokemon;

public class Status {
	//Atributos
		//status constantes
	private int atk;
	private int spAtk;
	private int def;
	private int spDef;
	private int spd;
	private int maxHp;
		//status volateis
	private int curHp;
	private String effect;
	
	//Construtor
	public Status(int atk, int spAtk, int def, int spDef, int spd, int maxHp){
		this.atk = atk;
		this.spAtk = spAtk;
		this.def = def;
		this.spDef = spDef;
		this.spd = spd;
		this.maxHp = maxHp;
		this.curHp = maxHp;
		this.effect = null;		
		}
	
	public Status(){
		this.atk = gerar();
		this.spAtk = gerar();
		this.def = gerar();
		this.spDef = gerar();
		this.spd = gerar();
		this.maxHp = gerar();
		this.curHp = this.maxHp;
		this.effect = null;		
	}
	
	//Métodos
	private int gerar(){
		return ((int)(((Math.random() * 100)%10) + 10));
	}
	
	public int getAtk(){
		return atk;
	}
	
	public int getSpAtk(){
		return this.spAtk;
	}
	public int getDef(){
		return this.def;
	}
	public int getSpDef(){
		return this.spDef;
	}
	public int getSpd(){
		return this.spd;
	}
	public int getMaxHp(){
		return this.maxHp;
	}
	public int getCurHp(){
		return this.curHp;
	}
	public String getEffect(){
		return this.effect;
	}
}
