package control;
/**
 * @author Alex Carlos
 * @version 1.x
 * 
 * <ul><h3>Versões</h3>
 * 		<li>1.0 Criação da classe.</li>
 * </ul>*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entity.Cliente;
import boundary.TelaConsultaEntrega;

public class ControleLeituraEntrega {
	DefaultTableModel modelo;
	public TelaConsultaEntrega con ;
	private String cliente;

	/**
	 * Metodo de busca.
	 * @param cliente
	 * @param data
	 * @param tabela
	 */
	public void busca(String cliente,String data,JTable tabela){



		modelo = (DefaultTableModel) tabela.getModel();
		String linha;

		try {
			BufferedReader le = new BufferedReader(new FileReader("src/BD/Entrega.txt"));
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

/**
 * Metodo para limpar
 * @param tabela
 * @param label
 * @param cliente
 * @param data
 */
	public void limpar(JTable tabela,JLabel label,JTextField cliente,JFormattedTextField data){

		int i=0;
		modelo = (DefaultTableModel) tabela.getModel();
		
		while(tabela.getRowCount()>0){
			modelo.removeRow(i);

		}
		label.setText("");
		cliente.setText("");
		data.setText("");

	}
/**
 * Metodo para exportar para xls.
 * @param tabela
 * @param label
 */
	public void exporta(JTable tabela,JLabel label){
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
			escreve = new BufferedWriter(new FileWriter("src/BD/Cliente.xls",true));
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		for(StringBuilder b1: linhas){  
			try {
				escreve.write(b1.toString()+"\n");
			} catch (IOException e) {

				e.printStackTrace();
			}  
		} 
		try {
			escreve.close();
		} catch (IOException e) {

			e.printStackTrace();
		}


		label.setText("gravado com sucesso");
	}






}









