package control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import boundary.TelaEntrega;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import boundary.TelaEntrega;


public class ControleTelaEntregas implements CRUD{
	
	private String [] name, number, state, zipCode, segunda, terca, quarta, quinta, sexta, sabado, domingo;
	private JComboBox cbCliente;
	
	public ControleTelaEntregas(JComboBox cbCliente){
		this.cbCliente = cbCliente;
	}
	
	// le arquivo com dados do cliente
	public void ler() throws IOException{
		int i = 0;
		try {
			Scanner entrada = new Scanner(new FileReader("C:\\Users\\home\\Documents\\Clientes"));
			while(entrada.hasNext()){
				name[i] = entrada.nextLine();
				number[i] = entrada.nextLine();
				state[i] = entrada.nextLine();
				zipCode[i] = entrada.nextLine();
				segunda[i] = entrada.nextLine();
				terca[i] = entrada.nextLine();
				quarta[i] = entrada.nextLine();
				quinta[i] = entrada.nextLine();
				sexta[i] = entrada.nextLine();
				sabado[i] = entrada.nextLine();
				domingo[i] = entrada.nextLine();
				cbCliente.addItem(name[i]);
				i++;
			}
			entrada.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado", null, JOptionPane.ERROR_MESSAGE, null);
		}
		
	}
	
	// Verifica quais dias estão habilitados para entrega
	public void habilitaDia(){
		
	}

	@Override
	public void gravar() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
