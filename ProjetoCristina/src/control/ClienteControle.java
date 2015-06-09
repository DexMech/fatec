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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import entity.Cliente;

public class ClienteControle implements CRUD{

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
			BufferedWriter escrever = new BufferedWriter(new FileWriter(fileName, true));
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
	
	public int numeroLinhas() throws IOException{
		int cta = 0;
		String fileName = "src/BD/Clientes.txt";
		BufferedReader ler = new BufferedReader(new FileReader(fileName));
		
		while(ler.ready()){
			String [] cliente = ler.readLine().split(";");
			cta ++;
		}
		
		ler.close();
		
		return cta * 17;
	}
	
	public double tratamentoLocalizacao(String distancia){
	
		distancia = distancia.replace("km", "");
		distancia = distancia.trim();
		distancia = distancia.replace(",", ".");
		
		return Double.parseDouble(distancia);
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
