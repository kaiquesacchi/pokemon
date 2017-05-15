package pokemon;

public class Atacar extends Event{
	//Atributos
	private PkmPool pool2;
	private Pokemon atacante;
	private Pokemon defensor;
	private Type types;
	
	//Métodos
	
	private boolean probEffect(double a){
		double aux = Math.random() * 100;
		return (aux<a);
	}
	
	private int thrashPetalCalc(){
		double a = Math.random() * 100;
		if(a<50) return 3;
		return 4;
	}
	
	private int bindCalc(){
		double a = Math.random() * 100;
		if(a<=37.5) return 2;
		else if(a<75) return 3;
		else if (a<87.5) return 4;
		return 5;
	}
	
	private boolean calcPrecisao(Ataque hab){
		double a = Math.random() * 100;
		return (a <= hab.getPrecisao() || hab.getEfeito().equals("CHARGE EFFECT") || hab.getEfeito().equals("FLY EFFECT") || hab.getEfeito().equals("JUMP KICK EFFECT") || hab.getEfeito().equals("SWIFT EFFECT")); 
		//para primeira instancia sempre ocorrendo
	}
	
	private double calcType(String type){
		return types.getTypeMult(type, defensor.getTipo1(), defensor.getTipo2());
	}
	
	private double calcSTAB(String type){
		if(type.equals(atacante.getTipo1()) || type.equals(atacante.getTipo2())) return 1.5;
		return 1;
	}
	
	private double multiCalc(String type){
		//double mod = (Math.random()*(0.25) + 0.85) * calcSTAB(type) * calcType(type); //IMPLEMENTAÇÃO REAL
		double mod = (calcSTAB(type) * calcType(type));
		return mod;
	}
	
	private int danoCalc(int power, String type){
		if(defensor.getInvulneravel()){
			System.out.println("Invulneravel");
			return 0;
		}
		else{
			double d = (((2/5) * atacante.getLv() + 2) * power * atacante.getAtk()/defensor.getDef())/50 + 2;
			//System.out.println("d = (((2/5) * "+atacante.getLv()+"+2) * "+power+" * "+atacante.getAtk()+"/"+defensor.getDef()+")/50 + 2");
			//System.out.println("dano == "+d);
			return (int)(d * multiCalc(type) + 10);
		}
	}
	
	private int specialDanoCalc(int power, String type){
		if(defensor.getInvulneravel()){
			System.out.println("Invulneravel");
			return 0;
		}
		else{
			double d = (((2/5) * atacante.getLv() + 2) * power * atacante.getSpc()/defensor.getSpc())/50 + 2;
			return (int)(d * multiCalc(type));
		}
	}

	public void action(int a){
		Ataque hab = atacante.getAtkPool().getAtaquesAtuais()[a];
		int rand, dano = danoCalc(hab.getDano(),hab.getTipo());
		/*if(defensor.getLeechSeed()){                                   //IMPLEMENTAÇÕES OUTROS ATAQUES
			defensor.takeDamage(danoCalc(10, "GRASS"));
			atacante.heal(danoCalc(10, "GRASS"));
			System.out.println("levou leech seed");
		}
		if(atacante.chargeEffect()) hab = atacante.getChargeEffect();
		if(defensor.getBindDur() > 0){
			danoCalc(defensor.getHabBind().getDano(), defensor.getHabBind().getTipo());
			defensor.removeBind(1);
		}
		if(defensor.getThrashPetal() > 0){
			danoCalc(atacante.getHabThrashPetal().getDano(), atacante.getHabThrashPetal().getTipo());
			atacante.removeThrashPetal(1);
		}
		if(atacante.getRecharge()){
			System.out.println("Ta em recharge");
			atacante.removeRecharge();
			return;
		}*/
		hab.usePP();
		if(calcPrecisao(hab)){
			
			switch(hab.getEfeito()){
			case "NO ADDITIONAL EFFECT":
				defensor.takeDamage(dano);
				System.out.println("O POKEMON RECEBEU " + dano + " DE DANO");
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
			case "PARALYZE SIDE EFFECT1": //line 10
				defensor.takeDamage(dano);
				rand = (int)(Math.random() * 10) +1;
				if(rand == 10){
					defensor.addEffect("FREEZE");
					System.out.println("CONGELADO");
				}
				break;
			case "OHKO EFFECT": //13
				defensor.takeDamage(defensor.getCurHp() + 1);
				System.out.println("OHKO!");
				break;
			case "CHARGE EFFECT":
				if(!(atacante.chargeEffect())){
					atacante.addChargeEffect(hab);
					atacante.getAtkPool().getAtaqueAtualX(a).restorePP(1);
				System.out.println("AGUARDE O ATAQUE CARREGAR");
				}
				else{
					atacante.removeChargeEffect();
					if(calcPrecisao(hab)){
						defensor.takeDamage(dano);
					}
					else System.out.println("FALHOU...");
				}
				break;
			case "ATTACK UP2 EFFECT":
				defensor.takeDamage(dano);
				atacante.getStatsVol().addAtk((int)(atacante.calcStatusAdd("ATTACK")));
				atacante.getStatsVol().addAtk((int)(atacante.calcStatusAdd("ATTACK")));
				break;
			case "SWITCH AND TELEPORT EFFECT":  //APENAS FUNCIONA EM WILD POKEMON
				System.out.println("NADA ACONTECEU...");
				break;
			case "FLY EFFECT":
				if(!(atacante.chargeEffect())){
					atacante.addChargeEffect(hab);
					atacante.addInvulneravel();
					atacante.getAtkPool().getAtaqueAtualX(a).restorePP(1);
					System.out.println("O POKEMON ESTÁ VOANDO");
				}
				else{
					atacante.removeChargeEffect();
					atacante.removeInvulneravel();
					if(calcPrecisao(hab)){
						defensor.takeDamage(dano);
					}
					else System.out.println("ERROU...");
				}
				break;
			case "TRAPPING EFFECT":
				defensor.addBind(hab, bindCalc());
				defensor.takeDamage(dano);
				defensor.removeBind(1);
				break;
			case "FLINCH SIDE EFFECT2":
				defensor.takeDamage(dano);
				if(probEffect(30)) defensor.addFlinch();
				break;
			case "ATTACK TWICE EFFECT":
				defensor.takeDamage(dano);
				defensor.takeDamage(dano);
				break;
			case "JUMP KICK EFFECT":
				if(probEffect(95)) defensor.takeDamage(dano);
				else atacante.takeDamage(dano/8);
				break;
			case "ACCURACY DOWN1 EFFECT":
				defensor.takeDamage(dano);
				defensor.getStatsVol().addAccuracy(defensor.calcStatusSub("ACCURACY"));
				break;
			case "RECOIL EFFECT":
				defensor.takeDamage(dano);
				atacante.takeDamage(dano/4);
				break;
			case "THRASH PETAL DANCE EFFECT":
				atacante.addThrashPetal(hab, thrashPetalCalc());
				defensor.takeDamage(dano);
				defensor.removeBind(1);
				break;
			case "DEFENSE DOWN1":
				defensor.takeDamage(dano);
				defensor.getStatsVol().addDef((int)(defensor.calcStatusSub("DEFENSE")));
				break;
			case "POISON SIDE EFFECT1":
				defensor.takeDamage(dano);
				defensor.addEffect("POISON");
				break;
			case "TWINEEDLE EFFECT":
				defensor.takeDamage(dano);
				defensor.takeDamage(dano);
				if(probEffect(20)){
					System.out.println("Deu poison");
					defensor.addEffect("POISON");
				}
				break;
			case "FLINCH SIDE EFFECT1":
				defensor.takeDamage(dano);
				if(probEffect(10)){
					defensor.addFlinch();
					System.out.println("Deu flinch");
				}
				break;
			case "ATTACK DOWN1 EFFECT":
				defensor.takeDamage(dano);
				defensor.getStatsVol().addAtk((int)(defensor.calcStatusSub("ATTACK")));
				System.out.println("Perdeu ad");
				break;
			case "SLEEP EFFECT":
				defensor.takeDamage(dano);
				defensor.addEffect("SLEEP");
				System.out.println("TA DORMINDO");
				break;
			case "CONFUSION EFFECT":
				defensor.takeDamage(dano);
				defensor.addEffect("CONFUSE");
				System.out.println("Ta confuso");
				break;
			case "SPECIAL DAMAGE EFFECT":
				defensor.takeDamage(specialDanoCalc(hab.getDano(), hab.getTipo()));
				defensor.addLightScreen();
				break;
			case "DISABLE":  //IMPLEMENTAR IMPEDIR USO NA INTERFACE
				if(defensor.getDisable() < 1){
					defensor.addDisable(defensor.getAtkPool().getAtaqueAtualX((int)(Math.random()*5)),(int)(Math.random()*7));
					System.out.println("Move "+defensor.getHabDisable().getNome()+" disabled for "+defensor.getDisable()+" turnos");
				}
				else System.out.println("Nao pode dois disable");
				break;
			case "DEFENSE DOWN SIDE EFFECT":
				defensor.takeDamage(dano);
				if(probEffect(35)){
					defensor.getStatsVol().addDef((int)(atacante.calcStatusSub("DEFENSE")));
					System.out.println("atacante perdeu defesa");
				}
				break;
			case "BURN SIDE EFFECT1":
				defensor.takeDamage(dano);
				if(probEffect(10)){
					defensor.addEffect("BURN");
					System.out.println("defensor levou burn");
				}
				break;
			case "MIST EFFECT": //falta implementar
				System.out.println("Atacante nao perde mais status");
				break;
			case "FREEZE SIDE EFFECT":
				defensor.takeDamage(dano);
				if(probEffect(10)){
					defensor.addEffect("FREEZE");
					System.out.println("levou freeze");
				}
				break;
			case "CONFUSION SIDE EFFECT":
				defensor.takeDamage(dano);
				if(probEffect(10)){
					defensor.addEffect("CONFUSE");
					System.out.println("defensor levou confuse");
				}
				break;
			case "SPEED DOWN SIDE EFFECT":
				defensor.takeDamage(dano);
				if(probEffect(35)){
					defensor.getStatsVol().addSpd((int)(defensor.calcStatusSub("SPEED")));
					System.out.println("defensor levou slow");
				}
				break;
			case "HYPER BEAM EFFECT":
				defensor.takeDamage(dano);
				atacante.addRecharge();
				break;
			case "DRAIN HP EFFECT":
				defensor.takeDamage(dano);
				atacante.heal((int)(dano/2));
				break;
			case "LEECH SEED EFFECT": //demoradissimo de implementar direito
				defensor.addLeechSeed();
				System.out.println("ta com leech seed");
				break;
			case "SPECIAL UP1 EFFECT":
				defensor.takeDamage(dano);
				atacante.getStatsVol().addSpc((int)(atacante.calcStatusAdd("SPECIAL")));
				System.out.println("GANHOU SPECIAL");
				break;
			case "POISON EFFECT":
				defensor.takeDamage(dano);
				defensor.addEffect("POISON");
				System.out.println("defensor levou poison");
				break;
			case "PARALYZE EFFECT":
				defensor.takeDamage(dano);
				defensor.addEffect("PARALYZE");
				System.out.println("defensor levou paralyze");
				break;
			case "SPEED DOWN1 EFFECT":
				defensor.takeDamage(dano);
				defensor.getStatsVol().addSpd((int)(defensor.calcStatusSub("SPEED")));
				System.out.println("Levou slow");
				break;
			case "SPECIAL DOWN SIDE EFFECT":
				defensor.takeDamage(dano);
				if(probEffect(35)){
					defensor.getStatsVol().addSpc((int)(defensor.calcStatusSub("SPECIAL")));
					System.out.println("defensor perdeu special");
				}
				break;
			case "ATTACK UP1 EFFECT":
				defensor.takeDamage(dano);
				atacante.getStatsVol().addAtk((int)(atacante.calcStatusAdd("ATTACK")));
				System.out.println("atacante ganhou ataque");
				break;
			case "SPEED UP2 EFFECT":
				defensor.takeDamage(dano);
				atacante.getStatsVol().addSpd((int)(atacante.calcStatusAdd("SPEED")));
				atacante.getStatsVol().addSpd((int)(atacante.calcStatusAdd("SPEED")));
				System.out.println("Atacante ganhou 2 bonus attack");
				break;
			case "RAGE EFFECT": //dificil pra porra de implementar, deixamos mais simples por enquanto
				defensor.takeDamage(2*dano);
				break;
			case "MIMIC EFFECT": //demorado pra porra de implementar, vamos simplificar
				defensor.takeDamage(2*danoCalc((int)(Math.random()*100),"NORMAL"));
				break;
			case "DEFENSE DOWN2":
				defensor.takeDamage(dano);
				defensor.getStatsVol().addDef((int)(defensor.calcStatusSub("DEFENSE")));
				defensor.getStatsVol().addDef((int)(defensor.calcStatusSub("DEFENSE")));
				System.out.println("defensor perdeu defesa 2x");
				break;
			case "EVASION UP1 EFFECT":
				defensor.takeDamage(dano);
				atacante.getStatsVol().addEvasion((int)(atacante.calcStatusAdd("EVASION")));
				System.out.println("Aumentou evasion do atacante");
				break;
			case "HEAL EFFECT":
				atacante.heal(atacante.getStatsSol().getHp()/2);
				System.out.println("usou heal");
				break;
			case "DEFENSE UP1 EFFECT":
				defensor.takeDamage(dano);
				atacante.getStatsVol().addDef((int)(atacante.calcStatusAdd("DEFENSE")));
				System.out.println("atacante ganhou defesa");
				break;
			case "DEFENSE UP2 EFFECT":
				defensor.takeDamage(dano);
				atacante.getStatsVol().addDef((int)(atacante.calcStatusAdd("DEFENSE")));
				atacante.getStatsVol().addDef((int)(atacante.calcStatusAdd("DEFENSE")));
				System.out.println("atacante ganhou armor 2x");
				break;
			case "LIGHT SCREEN EFFECT":
				if(atacante.getLightScreen()){
					atacante.getStatsVol().addSpc(atacante.getStatsVol().getSpc());
					atacante.removeLightScreen();
					System.out.println("Atacante DOBROU special");
				}
				else System.out.println("nao fez nada");
				break;
			case "HAZE EFFECT":
				atacante.removeEffect("ALL");
				defensor.removeEffect("ALL");
				atacante.resetStats();
				defensor.resetStats();
				System.out.println("resetou stats de ambos");
				break;
			case "REFLECT EFFECT": //falta implementar quando dobrar a defesa
				atacante.getStatsVol().addDef(atacante.getStatsVol().getSpc());
				System.out.println("dobrou defesa hurr");
				break;
			case "FOCUS ENERGY EFFECT": //falta implementar critico
				System.out.println("atacante dobrou a chance de crit");
				break;
			case "BIDE EFFECT": //RIDICULAMENTE demorado de implementar
				System.out.println("Ta bidando, pode confiar");
				break;
			case "METRONOME EFFECT": //ta dando dano aleatorio por enquanto
				defensor.takeDamage(danoCalc((int)(Math.random()*150), "NORMAL"));
				break;
			case "MIRROR  EFFECT": //idem do de cima
				defensor.takeDamage(danoCalc((int)(Math.random()*150), "NORMAL"));
				break;
			case "EXPLODE EFFECT":
				defensor.takeDamage(dano);
				atacante.takeDamage(atacante.getStatsSol().getHp());
				System.out.println("se matou");
			case "PARALYZE SIDE EFFECT2":
				defensor.takeDamage(dano);
				if(probEffect(30)){
					defensor.addEffect("PARALYZE");
					System.out.println("defensor paralizou");
				}
				break;
			case "POISON SIDE EFFECT2":
				defensor.takeDamage(dano);
				if(probEffect(40)){
					defensor.addEffect("POISON");
					System.out.println("defensor levou poison");
				}
				break;
			case "BURN SIDE EFFECT2":
				defensor.takeDamage(dano);
				if(probEffect(31)){
					defensor.addEffect("BURN");
					System.out.println("defensor levou burn");
				}
				break;
			case "SWIFT EFFECT": //falta implementar o dano em invulneravel
				defensor.takeDamage(dano);
				break;
			case "SPECIAL UP2 EFFECT":
				atacante.getStatsVol().addSpc((int)(atacante.calcStatusAdd("SPECIAL")));
				atacante.getStatsVol().addSpc((int)(atacante.calcStatusAdd("SPECIAL")));
				System.out.println("aumentou special 2x");
				break;
			case "DREAM EATER EFFECT":
				if(defensor.getEffect()[4] == true){
					defensor.takeDamage(dano);
					atacante.heal((int)(dano/2));
				}
				else System.out.println("target precisa estar dormindo, senao nao faz nada");
				break;
			case "TRANSFORM EFFECT": //falta implementar 
				System.out.println("se transformou em uma linda borboleta");
				break;
			case "SPLASH EFFECT":
				System.out.println("seu peixe fez um splash");
				break;
			case "CONVERSION EFFECT": 
				System.out.println("se transorma no megazord");
				break;
			case "SUPER FANG EFFECT":
				defensor.takeDamage(defensor.getStatsVol().getHp()/2);
				break;
			case "SUBSTITUTE EFFECT": 
				break;
			default:
				System.out.println("Tcharam aconteceu algo, descubra o que");			
			}
		}
		else System.out.println("ERROU...");
		
	}
	public String description(){
		return "usa uma habilidade do pokemon para causar dano ou causar efeito de status";
	}
	
	
	//Construtor
	public Atacar(PkmPool pool1, PkmPool pool2, Type types){
		super(pool1);
		atacante=pool1.getPokemon(0);
		defensor=pool2.getPokemon(0);
		this.types=types;
	}

}
