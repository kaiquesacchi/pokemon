package pokemon;

public class AtkPool {
	//Atributos
	private Ataque[] ataques;
	
	//Métodos
	public Ataque[] getAtaques(){
		return ataques;
	}
	
	//Construtor
	public AtkPool(Ataque[] ataques){
		this.ataques = ataques;
	}
}
