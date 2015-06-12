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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import util.Geolocalizacao;
import util.VerificaLinhas;




public class ControleTelaRota {

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
		DefaultTableModel modelo;
		Object[] conteiner=null;
		StringBuilder constroi = new  StringBuilder();
		boolean ver = true;
		Vector<String > rec=new Vector<String>();

		String as = null;




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
				constroi.setLength(0);
				conteiner=null;
				recebelinha=null;
				cep=null;
				cepp=null;
				if(linha.contains(combo.getSelectedItem().toString())){
					recebelinha = linha.split(";");
					cep=recebelinha[11].split(",");
					cepp=cep[3];

					constroi.append(recebelinha[2]);
					constroi.append(";");
					constroi.append(cepp);
					constroi.append(";");
					constroi.append(recebelinha[12]);
					constroi.append(";");
					constroi.append(recebelinha[3]);
					conteiner=constroi.toString().split(";");
					modelo.addRow(conteiner);


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
		DefaultTableModel modelo;
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
	public void PegaPorData(String path,JTable table,JFormattedTextField data){

		DefaultTableModel model;
		Object[] conteiner=null;
		StringBuilder constroi = new  StringBuilder();
		boolean ver = true;
		Vector<String > rec=new Vector<String>();

		String as = null;


		
			JOptionPane.showMessageDialog(null, "Preencha o Campo data");
		
			model  = (DefaultTableModel) table.getModel();
			try {

				BufferedReader le = new BufferedReader(new FileReader(path));
				VerificaLinhas veri = new VerificaLinhas();
				int num =veri.verifica(path);
				num = num - 1;
				int i=1;
				String linha =le.readLine();
				String[] recebelinha;
				String[] cep;
				String cepp;
				while(i<=num){
					constroi.setLength(0);
					conteiner=null;
					recebelinha=null;
					cep=null;
					cepp=null;
					if(linha.contains(data.getText())){
						recebelinha = linha.split(";");
						cep=recebelinha[11].split(",");
						cepp=cep[3];

						constroi.append(recebelinha[2]);
						constroi.append(";");
						constroi.append(cepp);
						constroi.append(";");
						constroi.append(recebelinha[12]);
						constroi.append(";");
						constroi.append(recebelinha[3]);
						conteiner=constroi.toString().split(";");
						model.addRow(conteiner);



					}
					linha=le.readLine();
					i++;	
				}



			} catch (IOException e) {

				e.printStackTrace();
			}
		
	}





	public void limpar(JTable tabela){
		DefaultTableModel modelo;
		int i=0;
		modelo = (DefaultTableModel) tabela.getModel();
		while(tabela.getRowCount()>0){
			modelo.removeRow(i);

		}



	}

}
