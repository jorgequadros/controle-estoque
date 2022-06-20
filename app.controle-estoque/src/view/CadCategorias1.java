package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import modulo.ConexaoBD;

public class CadCategorias1 extends JInternalFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbDescricao = new JLabel("Descrição");
	private JTextField tfDescricao = new JTextField(20);
	private JButton btIncluir, btCancelar, btAlterar, btExcluir, btSair, btPesquisa;
	private JTable consulta;
			
	
	public CadCategorias1() throws SQLException {
		
		super("Cadastro de Categorias",true,true,true,true);
		// TODO Auto-generated constructor stub
		JPanel conteudo= new JPanel();
		conteudo.setLayout(new GridLayout(2,1));
		conteudo.add(lbDescricao);
		conteudo.add(tfDescricao);
		
		consulta = new JTable();
		
		consulta.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Descri\u00E7\u00E3o"
				}
			));
				
		
		
		DefaultTableModel modelo = (DefaultTableModel) consulta.getModel();
		consulta.setRowSorter(new TableRowSorter<DefaultTableModel>(modelo));
		consulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(consulta.getSelectedRow()!=-1) {
					tfDescricao.setText(consulta.getValueAt(consulta.getSelectedRow(), 1).toString());
				}
			}
		});
		try {
			lerDados();
		} catch (IOException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		JPanel rodape = new JPanel(new GridLayout(1, 6));
		btAlterar = new JButton("Alterar");
		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(consulta.getSelectedRow()!=-1) {
					
					Categoria c = new Categoria();
					try {
						CategoriaDAO dao = new CategoriaDAO();
						c.setId(Integer.parseInt(consulta.getValueAt(consulta.getSelectedRow(), 0).toString()));
						c.setDescricao(tfDescricao.getText());
						dao.updateRegistro(c);
						lerDados();
					} catch (SQLException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(consulta.getSelectedRow()!=-1) {
					
					Categoria c = new Categoria();
					try {
						CategoriaDAO dao = new CategoriaDAO();
						c.setId(Integer.parseInt(consulta.getValueAt(consulta.getSelectedRow(), 0).toString()));
						dao.deleteRegistro(c);
						lerDados();
					} catch (SQLException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			}
		});
		btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tfDescricao.setText("");
			}
		});
		
		btPesquisa = new JButton("Pesquisar");
		btPesquisa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Categoria c=new Categoria();
					CategoriaDAO dao=new CategoriaDAO();
					c.setDescricao(tfDescricao.getText());
					dao.obterCategoriaDescricao(tfDescricao.getText());
					try {
						lerDadosPor();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btIncluir = new JButton("Incluir");
		btIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Categoria c =new Categoria();
				try {
					CategoriaDAO dao = new CategoriaDAO();
					c.setDescricao(tfDescricao.getText());
					dao.inserirRegistro(c);
				} catch (SQLException |IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadCategorias1.this.doDefaultCloseAction();
				try {
					ConexaoBD.getInstance().desligar();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		rodape.add(btAlterar);
		rodape.add(btExcluir);
		rodape.add(btIncluir);
		rodape.add(btCancelar);
		rodape.add(btPesquisa);
		rodape.add(btSair);
		
		add(conteudo,BorderLayout.NORTH);
		add("Center",new JScrollPane(consulta));
		add(rodape,BorderLayout.SOUTH);
		
	}
	
	public void lerDados() throws IOException, SQLException {
		DefaultTableModel modelo = (DefaultTableModel) consulta.getModel();
		modelo.setNumRows(0);
		CategoriaDAO cdao = new CategoriaDAO();
		
		for(Categoria c: cdao.obterCategoria()) {
			modelo.addRow(new Object[] {
					c.getId(),
					c.getDescricao()
					});
			
		}
	}
	
	public void lerDadosPor() throws IOException, SQLException {
		DefaultTableModel modelo = (DefaultTableModel) consulta.getModel();
		modelo.setNumRows(0);
		CategoriaDAO cdao = new CategoriaDAO();
		
		for(Categoria c1: cdao.obterCategoriaDescricao(tfDescricao.getText())) {
			modelo.addRow(new Object[] {
					c1.getId(),
					c1.getDescricao()
					});
			
		}
	}
}
