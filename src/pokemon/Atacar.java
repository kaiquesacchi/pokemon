package pokemon;

public class Atacar extends Event{
	//Atributos
	private PkmPool pool2;
	private Pokemon atacante;
	private Pokemon defensor;
	private Type types;
	
	//Métodos
	private boolean calcPrecisao(Ataque hab){
		double a = Math.random() * 100;
		if(a <= hab.getPrecisao() || hab.getEfeito().equals("CHARGE EFFECT")) return true; //para charge effects, primeira instancia sempre ocorrendo
		else return false;
	}
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
		int rand, dano = danoCalc(hab.getDano(),hab.getTipo());
		atacante.getAtkPool().getAtaquesAtuais()[a].usePP();
		if(calcPrecisao(hab)){
			switch(hab.getEfeito()){
			case "NO ADDITIONAL EFFECT":
				defensor.takeDamage(dano);
				//System.out.println("LEVOU FODENDOS " + dano + "DE DANOSO");
				break;
			case "TWO TO FIVE ATTACKS EFFECT":
				rand = (int)(Math.random() * 4) + 2;
				for(int i=0;i<rand;i++){
					defensor.takeDamage(dano);
				}
				System.out.println("Atacou " + rand + "vezes");
				break;
			case "PAY DAY EFFECT":
				defensor.takeDamage(dano);
				//SOMAR O GOLD DA BATALHA EM 2*atacante.getLv()
				break;
			case "BURN SIDE EFFECT1":
				defensor.takeDamage(dano);
				rand = (int)(Math.random() * 10) +1;
				if(rand == 10){
					defensor.addEffect("BURN");
					System.out.println("OLOCO BIXO TA PEGANDO FOGO");
				}
				break;
			case "FREEZE SIDE EFFECT":
				defensor.takeDamage(dano);
				rand = (int)(Math.random() * 10) +1;
				if(rand == 10){
					defensor.addEffect("FREEZE");
					System.out.println("OLOCO BIXO TA GELADO");
				}
				break;
			case "PARALYZE SIDE EFFECT1": //line 10
				defensor.takeDamage(dano);
				rand = (int)(Math.random() * 10) +1;
				if(rand == 10){
					defensor.addEffect("FREEZE");
					System.out.println("OLOCO BIXO TA EM CHOQUE");
				}
				break;
			case "OHKO EFFECT": //13
				defensor.takeDamage(defensor.getCurHp() + 1);
				System.out.println("EITA PORRA VIROU O SAITAMA");
				break;
			case "CHARGE EFFECT":
				if(!(atacante.chargeEffect())){
					atacante.addChargeEffect(hab);
				System.out.println("SÓ ESPERA ARROMBADO");
				}
				else{
					hab.usePP();
					atacante.removeChargeEffect();
					if(calcPrecisao(hab)){
						defensor.takeDamage(dano);
					}
					else System.out.println("FALHOU PIRANHO");
				}
				break;
			case "ATTACK UP2 EFFECT":
				
			 
				
			}
		}
		else System.out.println("ERROOOOW");
		
	}
	public String description(){
		return "usa uma habilidade seu imbecil, acha que \"ataca\" faz o que seu cabaço";
	}
	
	
	//Construtor
	public Atacar(PkmPool pool1, PkmPool pool2, Type types){
		super(pool1);
		atacante=pool1.getPokemonX(1);
		defensor=pool2.getPokemonX(1);
		this.types=types;
	}

}
