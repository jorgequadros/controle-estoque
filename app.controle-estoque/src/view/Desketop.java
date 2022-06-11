package view;

import javax.swing.JFrame;

public class Desketop {
	public static void main(String[] args) {
		DesktopFrame dFrame = new DesktopFrame();
		dFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dFrame.setSize(600,480);
		dFrame.setVisible(true);
	}
}
