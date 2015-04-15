package testing;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class NodeLabel {

	public JLabel dado;
	public NodeLabel prox;
	
	public NodeLabel(JLayeredPane layeredPane, int x, int y, String text){
		dado = new JLabel(text);
		layeredPane.add(dado, "cell " + x + " " + y);
		prox = null;
	}
}
