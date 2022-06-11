package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import modulo.Categoria;
import modulo.CategoriaDAO;

public class CadCategorias extends JInternalFrame {
	private JTable tabela;
	private JTextField tfDescricao;

	/**
	 * Launch the application.
	 */
		public CadCategorias() {
		setBounds(100, 100, 450, 300);
		
		JPanel pnCampo = new JPanel();
		getContentPane().add(pnCampo, BorderLayout.NORTH);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		pnCampo.add(lblDescricao);
		
		tfDescricao = new JTextField();
		pnCampo.add(tfDescricao);
		tfDescricao.setColumns(10);
		
		JPanel pnBotoes = new JPanel();
		getContentPane().add(pnBotoes, BorderLayout.SOUTH);
		
		JButton btAlterar = new JButton("Alterar");
		pnBotoes.add(btAlterar);
		
		JButton btCadastrar = new JButton("Cadastrar");
		pnBotoes.add(btCadastrar);
		
		JButton btSair = new JButton("Sair");
		pnBotoes.add(btSair);
		
		JButton btExcluir = new JButton("Excluir");
		pnBotoes.add(btExcluir);
		
		JButton btPesquisa = new JButton("Pesquisa");
		pnBotoes.add(btPesquisa);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		tabela = new JTable();
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Descri\u00E7\u00E3o"
			}
		));
		scrollPane.setViewportView(tabela);
		
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		tabela.setRowSorter(new TableRowSorter<DefaultTableModel>(modelo));
		
		try {
			lerTabela();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void lerTabela() throws IOException, SQLException {
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		modelo.setNumRows(0);
		CategoriaDAO cdao = new CategoriaDAO();
		
		for(Categoria c: cdao.obterCategoria()) {
			modelo.addRow(new Object[] {
					c.getId(),
					c.getDescricao()
					});
			
		}
	}

}
