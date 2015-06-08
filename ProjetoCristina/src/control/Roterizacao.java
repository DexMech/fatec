package control;

import java.io.IOException;

public class Roterizacao implements CRUD{
	
	@Override
	public void gravar(String fileName) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deletar(String nome) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(String nome) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int ler() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	public double roterizar(String pontoInicial, String pontoFinal){
		double distanciaDouble = 0.0;
		String distanciaTexto = null;
		
		Geolocalizacao distancia = new Geolocalizacao();
		
		distanciaTexto = distancia.pesquisa(pontoInicial, pontoFinal);
		
		distanciaTexto = distanciaTexto.replace("km", "");
		distanciaTexto = distanciaTexto.trim();
		distanciaTexto = distanciaTexto.replace(",", ".");
		
		distanciaDouble = Double.parseDouble(distanciaTexto.trim());
		
		return distanciaDouble;
	}
}
