package pokemon;

	abstract public class Event {
	//Atributos
	protected int prioridade;
	//Métodos
	public int getPrioridade(){
		return prioridade;
	}
	abstract public void action();
	abstract public String description();
	abstract public boolean viavel();
	

}
