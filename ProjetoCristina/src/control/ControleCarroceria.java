package control;

/**
 * @author Arthur Gomes
 * @version 1.2
 * 
 * <ul><h3>Versões</h3>
 * 		<li>1.0 - Criação da classe.</li>
 * 		<li>1.1 - Implementação da interface CRUD</li>
 * 		<li>1.2 - Retirada de extends desnecessário</li>
 * </ul>
 * 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import entity.Carroceria;

public class ControleCarroceria{

	public Carroceria c = new Carroceria();
	/**
	 * Instancia Carroceiria(nome) 
	 * @param nome
	 */
	public void InstanciarCarroceriaControle(String nome){
		c.setNome(nome);
		c.setAltura(nome);
		c.setLargura(nome);
		c.setComprimento(nome);
		c.setPeso(nome);
		c.setVolume();
	}
	/**
	 * Grava informações em arquivo
	 * @param fileName
	 * @throws IOException
	 */
	public void gravar(String fileName) throws IOException{
		
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName + ".txt", true));

			bw.write(c.getNome());
			bw.write(";");
			bw.write(Double.toString(c.getPeso()));
			bw.write(";");
			bw.write(Double.toString(c.getAltura()));
			bw.write(";");
			bw.write(Double.toString(c.getLargura()));
			bw.write(";");
			bw.write(Double.toString(c.getComprimento()));
			bw.write(";");
			bw.write(Double.toString(c.getVolume()));
			bw.write(";");
			bw.newLine();
			bw.close();
		} catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
}
