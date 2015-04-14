package controller;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.TextEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;

public class TelaRomaneio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField NomeProduto;
	private JTextField Peso;
	private JTextField Quantidade;
	private JTextField Volume;
	private JTextArea textArea;
    private JFormattedTextField TxtCep;
    private MaskFormatter mascara;
	/**
	 * Launch the application.
	 */


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
		
		NomeProduto = new JTextField();
		NomeProduto.setBounds(33, 55, 264, 19);
		contentPane.add(NomeProduto);
		NomeProduto.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 157, 264, 148);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		Peso = new JTextField();
		Peso.setBounds(500, 156, 114, 19);
		contentPane.add(Peso);
		Peso.setColumns(10);
		
		Quantidade = new JTextField();
		Quantidade.setBounds(500, 228, 114, 19);
		contentPane.add(Quantidade);
		Quantidade.setColumns(10);
		
		Volume = new JTextField();
		Volume.setBounds(503, 286, 86, 19);
		contentPane.add(Volume);
		Volume.setColumns(10);
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(555, 378, 117, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Gravar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedWriter escreve = new BufferedWriter(new FileWriter("romaneio.txt",true));
					BufferedReader le = new BufferedReader(new FileReader("romaneio.txt"));
					boolean acha = true;
					while(le.ready()){
						if(le.readLine().contains(NomeProduto.getText())){
						acha = false;	
						}
						
					}
					
					if(acha){
						escreve.append(TxtCep.getText()+";");
						escreve.append(NomeProduto.getText()+";");
						escreve.append(Peso.getText()+";");
						escreve.append(Quantidade.getText()+";");
						escreve.append(Volume.getText()+";");
						escreve.append(textArea.getText()+";");		
						
						
						escreve.newLine();
						JOptionPane.showMessageDialog(null, "Gravado com sucesso","Gravado com sucesso",JOptionPane.INFORMATION_MESSAGE);
						escreve.close();
						le.close();
						
					}
					else{
						JOptionPane.showMessageDialog(null, "ja existe","existe",JOptionPane.WARNING_MESSAGE);
						
					}
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			
				
				
				
				
				}
			
		});
		btnNewButton_1.setBounds(281, 378, 117, 25);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Nome do Produto");
		lblNewLabel.setBounds(37, 28, 135, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Peso");
		lblNewLabel_1.setBounds(500, 129, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Descrição");
		lblNewLabel_2.setBounds(37, 130, 70, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade");
		lblNewLabel_3.setBounds(503, 201, 100, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Volume");
		lblNewLabel_4.setBounds(504, 259, 70, 15);
		contentPane.add(lblNewLabel_4);
		
		try {
			mascara = new MaskFormatter("#####-###");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 TxtCep = new JFormattedTextField(mascara);
			TxtCep.setBounds(500, 106, 104, 19);
			contentPane.add(TxtCep);
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaInicial TelaVoltaInicial = new TelaInicial();
				TelaVoltaInicial.setLocationRelativeTo(null);
				TelaVoltaInicial.setVisible(true);
				
			}
		});
		btnVoltar.setBounds(426, 378, 117, 25);
		contentPane.add(btnVoltar);
		
		JLabel lblCepEntrega = new JLabel("Cep Entrega");
		lblCepEntrega.setBounds(500, 79, 103, 15);
		contentPane.add(lblCepEntrega);
		
		IndexTabulacao tab = new IndexTabulacao();
		tab.addIndexedComponent(NomeProduto);
		tab.addIndexedComponent(TxtCep);
		tab.addIndexedComponent(Peso);
		tab.addIndexedComponent(Quantidade);
		tab.addIndexedComponent(Volume);
		
		setFocusTraversalPolicy(tab);
}
}
