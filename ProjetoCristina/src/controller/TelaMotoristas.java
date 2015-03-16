package controller;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

public class TelaMotoristas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 */
	public TelaMotoristas() {
		setTitle("Tela de Motoristas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(31, 75, 211, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(31, 171, 211, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(31, 275, 114, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(31, 349, 114, 24);
		comboBox.addItem("A");
		comboBox.addItem("B");
		comboBox.addItem("A/B");
		comboBox.addItem("C");
		comboBox.addItem("D");
		comboBox.addItem("E");
		
		contentPane.add(comboBox);
		
		textField_3 = new JTextField();
		textField_3.setBounds(490, 75, 160, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Gravar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(320, 362, 117, 25);
		contentPane.add(btnNewButton);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(584, 362, 117, 25);
		contentPane.add(btnSair);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(34, 48, 70, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Endereço");
		lblNewLabel_1.setBounds(31, 144, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone");
		lblNewLabel_2.setBounds(34, 248, 70, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CNH");
		lblNewLabel_3.setBounds(34, 322, 70, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo de Veículo");
		lblNewLabel_4.setBounds(490, 48, 126, 15);
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(490, 160, 126, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Placa do Veículo");
		lblNewLabel_5.setBounds(490, 133, 126, 15);
		contentPane.add(lblNewLabel_5);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaInicial TelaVoltaInicial = new TelaInicial();
				TelaVoltaInicial.setLocationRelativeTo(null);
				TelaVoltaInicial.setVisible(true);
				
			}
		});
		btnVoltar.setBounds(455, 362, 117, 25);
		contentPane.add(btnVoltar);
	}
}
