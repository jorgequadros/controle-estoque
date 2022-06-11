package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Model.bean.Produto;
import Model.bean.ProdutosDAO;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaProdutos {

	private JFrame frame;
	private JTextField tfDescricao;
	private JTextField tfQtde;
	private JTextField tfValor;
	private JTable table;
	
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
		ProdutosDAO tableModal = new ProdutosDAO();
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
				p.setDescricao(tfDescricao.getText());
				p.setQtde(Integer.parseInt(tfQtde.getText()));
				p.setValor(Double.parseDouble(tfValor.getText()));
				
				tableModal.addRows(p);
			}
		});
		panelBotoes.add(btSalvar);
		
		JButton btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1) {
					tableModal.removeRow(table.getSelectedRow());
				}
			}
		});
		panelBotoes.add(btExcluir);
		
		JButton btAtualizar = new JButton("Atualizar");
		btAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1) {
					tableModal.setValueAt(tfDescricao.getText(), table.getSelectedRow(), 0);
					tableModal.setValueAt(tfQtde.getText(), table.getSelectedRow(), 1);
					tableModal.setValueAt(tfValor.getText(), table.getSelectedRow(), 2);
				}
			}
		});
		panelBotoes.add(btAtualizar);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(tableModal);
		scrollPane.setViewportView(table);
		ProdutosDAO dao = new ProdutosDAO();
		dao.obterProdutos();
	}

}
