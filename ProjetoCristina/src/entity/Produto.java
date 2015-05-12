package entity;

/**
 * @author Stefanie
 * @version 1.x
 * 
 * <ul><h3>Versões:</h3> 
 * 		<li>1.0 - Criação da classe.</li>
 * 		<li>1.x - Retirado o tipo <code>abstract</code> da classe.</li>
 * 		<li>1.x+1 - Adicionado a variável fornecedor, do tipo <code>String</code>.</li>
 * </ul>
 *  
 * Entidade responsável por dados do produto, que será gravado no Produto.txt*/

public class Produto {
	
	private String nome;
	private String fabricante;
	private String fornecedor;
	private String descritivo;
	private float peso;
	private float metros;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getDescritivo() {
		return descritivo;
	}
	public void setDescritivo(String descritivo) {
		this.descritivo = descritivo;
	}
	public float getKg() {
		return peso;
	}
	public void setKg(float peso) {
		this.peso = peso;
	}
	public float getMetros() {
		return metros;
	}
	public void setMetros(float metros) {
		this.metros = metros;
	}
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
}
