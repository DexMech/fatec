package boundary;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;

import control.ControleTelaRota;
import control.ControleListaCeps;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JComboBox;

import java.awt.Font;

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
				new ControleTelaRota().Pegamotorista(getComboMot());
				try {
					ControleListaCeps lc = new ControleListaCeps();
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
				new ControleTelaRota().rota(getTable(),ComboMot,getTxtdata());
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
		txtdata.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(table.getRowCount()==0){
				new ControleTelaRota().PegaPorData("src/BD/EntregaMot.txt", getTable(),txtdata);
				}
			
			}
			@Override
			public void focusGained(FocusEvent e) {
				txtdata.setForeground(Color.BLUE);
				
			}
		});
		
		 ComboMot = new JComboBox();
		ComboMot.setBounds(29, 121, 140, 24);
		contentPane.add(ComboMot);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ControleTelaRota().limpar(getTable());
			}
		});
		btnLimpar.setBounds(658, 427, 117, 25);
		contentPane.add(btnLimpar);
		
		JLabel lblAperteTabAps = new JLabel("* aperte tab após preencher a data");
		lblAperteTabAps.setFont(new Font("Dialog", Font.BOLD, 9));
		lblAperteTabAps.setForeground(Color.RED);
		lblAperteTabAps.setBounds(188, 71, 260, 20);
		contentPane.add(lblAperteTabAps);
	}
}
