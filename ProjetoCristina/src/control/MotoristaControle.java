package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import entity.Motorista;

public class MotoristaControle extends Motorista implements CRUD{

	public void InstanciarMotoristaControle(String nome, String cnh, String validadeInicio, String validadeFim, String telefone1, String telefone2){
		setNome(nome);
		setCnh(cnh);
		setValidadeInicio(validadeInicio);
		setValidadeFim(validadeFim);
		setTelefone1(telefone1);
		setTelefone2(telefone2);
	}
	
	public void gravar() throws IOException{
		String fileName = "Motoristas.txt";
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
			bw.write(getNome());
			bw.write(";");
			bw.write(getCnh());
			bw.write(";");
			bw.write(getValidadeInicio());
			bw.write(";");
			bw.write(getValidadeFim());
			bw.write(";");
			bw.write(getTelefone1());
			bw.write(";");
			bw.write(getTelefone2());
			bw.write(";");
			bw.close();
			JOptionPane.showMessageDialog(null, "Grava��o conclu�da com sucesso.", "Sucesso",  JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro de grava��o. Tente novamente mais tarde.", "ERRO",  JOptionPane.ERROR_MESSAGE);
		}
	}
	
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

	@Override
	public void deletar(String nome) throws IOException {
		String [] motorista = new String[ler()];
		String fileName = "Motoristas.txt";
		int index = 0;
		BufferedReader ler = new BufferedReader(new FileReader(fileName));
		BufferedWriter escreve = new BufferedWriter(new FileWriter(fileName));
		
		while (ler.ready()){
			motorista = ler.readLine().split(";");
		}
		
		ler.close();
		
		for (int j = 0; j < motorista.length; j ++){
			if (nome.equals(motorista[j])){
				index = j;
			}
		}
		
		for (int j = index; j < motorista.length; j ++){
			motorista[j] = motorista[j+17];
		}
		
		for (int j = 0; j < motorista.length - 17; j ++){
			escreve.write(motorista[j]);
			escreve.write(";");
		}
		
		escreve.close();
	}

	@Override
	public void atualizar(String nome) throws IOException {
		String [] motorista = new String[ler()];
		String fileName = "Motoristas.txt";
		int index = 0;
		BufferedReader ler = new BufferedReader(new FileReader(fileName));
		BufferedWriter escreve = new BufferedWriter(new FileWriter(fileName));
		
		while (ler.ready()){
			motorista = ler.readLine().split(";");
		}
		
		ler.close();
		
		for (int j = 0; j < motorista.length; j ++){
			if (nome.equals(motorista[j])){
				index = j;
			}
		}
		
		motorista[index] = getNome();
		motorista[index + 1] = getCnh();
		motorista[index + 2] = getValidadeInicio();
		motorista[index + 3] = getValidadeFim();
		motorista[index + 4] = getTelefone1();
		motorista[index + 5] = getTelefone2();
		
		for (int j = 0; j < motorista.length; j ++){
			escreve.write(motorista[j]);
			escreve.write(";");
		}
		
		escreve.close();
	}
}