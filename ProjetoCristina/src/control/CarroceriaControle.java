package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import entity.Carroceria;

public class CarroceriaControle extends Carroceria implements CRUD{

	public void InstanciarCarroceriaControle(String nome){
		setNome(nome);
		setAltura(nome);
		setLargura(nome);
		setComprimento(nome);
		setPeso(nome);
		setVolume();
	}
	
	public void gravar() throws IOException{
		String fileName = "Motoristas.txt";
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));

			bw.write(getNome());
			bw.write(";");
			bw.write(Integer.toString(getPeso()));
			bw.write(";");
			bw.write(Double.toString(getAltura()));
			bw.write(";");
			bw.write(Double.toString(getLargura()));
			bw.write(";");
			bw.write(Double.toString(getComprimento()));
			bw.write(";");
			bw.write(Double.toString(getVolume()));
			bw.write(";");
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
		String fileName = "Motoristas.txt";
		BufferedReader ler = new BufferedReader(new FileReader(fileName));
		
		while(ler.ready()){
			String [] motorista = ler.readLine().split(";");
			cta ++;
		}
		
		ler.close();
		
		return cta * 17;
	}
}
