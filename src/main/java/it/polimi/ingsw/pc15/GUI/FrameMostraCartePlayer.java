package it.polimi.ingsw.pc15.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.polimi.ingsw.pc15.carte.TipoCarta;

public class FrameMostraCartePlayer extends JFrame{

	String path;
	
	ArrayList<JLabel> arrayCarte;
	
	JPanel panelCarte;
	JLabel carta;
	
	int altezza, larghezza;
	int altezzaCarta, larghezzaCarta;
	
	ImageIcon imageIcon;
	Image image, newImage;
	
	public FrameMostraCartePlayer(TipoCarta tipoCarta) {
		
		//foreach card in set add in frame 
		
		altezzaCarta=550;
		larghezzaCarta=320;
		
		//init
		arrayCarte = new ArrayList<JLabel>();
		panelCarte = new JPanel(new GridLayout(1,6));
		
		switch(tipoCarta) {
		case TERRITORIO:
			path = "img/DevCardsBack/devcards_b_c_g_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg";
			break;
		case EDIFICIO:
			path = "img/DevCardsBack/devcards_b_c_y_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg";
			break;
		case PERSONAGGIO:
			path = "img/DevCardsBack/devcards_b_c_b_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg";
			break;
		case IMPRESA:
			path = "img/DevCardsBack/devcards_b_c_p_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg";
			break;
		}
		
		for(int i=0; i<6; i++) {
			
			carta = new JLabel();
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
