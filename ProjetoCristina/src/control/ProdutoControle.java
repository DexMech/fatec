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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import entity.Produto;

public class ProdutoControle implements CRUD{
	
	Produto p = new Produto();
	
	public void InstanciaProdutoControle(String nome, String fabricante, String fornecedor, String descritivo, float kg, float metros){
		
		p.setNome(nome);
		p.setFabricante(fabricante);
		p.setFornecedor(fornecedor);
		p.setDescritivo(descritivo);
		p.setKg(kg);
		p.setMetros(metros);		
		
	}
	
	public void gravar(String fileName) {
				
		try{
			BufferedWriter write = new BufferedWriter(new FileWriter(fileName, true));
			write.write(p.getNome());
			write.write(";");
			write.write(p.getFabricante());
			write.write(";");
			write.write(p.getFornecedor());
			write.write(";");
			write.write(p.getDescritivo().trim());
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
	
	public int numeroLinhas() throws IOException{
		int cta = 0;
		String fileName = "src/BD/Produtos.txt";
		BufferedReader ler = new BufferedReader(new FileReader(fileName));
		
		while(ler.ready()){
			String [] produto = ler.readLine().split(";");
			cta ++;
		}
		
		ler.close();
		
		return cta * 17;
	}

	@Override
	public void deletar(String parametro, String fileName) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(String parametro, String[] novoConteudo,
			String fileName) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] ler(String fileName, String identificador)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
}
