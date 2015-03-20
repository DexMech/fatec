package controller;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;

public class TelaInicial extends JFrame {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setTitle("Tela Inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("TelaRotas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaRotas telaRotas = new TelaRotas();
				telaRotas.setLocationRelativeTo(null);
				telaRotas.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(52, 108, 117, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("TelaMotoristas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaMotoristas telaMotorista = new TelaMotoristas();
				telaMotorista.setLocationRelativeTo(null);
				telaMotorista.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(212, 108, 117, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("TelaRomaneio");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaRomaneio telaRomaneio = new TelaRomaneio();
				telaRomaneio.setLocationRelativeTo(null);
				telaRomaneio.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(370, 108, 117, 25);
		contentPane.add(btnNewButton_2);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		btnSair.setBounds(212, 232, 117, 25);
		contentPane.add(btnSair);
	}
}
