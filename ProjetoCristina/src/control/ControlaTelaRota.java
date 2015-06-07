/**
 * @author alex
 */

package control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;




public class ControlaTelaRota {
	private DefaultTableModel modelo ;
	private JComboBox combo;
	private JFormattedTextField data;
	private JTable tabela;
	
	/**
	 * metodo construtor da classe ControlaTelaRota
	 * @param tabela
	 * @param texto
	 * @param data
	 */

	
	
/**
 * Metodo responsavel pela roteirizacao
 * @param tabela
 * @param combo
 * @param data
 */
public void rota(JTable tabela,JComboBox combo,JFormattedTextField data){
	
	
	
	
	
	
	
	
	
	
}

public void Pegamotorista(JComboBox combo){
	try {
		BufferedReader le = new BufferedReader(new FileReader("src/BD/Motoristas.txt"));
		String linha;
		String recebe[];
		while((linha=le.readLine())!=null){
			recebe=linha.split(";");
			combo.addItem(recebe[0]);
			
			
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}
