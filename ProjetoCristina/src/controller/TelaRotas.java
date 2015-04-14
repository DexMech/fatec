package controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TelaRotas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public TelaRotas() {
		setTitle("Tela de Rotas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JButton btnNewButton = new JButton("Gerar Rotas");
		
		btnNewButton.setBounds(589, 368, 117, 25);
		contentPane.add(btnNewButton);
		
		comboBox = new JComboBox();
		comboBox.setBounds(12, 368, 174, 24);
		contentPane.add(comboBox);
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				List<String> recebe_motorista = new ArrayList();
				String linha;
				String[] recebe;
				int i = 0;
				try {
					BufferedReader le = new BufferedReader(new FileReader("motoristas.txt"));
					while(le.ready()){
						linha = le.readLine();
						recebe = linha.split(";");
						recebe_motorista.add(recebe[0]);
						
					}
					for(String nome :recebe_motorista){
						comboBox.addItem(nome);
						
					}
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
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
		scrollPane.setBounds(53, 22, 653, 325);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cep", "Nome do Produto", "Peso", "Quantidade", "Volume", "Descri\u00E7\u00E3o"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(343);
		table.getColumnModel().getColumn(5).setPreferredWidth(280);
		scrollPane.setViewportView(table);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				String linha;
				try {
					BufferedReader le = new BufferedReader(new FileReader("romaneio.txt"));
					while(le.ready()){
					linha =le.readLine();
					Object[] objeto = linha.split(";");
					modelo.addRow(objeto);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
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

	
}
