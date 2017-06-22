package it.polimi.ingsw.pc15.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameInformazioniPlayer extends JFrame{

	int larghezza;
	int altezza;
	int numeroPlayer=4;
	
	ArrayList<JPanel> listaInformazioniPlayer;
	
	JPanel panelCenter = new JPanel();
	
	JLabel labelNorth = new JLabel();
	
	ImageIcon imageIcon;
	Image image, newImage;
	
	Dimension dimension;
	
	int altezzaComponent;
	int larghezzaNome;   //674
	int larghezzaPunti;   //150
	int larghezzaButton; //400
	
	public FrameInformazioniPlayer() {
		
		altezzaComponent = 100;
		larghezzaNome = 524;   //674
		larghezzaPunti = 50;   //300
		larghezzaButton = 50; //400
		larghezza = 1024;
		altezza = 200 + (altezzaComponent*numeroPlayer);
		
		this.getContentPane().setLayout(new BorderLayout());
		
		ImageIcon imageNorth = new ImageIcon("img/InfoPlayer/titoloClassifica.png");
		labelNorth.setIcon(imageNorth);
		
		listaInformazioniPlayer = new ArrayList<JPanel>(numeroPlayer);
		
		for(int i=0; i<numeroPlayer; i++) {
			//creazione record
			
			JPanel panelPlayer = new JPanel();
			panelPlayer.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			
			JLabel nome = new JLabel();
			JLabel puntiVittoria = new JLabel();
			JLabel puntiMilitari = new JLabel();
			JLabel puntiFede = new JLabel();
			JButton territorio = new JButton();
			JButton edifico = new JButton();
			JButton personaggio = new JButton();
			JButton impresa = new JButton();
			
			nome.setName("nome");
			puntiVittoria.setName("punti");
			puntiMilitari.setName("punti");
			puntiFede.setName("punti");
			
			dimension = new Dimension(larghezzaNome, altezzaComponent);
			nome.setPreferredSize(new Dimension(larghezzaNome, altezzaComponent));
			dimension = new Dimension(larghezzaPunti, altezzaComponent);
			puntiVittoria.setMinimumSize(dimension);
			puntiMilitari.setMinimumSize(dimension);
			puntiFede.setMinimumSize(dimension);
			dimension = new Dimension(larghezzaButton, altezzaComponent);
			territorio.setMinimumSize(dimension);
			edifico.setMinimumSize(dimension);
			personaggio.setMinimumSize(dimension);
			impresa.setMinimumSize(dimension);
			
			nome.setOpaque(true);
			nome.setBackground(Color.decode("15394527"));
			puntiVittoria.setOpaque(true);
			puntiVittoria.setBackground(Color.decode("15394527"));
			puntiFede.setOpaque(true);
			puntiFede.setBackground(Color.decode("15394527"));
			puntiMilitari.setOpaque(true);
			puntiMilitari.setBackground(Color.decode("15394527"));

			inserisciTesto(nome, "nome del giocatore");
			inserisciTesto(puntiVittoria, "null");
			inserisciTesto(puntiFede, "null");
			inserisciTesto(puntiMilitari, "null");
			
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
			
			gbc.gridy=0;
			gbc.gridx=0;
			panelPlayer.add(nome,gbc);
			gbc.gridx=1;
			panelPlayer.add(puntiVittoria,gbc);
			gbc.gridx=2;
			panelPlayer.add(puntiMilitari,gbc);
			gbc.gridx=3;
			panelPlayer.add(puntiFede,gbc);
			gbc.gridx=4;
			panelPlayer.add(territorio,gbc);
			gbc.gridx=5;
			panelPlayer.add(edifico,gbc);
			gbc.gridx=6;
			panelPlayer.add(personaggio,gbc);
			gbc.gridx=7;
			panelPlayer.add(impresa,gbc);
			
			listaInformazioniPlayer.add(panelPlayer);
		}
		
		panelCenter.setLayout(new GridLayout(numeroPlayer,1));
		for(JPanel panelGiocatore : listaInformazioniPlayer)
			panelCenter.add(listaInformazioniPlayer.get(listaInformazioniPlayer.lastIndexOf(panelGiocatore)));
		
		this.setSize(larghezza, altezza);
		this.add(labelNorth, BorderLayout.NORTH);
		this.add(panelCenter, BorderLayout.CENTER);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
	}
	
	public void inserisciTesto (JLabel label, String text) {

		int larghezza;
		int numeroSpazi;
		String toStamp = new String("");
		
		if(label.getName().equals("nome"))
			larghezza = larghezzaNome;
		else
			larghezza = larghezzaPunti;
		
		numeroSpazi = (larghezza-(text.length()))/2;
		System.out.println(numeroSpazi);
		
		for(int i=0; i<numeroSpazi/4; i++)
			toStamp += ' ';
		toStamp += text;
		for(int i=0; i<numeroSpazi/4; i++)
			toStamp += ' ';
		
		label.setText(toStamp);
	}
	
}
