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
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entity.Cliente;
import boundary.TelaConsultaEntrega;

public class ControleConsultaEntrega {
	DefaultTableModel modelo;
	public TelaConsultaEntrega con ;
	private String cliente;

/**
 * Metodo exibe mensagem e fecha caixa.
 */
	public void sair(){


		int resp = 	JOptionPane.showConfirmDialog(null, "deseja mesmo sair","Saindo",JOptionPane.INFORMATION_MESSAGE);
		if(resp==0){

			System.exit(0);

		}
	}

/**
 * Metodo de busca conforme informações digitadas.
 * @param cliente
 * @param data
 * @param tabela
 */
	public void busca(String cliente,String data,JTable tabela){

		this.cliente =cliente;

		modelo = (DefaultTableModel) tabela.getModel();
		String linha;

		try {
			BufferedReader le = new BufferedReader(new FileReader("src/BD/EntregaMot.txt"));

			while(le.ready()){
				linha = le.readLine();
				if(linha.contains(cliente) || (linha.contains(data))){
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
 * Metodo que limpa campos.
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
	public String retornaString(){


		return "Gravado com sucesso";

	}
/**
 * Metodo de exportação para xls.
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
			escreve = new BufferedWriter(new FileWriter("src/xls/"+cliente+".xls",true));
			
			escreve.write(getHora());
			escreve.write(";");
			for(StringBuilder b1: linhas){  

				escreve.write(b1.toString()+"\n");
			}
			escreve.close();
		} catch (IOException e1) {

			e1.printStackTrace();
		}






		label.setIcon(new ImageIcon(this.getClass().getResource("/images/check.png")));
	}
/**
 * Metodo que captura data e hora.
 * @return
 */
    public String getHora() {  
        
        // cria um StringBuilder  
        StringBuilder sb = new StringBuilder();  
      
        // cria um GregorianCalendar que vai conter a hora atual  
        GregorianCalendar d = new GregorianCalendar();  
          
        // anexa do StringBuilder os dados da hora  
        sb.append( d.get( GregorianCalendar.HOUR_OF_DAY ) );  
        sb.append( ":" );  
        sb.append( d.get( GregorianCalendar.MINUTE ) );  
        sb.append( ":" );  
        sb.append( d.get( GregorianCalendar.SECOND ) );  
          
        // retorna a String do StringBuilder  
        return sb.toString();  
          
    }  




}









