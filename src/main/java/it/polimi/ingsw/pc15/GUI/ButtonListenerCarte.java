package it.polimi.ingsw.pc15.GUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe che permette di creare un frame di zoom della carta selezionata
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */
public class ButtonListenerCarte implements ActionListener{

	private int larghezza = 500;
	private int altezza = 800;
	GUI gui;
	
	 public ButtonListenerCarte(GUI gui) {
		 this.gui = gui;
	  }

	@Override
	public void actionPerformed(ActionEvent e) {
		String path = "";
		String tipo = "";
		boolean write=false;
		for(int i = 0; i < e.getActionCommand().length(); i++)
		{
			  char lettera = e.getActionCommand().charAt(i);
			  if(!write && lettera != '-') {
				  Character.toString(lettera);
				  path+=lettera; 
			  }
			  if(write) {
				  Character.toString(lettera);
				  tipo+=lettera;
			  }
			  if(lettera == '-')
			    write=true;
		}
		
		JFrame zoomCard = new JFrame();
		JPanel panelCard = new JPanel();
		ImageIcon imageIcon = new ImageIcon(path);
		Image image = imageIcon.getImage();
		Image newImage = image.getScaledInstance(larghezza, altezza, Image.SCALE_DEFAULT);
		ImageIcon newImageIcon = new ImageIcon(newImage);
		JLabel label = new JLabel();
		label.setIcon(newImageIcon);
				
		panelCard.add(label);
		zoomCard.add(panelCard);
		zoomCard.getContentPane().setBackground(Color.decode("15394527"));
		zoomCard.setSize(600, 900);
		zoomCard.setVisible(true);
		zoomCard.setAlwaysOnTop(true);
	}
}
