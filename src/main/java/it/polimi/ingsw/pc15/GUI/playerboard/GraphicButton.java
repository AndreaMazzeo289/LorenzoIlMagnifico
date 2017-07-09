package it.polimi.ingsw.pc15.GUI.playerboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import it.polimi.ingsw.pc15.GUI.ButtonListener;
import it.polimi.ingsw.pc15.GUI.GUI;

/**
 * Classe che permette di gestire i button della GUI
 * @author AndreaMazzeo289
 *
 */
public class GraphicButton extends JButton{

	private JLabel imageButton;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	private int altezzaTotale;
	private int larghezzaTotale;
	private float rapporto;
	private int altezzaSchermo;
	private int larghezzaSchermo;
	
	public GraphicButton(int larghezza, int altezza, String imgPath, String actionCommand, ButtonListener listener, boolean border, GUI gui) {
		
		larghezzaTotale = gui.larghezzaTotale;
		altezzaTotale =  gui.altezzaTotale;
		rapporto = gui.rapportoPlayerBoard;
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)(((float)screenSize.getWidth())*rapporto);
		
		this.setLayout(new BorderLayout());
		
		imageButton = new JLabel();
		
		ImageIcon imageIcon;
		Image image, newImage;
		
		imageIcon = new ImageIcon(imgPath);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezza)/larghezzaTotale),((int)(altezzaSchermo*altezza)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageAll = new ImageIcon(newImage);
		
		this.setIcon(imageAll);
		this.setPreferredSize(new Dimension(larghezza,altezza));
		this.setActionCommand(actionCommand);
		
		if(border)
			this.setBackground(Color.decode("15394527"));
		else
			this.setBorder(null);
		this.addActionListener(listener);
	}
	
	/**
	 * metodo che blocca il button nei momenti in cui non può essere premuto
	 */
	public void bloccaButton() {
		this.setEnabled(false);
	}
	
	/**
	 * metodo complementare al precedente che sblocca il button
	 */
	public void sbloccaButton() {
		this.setEnabled(true);
	}
}
