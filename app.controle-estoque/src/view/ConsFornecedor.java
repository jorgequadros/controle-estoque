package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import modulo.ModeloTabelaConsulta;

public class ConsFornecedor extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbPesquisa;
	private JTextField tfPesquisa;
	private JTable tbTabela;
	private modulo.ModeloTabelaConsulta tm;
	private JButton btPesquisa, btAlterar, btExcluir, btIncluir,btSair;
	String query = "select * from fornecedor";
	
	public ConsFornecedor() throws HeadlessException {
		super("Gerenciamento de Fornecedor");
		JPanel pnPesquisa = new JPanel();
		pnPesquisa.setLayout(new GridLayout(1, 3));
		lbPesquisa = new JLabel("Pesquisa :");
		tfPesquisa = new JTextField(20);
		btPesquisa = new JButton("Localizar");
		pnPesquisa.add(lbPesquisa);
		pnPesquisa.add(tfPesquisa);
		pnPesquisa.add(btPesquisa);
		
		tm = new ModeloTabelaConsulta(query);
		tbTabela = new JTable(tm);
		tbTabela.setGridColor(Color.LIGHT_GRAY);
				
		JPanel pnBotoes = new JPanel();
		pnBotoes.setLayout(new GridLayout(1, 4));
		btAlterar = new JButton("Alterar");
		btExcluir = new JButton("Excluir");
		btIncluir = new JButton("Incluir");
		btSair = new JButton("Sair");
		pnBotoes.add(btAlterar);
		pnBotoes.add(btExcluir);
		pnBotoes.add(btIncluir);
		pnBotoes.add(btSair);
		
		add("North",pnPesquisa);
		add("Center",new JScrollPane(tbTabela));
		add("South",pnBotoes);
		
	}
	
	public static void main(String[] args) {
		ConsFornecedor consForn = new ConsFornecedor();
		consForn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		consForn.setSize(550, 400);
		consForn.setResizable(false);
		consForn.setVisible(true);
	}
	

}

	

	
