/**
 * @author Arthur Gomes
 * 
 * Tela de cadastro de motorista, veículo e carroceria*/

package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import control.CaminhaoControle;
import control.CarroceriaControle;
import control.ComboBoxItens;
import control.MotoristaControle;

public class TelaMotorista extends JFrame implements ComboBoxItens{
	CaminhaoControle cam = new CaminhaoControle();
	CarroceriaControle car = new CarroceriaControle();
	private JTextField textNome;
	private JFormattedTextField textCNH;
	private JFormattedTextField textTelefone;
	private JFormattedTextField textCelular;
	private JFormattedTextField textRg;
	private JFormattedTextField textCpf;
	private JTextField textPesoCaminhao;
	private JFormattedTextField textPlaca;
	private JFormattedTextField textValidadeFim;
	private JTextField textCidade;

	private MaskFormatter tel;
	private MaskFormatter cel;
	private MaskFormatter data;
	private MaskFormatter placa;
	private MaskFormatter cnh;
	private MaskFormatter rg;
	private MaskFormatter cpf;
	private JTextField textLargura;
	private JTextField textAltura;
	private JTextField textComprimento;
	private JTextField textPeso;
	private JTextField textVolume;
	private final JComboBox cbCaminhao;
	private final JComboBox cbCarroceria;
	private final JComboBox cbEstado;
	
	private JLabel lblNome;
	private JLabel lblRg;
	private JLabel lblCpf;
	private JLabel lblCnh;
	private JLabel lblValidade;
	private JLabel lblTelefone_1;
	private JLabel lblCelular;
	private JLabel lblNumeroDaPlaca;
	private JLabel lblCidade;

	/**
	 * @wbp.nonvisual location=283,714
	 */

	public TelaMotorista() throws ParseException {
		tel = new MaskFormatter("(##)####-####");
		cel = new MaskFormatter("(##)#####-####");
		data = new MaskFormatter("##/##/####");
		placa = new MaskFormatter("UUU-####");
		cnh = new MaskFormatter("###########");
		rg = new MaskFormatter("##.###.###-#");
		cpf = new MaskFormatter("###.###.###-##");
		
		tel.setValidCharacters("0123456789");
		cel.setValidCharacters("0123456789");
		data.setValidCharacters("0123456789");
		placa.setValidCharacters("0123456789ASDFGHJKLZXCVBNMQWERTYUIOP");
		rg.setValidCharacters("0123456789");
		cpf.setValidCharacters("0123456789");

		setSize(475, 622);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Cadastro de Motorista");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		JLabel lblContainer = new JLabel("Carroceria:");
		lblContainer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContainer.setBounds(14, 334, 152, 14);
		getContentPane().add(lblContainer);

		cbCarroceria = new JComboBox(CARROCERIA);
		cbCarroceria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbCarroceria.setBounds(129, 330, 270, 23);
		cbCarroceria.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				car.c.setPeso(cbCarroceria.getSelectedItem().toString());
				car.c.setLargura(cbCarroceria.getSelectedItem().toString());
				car.c.setAltura(cbCarroceria.getSelectedItem().toString());
				car.c.setComprimento(cbCarroceria.getSelectedItem().toString());
				car.c.setVolume();

				if (car.c.getPeso() == 0)
					textPeso.setText("Sem peso");
				else
					textPeso.setText(""+car.c.getPeso());

				if (car.c.getLargura() == 0)
					textLargura.setText(" - ");
				else
					textLargura.setText(Double.toString(car.c.getLargura()));

				if (car.c.getAltura() == 0)
					textAltura.setText(" - ");
				else
					textAltura.setText(Double.toString(car.c.getAltura()));

				if (car.c.getComprimento() == 0)
					textComprimento.setText(" - ");
				else
					textComprimento.setText(Double.toString(car.c.getComprimento()));

				if (car.c.getVolume() == 0)
					textVolume.setText(" - ");
				else
					textVolume.setText(Double.toString(car.c.getVolume()));
			}
		});
		getContentPane().add(cbCarroceria);

		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(14, 11, 46, 14);
		getContentPane().add(lblNome);

		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				textNome.setBackground(Color.white);
				lblNome.setForeground(Color.black);
			}
		});
		textNome.setBounds(14, 31, 385, 23);
		getContentPane().add(textNome);
		textNome.setColumns(10);

		lblCnh = new JLabel("CNH:");
		lblCnh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCnh.setBounds(14, 121, 46, 14);
		getContentPane().add(lblCnh);

		textCNH = new JFormattedTextField(cnh);
		textCNH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textCNH.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textCNH.setBackground(Color.white);
				lblCnh.setForeground(Color.black);
			}
		});
		textCNH.setBounds(14, 141, 86, 23);
		getContentPane().add(textCNH);
		textCNH.setValue("");
		textCNH.setColumns(10);

		lblValidade = new JLabel("Validade:");
		lblValidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValidade.setBounds(238, 121, 64, 14);
		getContentPane().add(lblValidade);

		lblTelefone_1 = new JLabel("Telefone 1:");
		lblTelefone_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone_1.setBounds(14, 175, 71, 23);
		getContentPane().add(lblTelefone_1);

		textTelefone = new JFormattedTextField(tel);
		textTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textTelefone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textTelefone.setBackground(Color.white);
				lblTelefone_1.setForeground(Color.black);
			}
		});
		textTelefone.setBounds(14, 200, 120, 23);
		getContentPane().add(textTelefone);
		textTelefone.setValue("");
		textTelefone.setColumns(10);

		lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCelular.setBounds(238, 175, 71, 23);
		getContentPane().add(lblCelular);

		textCelular = new JFormattedTextField(cel);
		textCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textCelular.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textCelular.setBackground(Color.white);
				lblCelular.setForeground(Color.black);
			}
		});
		textCelular.setColumns(10);
		textCelular.setBounds(238, 200, 120, 23);
		textCelular.setValue("");
		getContentPane().add(textCelular);

		JLabel lblTipoDeVeculo = new JLabel("Tipo de Caminh\u00E3o:");
		lblTipoDeVeculo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoDeVeculo.setBounds(14, 237, 134, 17);
		getContentPane().add(lblTipoDeVeculo);

		cbCaminhao = new JComboBox(VEICULO);
		cbCaminhao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbCaminhao.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cam.c.setCapacidadeCarga(cbCaminhao.getSelectedItem().toString());
				textPesoCaminhao.setText(Integer.toString(cam.c.getCapacidadeCarga()));
			}
		});
		cbCaminhao.setBounds(158, 234, 241, 23);
		getContentPane().add(cbCaminhao);

		JLabel lblCapacidadeDeCarga = new JLabel("Capacidade de carga:");
		lblCapacidadeDeCarga.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCapacidadeDeCarga.setBounds(14, 268, 134, 20);
		getContentPane().add(lblCapacidadeDeCarga);

		textPesoCaminhao = new JTextField();
		textPesoCaminhao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPesoCaminhao.setEditable(false);
		textPesoCaminhao.setBounds(159, 267, 64, 23);
		getContentPane().add(textPesoCaminhao);
		textPesoCaminhao.setColumns(10);
		textPesoCaminhao.setText(Integer.toString(16000));

		JLabel lblKg = new JLabel("kg");
		lblKg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKg.setBounds(232, 268, 21, 23);
		getContentPane().add(lblKg);

		lblNumeroDaPlaca = new JLabel("Numero da placa:");
		lblNumeroDaPlaca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroDaPlaca.setBounds(14, 429, 134, 17);
		getContentPane().add(lblNumeroDaPlaca);

		textPlaca = new JFormattedTextField(placa);
		textPlaca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPlaca.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textPlaca.setBackground(Color.white);
				lblNumeroDaPlaca.setForeground(Color.black);
			}
		});
		textPlaca.setBounds(136, 424, 64, 23);
		getContentPane().add(textPlaca);
		textPlaca.setValue("");
		textPlaca.setColumns(10);

		JButton btnGravar = new JButton("Salvar");
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGravar.setIcon(new ImageIcon(TelaMotorista.class
				.getResource("/images/save.png")));
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MotoristaControle mc = new MotoristaControle();

				if (validar()) {
					mc.InstanciarMotoristaControle(textNome.getText(), textCNH.getValue().toString(), 
							textValidadeFim.getText(), textTelefone.getValue().toString(), textCelular.getValue().toString(),
							textRg.getValue().toString(), textCpf.getValue().toString());
					cam.InstanciarCaminhaoControle(cbCaminhao.getSelectedItem()
							.toString(), textPlaca.getText(), cbEstado.getSelectedItem().toString(), textCidade.getText());
					car.InstanciarCarroceriaControle(cbCarroceria.getSelectedItem().toString());
					try {
						mc.gravar("src/BD/Caminhoes/" + cbCaminhao.getSelectedItem() + ".txt");
						cam.gravar("src/BD/Caminhoes/" + cbCaminhao.getSelectedItem() + ".txt");
						car.gravar("src/BD/Caminhoes/" + cbCaminhao.getSelectedItem() + ".txt");
						limpar();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnGravar.setBounds(14, 537, 100, 32);
		getContentPane().add(btnGravar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setIcon(new ImageIcon(TelaMotorista.class
				.getResource("/images/limpar.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					limpar();
			}
		});
		btnLimpar.setBounds(195, 537, 111, 32);
		getContentPane().add(btnLimpar);

		textValidadeFim = new JFormattedTextField(data);
		textValidadeFim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textValidadeFim.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textValidadeFim.setBackground(Color.white);
				lblValidade.setForeground(Color.black);
			}
		});
		textValidadeFim.setColumns(10);
		textValidadeFim.setBounds(238, 141, 76, 23);
		textValidadeFim.setValue("");
		getContentPane().add(textValidadeFim);

		lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCidade.setBounds(14, 463, 46, 14);
		getContentPane().add(lblCidade);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstado.setBounds(14, 507, 71, 14);
		getContentPane().add(lblEstado);

		textCidade = new JTextField();
		textCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textCidade.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textCidade.setBackground(Color.white);
				lblCidade.setForeground(Color.black);
			}
		});
		textCidade.setBounds(136, 457, 128, 23);
		getContentPane().add(textCidade);
		textCidade.setColumns(10);

		JLabel lblLargura = new JLabel("Largura:");
		lblLargura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLargura.setBounds(14, 299, 71, 23);
		getContentPane().add(lblLargura);

		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAltura.setBounds(14, 366, 46, 18);
		getContentPane().add(lblAltura);

		JLabel lblComprimento = new JLabel("Comprimento:");
		lblComprimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblComprimento.setBounds(14, 397, 112, 19);
		getContentPane().add(lblComprimento);

		JLabel lblVolume = new JLabel("Volume:");
		lblVolume.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVolume.setBounds(232, 368, 74, 14);
		getContentPane().add(lblVolume);

		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPeso.setBounds(232, 305, 46, 14);
		getContentPane().add(lblPeso);

		textLargura = new JTextField();
		textLargura.setEditable(false);
		textLargura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textLargura.setBounds(136, 301, 58, 23);
		textLargura.setText(Double.toString(2.46));
		getContentPane().add(textLargura);
		textLargura.setColumns(10);

		textAltura = new JTextField();
		textAltura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAltura.setEditable(false);
		textAltura.setColumns(10);
		textAltura.setBounds(136, 367, 58, 23);
		textAltura.setText(Double.toString(3));
		getContentPane().add(textAltura);

		textComprimento = new JTextField();
		textComprimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textComprimento.setEditable(false);
		textComprimento.setColumns(10);
		textComprimento.setBounds(136, 395, 58, 23);
		textComprimento.setText(Double.toString(7.65));
		getContentPane().add(textComprimento);

		JLabel lblMm = new JLabel("m");
		lblMm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMm.setBounds(201, 303, 46, 14);
		getContentPane().add(lblMm);

		JLabel lblM = new JLabel("m");
		lblM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblM.setBounds(201, 373, 46, 14);
		getContentPane().add(lblM);

		JLabel lblKg_1 = new JLabel("kg");
		lblKg_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKg_1.setBounds(386, 303, 46, 19);
		getContentPane().add(lblKg_1);

		textPeso = new JTextField();
		textPeso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPeso.setEditable(false);
		textPeso.setBounds(291, 302, 85, 21);
		getContentPane().add(textPeso);
		textPeso.setText("Sem peso");
		textPeso.setColumns(10);

		JLabel label = new JLabel("m");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(201, 401, 46, 14);
		getContentPane().add(label);

		textVolume = new JTextField();
		textVolume.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textVolume.setEditable(false);
		textVolume.setColumns(10);
		textVolume.setBounds(291, 364, 85, 23);
		textVolume.setText(Double.toString(56.457));
		getContentPane().add(textVolume);

		JLabel lblM_1 = new JLabel("m\u00B3");
		lblM_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblM_1.setBounds(386, 371, 46, 14);
		getContentPane().add(lblM_1);
		
		cbEstado = new JComboBox(ESTADOS);
		cbEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbEstado.setBounds(120, 503, 209, 23);
		getContentPane().add(cbEstado);
		
		lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRg.setBounds(14, 65, 46, 14);
		getContentPane().add(lblRg);
		
		textRg = new JFormattedTextField(rg);
		textRg.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textRg.setBackground(Color.white);
				lblRg.setForeground(Color.black);
			}
		});
		textRg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textRg.setValue("");
		textRg.setColumns(10);
		textRg.setBounds(14, 87, 120, 23);
		getContentPane().add(textRg);
		
		textCpf = new JFormattedTextField(cpf);
		textCpf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textCpf.setBackground(Color.white);
				lblCpf.setForeground(Color.black);
			}
		});
		textCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textCpf.setValue("");
		textCpf.setColumns(10);
		textCpf.setBounds(238, 87, 120, 23);
		getContentPane().add(textCpf);
		
		lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(238, 65, 46, 14);
		getContentPane().add(lblCpf);
		
		JButton btnBuscaCPF = new JButton("");
		btnBuscaCPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscaCPF.setIcon(new ImageIcon(TelaMotorista.class.getResource("/images/busca.png")));
		btnBuscaCPF.setBounds(368, 87, 31, 23);
		getContentPane().add(btnBuscaCPF);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeletar.setBounds(350, 537, 100, 32);
		getContentPane().add(btnDeletar);
		btnDeletar.setIcon(new ImageIcon(TelaMotorista.class.getResource("/images/red-x.png")));

		setVisible(true);
	}

	public boolean validar() {
		boolean confirm = true;

		if (textNome.getText().isEmpty()) {
			lblNome.setForeground(Color.RED);
			textNome.setBackground(new Color(255,250,205));
			confirm = false;
		}

		if (textCNH.getValue().toString().isEmpty()) {
			lblCnh.setForeground(Color.RED);
			textCNH.setBackground(new Color(255,250,205));
			confirm = false;
		}

		if (textValidadeFim.getValue().toString().isEmpty()) {
			lblValidade.setForeground(Color.RED);
			textValidadeFim.setBackground(new Color(255,250,205));
			confirm = false;
		}

		if (textTelefone.getValue().toString().isEmpty()
				|| textCelular.getValue().toString().isEmpty()) {
			if (textTelefone.getValue().toString().isEmpty()){
				lblTelefone_1.setForeground(Color.RED);
				textTelefone.setBackground(new Color(255,250,205));
			}
			
			if (textCelular.getValue().toString().isEmpty()){
				lblCelular.setForeground(Color.RED);
				textCelular.setBackground(new Color(255,250,205));
			}
			
			confirm = false;
		}

		if (textPlaca.getValue().toString().isEmpty()) {
			lblNumeroDaPlaca.setForeground(Color.RED);
			textPlaca.setBackground(new Color(255,250,205));
			confirm = false;
		}

		if (textCidade.getText().isEmpty()) {
			lblCidade.setForeground(Color.RED);
			textCidade.setBackground(new Color(255,250,205));
			confirm = false;
		}
		
		if(textRg.getValue().toString().isEmpty()){
			lblRg.setForeground(Color.RED);
			textRg.setBackground(new Color(255,250,205));
			confirm = false;
		}
		
		if(textCpf.getValue().toString().isEmpty()){
			lblCpf.setForeground(Color.RED);
			textCpf.setBackground(new Color(255,250,205));
			confirm = false;
		}

		return confirm;
	}
	
	public void limpar(){
		textNome.setText("");
		textCNH.setValue("");
		textValidadeFim.setValue("");
		textTelefone.setValue("");
		textCelular.setValue("");
		textPesoCaminhao.setText(Integer.toString(16000));
		cbCaminhao.setSelectedIndex(0);
		cbCarroceria.setSelectedIndex(0);
		textPlaca.setText("");
		cbEstado.setSelectedIndex(0);
		textCidade.setText("");
		textLargura.setText(Double.toString(2.46));
		textAltura.setText(Double.toString(3));
		textComprimento.setText(Double.toString(7.65));
		textPeso.setText("Sem peso");
		textVolume.setText(Double.toString(56.457));
		textRg.setValue("");
		textCpf.setValue("");
	}
	
	
}
