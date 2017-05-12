package pokemon;

import java.io.IOException;

public class AtkPool {
	//Atributos
	private Ataque[] ataquesAtuais;
	private int[] tmsRecebiveis;
	private String[][] ataquesPorNivel;
	
	//Métodos
	public Ataque[] getAtaquesAtuais(){
		return ataquesAtuais;
	}
	public Ataque getAtaqueAtualX(int x){
		return ataquesAtuais[x];
	}
	public int[] getTmsRecebiveis(){
		return tmsRecebiveis;
	}
	public String getAtaquePorNivel(int lv){
		int i = 0;
		while(lv != Integer.parseInt(ataquesPorNivel[i][0])){
			if(i>100) return null;
			i++;
		}
			return ataquesPorNivel[i][1];
	}
	
	
	//Construtor
	public AtkPool(String nome) throws IOException {
		Ataque[] ataques = CarregaTxt.leitorAtaque("txt/moves.txt");
		ataquesAtuais = CarregaTxt.leitorAtksBase("txt/baseStats/", nome, ataques);
		tmsRecebiveis= CarregaTxt.leitorTmsRecebiveis("txt/baseStats/", nome);
		ataquesPorNivel = CarregaTxt.leitorLearnSet("txt/evos_learnSet.txt", nome, ataques);
	}
	public void printAll(){
		int i = 0;
		System.out.println("--------Ataques Atuais --------");
		while (i<4 && ataquesAtuais[i] != null) System.out.print(ataquesAtuais[i++].getNome() + ",");
		System.out.println("\n------tms Recebiveis-------");
		for(i = 0; i < this.tmsRecebiveis.length; i++)System.out.print(tmsRecebiveis[i] + ",");
		System.out.println("\n-------Ataques Por Nivel-------");
		i = 0;
		while(ataquesPorNivel[i][0] != null) System.out.println(ataquesPorNivel[i][0] + " - " + ataquesPorNivel[i++][1]);
	}
}
