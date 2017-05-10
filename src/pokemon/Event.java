package pokemon;

	abstract public class Event {
	//Atributos
	protected PkmPool pool1;
	//Métodos
	//abstract public void action();
	abstract public String description();
	//Construtor
	public Event(PkmPool pool1){
		this.pool1=pool1;
	}

}
