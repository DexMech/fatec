package entity;

/**
 * @author Arthur Gomes
 * @version 1.2
 * 
 * 
 * <ul><h3>Versões:</h3>
 * 		<li>1.0 - Criação da classe, para tirar as responsabilidades da classe Motorista.</li>
 * 		<li>1.1 - Retirado o tipo <code>abstract</code> da classe.</li> 
 * 		<li>1.2 - Adicionado uma instância de pessoa, demonstrando composição</li>
 * </ul>
 * 
 * Classe que corresponde ao caminhão que o motorista irá conduzir. Cada motorista só pode
 * ter 1 caminhão. Suas informações serão gravadas no arquivo Motorista.txt */

public class Caminhao {

	private String tipoCaminhao;
	private int capacidadeCarga;
	private String numeroPlaca;
	private String cidade;
	private String estado;
	Carroceria c = new Carroceria();
	
	public String getTipoCaminhao() {
		return tipoCaminhao;
	}
	public void setTipoCaminhao(String tipoCaminhao) {
		this.tipoCaminhao = tipoCaminhao;
	}
	public String getNumeroPlaca() {
		return numeroPlaca;
	}
	public void setNumeroPlaca(String numeroPlaca) {
		this.numeroPlaca = numeroPlaca;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getCapacidadeCarga(){
		return capacidadeCarga;
	}
	public void setCapacidadeCarga(String text){
		if (text.equals("Toco"))
			this.capacidadeCarga = 16000;
 		else if (text.equals("Truck"))
			this.capacidadeCarga = 23000;
		else if (text.equals("Carreta 2 Eixos"))
			this.capacidadeCarga = 33000;
		else if (text.equals("Carreta Ba�") || text.equals("Carreta 3 Eixos"))
			this.capacidadeCarga = 41500;			
		else if (text.equals("Carreta Cavalo Truckado") || text.equals("Carreta Cavalo Truckado Ba�"))
			this.capacidadeCarga = 45000;			
		else
			this.capacidadeCarga = 57000;
	}
}
