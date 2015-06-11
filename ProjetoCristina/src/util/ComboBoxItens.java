package util;

/**
 * @author Arthur Gomes
 * @version 1.0
 * 
 * <ul><h3>Versões</h3>
 * 		<li>1.0 - Criação da classe</li>
 * </ul>
 * 
 * Interface de constantes.*/

public interface ComboBoxItens {

	/**
	 * Constante para preencher os Estados para as placas de caminhões*/
	public final String [] ESTADOS = {"Acre - AC", 
		"Alagoas - AL",
		"Amapá - AP",
		"Amazonas - AM",
		"Bahia - BA",
		"Ceará - CE",
		"Distrito Federal - DF",
		"Espírito Santo - ES",
		"Goiás - GO",
		"Maranhão - MA",
		"Mato Grosso - MT",
		"Mato Grosso do Sul - MS",
		"Minas Gerais - MG",
		"Pará - PA",
		"Paraíba - PB",
		"Paraná - PR",
		"Pernambuco - PE",
		"Piauí - PI",
		"Rio de Janeiro - RJ",
		"Rio Grande do Norte - RN",
		"Rio Grande do Sul - RS",
		"Rondônia - RO",
		"Roraima - RR",
		"Santa Catarina - SC",
		"São Paulo - SP",
		"Sergipe - SE",
		"Tocantins - TO"};
	
	/**
	 * Constante para preencher os tipos de caminhão*/
	public final String VEICULO[] = { "Toco", "Truck", "Carreta 2 Eixos",
			"Carreta Baú", "Carreta 3 Eixos", "Carreta Cavalo Truckado",
			"Carreta Cavalo Truckado Baú", "Bi-trem(Treminhão) - 7 eixos" };
	
	/**
	 * Constante para preencher as carrocerias*/
	public final String CARROCERIA[] = {
			"Carroceria tipo sider tamanho padrão",
			"Carroceria tipo sider semi reboque ",
			"Carroceria tipo baú(4.000 kg)", "Carroceria tipo baú(6.000 kg)",
			"Carroceria tipo baú semi reboque", "Dry Van(20)", "Bulk(20)",
			"Ventilated", "Open Top(20)", "Reefer(20)", "Platform(20)",
			"Dry Van(40)", "Bulk(40)", "Dry High Cube", "Open Top(40)",
			"Reefer(40)", "Port Hole", "Platform(40)", "Flat Track" };
}
