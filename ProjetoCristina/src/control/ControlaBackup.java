package control;

/**
 * @author Alex Carlos
 * @version 1.x
 * 
 * <ul><h3>Versões</h3>
 * 		<li>1.0 Criação da classe.</li>
 * </ul>*/

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ControlaBackup {
	private JTextArea text;
	private JLabel label;
	
	public ControlaBackup(JTextArea text,JLabel label){
		this.text = text;
		this.label = label;
	}
	
	public void salvar(){
		label.setText("");
		int confere = 0;
		InputStreamReader lefluxo ;
		InputStream fluxo;
		String get = System.getProperty("os.name");

		if(get.contains("Linux")){
			try {
				Process processo = Runtime.getRuntime().exec("ls src/BD");
				fluxo = processo.getInputStream();
				lefluxo = new InputStreamReader(fluxo);

				BufferedReader leitura = new BufferedReader(lefluxo);
				String linha = "";

				while(linha!=null)
				{
					linha = leitura.readLine();

					if(linha.contains("Distancias.txt")||linha.contains("FilaCeps.txt")||linha.contains("EntregaMid.txt")||linha.contains("Clientes.txt")||linha.contains("Entrega.txt")||linha.contains("Motoristas.txt")||linha.contains("Produtos.txt")||linha.contains("EntregaMot.txt")){

						confere++;
						
					}

				}
			} 
			catch (IOException e) {
				e.printStackTrace();
			} 
			catch(NullPointerException e){

				if(confere==8){

					try {
						Process processo = Runtime.getRuntime().exec("cp src/BD/Clientes.txt   src/Backup");
						Process processo1 = Runtime.getRuntime().exec("cp src/BD/Entrega.txt   src/Backup");
						Process processo2 = Runtime.getRuntime().exec("cp src/BD/Motoristas.txt   src/Backup");
						Process processo3 = Runtime.getRuntime().exec("cp src/BD/Produtos.txt  src/Backup");
						Process processo4 = Runtime.getRuntime().exec("cp src/BD/EntregaMot.txt  src/Backup");
						Process processo5 = Runtime.getRuntime().exec("cp src/BD/FilaCeps.txt  src/Backup");
						Process processo6 = Runtime.getRuntime().exec("cp src/BD/EntregaMid.txt  src/Backup");
						Process processo7 = Runtime.getRuntime().exec("cp src/BD/Distancias.txt  src/Backup");
					
					
						label.setText("Salvo com Sucesso");
					} catch (IOException e1) {

						e1.printStackTrace();
					}


				}

			}
		}
		else if(get.contains("windows")){

			label.setText("");
			int conferindo = 0;

			InputStream lendo = null;
			InputStreamReader le;
			if(get.contains("windows")){
				try {
					Process processo = Runtime.getRuntime().exec("dir src/BD/");
					fluxo = processo.getInputStream();
					le = new InputStreamReader(lendo);

					BufferedReader leitura = new BufferedReader(le);
					String linha = "";

					while(linha!=null)
					{
						linha = leitura.readLine();

						if(linha.contains("Distancias.txt")||linha.contains("FilaCeps.txt")||linha.contains("EntregaMid.txt")||linha.contains("Clientes.txt")||linha.contains("Entrega.txt")||linha.contains("Motoristas.txt")||linha.contains("Produtos.txt")||linha.contains("EntregaMot.txt")){

							confere++;
						}

					}
				} 
				catch (IOException e) {
					e.printStackTrace();
				} 
				catch(NullPointerException e){

					if(confere==8){

						try {
							Process processo = Runtime.getRuntime().exec("cp src/BD/Clientes.txt   src/Backup");
							Process processo1 = Runtime.getRuntime().exec("cp src/BD/Entrega.txt   src/Backup");
							Process processo2 = Runtime.getRuntime().exec("cp src/BD/Motoristas.txt   src/Backup");
							Process processo3 = Runtime.getRuntime().exec("cp src/BD/Produtos.txt  src/Backup");
							Process processo4 = Runtime.getRuntime().exec("cp src/BD/EntregaMot.txt  src/Backup");
							Process processo5 = Runtime.getRuntime().exec("cp src/BD/FilaCeps.txt  src/Backup");
							Process processo6 = Runtime.getRuntime().exec("cp src/BD/EntregaMid.txt  src/Backup");
							Process processo7 = Runtime.getRuntime().exec("cp src/BD/Distancias.txt  src/Backup");
							label.setText("Salvo com Sucesso");
						} catch (IOException e1) {

							e1.printStackTrace();
						}


					}

				}
			}
		}

	}

	public void escolher(){
		label.setText("");
		text.setForeground(Color.BLACK);

		JFileChooser chooserArquivo = new JFileChooser("src/Backup");

		int escolha = chooserArquivo.showOpenDialog(chooserArquivo);
		if (escolha==1){


		}
		else{
			String arquivo = chooserArquivo.getSelectedFile().getAbsolutePath();

			text.append(arquivo+"\n");
		}

	}
	
	public void recuperar(){
		label.setText("");
		String get =System.getProperty("os.name");
		if(get.contains("Linux")||get.contains("mac")){
			if(text.getText().equals("")){

				label.setText("Escolha os arquivos a serem recuperados");
			}
			else{
				String linhas = text.getText();
				String[] linha =linhas.split("\n");
				try {
					for(String cont:linha){
						Process processoLinha = Runtime.getRuntime().exec("cp "+cont+" src/BD/");
					}
					text.setForeground(Color.green);
					label.setText("Arquivos Recuperados com Sucesso ");
					label.setIcon(new ImageIcon(this.getClass().getResource("/images/check.png")));
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
		else{
			if(text.getText().equals("")){

				label.setText("Escolha os arquivos a serem recuperados");
			}
			else{
				String linhas = text.getText();
				String[] linha =linhas.split("\n");
				try {
					for(String cont:linha){
						Process processoLinha = Runtime.getRuntime().exec("copy "+cont+" src/BD/");
					}
					text.setForeground(Color.green);
					label.setText("Arquivos Recuperados com Sucesso ");
					label.setIcon(new ImageIcon(this.getClass().getResource("/images/check.png")));
				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		}
	}
	
	public void limpar(){
		text.setText("");
	}

}