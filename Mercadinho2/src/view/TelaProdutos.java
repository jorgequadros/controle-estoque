package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Model.bean.Produto;
import Model.dao.ProdutosDAO;

public class TelaProdutos {

	private JFrame frame;
	private JTextField tfDescricao;
	private JTextField tfQtde;
	private JTextField tfValor;
	private JTable table;
	private JTable table_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProdutos window = new TelaProdutos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public TelaProdutos() throws SQLException {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelCampos = new JPanel();
		frame.getContentPane().add(panelCampos, BorderLayout.NORTH);
		panelCampos.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblDescricao = new JLabel("Descricao");
		panelCampos.add(lblDescricao);
		
		tfDescricao = new JTextField();
		panelCampos.add(tfDescricao);
		tfDescricao.setColumns(10);
		
		JLabel lblqtde = new JLabel("Qtde");
		panelCampos.add(lblqtde);
		
		tfQtde = new JTextField();
		panelCampos.add(tfQtde);
		tfQtde.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		panelCampos.add(lblValor);
		
		tfValor = new JTextField();
		panelCampos.add(tfValor);
		tfValor.setColumns(10);
		
		JPanel panelBotoes = new JPanel();
		frame.getContentPane().add(panelBotoes, BorderLayout.SOUTH);
		
		JButton btSalvar = new JButton("Salvar");
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Produto p = new Produto();
				ProdutosDAO dao= new ProdutosDAO();
				p.setDescricao(tfDescricao.getText());
				p.setQtde(Integer.parseInt(tfQtde.getText()));
				p.setValor(Double.parseDouble(tfValor.getText()));
				
				dao.create(p);
				try {
					lerTabela();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panelBotoes.add(btSalvar);
		
		JButton btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1) {
					
				}
			}
		});
		panelBotoes.add(btExcluir);
		
		JButton btAtualizar = new JButton("Atualizar");
		btAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panelBotoes.add(btAtualizar);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Descri\u00E7\u00E3o", "Qtde", "Valor"
			}
		));
		scrollPane.setRowHeaderView(table_1);
		DefaultTableModel modelo =(DefaultTableModel) table_1.getModel();
		table_1.setRowSorter(new TableRowSorter<DefaultTableModel>(modelo));
		try {
			lerTabela();
		} catch (IOException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		scrollPane.setViewportView(table_1);
		
		
		
	}
	
	public void lerTabela() throws IOException, SQLException {
		DefaultTableModel modelo = (DefaultTableModel) table_1.getModel();
		modelo.setNumRows(0);
		ProdutosDAO pdao = new ProdutosDAO();
		
		for(Produto p: pdao.read()) {
			modelo.addRow(new Object[] {
					p.getId(),
					p.getDescricao(),
					p.getQtde(),
					p.getValor()
					});
			
		}
	}

}
