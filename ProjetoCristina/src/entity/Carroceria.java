package entity;

/**
 * @author Arthur Gomes
 * @version 1.0
 * 
 * <ul><h3>Versões:<h3>
 * 		<li>1.0 - Criação da classe. Retirada de responsabilidades da classe Motorista.</li>
 * 		<li>1.1 - Retirado o tipo <code>abstract</code> da classe.</li>
 * </ul>
 * 
 * Classe Carroceria, que faz parte do caminhão e será gravado em Motorista.txt*/

public class Carroceria {
	
	private int peso;
	private double largura;
	private double altura;
	private double comprimento;
	private double volume;
	private String nome;

	public int getPeso(){
		return peso;
	}
	
	public void setPeso(String text){
		if (text.equals("Carroceria tipo ba�(4.000 kg)"))
			this.peso = 4000;
		else if (text.equals("Carroceria tipo ba�(6.000 kg)"))
			this.peso = 6000;
		else if (text.equals("Dry Van(20)") || text.equals("Bulk(20)") || text.equals("Ventilated"))
			this.peso = 28100;
		else if (text.equals("Open Top(20)"))
			this.peso = 21980;
		else if (text.equals("Reefer(20)"))
			this.peso = 24000;
		else if (text.equals("Platform(20)"))
			this.peso = 21900;
		else if (text.equals("Dry Van(40)") || text.equals("Bulk(40)"))
			this.peso = 26650;
		else if (text.equals("Dry High Cube"))
			this.peso = 26200;
		else if (text.equals("Open Top(40)"))
			this.peso = 26870;
		else if (text.equals("Reefer(40)") || text.equals("Port Hole"))
			this.peso = 30500;
		else if (text.equals("Platform(40)"))
			this.peso = 40800;
		else if (text.equals("Flat Track"))
			this.peso = 40650;
		else
			this.peso = 0;
	}
	
	public double getAltura(){
		return altura;
	}
	
	/**
	 * A classe @class <b>setAltura</b> recebe um parâmetro @param text do tipo <code>String</code>,
	 * recebido de acordo com a escolha do tipo de carroceria. */
	
	public void setAltura(String text){
		if (text.equals("Carroceria tipo sider tamanho padr�o") || text.equals("Carroceria tipo sider semi reboque "))
			this.altura = 3;
		else if (text.equals("Carroceria tipo ba�(4.000 kg)"))
			this.altura = 2.2;
		else if (text.equals("Carroceria tipo ba�(6.000 kg)"))
			this.altura = 2.63;
		else if (text.equals("Carroceria tipo ba� semi reboque"))
			this.altura = 2.73;
		else if (text.equals("Dry Van(20)") || text.equals("Bulk(20)") || text.equals("Ventilated"))
			this.altura = 2.4;
		else if (text.equals("Open Top(20)"))
			this.altura = 2.312;
		else if (text.equals("Reefer(20)"))
			this.altura = 2.247;
		else if (text.equals("Platform(20)") || text.equals("Platform(40)"))
			this.altura = 0; //sem altura definida
		else if (text.equals("Dry Van(40)") || text.equals("Bulk(40)"))
			this.altura = 2.362;
		else if (text.equals("Dry High Cube"))
			this.altura = 2.690;
		else if (text.equals("Open Top(40)"))
			this.altura = 2.279;
		else if (text.equals("Reefer(40)") || text.equals("Port Hole"))
			this.altura = 2.2;
		else if (text.equals("Flat Track"))
			this.altura = 2.314;
	}
	
	public double getLargura(){
		return largura;
	}
	
	/**
	 * A classe @class <b>setLargura</b> recebe um parâmetro @param text do tipo <code>String</code>,
	 * recebido de acordo com a escolha do tipo de carroceria. 
	 */
	
	public void setLargura(String text){
		if (text.equals("Carroceria tipo sider tamanho padrão"))  
			this.largura = 2.46;
		else if (text.equals("Carroceria tipo sider semi reboque "))
			this.largura = 2.51;
		else if (text.equals("Carroceria tipo ba�(4.000 kg)"))
			this.largura = 2.08;
		else if (text.equals("Carroceria tipo ba�(6.000 kg)") || text.equals("Carroceria tipo ba� semi reboque"))
			this.largura = 2.48;
		else if (text.equals("Dry Van(20)") || text.equals("Bulk(20)") || text.equals("Ventilated") || text.equals("Open Top(20)") ||
				text.equals("Dry Van(40)") || text.equals("Bulk(40)") || text.equals("Dry High Cube"))
			this.largura = 2.345;
		else if (text.equals("Reefer(20)"))
			this.largura = 2.26;
		else if (text.equals("Platform(20)") || text.equals("Platform(40)"))
			this.largura = 0; //sem largura definida
		else if (text.equals("Open Top(40)"))
			this.largura = 2.332;
		else if (text.equals("Reefer(40)") || text.equals("Port Hole"))
			this.largura = 2.27;
		else if (text.equals("Flat Track"))
			this.largura = 2.263;
	}
	
	public double getComprimento(){
		return comprimento;
	}
	
	/**
	 * A classe @class <b>setComprimento</b> recebe um parâmetro @param text do tipo <code>String</code>,
	 * recebido de acordo com a escolha do tipo de carroceria. 
	 */
	
	public void setComprimento(String text){
		if (text.equals("Carroceria tipo sider tamanho padr�o")) 
			this.comprimento = 7.65;
		else if (text.equals("Carroceria tipo sider semi reboque "))
			this.comprimento = 14.86;
		else if (text.equals("Carroceria tipo ba�(4.000 kg)"))
			this.comprimento = 5.32;
		else if (text.equals("Carroceria tipo ba�(6.000 kg)"))
			this.comprimento = 7.32;
		else if (text.equals("Carroceria tipo ba� semi reboque"))
			this.comprimento = 14.94;
		else if (text.equals("Dry Van(20)") || text.equals("Bulk(20)") || text.equals("Ventilated"))
			this.comprimento = 5.89;
		else if (text.equals("Open Top(20)"))
			this.comprimento = 5.889;
		else if (text.equals("Reefer(20)"))
			this.comprimento = 5.45;
		else if (text.equals("Platform(20)") || text.equals("Platform(40)"))
			this.comprimento = 0; //sem comprimento definido
		else if (text.equals("Dry Van(40)") || text.equals("Bulk(40)") || text.equals("Dry High Cube"))
			this.comprimento = 12.015;
		else if (text.equals("Open Top(40)"))
			this.comprimento = 12.302;
		else if (text.equals("Reefer(40)") || text.equals("Port Hole"))
			this.comprimento = 11.55;
		else if (text.equals("Flat Track"))
			this.comprimento = 12.066;
	}
	
	public double getVolume(){
		return volume;
	}
	
	/**
	 * Volume calculado com fórmula: 
	 * <center>{@code Altura * Largura * Comprimento}</center>.
	 */
	
	public void setVolume(){
		this.volume = (double) getAltura() * getLargura() * getComprimento();
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
}
