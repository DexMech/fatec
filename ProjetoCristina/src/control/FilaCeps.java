package control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilaCeps {

	public String filaCeps[];
	public double distancias[];
	private int tamanho;
	
	public FilaCeps(int capacidade){
		filaCeps = new String[capacidade];
		distancias = new double [capacidade];
		tamanho = 0;
	}
	
	public void adicionaCep(double distancia, String cep){
		distancias[tamanho] = distancia;
		filaCeps[tamanho] = cep;
		tamanho ++;
	}
	
	public void mostrar(){
		System.out.println("Lista de CEP's com distância: ");
		for (int i = 0; i < tamanho; i ++){
			System.out.println(filaCeps[i] + " " + distancias[i]);
		}
	}
	
	public double distanciaTotal(){
		double total = 0;
		
		for (int i = 0; i < tamanho; i ++){
			total += distancias[i];
		}
		
		return total;
	}
}
