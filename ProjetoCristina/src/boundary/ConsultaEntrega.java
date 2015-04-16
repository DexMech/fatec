package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import control.ControlaLeituraEntrega;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.Color;

import javax.swing.JTextField;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextPane;

public class ConsultaEntrega extends JFrame {
	private JLabel labelgrava;




	public JLabel getLabelgrava() {
		return labelgrava;
	}

	private JPanel contentPane;
	public JTable table;
	private JLabel labelControl;
	private JTextField txtCliente;
	private MaskFormatter mascara;
	private JFormattedTextField txtdata;
	public JFormattedTextField getTxtdata() {
		return txtdata;
	}

	private ControlaLeituraEntrega control = new ControlaLeituraEntrega();
	public JTextField getTxtCliente() {
		return txtCliente;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}


	/**
	 * Create the frame.
	 */
	public ConsultaEntrega() {
		setTitle("Consulta de Entregas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 466);
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

				control.sair();

			}
		});
		btnSair.setBounds(572, 385, 117, 25);
		contentPane.add(btnSair);

		JButton btnExportarCvs = new JButton("Exportar cvs");
		btnExportarCvs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getRowCount()>0){
					control.exporta(getTable(),getLabelgrava());
				}
			}
		});
		btnExportarCvs.setBounds(54, 385, 117, 25);
		contentPane.add(btnExportarCvs);

		JLabel labelCliente = new JLabel("Cliente");
		labelCliente.setBounds(51, 38, 57, 50);
		contentPane.add(labelCliente);
		try {
			mascara = new MaskFormatter("##/##/####");
			mascara.setValidCharacters("0123456789");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		txtdata = new JFormattedTextField(mascara);
		txtdata.setBounds(398, 50, 122, 27);
		contentPane.add(txtdata);

		JLabel labelData = new JLabel("Data");
		labelData.setBounds(356, 38, 39, 50);
		contentPane.add(labelData);
		labelControl = new JLabel("");
		labelControl.setFont(new Font("Arial", Font.BOLD, 9));
		labelControl.setForeground(Color.RED);
		labelControl.setBounds(447, 6, 186, 15);
		contentPane.add(labelControl);
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtCliente.getText().isEmpty()||txtdata.getText().isEmpty()){

					labelControl.setText("*preencha os campos");

				}
				else if(table.getRowCount()>0){
					int j = 1;
					for(int i = 0;i<table.getRowCount()-1;i++){  

						if(table.getValueAt(i,j).toString().equals(txtCliente.getText())){  

						}  


					}
				}
				else{

					control.busca(txtCliente.getText(),txtdata.getText(),getTable());

				}

			}
		});
		btnBuscar.setBounds(572, 51, 117, 25);
		contentPane.add(btnBuscar);



		txtCliente = new JTextField();
		txtCliente.setBounds(110, 50, 122, 27);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.limpar(getTable(),getLabelgrava(),getTxtCliente(),getTxtdata());
			}
		});
		btnLimpar.setBounds(296, 385, 117, 25);
		contentPane.add(btnLimpar);

		labelgrava = new JLabel();
		labelgrava.setFont(new Font("Arial", Font.PLAIN, 9));
		labelgrava.setForeground(Color.RED);
		labelgrava.setBounds(204, 390, 157, 15);
		contentPane.add(labelgrava);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaInicial();
			}
		});
		btnVoltar.setBounds(435, 385, 117, 25);
		contentPane.add(btnVoltar);
		JTextPane textPane = new JTextPane();
		textPane.setBounds(51, 89, 637, 33);
		contentPane.add(textPane);
		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] objeto = new Object[4];
				int a = 0;
				int recebe = table.getSelectedRow();
				while( a<4){
					
				 objeto[a]=  table.getValueAt(recebe, a);
					a++;
					
					
					
				}
				new ConsultaEntregaDetalhada(objeto);
			}
		});
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBounds(700, 109, 49, 25);
		contentPane.add(btnNewButton);
		
		


		setVisible(true);
	}
}
