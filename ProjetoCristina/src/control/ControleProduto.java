package control;

/**
 * @author Stefanie Lima
 * @version 1.x
 * 
 * <ul><h3>Versões</h3>
 * 		<li>1.0 - Criação da classe</li>
 * 		<li>1.1 - Implementação da interface CRUD</li>
 * 		<li>1.2 - Retirada de extends desnecessário</li>
 * </ul>*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import util.CRUD;
import entity.Produto;

public class ControleProduto implements CRUD{
	
	Produto p = new Produto();
	/**
	 * Metodo para instanciar produto
	 * @param nome
	 * @param fabricante
	 * @param fornecedor
	 * @param descritivo
	 * @param kg
	 * @param metros
	 */
	public void InstanciaProdutoControle(String nome, String fabricante, String fornecedor, String descritivo, float kg, float metros){
		
		p.setNome(nome);
		p.setFabricante(fabricante);
		p.setFornecedor(fornecedor);
		p.setDescritivo(descritivo);
		p.setKg(kg);
		p.setMetros(metros);		
		
	}
	/**
	 * Metodo para gravação
	 */
	public void gravar(String fileName) {
				
		try{
			BufferedWriter write = new BufferedWriter(new FileWriter(fileName + ".txt", true));
			write.write(p.getNome());
			write.write(";");
			write.write(p.getFabricante());
			write.write(";");
			write.write(p.getFornecedor());
			write.write(";");
			write.write(p.getDescritivo());
			write.write(";");
			write.write(Float.toString(p.getKg()));
			write.write(";");
			write.write(Float.toString(p.getMetros()));
			write.write(";");
			write.newLine();
			write.close();
			
			JOptionPane.showMessageDialog(null,"Gravação concluida com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			
		}catch(IOException s){
			s.printStackTrace();
			JOptionPane.showMessageDialog(null,"Ocorreu um erro de Gravação, tente novamente mais tarde." , "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Metodo para preenchimento
	 * @param fileName
	 * @param nome
	 * @return
	 * @throws IOException
	 */
	public String[] preencherCb(String fileName, String nome) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName + ".txt"));
		int cta = numeroLinhas(fileName + ".txt");
		String motorista[] = new String[6];
		ListaLigadaNomes lln = new ListaLigadaNomes();
		
		for (int i = 0; i < cta; i ++){
			String temp[] = br.readLine().split(";");
			
			if(temp[0].contains(nome)){
				lln.addInicio(temp[0]);
			}
		}
		
		br.close();
		
		lln.retornoCb();
		
		return lln.items;
	}
	/**
	 * Metodo de leitura
	 */
	public String[] ler(String fileName, String nome) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName + ".txt"));
		int cta = numeroLinhas(fileName + ".txt");
		String motorista[] = new String[6];
		
		for (int i = 0; i < cta; i ++){
			String temp[] = br.readLine().split(";");
			
			if(temp[0].equals(nome)){
				motorista = temp;
			}
		}
		
		br.close();
		
		return motorista;
	}

	@Override
	public void deletar(String nome, String fileName) throws IOException {
		BufferedWriter arquivoTemporario = new BufferedWriter(new FileWriter(fileName + "2.txt"));
		BufferedReader lerArquivo = new BufferedReader(new FileReader(fileName + ".txt"));
		
		int cta = numeroLinhas(fileName + ".txt");
		
		for (int i = 0; i < cta; i ++){
			String temporario[] = lerArquivo.readLine().split(";");
			
			if (!temporario[0].equals(nome)){
				for (int j = 0; j < 6; j ++){
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
	public void atualizar(String nome, String[] novoConteudo, String fileName) throws IOException {
		BufferedWriter arquivoTemporario = new BufferedWriter(new FileWriter(fileName + "2.txt"));
		BufferedReader lerArquivo = new BufferedReader(new FileReader(fileName + ".txt"));
		int cta = numeroLinhas(fileName + ".txt");
		
		for (int i = 0; i < cta; i ++){
			String temporario[] = lerArquivo.readLine().split(";");
			
			if (temporario[0].equals(nome)){
				for (int j = 0; j < 6; j ++){
					arquivoTemporario.write(novoConteudo[j]);
					arquivoTemporario.write(";");
				}
				arquivoTemporario.newLine();
			} else {
				for (int j = 0; j < 6; j ++){
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
