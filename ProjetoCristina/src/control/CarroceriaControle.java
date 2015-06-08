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

public class CarroceriaControle implements CRUD{

	public Carroceria c = new Carroceria();
	
	public void InstanciarCarroceriaControle(String nome){
		c.setNome(nome);
		c.setAltura(nome);
		c.setLargura(nome);
		c.setComprimento(nome);
		c.setPeso(nome);
		c.setVolume();
	}
	
	public void gravar(String fileName) throws IOException{
		
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));

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

	@Override
	public void deletar(String nome) throws IOException {
		//sem função até pensarmos em algo melhor...
	}

	@Override
	public void atualizar(String nome) throws IOException {
		
	}

	@Override
	public int ler() throws IOException{
		int cta = 0;
		String fileName = "src/BD/Motoristas.txt";
		BufferedReader ler = new BufferedReader(new FileReader(fileName));
		
		while(ler.ready()){
			String [] motorista = ler.readLine().split(";");
			cta ++;
		}
		
		ler.close();
		
		return cta * 17;
	}
}
