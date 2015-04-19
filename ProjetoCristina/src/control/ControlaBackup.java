package control;

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
		InputStreamReader lefluxo = null;
		InputStream fluxo;
		BufferedReader leitura = null;
		try {
			Process processo = Runtime.getRuntime().exec("ls");
			fluxo = processo.getInputStream();
			lefluxo = new InputStreamReader(fluxo);

		leitura = new BufferedReader(lefluxo);
			String linha = "";

			while(linha!=null)
			{
				linha = leitura.readLine();
				if(linha.contains("alex.txt")||linha.contains("entrega.txt")||linha.contains("motoristas.txt")||linha.contains("alex.txt")||linha.contains("testeProdutosComprados.txt")){

					confere++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (NullPointerException e) {

			if(confere==4){

				try {
					Process processo2 = Runtime.getRuntime().exec("cp alex.txt entrega.txt motoristas.txt testeProdutosComprados.txt Backup");
					label.setText("Backup Salvo com Sucesso");
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			else{
				label.setText("Nenhum Arquivo a Salvar");

			}
			try {
				leitura.close();
			} catch (IOException e2) {

				e2.printStackTrace();
			}
			try {
				lefluxo.close();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}


	}

	public void escolher(){
		label.setText("");

		JFileChooser chooserArquivo = new JFileChooser("/home/dex/git/fatec/ProjetoCristina/Backup");

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
		if(text.getText().equals("")){
			
			label.setText("Escolha os arquivos a serem recuperados");
		}
		else{
		String linhas = text.getText();
		String[] linha =linhas.split("\n");
		try {
			for(String cont:linha){
			Process processoLinha = Runtime.getRuntime().exec("cp "+cont+" /home/dex/git/fatec/ProjetoCristina");
			}
			text.setForeground(Color.green);
			label.setText("Arquivos Recuperados com Sucesso ");
			label.setIcon(new ImageIcon("/Users/Thiago/Git/fatec/ProjetoCristina/images/check.png"));
			} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		}

	}
	public void limpar(){
		
		text.setText("");
		
	}

}