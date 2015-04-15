package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import controller.ControlaLeituraEntrega;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import javax.swing.JTextField;

public class ConsultaEntrega extends JFrame {

	private JPanel contentPane;
	public JTable table;
	private JLabel labelControl;
	private JTextField txtCliente;
	public JTextField getTxtCliente() {
		return txtCliente;
	}

	private JTextField txtdata;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaEntrega frame = new ConsultaEntrega();
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
	public ConsultaEntrega() {
		setTitle("Consulta de Entregas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 109, 637, 246);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Regi\u00E3o", "Cliente", "Caminh\u00E3o", "Data"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			new ControlaLeituraEntrega().sair();
			
			}
		});
		btnSair.setBounds(572, 385, 117, 25);
		contentPane.add(btnSair);
		
		JButton btnExportarCvs = new JButton("Exportar cvs");
		btnExportarCvs.setBounds(54, 385, 117, 25);
		contentPane.add(btnExportarCvs);
		
		JLabel labelCliente = new JLabel("Cliente");
		labelCliente.setBounds(51, 38, 57, 50);
		contentPane.add(labelCliente);
		
		JLabel labelData = new JLabel("Data");
		labelData.setBounds(356, 38, 39, 50);
		contentPane.add(labelData);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(getTxtCliente());
				ControlaLeituraEntrega c = new ControlaLeituraEntrega();
				
				c.busca();
				
			}
		});
		btnBuscar.setBounds(572, 51, 117, 25);
		contentPane.add(btnBuscar);
		
		JLabel labelControl = new JLabel("");
		labelControl.setForeground(Color.RED);
		labelControl.setBounds(447, 6, 60, 15);
		contentPane.add(labelControl);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(100, 50, 122, 27);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);
		
		txtdata = new JTextField();
		txtdata.setBounds(397, 50, 122, 27);
		contentPane.add(txtdata);
		txtdata.setColumns(10);
	}
}
