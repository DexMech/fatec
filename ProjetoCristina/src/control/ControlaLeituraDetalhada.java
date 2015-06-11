package control;
/**
 * @author Alex Carlos
 * @version 1.x
 * 
 * <ul><h3>Versões</h3>
 * 		<li>1.0 Criação da classe.</li>
 * </ul>*/
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
		String[] items ={"Nome do Motorista","Veículo","Nome do Cliente","Produto","Fabricante","Fornecedor","Descrição","Peso","Volume","Data","Quantidade","Endereço"};
		
		String linha = "";


		try {
			BufferedReader le = new BufferedReader(new FileReader("src/BD/EntregaMot.txt"));
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
						if(pos>11){
						break;}
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



