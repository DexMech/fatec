package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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
		
		motorista[index + 6] = getTipoCaminhao();
		motorista[index + 7] = Integer.toString(getCapacidadeCarga());
		motorista[index + 8] = getNumeroPlaca();
		motorista[index + 9] = getCidade();
		motorista[index + 10] = getEstado();
		
		for (int j = 0; j < i; j ++){
			escreve.write(motorista[j]);
			escreve.write(";");
		}
		
		escreve.close();
	}

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
	@Override
	public void deletar(String nome) throws IOException {
		// TODO Auto-generated method stub
		
	}
}
