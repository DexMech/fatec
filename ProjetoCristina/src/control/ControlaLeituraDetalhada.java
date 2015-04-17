package control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JTextPane;

import entity.ConsultaDetalhada;

public class ControlaLeituraDetalhada {

	private Object[] objeto;
	private JTextArea text;
	private String[] recebe;

	public ControlaLeituraDetalhada( Object[] objeto,JTextArea text) {

        this.text =text;
		this.objeto = objeto;

	}
	public void preenche(){
		String linha = "";
		

		try {
			BufferedReader le = new BufferedReader(new FileReader("testeProdutosComprados.txt"));
			while(linha!=null){
				linha = le.readLine();
	           if(linha.contains(objeto[1].toString())&&linha.contains(objeto[3].toString())){
				 recebe = linha.split(";");
					
				 for(String ve:recebe){

						text.append(ve+"\n");

					}
				}
	           
				
			}
			le.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NullPointerException e) {
			
		}



	}



}



