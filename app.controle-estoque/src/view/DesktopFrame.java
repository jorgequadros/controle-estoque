package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class DesktopFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDesktopPane theDesktop;

	public DesktopFrame(){
		super("Usando um JDesktopPane");
		
		JMenuBar bar = new JMenuBar();//Cria a barra de menus
		JMenu addMenu = new JMenu("Add");//Cria um menu add
		JMenuItem newFrame = new JMenuItem("Internal Frame");
		
		addMenu.add(newFrame);//Adiciona um novo item de frame ao menu add
		bar.add(addMenu);//adiciona o menu add a barra de menus
		setJMenuBar(bar);//configura a barra de menus para esse aplicativo
		
		theDesktop = new JDesktopPane();//cria o painel de área de trabalho
		add(theDesktop);//adiciona painel de área de trabalho
		
		newFrame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//cria o frame interno
				JInternalFrame frame =new JInternalFrame("Internal Frame",true,true,true,true);
				JPanel panel = new JPanel();
				frame.add(panel);
				frame.pack();
				theDesktop.add(frame);
				frame.setVisible(true);
			}
		});
		
	}
	
	
}
