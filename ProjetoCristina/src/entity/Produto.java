// @author Stefanie

package entity;

public abstract class Produto {
	
	private String nome;
	private String Fabricante;
	private String Descritivo;
	private float kg;
	private float metros;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFabricante() {
		return Fabricante;
	}
	public void setFabricante(String fabricante) {
		Fabricante = fabricante;
	}
	public String getDescritivo() {
		return Descritivo;
	}
	public void setDescritivo(String descritivo) {
		Descritivo = descritivo;
	}
	public float getKg() {
		return kg;
	}
	public void setKg(float kg) {
		this.kg = kg;
	}
	public float getMetros() {
		return metros;
	}
	public void setMetros(float metros) {
		this.metros = metros;
	}
}
