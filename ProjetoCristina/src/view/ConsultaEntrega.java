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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaEntrega extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
		scrollPane.setViewportView(table);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnSair.setBounds(572, 385, 117, 25);
		contentPane.add(btnSair);
		
		JButton btnExportarCvs = new JButton("Exportar cvs");
		btnExportarCvs.setBounds(54, 385, 117, 25);
		contentPane.add(btnExportarCvs);
		
		JComboBox comboCliente = new JComboBox();
		comboCliente.setBounds(113, 51, 117, 24);
		contentPane.add(comboCliente);
		
		JComboBox comboData = new JComboBox();
		comboData.setBounds(413, 51, 116, 24);
		contentPane.add(comboData);
		
		JLabel labelCliente = new JLabel("Cliente");
		labelCliente.setBounds(51, 38, 57, 50);
		contentPane.add(labelCliente);
		
		JLabel labelData = new JLabel("Data");
		labelData.setBounds(356, 38, 39, 50);
		contentPane.add(labelData);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(572, 51, 117, 25);
		contentPane.add(btnBuscar);
	}
}
