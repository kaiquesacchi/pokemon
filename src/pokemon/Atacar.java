package pokemon;

public class Atacar extends Event{
	//Atributos
	private PkmPool pool2;
	private Pokemon atacante;
	private Pokemon defensor;
	private Type types;
	
	//Métodos
	private double calcType(String type){
		return types.getTypeMult(type, defensor.getTipo1(), defensor.getTipo2());
		
		
	}
	private double calcSTAB(String type){
		if(type.equals(atacante.getTipo1()) || type.equals(atacante.getTipo2())){
			return 1.5;
		}
		else return 1;
	}
	private double multiCalc(String type){
		double mod = (Math.random()*(0.25) + 0.85) * calcSTAB(type) * calcType(type);
		return mod;
	}
	private int danoCalc(int power, String type){
		double d = (((2/5) * atacante.getLv() + 2) * power * atacante.getAtk()/defensor.getDef())/50 + 2;
		return (int)(d * multiCalc(type));
	}
	public void action(int a){
		Ataque hab = atacante.getAtkPool().getAtaquesAtuais()[a];
		switch(hab.getEfeito()){
		case "NO ADDITIONAL EFFECT":
			defensor.takeDamage(danoCalc(hab.getDano(),hab.getTipo()));
			break;
		case "TWO TO FIVE ATTACKS EFFECT":
			int rand = (int)(Math.random() * 4) + 2;
			for(int i=0;i<rand;i++){
				defensor.takeDamage(danoCalc(hab.getDano(),hab.getTipo()));
			}
		}
		
		
	}
	public String description(){
		return "usa uma habilidade";
	}
	
	
	//Construtor
	public Atacar(PkmPool pool1, PkmPool pool2, Type types){
		super(pool1);
		atacante=pool1.getPokemonX(1);
		defensor=pool2.getPokemonX(1);
		this.types=types;
	}

}
