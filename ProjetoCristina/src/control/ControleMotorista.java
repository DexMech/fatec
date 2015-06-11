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
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import util.CRUD;
import entity.Motorista;

public class ControleMotorista implements CRUD{

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
	public void gravar(String fileName) throws IOException{
		fileName += ".txt";
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
	
	@Override
	public String[] ler(String fileName, String cpf) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName + ".txt"));
		int cta = numeroLinhas(fileName + ".txt");
		String motorista[] = new String[18];
		
		for (int i = 0; i < cta; i ++){
			String temp[] = br.readLine().split(";");
			
			if(temp[2].equals(cpf)){
				motorista = temp;
			}
		}
		
		br.close();
		
		return motorista;
	}

	@Override
	public void deletar(String cpf, String fileName) throws IOException {
		BufferedWriter arquivoTemporario = new BufferedWriter(new FileWriter(fileName + "2.txt"));
		BufferedReader lerArquivo = new BufferedReader(new FileReader(fileName + ".txt"));
		
		int cta = numeroLinhas(fileName + ".txt");
		
		for (int i = 0; i < cta; i ++){
			String temporario[] = lerArquivo.readLine().split(";");
			
			if (!temporario[2].equals(cpf)){
				for (int j = 0; j < 18; j ++){
					arquivoTemporario.write(temporario[j]);
					arquivoTemporario.write(";");
				}
				arquivoTemporario.newLine();
			}
		}
		
		lerArquivo.close();
		arquivoTemporario.close();
		
		merge(fileName);
	}

	@Override
	public void atualizar(String cpf, String[] novoConteudo, String fileName) throws IOException {
		BufferedWriter arquivoTemporario = new BufferedWriter(new FileWriter(fileName + "2.txt"));
		BufferedReader lerArquivo = new BufferedReader(new FileReader(fileName + ".txt"));
		int cta = numeroLinhas(fileName + ".txt");
		
		for (int i = 0; i < cta; i ++){
			String temporario[] = lerArquivo.readLine().split(";");
			
			if (temporario[2].equals(cpf)){
				for (int j = 0; j < 18; j ++){
					arquivoTemporario.write(novoConteudo[j]);
					arquivoTemporario.write(";");
				}
				arquivoTemporario.newLine();
			} else {
				for (int j = 0; j < 18; j ++){
					arquivoTemporario.write(temporario[j]);
					arquivoTemporario.write(";");
				}
				arquivoTemporario.newLine();
			}
		}
		
		lerArquivo.close();
		arquivoTemporario.close();
		
		merge(fileName);
	}
	
	public void merge(String fileName) throws IOException{
		BufferedWriter arquivoFinal = new BufferedWriter(new FileWriter(fileName + ".txt"));
		BufferedReader lerArquivo = new BufferedReader(new FileReader(fileName + "2.txt"));
		int cta = numeroLinhas(fileName + "2.txt");
		String temporario = null;
		
		for (int i = 0; i < cta; i ++){
			temporario = lerArquivo.readLine();
			arquivoFinal.write(temporario);
			arquivoFinal.newLine();
			temporario = null;
		}
		
		arquivoFinal.close();
		lerArquivo.close();
		
		deletarArquivo(fileName + "2.txt");
	}

	public void deletarArquivo(String fileName){
		File f = new File(fileName);
		
		f.delete();
	}
	
	public int numeroLinhas(String fileName) throws IOException {
		BufferedReader counter = new BufferedReader(new FileReader(fileName));
		int cta = 0;
		
		while(counter.ready()){
			String [] motorista = counter.readLine().split(";");
			cta ++;
		}
		
		counter.close();
		
		return cta;
	}
}