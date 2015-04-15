package testing;

import javax.swing.JLayeredPane;
import javax.swing.JTextField;

public class NodeText {

	public JTextField dado;
	public NodeText prox;
	
	public NodeText(JLayeredPane layeredPane, int x, int y){
		dado = new JTextField("");
		dado.setColumns(10);
		layeredPane.add(dado, "cell " + x + " " + y + ",growx");
		prox = null;
	}
}
