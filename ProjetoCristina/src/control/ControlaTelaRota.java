/**
 * @author alex
 */

package control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;




public class ControlaTelaRota {
	private DefaultTableModel modelo ;
	private JComboBox combo;
	private JFormattedTextField data;
	private JTable tabela;




	/**
	 * Metodo responsavel pela roteirizacao
	 * @param tabela
	 * @param combo
	 * @param data
	 */
	public void rota(JTable tabela,JComboBox combo,JFormattedTextField data){
		Object[] lala=null;
		StringBuilder bu = new  StringBuilder();
		boolean ver = true;
		Vector<String > rec=new Vector<String>();

		String as = null;

		Geolocalizacao geo = new Geolocalizacao();


		modelo  = (DefaultTableModel) tabela.getModel();
		try {
			
			BufferedReader le = new BufferedReader(new FileReader("src/BD/EntregaMot.txt"));
			VerificaLinhas veri = new VerificaLinhas();
			int num =veri.verifica("src/BD/EntregaMot.txt");
			num = num - 1;
			int i=1;
			String linha =le.readLine();
			String[] recebelinha;
			String[] cep;
			String cepp;
			while(i<=num){
				bu.setLength(0);
				lala=null;
				recebelinha=null;
				cep=null;
				cepp=null;
				if(linha.contains(combo.getSelectedItem().toString())){
					recebelinha = linha.split(";");
					cep=recebelinha[11].split(",");
					cepp=cep[3];
					
					bu.append(recebelinha[2]);
					bu.append(";");
					bu.append(cepp);
					bu.append(";");
					bu.append(recebelinha[12]);
					bu.append(";");
					bu.append(recebelinha[3]);
					lala=bu.toString().split(";");
					modelo.addRow(lala);


				}

				linha=le.readLine();
				i++;	
			}



		} catch (IOException e) {

			e.printStackTrace();
		}


	}
	/**
	 * preenche combobox com nome dos motoristas
	 * @param combo
	 */
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
	public void limpar(JTable tabela){

		int i=0;
		modelo = (DefaultTableModel) tabela.getModel();
		while(tabela.getRowCount()>0){
			modelo.removeRow(i);

		}
		


	}

}
