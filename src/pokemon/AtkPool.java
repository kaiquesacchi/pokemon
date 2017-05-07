package pokemon;

import java.io.IOException;

public class AtkPool {
	//Atributos
	private Ataque[] ataquesAtuais;
	private int[] tmsRecebiveis;
	private int[][] ataquesPorNivel;
	
	//Construtor
	public AtkPool(String nome) throws IOException {
		Ataque[] ataques = CarregaTxt.leitorAtaque("moves.txt");
		ataquesAtuais = CarregaTxt.leitorAtksBase("txt/baseStats/", nome, ataques);
		tmsRecebiveis= CarregaTxt.leitorTmsRecebiveis("txt/baseStats", nome);
	}
}
