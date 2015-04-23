package boundary;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;

import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;

public class TelaInicial extends JFrame {
	private JMenuBar barraMenu;
	
	public TelaInicial(){
		setSize(791,633);
		setTitle("RotaMax - Roteirização");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

	
		barraMenu = new JMenuBar();
		barraMenu.setBounds(0, 9, 809, 21);
		JMenu menu = new JMenu("Menu");
		
		JMenuItem menu0 = new JMenuItem("Backup e Restauração");

		JMenuItem menu1 = new JMenuItem("Cadastro de Clientes");
		JMenuItem menu2= new JMenuItem("Cadastro de Produtos");
		JMenuItem menu3 = new JMenuItem("Cadastro de Motoristas");
		JMenuItem menu41 = new JMenuItem("Cadastro de Entregas");
		JMenuItem menu4 = new JMenuItem("Visualizar Entregas");
		JMenuItem menu5 = new JMenuItem("Sair");
		
		menu5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		
		
		menu41.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaEntrega();
				
			}
		});
		menu0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaBackup tela = new TelaBackup();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);

			}
		});
		menu1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new TelaCliente();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});
		menu2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaProduto();

			}
		});
		menu3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new TelaMotorista();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});
		menu4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ConsultaEntrega().setLocationRelativeTo(null);

			}
		});
	

		menu.add(menu0);
		menu.add(menu1);
		menu.add(menu2);
		menu.add(menu3);
		menu.add(menu41);
		menu.add(menu4);
		menu.add(menu5);

		barraMenu.add(menu);
		
		//JMenu menu = new JMenu("Backup e restauração");
		getContentPane().add(barraMenu);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaInicial.class.getResource("/images/ola.jpg")));
		lblNewLabel.setBounds(0, 28, 800, 613);
		getContentPane().add(lblNewLabel);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TelaInicial();
	}
}