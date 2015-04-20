package control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import boundary.TelaEntrega;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import boundary.TelaEntrega;


public class ControleTelaEntregas implements CRUD{

	private DefaultTableModel modelo;
	private JComboBox  cbCliente;
	private JComboBox  cbProduto;
	private JTable tabela;

	public ControleTelaEntregas(JComboBox cbCliente,JComboBox cbProduto,JTable tabela){
		this.cbCliente = cbCliente;
		this.cbProduto = cbProduto;
		this.tabela = tabela;
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


		String arquivo =cbProduto.getSelectedItem().toString();
		modelo = (DefaultTableModel) tabela.getModel();
		String linha;

		try {
			BufferedReader le = new BufferedReader(new FileReader("produtos.txt"));
			while(le.ready()){
				linha = le.readLine();
				if(linha.contains(arquivo)){
					Object[] objeto = linha.split(";");
					modelo.addRow(objeto);
				}
			}
		}catch(IOException e1){

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
