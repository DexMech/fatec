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
		String [] motorista = ler();
		String fileName = "Motoristas.txt";
		int i = 0;
		int index = 0;
		BufferedReader ler = new BufferedReader(new FileReader(fileName));
		BufferedWriter escreve = new BufferedWriter(new FileWriter(fileName));
		
		while (ler.ready()){
			String [] contador = ler.readLine().split(";");
			i ++;
		}
		
		ler.close();
		
		i *= 17;
		
		for (int j = 0; j < i; j ++){
			if (nome.equals(motorista[j])){
				index = j;
			}
		}
		
		motorista[index + 11] = getNome();
		motorista[index + 12] = Double.toString(getAltura());
		motorista[index + 13] = Double.toString(getLargura());
		motorista[index + 14] = Double.toString(getComprimento());
		motorista[index + 15] = Double.toString(getPeso());
		motorista[index + 16] = Double.toString(getVolume());
		
		for (int j = 0; j < i; j ++){
			escreve.write(motorista[j]);
			escreve.write(";");
		}
		
		escreve.close();
	}

	@Override
	public String[] ler() throws IOException{
		String [] motorista = null;
		String fileName = "Motoristas.txt";
		BufferedReader ler = new BufferedReader(new FileReader(fileName));
		
		while(ler.ready()){
			motorista = ler.readLine().split(";");
		}
		
		ler.close();
		
		return motorista;
	}
}
