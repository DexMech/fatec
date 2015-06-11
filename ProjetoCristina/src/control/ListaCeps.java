package control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListaCeps {

	public String listaCeps[];
	private int tamanho;
	private int inicio;
	private double distanciaMinima = Double.MAX_VALUE;
	
	public ListaCeps() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("src/BD/Entrega.txt"));
		int numLinhas = 0;
		
		while (br.ready()){
			br.readLine();
			numLinhas ++;
		}
		
		listaCeps = new String[numLinhas];
		tamanho = 0;
	}
	
	public void removeCep(int p){
		listaCeps[0] = listaCeps[p];
		
		for (int i = p; i < tamanho - 1; i ++){
			listaCeps[i] = listaCeps[i + 1];
		}
		
		tamanho --;
	}
	
	public int getTamanho(){
		return tamanho;
	}
	
	public void preencherLista() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("src/BD/Entrega.txt"));
		String[] cepp=null;	
		for (int i = 0; i < listaCeps.length; i ++){
			String ceps[] = br.readLine().split(";");
			 cepp=ceps[9].split(",");
			
			listaCeps[i] = cepp[3];
			tamanho ++;
			cepp=null;	
		}
		
		br.close();
	}
	
//	public double firstPosition() throws IOException{
//		BufferedReader br = new BufferedReader(new FileReader("src/BD/Clientes.txt"));
//		String km = null;
//		
//		String ceps[] = br.readLine().split(";");
//		
//		km = ceps[0];
//		km = km.replace("km", "");
//		km = km.trim();
//		km = km.replace(",", ".");
//		
//		double dist = Double.parseDouble(km);
//		
//		br.close();
//		
//		return dist;
//	}
	
	public void calculoDistancias(){
		
		try {
			preencherLista();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		FilaCeps fc = new FilaCeps(tamanho);
		Roterizacao r = new Roterizacao();
		double distancia = 0;
		int posicao = 0;
		
//		try {
//			fc.adicionaCep(firstPosition(), listaCeps[0]);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		while (tamanho > 1){
			for (int i = 1; i < tamanho; i ++){
				distancia = r.roterizar(listaCeps[0], listaCeps[i]);
				
				if (distancia < distanciaMinima){
					distanciaMinima = distancia;
					posicao = i;
				}
			}
			
			removeCep(posicao);
			fc.adicionaCep(distanciaMinima, listaCeps[0]);
			
			distanciaMinima = Double.MAX_VALUE;
		}
		
		fc.gravar();
		
		
	}
}
