package entity;

public abstract class  Cliente {
	
	private String Nome;
	private int N;
	private String telefone;
	private String bairro;
	private String cep;
	private String identificacao;
	private String diasDaSemana;
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public int getN() {
		return N;
	}
	public void setN(int n) {
		N = n;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getIdentificacao() {
		return identificacao;
	}
	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}
	public String getDiasDaSemana() {
		return diasDaSemana;
	}
	public void setDiasDaSemana(String diasDasemana) {
		this.diasDaSemana = diasDasemana;
	}
}