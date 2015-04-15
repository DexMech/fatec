package testing;

import javax.swing.JLayeredPane;

public class ListaLigadaButton {

private NodeButton inicio;
	
	public ListaLigadaButton(){
		inicio = null;
	}
	
	public void adicionaButton(JLayeredPane layeredPane, int x){
		NodeButton novo = new NodeButton(layeredPane, x);
		novo.prox = inicio;
		inicio = novo;
	}
}
