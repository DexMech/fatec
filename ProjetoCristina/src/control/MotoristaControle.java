package control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import entity.Motorista;

public class MotoristaControle extends Motorista {

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
			bw.newLine();
			bw.write(getCnh());
			bw.newLine();
			bw.write(getValidadeInicio());
			bw.newLine();
			bw.write(getValidadeFim());
			bw.newLine();
			bw.write(getTelefone1());
			bw.newLine();
			bw.write(getTelefone2());
			bw.newLine();
			bw.close();
			JOptionPane.showMessageDialog(null, "Grava��o conclu�da com sucesso.", "Sucesso",  JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro de grava��o. Tente novamente mais tarde.", "ERRO",  JOptionPane.ERROR_MESSAGE);
		}
	
	}
}