/**
 * @author Arthur Gomes
 * 
 * Tela inicial do programa*/

package boundary;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import javax.swing.SwingConstants;

public class TelaInicial extends JFrame {

	public TelaInicial(){
		setSize(334,345);
		setTitle("");
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(86, 93, 154, 29);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Programa que funciona");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(10, 11, 304, 29);
		getContentPane().add(lblNewLabel);
		
		JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					new TelaCliente();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCadastrarCliente.setBounds(86, 133, 154, 29);
		getContentPane().add(btnCadastrarCliente);
		
		JButton btnVerEntregas = new JButton("Ver Entregas");
		btnVerEntregas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new ConsultaEntrega();
			}
		});
		btnVerEntregas.setBounds(86, 213, 154, 29);
		getContentPane().add(btnVerEntregas);
		
		JButton btnAbrirExcel = new JButton("Abrir Excel");
		btnAbrirExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAbrirExcel.setBounds(86, 253, 154, 29);
		getContentPane().add(btnAbrirExcel);
		
		JButton btnCadastrarEntregas = new JButton("Cadastrar Entregas");
		btnCadastrarEntregas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new TelaEntrega();
			}
		});
		btnCadastrarEntregas.setBounds(86, 173, 154, 29);
		getContentPane().add(btnCadastrarEntregas);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TelaInicial();
	}
}