package boundary;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;

public class TelaInicial extends JFrame {

	public TelaInicial(){
		setSize(440,467);
		setTitle("RotaMax - Roteirização");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Cadastrar \nMotorista");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new TelaMotorista();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 53, 154, 56);
		getContentPane().add(btnNewButton);
		
		JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					new TelaCliente();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCadastrarCliente.setBounds(270, 53, 154, 56);
		getContentPane().add(btnCadastrarCliente);
		
		JButton btnVerEntregas = new JButton("Visualizar Entregas");
		btnVerEntregas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new ConsultaEntrega().setLocationRelativeTo(null);
			}
		});
		btnVerEntregas.setBounds(10, 272, 154, 56);
		getContentPane().add(btnVerEntregas);
		
		JButton btnAbrirExcel = new JButton("Abrir Excel");
		btnAbrirExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAbrirExcel.setBounds(10, 372, 154, 45);
		getContentPane().add(btnAbrirExcel);
		
		JButton btnCadastrarEntregas = new JButton("Cadastrar Entregas");
		btnCadastrarEntregas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaEntrega();
			}
		});
		btnCadastrarEntregas.setBounds(270, 164, 154, 56);
		getContentPane().add(btnCadastrarEntregas);
		
		JButton btnCadastrarProduto = new JButton("Cadastrar Produto");
		btnCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TelaProduto();
			}
		});
		btnCadastrarProduto.setBounds(10, 164, 154, 56);
		getContentPane().add(btnCadastrarProduto);
		
		JButton btnNewButton_1 = new JButton("Backup e Restauração");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackup tela = new TelaBackup();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
			}
		});
		btnNewButton_1.setBounds(270, 273, 154, 55);
		getContentPane().add(btnNewButton_1);
		
		JMenuBar barraMenu = new JMenuBar();
		barraMenu.setBounds(12, 23, 129, 21);
		getContentPane().add(barraMenu);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TelaInicial();
	}
}