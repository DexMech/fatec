package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

import control.ControlaLeituraDetalhada;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import java.awt.Color;

public class ConsultaEntregaDetalhada extends JFrame {

	private JTextArea textArea;
private Object[] objeto;
	private JPanel contentPane;
	


	public JTextArea getTextArea() {
		return textArea;
	}


	public ConsultaEntregaDetalhada(Object[] objetos) {
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
		textArea.setBackground(new Color(240, 248, 255));
		textArea.setForeground(Color.BLACK);
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
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
