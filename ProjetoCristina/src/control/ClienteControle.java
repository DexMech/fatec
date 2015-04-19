/**
 * @author Arthur Gomes
 * 
 * Classe que grava informações do cliente*/

package control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import entity.Cliente;

public class ClienteControle extends Cliente implements CRUD{

	public void InstanciarCliente(String nome, int numero, String telefone, String bairro, String cep, String indentificacao, String diasDaSemana){
		setNome(nome);
		setN(numero);
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
			escrever.write(getN());
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
