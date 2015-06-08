package control;

public class Main {

	public static void main(String[] args) {
		Roteirização r = new Roteirização ();
		String cepOrigem = "03694-000";
		String cepDestino1 = "08120-560";
		String cepDestino2 = "03821-020";
		
		
		double distancias[] = new double[2];
		
		
		
		distancias[0] = r.roteirizar(cepOrigem, cepDestino1);
		distancias[1] = r.roteirizar(cepOrigem, cepDestino2);
		
		if (distancias[0] < distancias[1]){
			System.out.println("O cep " + cepDestino1 + " é mais perto do que o " + cepDestino2);
		} else {
			System.out.println("O cep " + cepDestino2 + " é mais perto do que o " + cepDestino1);
		}
	}
}
