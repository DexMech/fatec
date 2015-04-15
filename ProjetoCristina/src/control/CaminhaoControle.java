package control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import entity.Caminhao;

public class CaminhaoControle extends Caminhao{

	public void InstanciarCaminhaoControle(String tipoCaminhao, String numeroPlaca, String cidade, String estado){
		setTipoCaminhao(tipoCaminhao);
		setCapacidadeCarga(tipoCaminhao);
		setNumeroPlaca(numeroPlaca);
		setCidade(cidade);
		setEstado(estado);
	}
	
	public void gravar() throws IOException{
		String fileName = "Motoristas.txt";
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
			bw.write(getTipoCaminhao());
			bw.newLine();
			bw.write(Integer.toString(getCapacidadeCarga()));
			bw.newLine();
			bw.write(getNumeroPlaca());
			bw.newLine();
			bw.write(getCidade());
			bw.newLine();
			bw.write(getEstado());
			bw.newLine();
			bw.close();
		} catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
}
