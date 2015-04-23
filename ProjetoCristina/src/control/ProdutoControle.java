// @author Stefanie

package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import entity.Produto;

public class ProdutoControle extends Produto implements CRUD{
	
	public void InstanciaProdutoControle(String nome, String fabricante, String descritivo, float kg, float metros){
		
		setNome(nome);
		setFabricante(fabricante);
		setDescritivo(descritivo);
		setKg(kg);
		setMetros(metros);		
		
	}
	
	public void gravar() {
		String filename = "src/BD/Produtos.txt";
		
		try{
			BufferedWriter write = new BufferedWriter(new FileWriter(filename, true));
			write.write(getNome());
			write.write(";");
			write.write(getFabricante());
			write.write(";");
			write.write(getDescritivo().trim());
			write.write(";");
			write.write(Float.toString(getKg()));
			write.write(";");
			write.write(Float.toString(getMetros()));
			write.write(";");
			write.newLine();
			write.close();
			
			JOptionPane.showMessageDialog(null,"Gravação concluida com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			
		}catch(IOException s){
			s.printStackTrace();
			JOptionPane.showMessageDialog(null,"Ocorreu um erro de Gravação, tente novamente mais tarde." , "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void deletar(String nome) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(String nome) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int ler() throws IOException{
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
}
