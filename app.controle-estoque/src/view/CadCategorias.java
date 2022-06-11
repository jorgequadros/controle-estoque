package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import modulo.CategoriaDAO;

public class CadCategorias extends JInternalFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbDescricao = new JLabel("Descrição");
	private JTextField tfDescricao = new JTextField(20);
	private JButton btIncluir, btCancelar, btAlterar, btExcluir, btSair, btPesquisa;
	private JTable tabela;
	CategoriaDAO tm;
	
	
		
	
	public CadCategorias() throws SQLException {
		super("Cadastro de Categorias",true,true,true,true);
		// TODO Auto-generated constructor stub
		JPanel conteudo= new JPanel();
		conteudo.setLayout(new GridLayout(2,1));
		conteudo.add(lbDescricao);
		conteudo.add(tfDescricao);
		
		tm = new CategoriaDAO();
		
		//tabela = new JTable(tm);
		
		JPanel rodape = new JPanel(new GridLayout(1, 6));
		btAlterar = new JButton("Alterar");
		EventosBotoes eventos = new EventosBotoes();
		btAlterar.addActionListener(eventos);
		btExcluir = new JButton("Excluir");
		btCancelar = new JButton("Cancelar");
		btPesquisa = new JButton("Pesquisar");
		btIncluir = new JButton("Incluir");
		btSair = new JButton("Sair");
		rodape.add(btAlterar);
		rodape.add(btExcluir);
		rodape.add(btIncluir);
		rodape.add(btCancelar);
		rodape.add(btPesquisa);
		rodape.add(btSair);
		
		add(conteudo,BorderLayout.NORTH);
		add("Center",new JScrollPane(tabela));
		add(rodape,BorderLayout.SOUTH);
		
	}
	
	private class EventosBotoes implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
}
