/**
 * @author Arthur Gomes
 * 
 * Classe que grava informações do cliente*/

package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import entity.Cliente;

public class ClienteControle extends Cliente implements CRUD{

	public void InstanciarCliente(String nome, int numero, String telefone, String bairro, String cep, String indentificacao, String diasDaSemana){
		setNome(nome);
		setNumero(numero);
		setTelefone(telefone);
		setBairro(bairro);
		setCep(cep);
		setIdentificacao(indentificacao);		
		setDiasDaSemana(diasDaSemana);
	}
	
	public void gravar() throws IOException{
		String filename = "Clientes.txt";
		try{
			BufferedWriter escrever = new BufferedWriter(new FileWriter(filename, true));
			escrever.write(getNome());
			escrever.write(";");
			escrever.write(getNumero());
			escrever.write(";");
			escrever.write(getTelefone());
			escrever.write(";");
			escrever.write(getBairro());
			escrever.write(";");
			escrever.write(getCep());
			escrever.write(";");
			escrever.write(getIdentificacao());
			escrever.write(";");
			escrever.write(getDiasDaSemana());
			escrever.newLine();
			escrever.close();
			
			JOptionPane.showMessageDialog(null,"Gravação concluida com sucesso." , "Sucesso" , JOptionPane.INFORMATION_MESSAGE);
		}catch(IOException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Ocorreu um erro de gravação. Tente novamente mais tarde." , "Erro", JOptionPane.ERROR_MESSAGE);
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
		String fileName = "Clientes.txt";
		BufferedReader ler = new BufferedReader(new FileReader(fileName));
		
		while(ler.ready()){
			String [] cliente = ler.readLine().split(";");
			cta ++;
		}
		
		ler.close();
		
		return cta * 17;
	}
	
}
