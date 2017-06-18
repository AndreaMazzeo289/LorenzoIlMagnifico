package it.polimi.ingsw.pc15.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelezionaNumeroServitori extends JFrame{

	JPanel panelButton;
	
	JLabel testo;
	
	JButton buttonNo;
	JButton buttonSi;
	
	ImageIcon imageIcon;
	Image image, newImage;
	
	int altezzaButton;
	int larghezzaButton;
	
	public SelezionaNumeroServitori(ButtonListener listener) {
		
		altezzaButton = 200;
		larghezzaButton = 200;
		
		this.setBackground(Color.decode("15394527"));
		this.getContentPane().setLayout(new BorderLayout());
		
		panelButton = new JPanel(new GridLayout(1,2));
		
		buttonNo = new JButton();
		buttonSi = new JButton();
		
		imageIcon = new ImageIcon("img/Punchboard/Popup/SiButton.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaButton,altezzaButton,Image.SCALE_DEFAULT);
		ImageIcon imageButtonSi = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img/Punchboard/Popup/NoButton.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaButton,altezzaButton,Image.SCALE_DEFAULT);
		ImageIcon imageButtonNo = new ImageIcon(newImage);
		
		buttonSi.setIcon(imageButtonSi);
		buttonNo.setIcon(imageButtonNo);
		
		buttonSi.setBorder(null);
		buttonNo.setBorder(null);
		
		buttonSi.addActionListener(listener);
		buttonNo.addActionListener(listener);
		
		buttonSi.setActionCommand("siServitori");
		buttonSi.setActionCommand("noServitori");
		
		panelButton.add(buttonSi);
		panelButton.add(buttonNo);
		
		testo = new JLabel();
		testo.setText("VUOI USARE SERVITORI AGGIUNTIVI?");
		
		this.add(testo, BorderLayout.NORTH);
		this.add(panelButton, BorderLayout.CENTER);
		
		this.setSize(larghezzaButton*2, altezzaButton);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
	}
	
}
