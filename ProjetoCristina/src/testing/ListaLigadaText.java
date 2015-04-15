package testing;

import javax.swing.JLayeredPane;

public class ListaLigadaText {
	
	private NodeText inicio;
	
	public ListaLigadaText(){
		inicio = null;
	}
	
	public void adicionaText(JLayeredPane layeredPane, int x, int y){
		NodeText novo = new NodeText(layeredPane, x, y);
		novo.prox = inicio;
		inicio = novo;
	}
}
