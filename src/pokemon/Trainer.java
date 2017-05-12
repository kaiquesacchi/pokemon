package pokemon;

public class Trainer {
	//Atributos
	private String nome;
	private PkmPool pool;
	private int gold;
	
	//Metodos
	public String getNome(){
		return nome;
	}
	public PkmPool getPool(){
		return pool;
	}
	public int getGold(){
		return gold;
	}
	//Testes
	public void printPokemons(){
		Pokemon poke = pool.getPokemon(0);
		int a=0;
		while(true){
			poke = pool.getPokemon(a);
			if(poke.equals(null)) break;
			else{
				System.out.println("Poke "+a+":");
				poke.printAll();
			}
			a++;
		}
	}
	public void printTrainer(){
		System.out.println("nome: "+nome);
		System.out.println("Pokemons:");
		printPokemons();
		System.out.println("gold: "+gold);
	}
	
	
	
	//Construtor
	public Trainer(String nome, PkmPool pool, int gold){
		this.nome=nome;
		this.pool=pool;
		this.gold=gold;
	}

}
