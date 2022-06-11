package view;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MDIPrincipal extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDesktopPane desktop = new JDesktopPane();
	
	public static void main(String[] args) {
		MDIPrincipal principal = new MDIPrincipal();
		principal.setDefaultCloseOperation(EXIT_ON_CLOSE);
		principal.setSize(800, 600);
		principal.setResizable(false);
		principal.setVisible(true);
	}
	
	
	public MDIPrincipal() throws HeadlessException {
		super("Gestão de Estoque");
		// TODO Auto-generated constructor stub
		
		JMenuBar bar = new JMenuBar();
		JMenu cadastro = new JMenu("Cadastro");
		JMenuItem categorias = new JMenuItem("Categorias");
		
		cadastro.add(categorias);
		bar.add(cadastro);
		setJMenuBar(bar);
		
		add(desktop);
		
		categorias.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CadCategorias frame = new CadCategorias();
							frame.pack();
							desktop.add(frame);
							
							frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
							frame.setSize(600, 400);
							frame.setResizable(true);
							frame.setVisible(true);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
	}	
	
}
