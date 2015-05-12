package entity;

/**
 * @author Arthur Gomes
 * @version 1.5
 * 
 * <ul><h3>Versões:</h3> 
 * 	 <li>1.0 - Criação da classe.</li>
 * 	 <li>1.1 - Divisão das propriedades da classe em Motorista, Caminhão e Carroceria.</li>
 * 	 <li>1.2 - Adicionado RG e CPF</li>
 *   <li>1.3 - Mudança no nome da variável telefone 2 para celular</li>
 *   <li>1.4 - Retirado o tipo <code>abstract</code> da classe.</li>
 *   <li>1.5 - Adicionado herança com a classe pessoa.</li>
 * </ul>
 * 
 * Entidade motorista, que será gravada no Motorista.txt juntamente com as classes Caminhão e Carroceria*/

public class Motorista extends Pessoa{

	private String cnh;
	private String rg;
	private String cpf;
	private String validade;
	
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	public String getValidade() {
		return validade;
	}
	public void setValidade(String validade) {
		this.validade = validade;
	}
	
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}