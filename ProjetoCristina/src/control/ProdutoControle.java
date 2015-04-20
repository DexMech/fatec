// @author Stefanie

package control;

import java.io.BufferedWriter;
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
	
	public void gravar() throws IOException{
		String filename = "produtos.txt";
		
		try{
			BufferedWriter write = new BufferedWriter(new FileWriter(filename, true));
			write.write(getNome());
			write.write(";");
			write.write(getFabricante());
			write.write(";");
			write.write(getDescritivo());
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
	public void deletar() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ler() throws IOException {
		// TODO Auto-generated method stub
		
	}
}
