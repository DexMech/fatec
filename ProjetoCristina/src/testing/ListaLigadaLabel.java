package testing;

import javax.swing.JLayeredPane;

public class ListaLigadaLabel {

private NodeLabel inicio;
	
	public ListaLigadaLabel(){
		inicio = null;
	}
	
	public void adicionaLabel(JLayeredPane layeredPane, int x, int y, String text){
		NodeLabel novo = new NodeLabel(layeredPane, x, y, text);
		novo.prox = inicio;
		inicio = novo;
	}
}
