package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import boundary.TelaEntrega;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import boundary.TelaEntrega;


public class ControleTelaEntregas implements CRUD{

	
	private JComboBox  cbCliente;
	private JComboBox  cbProduto;
	private JTable tabela;
	private DefaultTableModel modelo ;
	private JTextField texto;
	private JFormattedTextField forma;
	
	public ControleTelaEntregas(JComboBox cbCliente,JComboBox cbProduto,JTable tabela,JTextField texto,JFormattedTextField forma){
		this.cbCliente = cbCliente;
		this.cbProduto = cbProduto;
		this.tabela = tabela;
		this.forma = forma;
		this.texto = texto;
		
	}

	// le arquivo com dados do cliente
	public void ler() {
		try {
			BufferedReader entrada = new BufferedReader(new FileReader("Clientes.txt"));


			while(entrada.ready()){
				String[] recebe = entrada.readLine().split(";");

				cbCliente.addItem(recebe[0]);



			}
		}catch (Exception e) {
		}

		try {
			BufferedReader entrada2 = new BufferedReader(new FileReader("produtos.txt"));


			while(entrada2.ready()){
				String[] recebe2 = entrada2.readLine().split(";");

				cbProduto.addItem(recebe2[0]);



			}
		}catch (Exception e) {
		}

	}
	public void preencher(){
		modelo  = (DefaultTableModel) tabela.getModel();

		String arquivo =cbProduto.getSelectedItem().toString();
		
		String linha;

		try {
			BufferedReader le = new BufferedReader(new FileReader("produtos.txt"));
			while(le.ready()){
				linha = le.readLine();
				int j =0;
				if(linha.contains(arquivo)){
					Object[] objeto = new Object[7];
					Object[] recipiente = new Object[2];
					objeto[5] =forma.getText();
					objeto[6]=texto.getText();
					recipiente = linha.split(";");
					for(int i=0;i<5;i++){
						
						objeto[i] = recipiente[j];
						j++;
					}
					
				//	
					modelo.addRow(objeto);
				}
			}

			le.close();

		}catch(IOException e1){

		}
	}

public void limpar(){
	modelo  = (DefaultTableModel) tabela.getModel();
	int i=0;


	
	while(tabela.getRowCount()>0){
		modelo.removeRow(i);
		i++;

	}
	
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
