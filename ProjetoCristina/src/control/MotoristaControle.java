package control;

/**
 * @author Arthur Gomes
 * @version 1.2
 * 
 * <ul><h3>Versões: </h3>
 * 		<li>1.0 - Criação da classe.</li>
 * 		<li>1.1 - Implementação da interface CRUD.</li>
 * 		<li>1.2 - Retirada de extends desnecessário.</li>
 * </ul>
 * 
 * Classe responsável por gravar as informações da entidade Motorista.*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import entity.Motorista;

public class MotoristaControle implements CRUD{

	private Motorista m = new Motorista();
	
	public void InstanciarMotoristaControle(String nome, String cnh, String validade, String telefone, String celular, String rg, String cpf){
		m.setNome(nome);
		m.setCnh(cnh);
		m.setValidade(validade);
		m.setTelefone(telefone);
		m.setCelular(celular);
		m.setRg(rg);
		m.setCpf(cpf);
	}
	
	/**
	 * Método de gravação no txt. O caminho é um package feito para acumular os
	 * resources gerados pelo programa.*/
	public void gravar() throws IOException{
		String fileName = "src/BD/Motoristas.txt";
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
			
			bw.write(m.getNome());
			bw.write(";");
			bw.write(m.getRg());
			bw.write(";");
			bw.write(m.getCpf());
			bw.write(";");
			bw.write(m.getCnh());
			bw.write(";");
			bw.write(m.getValidade());
			bw.write(";");
			bw.write(m.getTelefone());
			bw.write(";");
			bw.write(m.getCelular());
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