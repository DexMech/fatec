package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import view.ConsultaEntrega;

public class ControlaLeituraEntrega {

public void sair(){
	
	
	int resp = 	JOptionPane.showConfirmDialog(null, "deseja mesmo sair","Saindo",JOptionPane.INFORMATION_MESSAGE);
	if(resp==0){
		
		System.exit(0);
		
	}
}


public void busca(String cliente,String data,JTable tabela){
	
	

			DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
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
int row = tabela.getRowCount();

	
	
	

}
	
	
	
	
	
	
}









