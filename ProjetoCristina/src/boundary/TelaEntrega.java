package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import control.ControleTelaEntregas;
import control.MotoristaControle;
import control.ValidarData;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


public class TelaEntrega extends JFrame {

	private JPanel contentPane;
	private MaskFormatter mascara;
	private JComboBox cbCliente, cbProduto;
	private JFormattedTextField formattedTextField;
	
	public JComboBox getCbProduto() {
		return cbProduto;
	}

	private ControleTelaEntregas con=new ControleTelaEntregas(getCbCliente(), getCbProduto(), getTable(),getTextField(),getFormattedTextField());
	private JTable table;
	private JTextField textField;

	public JTable getTable() {
		return table;
	}

	/**
	 * Create the frame.
	 */
	public TelaEntrega() {
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				con = new ControleTelaEntregas(getCbCliente(), getCbProduto(),getTable(),getTextField(),getFormattedTextField());
				con.ler();

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
		setTitle("Cadastro de Entrega");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(565, 487);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(20, 20, 56, 16);
		contentPane.add(lblCliente);

		Icon iconbuscar = new ImageIcon("images\\buscar.png");

		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(20, 80, 126, 16);
		contentPane.add(lblProduto);

		try {
			mascara = new MaskFormatter("##/##/####");
			mascara.setValidCharacters("0123456789");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		setVisible(true);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(435, 391, 107, 32);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con = new ControleTelaEntregas(getCbCliente(), getCbProduto(),getTable(),getTextField(),getFormattedTextField());
				con.limpar(); 		
			}
		});
		getContentPane().add(btnLimpar);

		JButton btnGravar = new JButton("Gravar");
		btnGravar.setIcon(new ImageIcon(TelaEntrega.class.getResource("/images/save.png")));
		btnGravar.setBounds(261, 391, 132, 32);
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(btnGravar);

		cbCliente = new JComboBox();
		cbCliente.setBounds(20, 47, 180, 20);
		contentPane.add(cbCliente);

		cbProduto = new JComboBox();
		cbProduto.setBounds(20, 109, 180, 20);
		contentPane.add(cbProduto);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 144, 533, 211);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome do Produto", "Fabricante", "Descri\u00E7\u00E3o", "Peso", "volume", "Data", "Quantidade"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnBuscar = new JButton("Adicionar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con = new ControleTelaEntregas(getCbCliente(), getCbProduto(),getTable(),getTextField(),getFormattedTextField());
				con.preencher();
			}
		});
		btnBuscar.setBounds(221, 107, 117, 25);
		contentPane.add(btnBuscar);
		
		 formattedTextField = new JFormattedTextField(mascara);
		formattedTextField.setBounds(233, 48, 147, 19);
		contentPane.add(formattedTextField);
		
		textField = new JTextField();
		textField.setBounds(422, 48, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Data");
		lblNewLabel.setBounds(232, 21, 70, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quantidade");
		lblNewLabel_1.setBounds(422, 21, 120, 15);
		contentPane.add(lblNewLabel_1);


	}

	public JFormattedTextField getFormattedTextField() {
		return formattedTextField;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JComboBox getCbCliente() {
		return cbCliente;
	}
}
