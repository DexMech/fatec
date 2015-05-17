package boundary;
/**
 * @author Alex Carlos
 * @version 1.x
 * 
 **/
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import control.ControlaLeituraDetalhada;
import java.awt.Font;

public class TelaConsultaEntregaDetalhada extends JFrame {

	private JTextArea textArea;
	private Object[] objeto;
	private JPanel contentPane;
	

/**
 * metodo que retorna o componente textArea
 * @return
 */
	public JTextArea getTextArea() {
		return textArea;
	}

/**
 * Método contrutor da classe, que recebe como parâmetro um vetor de objetos
 * @param objetos
 */
	public TelaConsultaEntregaDetalhada(Object[] objetos) {
		setTitle("Detalhes do Pedido");
	this.objeto =objetos;
	setVisible(true);
	setResizable(false);
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 555, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 38, 525, 291);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textArea.setBackground(new Color(240, 248, 255));
		textArea.setForeground(Color.BLACK);
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		/**
		 * método acionado ao abrir a janela
		 */
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				/**
				 * Cria uma novo instancia de ControlaLeituraDetalhada, passando como
				 * parâmetro um vetor de objetos e um componente TextArea e invocando o método preenche 
				 */
				new ControlaLeituraDetalhada(objeto,getTextArea()).preenche();
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
