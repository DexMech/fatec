package entity;

public class ListaLigadaNomes {
	
	public Node inicio;
	public String items[];
	
	public ListaLigadaNomes(){
		inicio = null;
	}
	
	/**
	 * Adiciona no inicio
	 */
	public void addInicio(String e){
		Node novo = new Node(e);
		novo.prox = inicio;
		inicio = novo;
	}
	
	
	public int contador(){
		int cta = 0;
		
		if (inicio != null){
			Node aux = inicio;
			
			while (aux != null){
				cta ++;
				aux = aux.prox;
			}
		}
		
		return cta;
	}
	
	public String [] retornoCb(){
		items = new String[contador()];
		
		int cta = 0;
		
		if (inicio != null){
			Node aux = inicio;
			
			while (aux != null){
				items[cta] = aux.dado;
				aux = aux.prox;
				cta ++;
			}
		}
		
		return items;
	}
}
