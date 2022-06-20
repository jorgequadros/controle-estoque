package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import modulo.Fornecedor;
import modulo.FornecedorDAO;

public class telaFornecedor extends JInternalFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final GridBagLayout layout;
	private final GridBagConstraints constraints;
	
	private JLabel lbRazaoSocial, lbEndereco, lbCidade, lbBairro, lbUF, lbCep;
	private JTextField tfRazaoSocial, tfEndereco, tfCidade, tfBairro, tfCep;
	private JButton btAlterar, btCancelar, btExcluir, btIncluir, btPesquisa, btSair;
	private JTable tabela;
	private JComboBox<String> cboUF;
	private JPanel Campos;
	
	
	public telaFornecedor() {
		super("Cadastro Fornecedor",true,true,true,true);
		Campos = new JPanel();
		layout = new GridBagLayout();
		Campos.setLayout(layout);
		constraints = new GridBagConstraints();
		
		lbRazaoSocial = new JLabel("Razão Social");
		tfRazaoSocial = new JTextField();
		
		lbEndereco =new JLabel("Endereço");
		tfEndereco =new JTextField();
		
		lbCidade =new JLabel("Cidade");
		tfCidade =new JTextField();
		
		lbBairro =new JLabel("Bairro");
		tfBairro =new JTextField();
		
		lbUF = new JLabel("UF");
		cboUF = new JComboBox<>();
		
		lbCep = new JLabel("Cep");
		tfCep = new JTextField();
		
		btAlterar = new JButton("Alterar");
		btCancelar = new JButton("Cancelar");
		btExcluir = new JButton("Excluir");
		btIncluir = new JButton("Incluir");
		btPesquisa = new JButton("Pesquisar");
		btSair = new JButton("Sair");
		
		constraints.fill=GridBagConstraints.BOTH;
		addComponent(lbRazaoSocial,0,0,2,1);
		constraints.fill=GridBagConstraints.BOTH;
		addComponent(tfRazaoSocial,0,2,5,1);
		
		constraints.fill=GridBagConstraints.BOTH;
		addComponent(lbEndereco,0,7,1,1);
		constraints.fill=GridBagConstraints.BOTH;
		addComponent(tfEndereco,0,9,5,1);

		constraints.fill=GridBagConstraints.BOTH;
		addComponent(lbBairro,1,0,1,1);
		constraints.fill=GridBagConstraints.BOTH;
		addComponent(tfBairro,1,1,6,1);

		constraints.fill=GridBagConstraints.BOTH;
		addComponent(lbCidade,1,7,1,1);
		constraints.fill=GridBagConstraints.BOTH;
		addComponent(tfCidade,1,8,4,1);

		constraints.fill=GridBagConstraints.BOTH;
		addComponent(lbUF,2,0,1,1);
		constraints.fill=GridBagConstraints.BOTH;
		addComponent(cboUF,2,1,4,1);
		
		constraints.fill=GridBagConstraints.BOTH;
		addComponent(lbCep,2,5,2,1);
		constraints.fill=GridBagConstraints.BOTH;
		addComponent(tfCep,2,6,4,1);

		constraints.fill=GridBagConstraints.BOTH;
		addComponent(btAlterar,3,0,2,1);
		constraints.fill=GridBagConstraints.BOTH;
		addComponent(btCancelar,3,2,2,1);
		constraints.fill=GridBagConstraints.BOTH;
		addComponent(btExcluir,3,4,2,1);
		constraints.fill=GridBagConstraints.BOTH;
		addComponent(btIncluir,3,6,2,1);
		constraints.fill=GridBagConstraints.BOTH;
		addComponent(btPesquisa,3,8,2,1);
		constraints.fill=GridBagConstraints.BOTH;
		addComponent(btSair,3,10,2,1);
		
		tabela = new JTable();
		
		tabela.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nome","Endereço","Cidade","Bairro","UF","Cep"
				}
			));
				
		
		
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		tabela.setRowSorter(new TableRowSorter<DefaultTableModel>(modelo));
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tabela.getSelectedRow()!=-1) {
					tfRazaoSocial.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
					tfEndereco.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
					tfBairro.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
					tfCidade.setText(tabela.getValueAt(tabela.getSelectedRow(), 4).toString());
					cboUF.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 5).toString());
					tfCep.setText(tabela.getValueAt(tabela.getSelectedRow(), 6).toString());
				}
			}
		});
		try {
			lerDados();
		} catch (IOException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		add("Center",new JScrollPane(tabela));
	}

	private void addComponent(Component component, int row, int column, int width, int height) {
		// TODO Auto-generated method stub
		constraints.gridx=column;
		constraints.gridy=row;
		constraints.gridwidth=width;
		constraints.gridheight=height;
		layout.setConstraints(component, constraints);
	    Campos.add(component);
	    add(Campos,BorderLayout.NORTH);
	}

	public void lerDados() throws IOException, SQLException {
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		modelo.setNumRows(0);
		FornecedorDAO fdao = new FornecedorDAO();
		
		for(Fornecedor f: fdao.obterFornecedor()) {
			modelo.addRow(new Object[] {
					f.getId(),
					f.getRazaoSocial(),
					f.getEndereco(),
					f.getBairro(),
					f.getCidade(),
					f.getUf(),
					f.getCep()
					});
			
		}
	}
	
	public void lerDadosPor() throws IOException, SQLException {
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		modelo.setNumRows(0);
		FornecedorDAO fdao = new FornecedorDAO();
		
		for(Fornecedor f: fdao.obterFornecedorNome(tfRazaoSocial.getText())) {
			modelo.addRow(new Object[] {
					f.getId(),
					f.getRazaoSocial(),
					f.getEndereco(),
					f.getBairro(),
					f.getCidade(),
					f.getUf(),
					f.getCep()
					});
			
		}
	}
	
}

