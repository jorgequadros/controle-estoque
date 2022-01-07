package modulo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotoes extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btAlterar, btExcluir, btIncluir, btSair;
	
	public PanelBotoes() {
		setLayout(new GridLayout(1,1));
		btAlterar = new JButton("Alterar");
		btExcluir = new JButton("Excluir");
		btIncluir = new JButton("Incluir");
		btSair = new JButton("Sair");
		
		btSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		add(btAlterar);
		add(btExcluir);
		add(btIncluir);
		add(btSair);
	}
	
	

}
