package pokemon;

public class Type {
	//Atributos
	private String[] colMatriz;
	private String[][] typeChart;
	//Metodos
	public double getTypeMult(String typeA, String type1, String type2){
		int a=0,b=0,c=0;
		while(!(typeA.equals(colMatriz[a]))){
			a++;
			if(a>17){
				throw new IllegalArgumentException("Invalid Type: " + typeA);
			}
		}
		while(!(type1.equals(colMatriz[b]))){
			b++;
			if(b>17){
				throw new IllegalArgumentException("Invalid Type: " + type1);
			}
		}
		if((type2!=null)){
			System.out.println("HERE"+type2);
			while(!(type2.equals(colMatriz[c]))){
				c++;
				if(c>17){
					throw new IllegalArgumentException("Invalid Type: " + type2);
				}
			}
		}
		else return Double.parseDouble(typeChart[a][b+1]);
		return Double.parseDouble(typeChart[a][b+1])*Double.parseDouble(typeChart[a][c+1]);
	}
	
	
	public void printTypeChart(){
		for(int a=0;a<18;a++) System.out.print(colMatriz[a]+",");
		System.out.println();
		for(int i=0;i<18;i++){
			for(int j=0;j<19;j++){
				System.out.print(typeChart[i][j]);
				if(j!=18) System.out.print(",");
			}
			System.out.println();
		}
	}
	
	
	//Construtor
	public Type(String[] colMatriz, String[][] typeChart){
		this.colMatriz=colMatriz;
		this.typeChart=typeChart;
	}

}
