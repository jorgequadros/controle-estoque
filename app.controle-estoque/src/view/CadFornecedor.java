package view;

import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CadFornecedor extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbID,lbRazaoSocial, lbEndereco,lbCidade, lbBairro,lbUf,lbCep;
	private JTextField tfId, tfRazaoSocial,tfEndereco, tfCidade, tfBairro, tfCep;
	private JButton btSair, btOk;
	private final static String estados[] = {"Escolha Estado!","AC","AL","AP","AM","BA","CE","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO","DF"}; 
	private JComboBox<String> cboLista;
	public CadFornecedor() throws HeadlessException {
		// TODO Auto-generated constructor stub
		
		JPanel campos = new JPanel();
		campos.setLayout(new GridLayout(14, 1));
		lbID = new JLabel("ID");
		tfId= new JTextField(5);
		lbRazaoSocial = new JLabel("Razão Social");
		tfRazaoSocial= new JTextField(20);
		lbEndereco = new JLabel("Endereço");
		tfEndereco= new JTextField(10);
		lbCidade =new JLabel("Cidade");
		tfCidade= new JTextField(10);
		lbBairro = new JLabel("Bairro");
		tfBairro= new JTextField(10);
		lbUf =new JLabel("UF");
		cboLista= new JComboBox<>(estados);
		lbCep= new JLabel("Cep");
		tfCep= new JTextField(10);
		campos.add(lbID);
		campos.add(tfId);
		campos.add(lbRazaoSocial);
		campos.add(tfRazaoSocial);
		campos.add(lbEndereco);
		campos.add(tfEndereco);
		campos.add(lbCidade);
		campos.add(tfCidade);
		campos.add(lbBairro);
		campos.add(tfBairro);
		campos.add(lbUf);
		campos.add(cboLista);
		campos.add(lbCep);
		campos.add(tfCep);
		JPanel Botao = new JPanel();
		Botao.setLayout(new GridLayout(1, 2));
		btOk = new JButton("OK");
		btSair = new JButton("Sair");
		Botao.add(btSair);
		Botao.add(btOk);
		add("North",campos);
		add("South",Botao);
		
	}
	 
	public static void main(String[] args) {
		CadFornecedor forn = new CadFornecedor();
		forn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		forn.setSize(400, 450);
		forn.setResizable(false);
		forn.setVisible(true);
	}
}