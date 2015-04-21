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
		InputStreamReader lefluxo ;
		InputStream fluxo;
		String get = System.getProperty("os.name");
		
		if(get.contains("Linux")){
		try {
			Process processo = Runtime.getRuntime().exec("ls");
			fluxo = processo.getInputStream();
			lefluxo = new InputStreamReader(fluxo);

		BufferedReader leitura = new BufferedReader(lefluxo);
			String linha = "";

			while(linha!=null)
			{
				linha = leitura.readLine();
				
				if(linha.contains("Clientes.txt")||linha.contains("entrega.txt")||linha.contains("Motoristas.txt")||linha.contains("produtos.txt")){

					confere++;
				}
			
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch(NullPointerException e){
			
			if(confere==4){
				
				try {
					Process processo = Runtime.getRuntime().exec("cp Clientes.txt entrega.txt Motoristas.txt produtos.txt src/Backup");
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
			String gett = System.getProperty("os.name");
			
			if(get.contains("windows")){
			try {
				Process processo = Runtime.getRuntime().exec("dir");
				fluxo = processo.getInputStream();
					le = new InputStreamReader(lendo);

			BufferedReader leitura = new BufferedReader(le);
				String linha = "";

				while(linha!=null)
				{
					linha = leitura.readLine();
					
					if(linha.contains("Clientes.txt")||linha.contains("entrega.txt")||linha.contains("Motoristas.txt")||linha.contains("produtos.txt")){

						confere++;
					}
				
				}
			} 
			catch (IOException e) {
				e.printStackTrace();
			} 
			catch(NullPointerException e){
				
				if(confere==4){
					
					try {
						Process processo = Runtime.getRuntime().exec("cp Clientes.txt entrega.txt Motoristas.txt produtos.txt src/Backup");
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
			label.setIcon(new ImageIcon(this.getClass().getResource("/images/check.png")));
			} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		}

	}
	public void limpar(){
		
		text.setText("");
		
	}

}