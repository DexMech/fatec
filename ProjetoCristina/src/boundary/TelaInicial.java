package boundary;
/**
 * @author Alex carlos e Arthur
 */
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
		barraMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		barraMenu.setBounds(0, 9, 809, 21);
		JMenu menu = new JMenu("Menu");
		menu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JMenuItem menu0 = new JMenuItem("Backup e Restauração");
		menu0.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		JMenuItem menu1 = new JMenuItem("Cadastro de Clientes");
		menu1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		JMenuItem menu2= new JMenuItem("Cadastro de Produtos");
		menu2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		JMenuItem menu3 = new JMenuItem("Cadastro de Motoristas");
		menu3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		JMenuItem menu41 = new JMenuItem("Cadastro de Entregas");
		menu41.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		JMenuItem menu4 = new JMenuItem("Visualizar Entregas");
		menu4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		JMenuItem menu5 = new JMenuItem("Sair");
		menu5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		JMenuItem menu6 = new JMenuItem("Roteirizar");
		menu6.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaRota().setLocationRelativeTo(null);
				
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
				new TelaConsultaEntrega().setLocationRelativeTo(null);

			}
		});
	

		
		menu.add(menu1);
		menu.add(menu2);
		menu.add(menu3);
		menu.add(menu41);
		menu.add(menu4);
		menu.add(menu6);
		menu.add(menu0);
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
