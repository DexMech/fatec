package control;

import java.io.IOException;

public class Roteirização implements CRUD{
	
	
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

	public double roteirizar(String pontoInicial, String pontoFinal){
		double d = 0.0;
		String distance = null;
		
		Geolocalizacao distancia = new Geolocalizacao();
		
		distance = distancia.pesquisa(pontoInicial, pontoFinal);
		
		distance.replace("km", "");
		distance.trim();
		distance.replace(",", ".");
		
		d = Double.parseDouble(distance);
		
		return d;
	}

	@Override
	public void gravar(String fileName) throws IOException {
		// TODO Auto-generated method stub
		
	}
}
