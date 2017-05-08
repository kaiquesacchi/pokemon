package pokemon;

public class Atacar extends Event{
	//Atributos
	private PkmPool pool2;
	private Pokemon atacante;
	private Pokemon defensor;
	
	//Métodos
	public void action(int a){
		//String hab = atacante.
		
		
	}
	public String description(){
		return "usa uma habilidade";
	}
	
	
	//Construtor
	public Atacar(PkmPool pool1, PkmPool pool2){
		super(pool1);
		atacante=pool1.getPokemonX(1);
		defensor=pool2.getPokemonX(1);
	}

}
