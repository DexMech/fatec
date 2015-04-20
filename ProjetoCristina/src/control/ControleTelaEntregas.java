package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import boundary.TelaEntrega;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import boundary.TelaEntrega;


public class ControleTelaEntregas implements CRUD{

	private JLabel local;
	private JComboBox  cbCliente;
	private JComboBox  cbProduto;
	private JTable tabela;
	private DefaultTableModel modelo ;
	private JTextField texto;
	private JFormattedTextField forma;
	private JTextField nomeCli;
	private TelaEntrega tela;
	public ControleTelaEntregas(JComboBox cbCliente,JComboBox cbProduto,JTable tabela,JTextField texto,JFormattedTextField forma,JTextField nomeCli){
		this.cbCliente = cbCliente;
		this.cbProduto = cbProduto;
		this.tabela = tabela;
		this.forma = forma;
		this.texto = texto;
		this.nomeCli = nomeCli;

	}


	public void ler() {
		try {
			BufferedReader entrada = new BufferedReader(new FileReader("Clientes.txt"));


			while(entrada.ready()){
				String[] recebe = entrada.readLine().split(";");

				cbCliente.addItem(recebe[0]);
				cbCliente.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							BufferedReader entrada = new BufferedReader(new FileReader("Clientes.txt"));

							String linha;
							while(entrada.ready()){
								linha =entrada.readLine();
								String[] recebe = linha.split(";");

								if(linha.contains(cbCliente.getSelectedItem().toString())){

									nomeCli.setText(recebe[3]);
								}




							}
							entrada.close();
						}catch (Exception b) {
						}

					}
				});




			}
			entrada.close();
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
		int i=0;
		modelo = (DefaultTableModel) tabela.getModel();
		while(tabela.getRowCount()>0){
			modelo.removeRow(i);

		}

	}

	@Override
	public void gravar() {

		try {
			BufferedWriter escrita = new BufferedWriter(new FileWriter("Entrega.txt"));
			ArrayList<StringBuilder> linhas = new ArrayList<StringBuilder>(); 
			StringBuilder b = new StringBuilder();
			for(int i = 0; i< tabela.getRowCount(); i++){  
				b = new StringBuilder();  
				b.append(nomeCli.getText()+";");
				b.append(cbCliente.getSelectedItem().toString()+";");
				for(int j = 0; j < tabela.getColumnCount(); j++){  
					b.append(tabela.getValueAt(i,j)).append(";");  
				}  
				linhas.add(b); 
			}
			for(StringBuilder b1: linhas){  

				escrita.write(b1.toString()+"\n");
			}



			escrita.close();	
		} 
		catch(IOException e){


		}



	}
	public String retornaString(){


		return "Gravado com sucesso";

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
