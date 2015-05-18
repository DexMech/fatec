package entity;

/**
 * @author Arthur Gomes
 * @version 1.0
 * 
 * <ul><h3>Versões: </h3>
 * 		<li>1.0 - Criação da classe.</li>
 * </ul>
 *
 * Essa classe irá criar uma generalização nas entidades que compartilham esses
 * atributos.*/

public abstract class Pessoa {

	String nome;
	String telefone;
	String celular;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
}
