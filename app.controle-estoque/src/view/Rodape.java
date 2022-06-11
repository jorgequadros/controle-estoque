package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Rodape extends JPanel implements ActionListener{ 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton button;
	
	public Rodape() {
		super();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c= new GridBagConstraints();
		
		setLayout(layout);
		c.weightx=1;
		c.weighty=1;
		c.fill=GridBagConstraints.BOTH;
		c.gridwidth=1;
		adicionaBotao("Incluir",c,0,1);	
		adicionaBotao("Aterar",c,1,1);	
		adicionaBotao("Excluir",c,2,1);
		adicionaBotao("Cancelar",c,3,1);
		adicionaBotao("Pesquisar",c,0,2);
		adicionaBotao("Ok",c,1,2);
		adicionaBotao("Sair",c,2,2);
		
	}
	
	public void adicionaBotao(String texto,GridBagConstraints c, int x,int y) {
		c.gridx=x;
		c.gridy=y;
		button = new JButton(texto);
		button.addActionListener(this);
		add(button,c);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() instanceof JButton) {
			JButton botao = (JButton) e.getSource();

			
		}
	}
	
	
}
