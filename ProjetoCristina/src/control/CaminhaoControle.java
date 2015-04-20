package control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import entity.Caminhao;

public class CaminhaoControle extends Caminhao implements CRUD{

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
			bw.write(";");
			bw.write(Integer.toString(getCapacidadeCarga()));
			bw.write(";");
			bw.write(getNumeroPlaca());
			bw.write(";");
			bw.write(getCidade());
			bw.write(";");
			bw.write(getEstado());
			bw.write(";");
			bw.close();
		} catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

	public void atualizar(String nome) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void ler() throws IOException {
		// TODO Auto-generated method stub
	}

	@Override
	public void deletar(String nome) throws IOException {
		// TODO Auto-generated method stub
		
	}
}
