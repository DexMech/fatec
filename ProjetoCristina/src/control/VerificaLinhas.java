package control;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class VerificaLinhas {
	public int verifica(String caminho){
		
		
		
		
	int num = 1;
	
	
	Scanner in;
	try {
		in = new Scanner(new FileReader(caminho));
		while (in.hasNextLine()) {
num++;
		    String line = in.nextLine();
		
		}
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	
	
	return num;
	
}
}
