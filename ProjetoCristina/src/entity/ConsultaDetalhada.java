package entity;

/**
 * @author Alex Carlos
 * @version 1.x
 * 
 * <ul><h3>Versões: </h3>
 * 		<li>1.0 - Criação da classe.</li>
 * </ul>
 * 
 * Classe responsável por gravar os detalhes da entrega.*/

public class ConsultaDetalhada {
	
	private String cliente;
	private String data;
	private String Jpane;

	public String getJpane() {
		return Jpane;
	}
	public void setJpane(String jpane) {
		Jpane = jpane;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
}
