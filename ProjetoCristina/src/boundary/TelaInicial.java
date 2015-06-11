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
		JMenu menu=new JMenu("Menu");
		JMenu cadastro=new JMenu("Cadastro");
		JMenuItem CadCli=new JMenuItem("Cadastro de Clientes");
		JMenuItem CadMot=new JMenuItem("Cadastro de Motoristas");
		JMenuItem CadProd=new JMenuItem("Cadastro de Produtos");
		cadastro.add(CadCli);
		cadastro.add(CadMot);
		cadastro.add(CadProd);
		JMenu Entregas=new JMenu("Entregas");
		JMenuItem CadEnt=new JMenuItem("Cadastro de Entregas");
		JMenuItem View=new JMenuItem("Consultar  Entregas");
		Entregas.add(CadEnt);
		Entregas.add(View);
		JMenuItem Rota=new JMenuItem("Roteirização");
		JMenuItem Back=new JMenuItem("Backup e Restauração");
		JMenuItem Sair=new JMenuItem("Sair");
		
		menu.add(cadastro);
		menu.add(Entregas);
		menu.add(Rota);
		menu.add(Back);
		menu.add(Sair);
		barraMenu.add(menu);
		CadCli.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new TelaCliente().setLocationRelativeTo(null);
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		CadEnt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaEntrega().setLocationRelativeTo(null);
				
			}
		});
		CadMot.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new TelaMotorista().setLocationRelativeTo(null);
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		CadProd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new TelaProduto().setLocationRelativeTo(null);
			}
		});
		View.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaConsultaEntrega().setLocationRelativeTo(null);;
			}
		});
		Back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaBackup().setLocationRelativeTo(null);
				
			}
		});
		Sair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		Rota.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaRota().setLocationRelativeTo(null);
				
			}
		});
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
