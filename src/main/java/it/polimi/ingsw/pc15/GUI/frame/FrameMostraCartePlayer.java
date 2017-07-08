package it.polimi.ingsw.pc15.GUI.frame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.Player;

public class FrameMostraCartePlayer extends JFrame{

	private String path;
	
	private ArrayList<JLabel> arrayCarte;
	
	private JPanel panelCarte;
	private JLabel carta;
	
	private int altezza;
	private int larghezza;
	private int altezzaCarta;
	private int larghezzaCarta;
	private int numCarte;
	
	transient ImageIcon imageIcon;
	transient Image image, newImage;
	
	public FrameMostraCartePlayer(TipoCarta tipoCarta, Player player) {
		
		//foreach card in set add in frame 
		
		altezzaCarta=550;
		larghezzaCarta=320;
		
		//init
		arrayCarte = new ArrayList<JLabel>();
		panelCarte = new JPanel(new GridLayout(1,6));
		
		numCarte = player.getCarte(tipoCarta).size();
		
		for(int i=0; i<numCarte; i++) {
			
			carta = new JLabel();
			path = player.getCarte(tipoCarta).get(i).getImagePath();
			imageIcon = new ImageIcon(path);
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(larghezzaCarta,altezzaCarta,Image.SCALE_DEFAULT);
			ImageIcon imageCard = new ImageIcon(newImage);
			carta.setIcon(imageCard);
			arrayCarte.add(carta);
			panelCarte.add(carta);
		}
		
		this.getContentPane().setLayout(new BorderLayout());
		this.add(panelCarte, BorderLayout.CENTER);
		this.setSize(larghezzaCarta*6,altezzaCarta);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
	}
	
}
