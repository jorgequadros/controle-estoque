package view;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.CategoriaDAO;

public class CadCategoria extends JFrame{

	private JLabel lblId, lblDescricao;
	private JTextField txtId, txtDescricao;
	private JButton btLimpar, btOk;
	private CategoriaDAO cat ;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CadCategoria(String op, int id, String descricao) throws HeadlessException {
		super("Alterar/Incluir");
		// TODO Auto-generated constructor stub
		JPanel campos = new JPanel(new GridLayout(4,1));
				
		lblId = new JLabel("Id");
		txtId = new JTextField(10);
		txtId.setText(String.valueOf(id));
		txtId.setEnabled(false);
		lblDescricao = new JLabel("Descrição");
		txtDescricao = new JTextField(20);
		txtDescricao.setText(descricao);
		
		campos.add(lblId);
		campos.add(txtId);
		campos.add(lblDescricao);
		campos.add(txtDescricao);
				
		add("North",campos);
		operador("alterar");
	}
	
	public CadCategoria() throws HeadlessException {
		super("Alterar/Incluir");
		// TODO Auto-generated constructor stub
		JPanel campos = new JPanel(new GridLayout(4,1));
		
		lblId = new JLabel("Id");
		lblId.setVisible(false);
		txtId = new JTextField(10);
		txtId.setVisible(false);
		lblDescricao = new JLabel("Descrição");
		txtDescricao = new JTextField(20);
		
		
		campos.add(lblId);
		campos.add(txtId);
		campos.add(lblDescricao);
		campos.add(txtDescricao);
		
		
		add("North",campos);
		operador("incluir");
	}


	public void operador(String op) {
		
		
		JPanel botoes = new JPanel();
		botoes.setLayout(new GridLayout(1, 2));
		btLimpar = new JButton("Sair");
		btLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CadCategoria.this.dispose();
			}
		});
		
		btOk = new JButton("Ok");
		
		btOk.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
			
				try {
					if(op.equals("alterar")) {
						if (txtDescricao.getText()=="") {
							JOptionPane.showMessageDialog(botoes, "Registro não Alterado!");
						}else {
							cat.getInstance()
								.updateRegistro(txtDescricao.getText(),txtId.getText());
							JOptionPane.showMessageDialog(botoes, "Registro Alterado com sucesso!");
							CadCategoria.this.dispose();
						}
					}else if (op.equals("incluir")) {
						if (txtDescricao.getText()=="") {
							JOptionPane.showMessageDialog(botoes, "Campo Vazio Registro não Incluido!");
						}else {
							cat = new CategoriaDAO();
							cat.inserirRegistro(txtDescricao.getText());
							JOptionPane.showMessageDialog(botoes, "Registro Incluido com sucesso!");
							CadCategoria.this.dispose();
						}
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botoes.add(btLimpar);
		botoes.add(btOk);
		
		add("South", botoes);
		
	}


	
	
	
}
