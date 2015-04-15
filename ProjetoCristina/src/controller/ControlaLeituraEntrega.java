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
private ConsultaEntrega consulta = new ConsultaEntrega();
private JTextField s;
public void sair(){
	
	
	int resp = 	JOptionPane.showConfirmDialog(null, "deseja mesmo sair","Saindo",JOptionPane.INFORMATION_MESSAGE);
	if(resp==0){
		
		System.exit(0);
		
	}
}


public void busca(JTable table,JTextField cliente){
	System.out.println(consulta.getTxtCliente());
/*
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			String linha;
		
			try {
				BufferedReader le = new BufferedReader(new FileReader("entrega.txt"));
		while(le.ready()){
				linha = le.readLine();
				if(linha.contains(cliente.getText())){
				Object[] objeto = linha.split(";");
				modelo.addRow(objeto);
				}
				
				}
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			*/
		}
	
	

	
	
	
	
	
	
}









