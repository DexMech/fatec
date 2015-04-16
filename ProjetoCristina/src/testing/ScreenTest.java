/*package testing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import net.miginfocom.swing.MigLayout;

public class ScreenTest extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblKg;
	private JLabel lblM;
	private JLabel lblProduto;
	private JLabel lblValidade;
	private JLabel lblQuantidade;
	private JLabel lblPeso;
	private JLabel lblVolume;
	int i = 0;
	
	public ScreenTest(){
		setSize(758,348);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 49, 732, 226);
		getContentPane().add(scrollPane);
		
		final JLayeredPane layeredPane = new JLayeredPane();
		scrollPane.setViewportView(layeredPane);
		layeredPane.setLayout(new MigLayout("", "[grow][][grow][][][][grow]", "[][][]"));
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String position = "cell 1 " + Integer.toString(i);
				//layeredPane.add(new JButton("Button"), position);
				ListaLigadaButton llb = new ListaLigadaButton();
				ListaLigadaText produto = new ListaLigadaText();
				ListaLigadaText validade = new ListaLigadaText();
				ListaLigadaText quantidade = new ListaLigadaText(); 
				ListaLigadaText peso = new ListaLigadaText();
				ListaLigadaText volume = new ListaLigadaText();
				ListaLigadaLabel lblKg = new ListaLigadaLabel();
				ListaLigadaLabel lblM = new ListaLigadaLabel();
				
				produto.adicionaText(layeredPane, 0, i);
				llb.adicionaButton(layeredPane, i);
				validade.adicionaText(layeredPane, 2, i);
				quantidade.adicionaText(layeredPane, 3, i);
				peso.adicionaText(layeredPane, 4, i);
				lblKg.adicionaLabel(layeredPane, 5, i, "kg");
				volume.adicionaText(layeredPane, 6, i);
				lblM.adicionaLabel(layeredPane, 6, i, "m�");
				revalidate();
				i ++;
			}
		});
		btnAdicionar.setBounds(10, 286, 89, 23);
		getContentPane().add(btnAdicionar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(631, 286, 89, 23);
		getContentPane().add(btnExcluir);
		
		lblProduto = new JLabel("Produto");
		lblProduto.setBounds(20, 25, 156, 14);
		getContentPane().add(lblProduto);
		
		lblValidade = new JLabel("Validade");
		lblValidade.setBounds(240, 24, 55, 14);
		getContentPane().add(lblValidade);
		
		lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(385, 25, 79, 14);
		getContentPane().add(lblQuantidade);
		
		lblPeso = new JLabel("Peso");
		lblPeso.setBounds(474, 25, 46, 14);
		getContentPane().add(lblPeso);
		
		lblVolume = new JLabel("Volume");
		lblVolume.setBounds(595, 25, 46, 14);
		getContentPane().add(lblVolume);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ScreenTest();
	}
}
*/