package control;

/**
 * @author Tiago Lucas
 * @version 1.2
 * 
 * <ul><h3>Versões</h3>
 * 		<li>1.0 - Criação da classe.</li>
 * 		<li>1.1 - Implementação da interface CRUD</li>
 * 		<li>1.2 - Retirada de extends desnecessário</li>
 * </ul>
 * 
 * Classe que grava informações do cliente*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import util.CRUD;
import util.Geolocalizacao;
import entity.Cliente;

public class ControleCliente implements CRUD{

	Cliente c = new Cliente();
	
	public void InstanciarCliente(String nome, String endereco, int numero, String telefone, String celular, String bairro, String cep, String indentificacao, String diasDaSemana){
		c.setNome(nome);
		c.setEndereco(endereco);
		c.setNumero(numero);
		c.setTelefone(telefone);
		c.setCelular(celular);
		c.setBairro(bairro);
		c.setCep(cep);
		c.setIdentificacao(indentificacao);		
		c.setDiasDaSemana(diasDaSemana);
		
	}
	
	/**
	 * Método de gravação no txt. O caminho é um package feito para acumular os
	 * resources gerados pelo programa juntamente ao nome do arquivo.*/
	public void gravar(String fileName){
		
		try{
			BufferedWriter escrever = new BufferedWriter(new FileWriter(fileName + ".txt", true));
			Geolocalizacao geo = new Geolocalizacao();
			
			String distancia = geo.pesquisa("03821-020", c.getCep());
			
			escrever.write(Double.toString(tratamentoLocalizacao(distancia)));
			escrever.write(";");
			escrever.write(c.getNome());
			escrever.write(";");
			escrever.write(c.getEndereco()+","+c.getNumero()+","+c.getBairro());
			escrever.write(";");
			escrever.write(c.getTelefone());
			escrever.write(";");
			escrever.write(c.getCelular());
			escrever.write(";");
			escrever.write(c.getCep());
			escrever.write(";");
			escrever.write(c.getIdentificacao());
			escrever.write(";");
			escrever.write(c.getDiasDaSemana());
			escrever.newLine();
			escrever.close();
			
			JOptionPane.showMessageDialog(null,"Gravação concluida com sucesso." , "Sucesso" , JOptionPane.INFORMATION_MESSAGE);
		}catch(IOException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Ocorreu um erro de gravação. Tente novamente mais tarde." , "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public double tratamentoLocalizacao(String distancia){
	
		distancia = distancia.replace("km", "");
		distancia = distancia.trim();
		distancia = distancia.replace(",", ".");
		
		return Double.parseDouble(distancia);
	}

	@Override
	public void deletar(String cpf, String fileName) throws IOException {
		BufferedWriter arquivoTemporario = new BufferedWriter(new FileWriter(fileName + "2.txt"));
		BufferedReader lerArquivo = new BufferedReader(new FileReader(fileName + ".txt"));
		
		int cta = numeroLinhas(fileName + ".txt");
		
		for (int i = 0; i < cta; i ++){
			String temporario[] = lerArquivo.readLine().split(";");
			
			if (!temporario[6].equals(cpf)){
				for (int j = 0; j < 14; j ++){
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
			
			if (temporario[6].equals(cpf)){
				for (int j = 0; j < 14; j ++){
					arquivoTemporario.write(novoConteudo[j]);
					arquivoTemporario.write(";");
				}
				arquivoTemporario.newLine();
			} else {
				for (int j = 0; j < 14; j ++){
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

	@Override
	public String[] ler(String fileName, String cpf) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName + ".txt"));
		int cta = numeroLinhas(fileName + ".txt");
		String motorista[] = new String[14];
	
		for (int i = 0; i < cta; i ++){
			String temp[] = br.readLine().split(";");
		
			if(temp[6].equals(cpf)){
				motorista = temp;
			}
		}
	
		br.close();
	
		return motorista;
		
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
