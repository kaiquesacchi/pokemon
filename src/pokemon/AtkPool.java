package pokemon;

import java.io.IOException;

public class AtkPool {
	//Atributos
	private Ataque[] ataquesAtuais;
	private int[] tmsRecebiveis;
	private int[][] ataquesPorNivel;
	
	//Construtor
	public AtkPool(String nome) throws IOException {
		Ataque[] ataques = CarregaTxt.leitorAtaque("txt/moves.txt");
		ataquesAtuais = CarregaTxt.leitorAtksBase("txt/baseStats/", nome, ataques);
		tmsRecebiveis= CarregaTxt.leitorTmsRecebiveis("txt/baseStats/", nome);
	}
	public void printAtaques(){
		System.out.println(ataquesAtuais[0].getNome());
	}
}
