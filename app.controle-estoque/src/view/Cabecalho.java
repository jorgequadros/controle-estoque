package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cabecalho extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JLabel lbPesquisa;
	public JTextField tfPesquisa;
		
	public Cabecalho() {
		super();
		setLayout(new GridLayout(2,1));
		
		lbPesquisa = new JLabel("Descrição : ");
		tfPesquisa = new JTextField(20);
		
		add(lbPesquisa);
		add(tfPesquisa);
	}
	
}
