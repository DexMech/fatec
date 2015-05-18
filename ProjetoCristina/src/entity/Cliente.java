package entity;

/**
 * @author Tiago Lucas
 * @version 1.x
 * 
 * <ul><h3>Versões:</h3> 
 * 		<li>1.0 - Criação da classe.</li>
 * 		<li>1.x - Retirado o tipo <code>abstract</code> da classe.</li>
 * 		<li>1.x+1 - Adicionado herança. Essa classe agora herda da classe Pessoa.</li>
 * </ul>
 *  
 * Entidade responsável por dados do cliente, que será gravado no Cliente.txt*/

public class Cliente {

	private String endereco;	
	private int numero;
	private String bairro;
	private String cep;
	private String identificacao; //referente ao cpf/cnpj que o cliente terá
	private String diasDaSemana;
	private String Nome;
	private String Telefone;
	private String Celular;

	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public String getCelular() {
		return Celular;
	}
	public void setCelular(String celular) {
		Celular = celular;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
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