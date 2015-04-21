package control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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


public class ControleTelaEntregas {


	private JComboBox  cbCliente;
	private JComboBox  cbProduto;
	private JTable tabela;
	private DefaultTableModel modelo ;
	private JTextField quantidade;
	private JFormattedTextField data;
	private JTextField regiao;
	private TelaEntrega tela;
	public ControleTelaEntregas(JComboBox cbCliente,JComboBox cbProduto,JTable tabela,JTextField quantidade,JFormattedTextField data,JTextField regiao){
		this.cbCliente = cbCliente;
		this.cbProduto = cbProduto;
		this.tabela = tabela;
		this.data = data;
		this.quantidade = quantidade;
		this.regiao = regiao;

	}


	public void ler() {

		data.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				data.setBackground(Color.WHITE);

			}
		});
		quantidade.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				quantidade.setBackground(Color.WHITE);

			}
		});
		cbCliente.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				cbCliente.setBackground(Color.WHITE);
				regiao.setBackground(Color.WHITE);

			}
		});	cbProduto.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				cbProduto.setBackground(Color.WHITE);

			}
		});
		cbCliente.addItem("");
		cbProduto.addItem("");
		try {
			BufferedReader entrada = new BufferedReader(new FileReader("src/BD/Clientes.txt"));


			while(entrada.ready()){
				String[] recebe = entrada.readLine().split(";");

				cbCliente.addItem(recebe[0]);
				cbCliente.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							BufferedReader entrada = new BufferedReader(new FileReader("src/BD/Clientes.txt"));

							String linha;
							while(entrada.ready()){
								linha =entrada.readLine();
								String[] recebe = linha.split(";");
								if(cbCliente.getSelectedItem()!=""){
									if(linha.contains(cbCliente.getSelectedItem().toString())){

										regiao.setText(recebe[3]);
									}
								}
								else{

									regiao.setText("");
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
			BufferedReader entrada2 = new BufferedReader(new FileReader("src/BD/Produtos.txt"));


			while(entrada2.ready()){
				String[] recebe2 = entrada2.readLine().split(";");

				cbProduto.addItem(recebe2[0]);



			}
		}catch (Exception e) {

		}

	}
	public void preencher(){

		if(valida()){}
		else{

			modelo  = (DefaultTableModel) tabela.getModel();

			String arquivo = cbProduto.getSelectedItem().toString();

			String linha;

			try {
				BufferedReader le = new BufferedReader(new FileReader("src/BD/Produtos.txt"));
				while(le.ready()){
					linha = le.readLine();
					int j = 0;
					if(linha.contains(arquivo)){
						Object[] objeto = new Object[7];

						objeto[5] = data.getText();
						objeto[6] = quantidade.getText();
						Object[] recipiente = linha.split(";");

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
	}
	private boolean valida(){
		boolean resposta = false;
		if(cbCliente.getSelectedItem()==""){
			cbCliente.setBackground(new Color(255,250,205));
			resposta = true;
		} if(cbProduto.getSelectedItem()==""){
			cbProduto.setBackground(new Color(255,250,205));
			resposta = true;
		} if(regiao.getText().equals("")){
			regiao.setBackground(new Color(255,250,205));
			resposta = true;
		} if(quantidade.getText().equals("")){
			quantidade.setBackground(new Color(255,250,205));
			resposta = true;

		}


		return resposta;
	}
	public void limpar(){
		int i=0;
		modelo = (DefaultTableModel) tabela.getModel();
		while(tabela.getRowCount()>0){
			modelo.removeRow(i);

		}

	}


	public void gravar() {

		try {
			BufferedWriter escrita = new BufferedWriter(new FileWriter("src/BD/Entrega.txt"));
			ArrayList<StringBuilder> linhas = new ArrayList<StringBuilder>(); 
			StringBuilder b = new StringBuilder();
			for(int i = 0; i< tabela.getRowCount(); i++){  
				b = new StringBuilder();  
				b.append(regiao.getText()+";");
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



}
