package controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TelaRomaneio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRomaneio frame = new TelaRomaneio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaRomaneio() {
		setTitle("Tela de romaneio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(33, 55, 264, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(33, 157, 264, 148);
		contentPane.add(textArea);
		
		textField_1 = new JTextField();
		textField_1.setBounds(489, 55, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(489, 155, 114, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(489, 241, 86, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.setBounds(555, 378, 117, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Gravar");
		btnNewButton_1.setBounds(410, 378, 117, 25);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Nome do Produto");
		lblNewLabel.setBounds(37, 28, 135, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Peso");
		lblNewLabel_1.setBounds(489, 28, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Descrição");
		lblNewLabel_2.setBounds(37, 130, 70, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade");
		lblNewLabel_3.setBounds(489, 128, 100, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Volume");
		lblNewLabel_4.setBounds(489, 217, 70, 15);
		contentPane.add(lblNewLabel_4);
	}
}
