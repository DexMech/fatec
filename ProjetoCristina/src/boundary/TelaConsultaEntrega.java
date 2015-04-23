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

import control.ControlaConsultaEntrega;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.Color;

import javax.swing.JTextField;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextPane;
import javax.swing.ImageIcon;

public class TelaConsultaEntrega extends JFrame {
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

	private ControlaConsultaEntrega control = new ControlaConsultaEntrega();
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
	public TelaConsultaEntrega() {
		setTitle("Consulta de Entregas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 811, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 113, 637, 246);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Caminh\u00E3o", "Cliente", "Nome do produto", "Fabricante", "Descri\u00E7\u00E3o", "Peso", "volume", "Data", "Quantidade", "Regi\u00E3o"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(185);
		table.getColumnModel().getColumn(2).setPreferredWidth(111);
		table.getColumnModel().getColumn(3).setPreferredWidth(111);
		scrollPane.setViewportView(table);

		JButton btnExportarCvs = new JButton("Exportar para Excel");
		btnExportarCvs.setIcon(new ImageIcon(TelaConsultaEntrega.class.getResource("/images/excel.png")));
		btnExportarCvs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getRowCount()>0){
					control.exporta(getTable(),getLabelgrava());

					labelgrava.setText(control.retornaString());

				}
			}
		});
		btnExportarCvs.setBounds(271, 378, 159, 32);
		contentPane.add(btnExportarCvs);

		JLabel labelCliente = new JLabel("Cliente");
		labelCliente.setBounds(24, 38, 57, 50);
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
		btnBuscar.setIcon(new ImageIcon(TelaConsultaEntrega.class.getResource("/images/busca.png")));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelgrava.setText("");
				
				 if(table.getRowCount()>0){
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
		btnBuscar.setBounds(572, 44, 117, 32);
		contentPane.add(btnBuscar);



		txtCliente = new JTextField();
		txtCliente.setEditable(true);
		txtCliente.setBounds(85, 50, 177, 27);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(TelaConsultaEntrega.class.getResource("/images/limpar.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.limpar(getTable(),getLabelgrava(),getTxtCliente(),getTxtdata());
			}
		});
		btnLimpar.setBounds(458, 378, 122, 32);
		contentPane.add(btnLimpar);

		labelgrava = new JLabel();
		labelgrava.setIcon(new ImageIcon(""));
		labelgrava.setFont(new Font("Arial", Font.PLAIN, 11));
		labelgrava.setForeground(Color.BLACK);
		labelgrava.setBounds(61, 358, 213, 25);
		contentPane.add(labelgrava);

		JButton btnNewButton = new JButton("Detalhes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				Object[] objeto = new Object[4];
				int a = 0;
				int recebe = table.getSelectedRow();
				while( a<4){

					objeto[a]=  table.getValueAt(recebe, a);
					a++;
					}
				new TelaConsultaEntregaDetalhada(objeto);
			}
			catch(ArrayIndexOutOfBoundsException e1){
				labelgrava.setText("Selecione um registro");
				
			}
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(673, 109, 101, 25);
		contentPane.add(btnNewButton);




		setVisible(true);
	}
}
