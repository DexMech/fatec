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
 *  Classe criada para controlar os caminhões.*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import entity.Caminhao;

public class CaminhaoControle implements CRUD{

	public Caminhao c = new Caminhao();
	
	public void InstanciarCaminhaoControle(String tipoCaminhao, String numeroPlaca, String cidade, String estado){
		c.setTipoCaminhao(tipoCaminhao);
		c.setCapacidadeCarga(tipoCaminhao);
		c.setNumeroPlaca(numeroPlaca);
		c.setCidade(cidade);
		c.setEstado(estado);
	}
	
	public void gravar(String fileName) throws IOException{
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
			bw.write(c.getTipoCaminhao());
			bw.write(";");
			bw.write(Integer.toString(c.getCapacidadeCarga()));
			bw.write(";");
			bw.write(c.getNumeroPlaca());
			bw.write(";");
			bw.write(c.getCidade());
			bw.write(";");
			bw.write(c.getEstado());
			bw.write(";");
			bw.close();
		} catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

	public void atualizar(String nome) throws IOException {
		
	}

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
	@Override
	public void deletar(String nome) throws IOException {
		//sem função até pensarmos em algo melhor...
	}
}
