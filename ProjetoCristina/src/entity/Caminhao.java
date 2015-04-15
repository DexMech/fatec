package entity;

public abstract class Caminhao {

	private String tipoCaminhao;
	private int capacidadeCarga;
	private String numeroPlaca;
	private String cidade;
	private String estado;
	
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
		else if (text.equals("Carreta Baú") || text.equals("Carreta 3 Eixos"))
			this.capacidadeCarga = 41500;			
		else if (text.equals("Carreta Cavalo Truckado") || text.equals("Carreta Cavalo Truckado Baú"))
			this.capacidadeCarga = 45000;			
		else
			this.capacidadeCarga = 57000;
	}
}
