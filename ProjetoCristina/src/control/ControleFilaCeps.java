package control;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

import util.VerificaLinhas;

public class ControleFilaCeps {

	public String filaCeps[];
	public double distancias[];
	private int tamanho;
	
	public ControleFilaCeps(int capacidade){
		filaCeps = new String[capacidade];
		distancias = new double [capacidade];
		tamanho = 0;
	}
	
	public void adicionaCep(double distancia, String cep){
		distancias[tamanho] = distancia;
		filaCeps[tamanho] = cep;
		tamanho ++;
	}
	/**
	 * Metodo de gravar
	 */
	public void gravar(){
		
		try {
			BufferedWriter dist = new BufferedWriter(new FileWriter("src/BD/Distancias.txt"));
			BufferedWriter fila = new BufferedWriter(new FileWriter("src/BD/FilaCeps.txt"));
			
			for(int i=0;i<=distancias.length-1;i++){
				dist.write(""+distancias[i]);
				dist.write("\n");
				
			}
			for(int i=0;i<filaCeps.length-1;i++){
				fila.write(filaCeps[i]);
				fila.write("\n");
			}
			
			
			fila.close();
			dist.close();
			constroiArquivo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public double distanciaTotal(){
		double total = 0;
		
		for (int i = 0; i < tamanho; i ++){
			total += distancias[i];
		}
		
		return total;
	}
	/**
	 * Metodo de criação de arquivo.
	 */
	private void constroiArquivo(){
		
	
		try {
			BufferedReader leFila = new BufferedReader(new FileReader("src/BD/FilaCeps.txt"));
			BufferedReader leDist = new BufferedReader(new FileReader("src/BD/Distancias.txt"));
			RandomAccessFile leCli = new RandomAccessFile("src/BD/Entrega.txt","r");
			BufferedWriter escreve = new BufferedWriter(new FileWriter("src/BD/EntregaMid.txt"));
			StringBuilder lista = new  StringBuilder();
			VerificaLinhas verifica = new VerificaLinhas();
			
			int i=0;
			int num = verifica.verifica("src/BD/Entrega.txt")-1;
			
			while(i<num-1){
				String linha=leCli.readLine();
				
				String fila=leFila.readLine();
				String dist=leDist.readLine();
				while(!linha.contains(fila)){
					if(linha.equals(null)){
						leCli.seek(0);}
					
					linha=leCli.readLine();
					
					
				}
				
				lista.append(linha);
				lista.append(";");
				lista.append(dist);
				escreve.write(lista.toString());
				escreve.write("\n");
				linha=null;
				lista.setLength(0);
				leCli.seek(0);
				i++;
			}
			
			
			
			
			leFila.close();
			leDist.close();
			leCli.close();
			escreve.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		separaMotorista();
	}
	private void separaMotorista(){
		
		

			/**
			 * verifica a quantidade de linhas no arquivo Entrega.txt
			 */
			VerificaLinhas verifica =new VerificaLinhas();
			int num = verifica.verifica("src/BD/EntregaMid.txt");
			num = num - 1;
			
				
					List temp = new List();
					try {
						double calc = 0.0;
						double recebe=0.0;
						/**
						 * abre os arquivos para leitura
						 */
						BufferedReader mot = new BufferedReader(new FileReader("src/BD/Motoristas.txt"));
						BufferedReader entrega = new BufferedReader(new FileReader("src/BD/EntregaMid.txt"));
						BufferedWriter escrita = new  BufferedWriter(new FileWriter("src/BD/EntregaMot.txt"));
						List listaEntrega = new List();
						List listaMotorista = new List();
						String linha;
						String mota = mot.readLine();
						
						for(String cont:mota.split(";")){
							listaMotorista.add(cont);

						}
						recebe = Double.parseDouble(listaMotorista.getItem(8));



						while((linha=entrega.readLine())!=null &&num>0){
							
							listaEntrega.delItems(0, listaEntrega.getItemCount()-1);

							for(String cont:linha.split(";")){
								listaEntrega.add(cont);

							}
							
							calc = Double.parseDouble(listaEntrega.getItem(8))*Double.parseDouble(listaEntrega.getItem(8));



							recebe = recebe - calc;

							if(recebe<0){
								listaMotorista.delItems(0, listaMotorista.getItemCount()-1);
								mota=mot.readLine();
								for(String cont:mota.split(";")){
									listaMotorista.add(cont);

								}
								recebe = Double.parseDouble(listaMotorista.getItem(8));
							}


							escrita.write(listaMotorista.getItem(0));
							escrita.write(";");
							escrita.write(listaMotorista.getItem(7));
							escrita.write(";");
							for(int i=0;i<listaEntrega.getItemCount();i++){
								escrita.write(listaEntrega.getItem(i));
								escrita.write(";");
							}
							escrita.newLine();
						num = num - 1;


						}
						mot.close();
						entrega.close();
						escrita.close();
					
					} catch (IOException e) {
				
						e.printStackTrace();
					}catch(NullPointerException e){


					}

				}





				
				
				
				
			

	}

