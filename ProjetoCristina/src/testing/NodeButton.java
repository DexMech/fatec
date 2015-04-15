package testing;

import javax.swing.JButton;
import javax.swing.JLayeredPane;

public class NodeButton {

	public JButton dado;
	public NodeButton prox;
	
	public NodeButton(JLayeredPane layeredPane, int x){
		dado = new JButton("Search");
		layeredPane.add(dado, "cell 1 " + x);
		prox = null;
	}
}
