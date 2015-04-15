package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import view.ConsultaEntrega;

public class ControlaLeituraEntrega {
	DefaultTableModel modelo;
	String cliente;
public void sair(){
	
	
	int resp = 	JOptionPane.showConfirmDialog(null, "deseja mesmo sair","Saindo",JOptionPane.INFORMATION_MESSAGE);
	if(resp==0){
		
		System.exit(0);
		
	}
}


public void busca(String cliente,String data,JTable tabela){
	
	this.cliente =cliente;

			 modelo = (DefaultTableModel) tabela.getModel();
			String linha;
		
			try {
				BufferedReader le = new BufferedReader(new FileReader("entrega.txt"));
		while(le.ready()){
				linha = le.readLine();
				if(linha.contains(cliente) && (linha.contains(data))){
				Object[] objeto = linha.split(";");
				modelo.addRow(objeto);
				}
				
				}
		le.close();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
		}
	
	
public void limpar(JTable tabela){
System.out.println(tabela.getRowCount());
int i=0;
	 modelo = (DefaultTableModel) tabela.getModel();
	while(tabela.getRowCount()>0){
	modelo.removeRow(i);
	
	 }
	

}

public void exporta(JTable tabela){
	ArrayList<StringBuilder> linhas = new ArrayList<StringBuilder>(); 
	StringBuilder b = new StringBuilder();
	for(int i = 0; i< tabela.getRowCount(); i++){  
		   b = new StringBuilder();  
		   for(int j = 0; j < tabela.getColumnCount(); j++){  
		        b.append(tabela.getValueAt(i,j)).append(";");  
		   }  
		   linhas.add(b);  
		} 
	BufferedWriter escreve = null;
	try {
		escreve = new BufferedWriter(new FileWriter(cliente+".txt",true));
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	for(StringBuilder b1: linhas){  
	    try {
			escreve.write(b1.toString()+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	} 
	try {
		escreve.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
 
	
	
	
	
}









