/**
 * @author Stefanie
 * */

package entity;

public abstract class Produto {
	
	private String nome;
	private String fabricante;
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
		fabricante = fabricante;
	}
	public String getDescritivo() {
		return descritivo;
	}
	public void setDescritivo(String descritivo) {
		descritivo = descritivo;
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
}
