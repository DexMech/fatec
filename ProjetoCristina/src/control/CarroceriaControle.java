package control;

import java.io.BufferedWriter;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(String nome) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ler() throws IOException {
		// TODO Auto-generated method stub
		
	}
}
