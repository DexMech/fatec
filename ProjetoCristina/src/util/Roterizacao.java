package util;

import java.io.IOException;

public class Roterizacao implements CRUD{
	
	@Override
	public void gravar(String fileName) throws IOException {
		
		
	}
	
	public double roterizar(String pontoInicial, String pontoFinal){
		double distanciaDouble = 0.0;
		String distanciaTexto = null;
		
		Geolocalizacao distancia = new Geolocalizacao();
		
		distanciaTexto = distancia.pesquisa(pontoInicial, pontoFinal);
		
		distanciaTexto = distanciaTexto.replace("km", "");
		distanciaTexto = distanciaTexto.replace("m", "");
		distanciaTexto = distanciaTexto.trim();
		distanciaTexto = distanciaTexto.replace(",", ".");
		
		distanciaDouble = Double.parseDouble(distanciaTexto.trim());
		
		return distanciaDouble;
	}

	@Override
	public void deletar(String parametro, String fileName) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(String parametro, String[] novoConteudo,
			String fileName) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] ler(String fileName, String identificador)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
}
