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
		String[] items ={"Região","Nome do Cliente","Produto","Fabricante","Descrição","Peso","Volume","Data","Quantidade"};
		
		String linha = "";


		try {
			BufferedReader le = new BufferedReader(new FileReader("entrega.txt"));
			while(linha != null){
				linha = le.readLine();
				if(linha.contains(objeto[1].toString())&&linha.contains(objeto[3].toString())){
					recebe = linha.split(";");
					int pos = 0;
					for(String ve:recebe){
						text.append(items[pos]+"\n");
						text.append(ve+"\n");
						text.append("------------------------------------------------------------------------------------------------------\n");
						pos++;
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



