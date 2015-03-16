package controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRotas extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public TelaRotas() {
		setTitle("Tela de Rotas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Gerar Rotas");
		btnNewButton.setBounds(589, 368, 117, 25);
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(69, 368, 117, 24);
		contentPane.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Imprimir");
		btnNewButton_1.setBounds(198, 368, 117, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
			}
		});
		btnSair.setBounds(460, 368, 117, 25);
		contentPane.add(btnSair);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 22, 628, 325);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaInicial TelaVoltaInicial = new TelaInicial();
				TelaVoltaInicial.setLocationRelativeTo(null);
				TelaVoltaInicial.setVisible(true);
			}
		});
		btnVoltar.setBounds(327, 368, 117, 25);
		contentPane.add(btnVoltar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
