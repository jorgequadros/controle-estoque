package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import control.CategoriaDAO;
import control.ConexaoBD;
import modulo.ModeloTabelaConsulta;

public class ConsCategoria extends JFrame{
	private JTable tabela;
	private JLabel rotulo;
	private JTextField txtConsulta;
	private JButton btPesquisa, btAlterar, btExcluir, btIncluir, btSair;
	String query = "select * from categorias";
	
	private modulo.ModeloTabelaConsulta tm;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public ConsCategoria() throws HeadlessException {
		
		JPanel pesquisa = new JPanel();
		pesquisa.setLayout(new GridLayout(1, 3));
		rotulo = new JLabel("Pesquisa");
		txtConsulta = new JTextField(25);
		btPesquisa =new JButton("Pesquisa");
		btPesquisa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(txtConsulta.getText().isEmpty() && txtConsulta.getText().equals("")) {
					query = "select * from categorias";
					tm.setConsulta(query);
					tm.loadData();
				}else {
					query = "select * from categorias where descricao like '" + txtConsulta.getText() + "%'";
					tm.setConsulta(query);
					tm.loadData();
				}
				
			}});
		
		pesquisa.add(rotulo);
		pesquisa.add(txtConsulta);
		pesquisa.add(btPesquisa);
				
		tm = new ModeloTabelaConsulta(query);
		tabela = new JTable(tm);
		tabela.setGridColor(Color.LIGHT_GRAY);
		
		JPanel botoes = new JPanel();
		botoes.setLayout(new GridLayout(1, 4));
		btAlterar = new JButton("Alterar");
		btAlterar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
								
				if(tabela.getRowSelectionAllowed()) {
					int index =tabela.getSelectedRow();
					int id = Integer.parseInt(tm.getValueAt(index, 0).toString());
					String descricao = tm.getValueAt(index, 1).toString();
					if(descricao.equals("") && descricao.isEmpty()) {
						JOptionPane.showMessageDialog(botoes, "Item não selecionado!!");
					}else {
						CadCategoria form = new CadCategoria("Alterar", id, descricao);
						form.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						form.setSize(300, 150);
						form.setResizable(false);
						form.setVisible(true);
					}
				}
				
			}
		});
		btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int index = tabela.getSelectedRow();
				String id = tm.getValueAt(index, 0).toString();
				
				try {
				if(id.isEmpty() && id.equals("")) {
					JOptionPane.showMessageDialog(botoes, "Exclução não realizada!!!");
				}else {
					CategoriaDAO catDao = new CategoriaDAO();
					catDao.deleteRegistro(id);
					JOptionPane.showMessageDialog(botoes, "Exclução realizada com Sucesso!!!");
				}
					
				tm.setConsulta("select id AS ID, descricao as Descrição from categorias");
				tm.loadData();
				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btIncluir = new JButton("Incluir");
		btIncluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CadCategoria form = new CadCategoria();
				form.setDefaultCloseOperation(EXIT_ON_CLOSE);
				form.setSize(300, 150);
				form.setResizable(false);
				form.setVisible(true);
				
				tm.setConsulta("select id AS ID, descricao as Descrição from categorias");
				tm.loadData();
			}
		});
		btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					ConexaoBD.getInstance().desligar();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ConsCategoria.this.dispose();
			}
		});
		
		botoes.add(btAlterar);
		botoes.add(btExcluir);
		botoes.add(btIncluir);
		botoes.add(btSair);
				
		add("North",pesquisa);
		add("Center", new JScrollPane(tabela));
		add("South", botoes);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				try {
					ConexaoBD.getInstance().desligar();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		pack();
	}


	/*
	 * public static void main(String[] args) { 
	 * CadastroCategoria categoria = new CadastroCategoria("DataView.properties");
	 * categoria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * categoria.setSize(500, 300); 
	 * categoria.setResizable(false);
	 * categoria.setVisible(true); }
	 */
}