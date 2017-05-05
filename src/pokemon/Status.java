package pokemon;

public class Status {
	//solid stats
	private int atk;
	private int spAtk;
	private int def;
	private int spDef;
	private int spd;
	private int maxHp;
	//volatile stats
	private int curHp;
	private String effect;
	
	public Status(int atk, int aspAtk, int def, int spDef, int spd, int maxHp){
		this.atk=atk;
		this.spAtk=spAtk;
		this.def=def;
		this.spDef=spDef;
		this.spd=spd;
		this.maxHp=maxHp;
		this.curHp=maxHp;
		this.effect=null;		
		}
}
