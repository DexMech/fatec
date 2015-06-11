package boundary;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;

import control.ControlaTelaRota;
import control.ListaCeps;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JComboBox;

public class TelaRota extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox ComboMot;
	private JFormattedTextField txtdata;
	public JComboBox getComboMot() {
		return ComboMot;
	}

	public JFormattedTextField getTxtdata() {
		return txtdata;
	}

	public JTable getTable() {
		return table;
	}

	private JTable table;
	private MaskFormatter mascara;

	/**
	 * Launch the application.
	 */

				
		

	/**
	 * Create the frame.
	 */
	public TelaRota() {
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				new ControlaTelaRota().Pegamotorista(getComboMot());
				try {
					ListaCeps lc = new ListaCeps();
					lc.calculoDistancias();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
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
		setVisible(true);
		setTitle("Roteirização");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 806, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ControlaTelaRota().rota(getTable(),ComboMot,getTxtdata());
			}
		});
		btnBuscar.setBounds(206, 119, 117, 28);
		contentPane.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 171, 752, 232);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cliente", "Cep", "Dist\u00E2ncia at\u00E9 a entrega", "Lista de Produtos"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(26, 45, 70, 15);
		contentPane.add(lblData);
		
		JLabel lblMotorista = new JLabel("Motorista");
		lblMotorista.setBounds(30, 99, 70, 15);
		contentPane.add(lblMotorista);
		try {
			mascara = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtdata = new JFormattedTextField(mascara);
		txtdata.setBounds(30, 66, 140, 25);
		contentPane.add(txtdata);
		
		 ComboMot = new JComboBox();
		ComboMot.setBounds(29, 121, 140, 24);
		contentPane.add(ComboMot);
	}
}
