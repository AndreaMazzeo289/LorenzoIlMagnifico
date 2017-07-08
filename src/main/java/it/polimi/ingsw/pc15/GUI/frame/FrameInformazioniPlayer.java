package it.polimi.ingsw.pc15.GUI.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.html.HTMLDocument.Iterator;

import it.polimi.ingsw.pc15.GUI.ButtonListener;
import it.polimi.ingsw.pc15.GUI.GUI;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class FrameInformazioniPlayer extends JFrame{

	private int larghezza;
	private int altezza;
	private int numeroPlayer;
	
	private HashMap<String, JPanel> listaPanelPlayer;
	
	private JPanel panelCenter = new JPanel();
	private JLabel labelNorth = new JLabel();
	
	transient ImageIcon imageIcon;
	transient Image image, newImage;
	transient ImageIcon imageNorth;
	
	private Dimension dimension;
	
	private int altezzaComponent;
	private int larghezzaNome;
	private int larghezzaPunti;
	private int larghezzaButton;
	
	public FrameInformazioniPlayer(ArrayList<Player> arrayListAvversari, GUI gui) {
		
		numeroPlayer = arrayListAvversari.size();
		
		altezzaComponent = 100;
		larghezzaNome = 550;
		larghezzaPunti = 65;
		larghezzaButton = 50;
		larghezza = 1024;
		altezza = 400 + (altezzaComponent*numeroPlayer);
		
		this.getContentPane().setLayout(new BorderLayout());
		
		imageNorth = new ImageIcon("img/InfoPlayer/titoloClassificaMod.png");
		labelNorth.setIcon(imageNorth);
		
		listaPanelPlayer = new HashMap<String, JPanel>();
		
		for(int i=0; i<numeroPlayer; i++) {
			
			JPanel panelPlayer = new JPanel();
			panelPlayer.setLayout(new FlowLayout());
			
			JLabel nome = new JLabel(arrayListAvversari.get(i).getNome(), SwingConstants.CENTER);
			JLabel puntiVittoria = new JLabel(Integer.toString(arrayListAvversari.get(i).getSetRisorse().getRisorsa(TipoRisorsa.PUNTIVITTORIA).getQuantità()), SwingConstants.CENTER);
			JLabel puntiMilitari = new JLabel(Integer.toString(arrayListAvversari.get(i).getSetRisorse().getRisorsa(TipoRisorsa.PUNTIMILITARI).getQuantità()), SwingConstants.CENTER);
			JLabel puntiFede = new JLabel(Integer.toString(arrayListAvversari.get(i).getSetRisorse().getRisorsa(TipoRisorsa.PUNTIFEDE).getQuantità()), SwingConstants.CENTER);
			JButton territorio = new JButton();
			JButton edifico = new JButton();
			JButton personaggio = new JButton();
			JButton impresa = new JButton();
			
			territorio.addActionListener(new ButtonListener(gui));
			edifico.addActionListener(new ButtonListener(gui));
			personaggio.addActionListener(new ButtonListener(gui));
			impresa.addActionListener(new ButtonListener(gui));
			
			territorio.setActionCommand("carteTerritorioPlayer"+i);
			edifico.setActionCommand("carteEdificioPlayer"+i);
			personaggio.setActionCommand("cartePersonaggioPlayer"+i);
			impresa.setActionCommand("carteImpresaPlayer"+i);
			
			puntiVittoria.setName("puntiVittoria");
			puntiMilitari.setName("puntiMilitari");
			puntiFede.setName("puntiFede");
			
			dimension = new Dimension(larghezzaNome, altezzaComponent);
			nome.setPreferredSize(new Dimension(larghezzaNome, altezzaComponent));
			dimension = new Dimension(larghezzaPunti, altezzaComponent);
			puntiVittoria.setPreferredSize(dimension);
			puntiMilitari.setPreferredSize(dimension);
			puntiFede.setPreferredSize(dimension);
			dimension = new Dimension(larghezzaButton, altezzaComponent);
			territorio.setPreferredSize(dimension);
			edifico.setPreferredSize(dimension);
			personaggio.setPreferredSize(dimension);
			impresa.setPreferredSize(dimension);
			
			nome.setOpaque(true);
			nome.setBackground(Color.decode("15394527"));
			puntiVittoria.setOpaque(true);
			puntiVittoria.setBackground(Color.decode("15394527"));
			puntiFede.setOpaque(true);
			puntiFede.setBackground(Color.decode("15394527"));
			puntiMilitari.setOpaque(true);
			puntiMilitari.setBackground(Color.decode("15394527"));

			nome.setFont((new Font("Courier New", Font.ITALIC, 12)));
			
			imageIcon = new ImageIcon("img/InfoPlayer/Territorio.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(larghezzaButton,altezzaComponent,Image.SCALE_DEFAULT);
			ImageIcon imageTerritorio = new ImageIcon(newImage);
			imageIcon = new ImageIcon("img/InfoPlayer/Edificio.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(larghezzaButton,altezzaComponent,Image.SCALE_DEFAULT);
			ImageIcon imageEdificio = new ImageIcon(newImage);
			imageIcon = new ImageIcon("img/InfoPlayer/Personaggio.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(larghezzaButton,altezzaComponent,Image.SCALE_DEFAULT);
			ImageIcon imagePersonaggio = new ImageIcon(newImage);
			imageIcon = new ImageIcon("img/InfoPlayer/Impresa.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(larghezzaButton,altezzaComponent,Image.SCALE_DEFAULT);
			ImageIcon imageImpresa = new ImageIcon(newImage);
			
			territorio.setIcon(imageTerritorio);
			edifico.setIcon(imageEdificio);
			personaggio.setIcon(imagePersonaggio);
			impresa.setIcon(imageImpresa);
			
			territorio.setBorder(null);
			edifico.setBorder(null);
			personaggio.setBorder(null);
			impresa.setBorder(null);
			
			panelPlayer.add(nome);
			panelPlayer.add(puntiMilitari);
			panelPlayer.add(puntiFede);
			panelPlayer.add(puntiVittoria);
			panelPlayer.add(territorio);
			panelPlayer.add(edifico);
			panelPlayer.add(personaggio);
			panelPlayer.add(impresa);
			
			listaPanelPlayer.put("Player"+i, panelPlayer);	
		}
		
		panelCenter.setLayout(new GridLayout(numeroPlayer,1));
		
		for (String key : listaPanelPlayer.keySet())
			panelCenter.add(listaPanelPlayer.get(key));
		
		this.setSize(larghezza, altezza);
		this.add(labelNorth, BorderLayout.NORTH);
		this.add(panelCenter, BorderLayout.CENTER);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
	}
	
	public void aggiornaRisorse(String player, String tipoRisorsa, int value) {
		
		JLabel label=null;
		
		for (String key : listaPanelPlayer.keySet()) {
			
			if(key.equals(player)) {
				
				switch(tipoRisorsa) {
				case "puntiVittoria":
					label = (JLabel) listaPanelPlayer.get(key).getComponent(3);
					break;
				case "puntiMilitari":
					label = (JLabel) listaPanelPlayer.get(key).getComponent(1);
					break;
				case "puntiFede":
					label = (JLabel) listaPanelPlayer.get(key).getComponent(2);
					break;
				}
				
				label.setText(Integer.toString(value));
			}
		}
	}
}
