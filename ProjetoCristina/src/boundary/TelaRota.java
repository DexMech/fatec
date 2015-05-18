package boundary;
/**
 * @author Alex Carlos
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
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

public class TelaRota extends JFrame {

	private JPanel contentPane;
	private JTextField txtmotorista;
	private JTable table;
	private MaskFormatter mascara;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRota frame = new TelaRota();
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
	public TelaRota() {
		setTitle("Roteirização");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtmotorista = new JTextField();
		txtmotorista.setBounds(30, 125, 114, 19);
		contentPane.add(txtmotorista);
		txtmotorista.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(179, 122, 117, 25);
		contentPane.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 171, 551, 232);
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
		
		JLabel lblTotal = new JLabel("New label");
		lblTotal.setBounds(39, 415, 70, 15);
		contentPane.add(lblTotal);
		
		JLabel lblKm = new JLabel("New label");
		lblKm.setBounds(323, 415, 70, 15);
		contentPane.add(lblKm);
		
		JLabel lblTotProduto = new JLabel("New label");
		lblTotProduto.setBounds(469, 415, 70, 15);
		contentPane.add(lblTotProduto);
		
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
		JFormattedTextField formattedTextField = new JFormattedTextField(mascara);
		formattedTextField.setBounds(30, 72, 114, 19);
		contentPane.add(formattedTextField);
	}
}
