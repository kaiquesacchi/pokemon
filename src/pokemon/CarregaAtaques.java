package pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CarregaAtaques {
	
	public static Ataque[] leitor(String path) throws IOException {
    	Ataque[] ataques = new Ataque[165];
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = buffRead.readLine();
        int i=0;
        while (true) {
            if (linha != null) {
                String[] aux = linha.split(",");
                ataques[i] = new Ataque(aux[0], aux[3], Integer.parseInt(aux[2]), Integer.parseInt(aux[4]), Integer.parseInt(aux[5]), aux[1]);
            }
            else break;
	        linha = buffRead.readLine();
	        i++;
	    }
	    buffRead.close();
	    System.out.println("[CarregaAtaques] Ataques gerados com sucesso");
	    return ataques;
	}

}
