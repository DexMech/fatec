package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import entity.Motorista;

public class MotoristaControle extends Motorista implements CRUD{

	public void InstanciarMotoristaControle(String nome, String cnh, String validade, String telefone1, String telefone2, String rg, String cpf){
		setNome(nome);
		setCnh(cnh);
		setValidade(validade);
		setTelefone1(telefone1);
		setTelefone2(telefone2);
		setRg(rg);
		setCpf(cpf);
	}
	
	public void gravar() throws IOException{
		String fileName = "src/BD/Motoristas.txt";
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
			
			bw.write(getNome());
			bw.write(";");
			bw.write(getRg());
			bw.write(";");
			bw.write(getCpf());
			bw.write(";");
			bw.write(getCnh());
			bw.write(";");
			bw.write(getValidade());
			bw.write(";");
			bw.write(getTelefone1());
			bw.write(";");
			bw.write(getTelefone2());
			bw.write(";");
			bw.close();
			JOptionPane.showMessageDialog(null, "Gravação concluída com sucesso.", "Sucesso",  JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro de gravação. Tente novamente mais tarde.", "ERRO",  JOptionPane.ERROR_MESSAGE);
		}
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
		
	}

	@Override
	public void atualizar(String nome) throws IOException {
		
	}
}