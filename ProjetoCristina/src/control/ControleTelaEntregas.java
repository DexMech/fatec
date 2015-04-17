package control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JOptionPane;

import boundary.TelaEntrega;

public class ControleTelaEntregas {
	
	// le arquivo com dados do cliente
	public void leCliente(){
		
		try {
			Scanner entrada = new Scanner(new FileReader("\\Bibliotecas\\Documentos\\TesteCliente"));
			while(entrada.hasNext()){
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado", null, JOptionPane.ERROR_MESSAGE, null);
		}
		
	}

}
