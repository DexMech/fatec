package entity;

public abstract class Motorista {

	private String nome;
	private String cnh;
	private String validadeInicio;
	private String validadeFim;
	private String telefone1;
	private String telefone2;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	public String getValidadeInicio() {
		return validadeInicio;
	}
	public void setValidadeInicio(String validadeInicio) {
		this.validadeInicio = validadeInicio;
	}
	public String getValidadeFim() {
		return validadeFim;
	}
	public void setValidadeFim(String validadeFim) {
		this.validadeFim = validadeFim;
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	
	
}