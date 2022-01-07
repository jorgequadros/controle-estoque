package view;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MDIPrincipal extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MDIPrincipal() throws HeadlessException {
		super("Controle de Estoque.");
		JMenu cadastro = new JMenu("Gerenciador de Cadastro");
		cadastro.setMnemonic('C');
		JMenuItem mnucategoria = new JMenuItem("Categorias");
		mnucategoria.setMnemonic('A');
		
		mnucategoria.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						ConsCategoria cadCategorias = new ConsCategoria();
						cadCategorias.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						cadCategorias.setSize(450, 400);
						cadCategorias.setVisible(true);
						cadCategorias.setResizable(false);
					}
					
				}
		);
		cadastro.add(mnucategoria);
		
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(cadastro);
				
	}
	
	public static void main(String[] args) {
		MDIPrincipal principal = new MDIPrincipal();
		principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		principal.setSize(1000,600);
		principal.setVisible(true);
	}
	
}
