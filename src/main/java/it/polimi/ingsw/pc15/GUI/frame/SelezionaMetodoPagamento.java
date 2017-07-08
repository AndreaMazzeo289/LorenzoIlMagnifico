package it.polimi.ingsw.pc15.GUI.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import it.polimi.ingsw.pc15.GUI.ButtonListener;

public class SelezionaMetodoPagamento extends JFrame{

	private JPanel panelButton;
	
	private JLabel testo;
	
	private JButton buttonRisorse;
	private JButton buttonMilitari;
	
	transient ImageIcon imageIcon;
	transient Image image, newImage;
	
	private int altezzaButton;
	private int larghezzaButton;
	
	private transient ButtonListener buttonListenerCall;
	
	public SelezionaMetodoPagamento(ButtonListener buttonListener) {
		
		buttonListenerCall = buttonListener;
		
		altezzaButton = 200;
		larghezzaButton = 600;
		
		this.setBackground(Color.decode("15394527"));
		this.getContentPane().setLayout(new BorderLayout());
		
		panelButton = new JPanel(new GridLayout(1,2));
		
		buttonRisorse = new JButton();
		buttonMilitari = new JButton();
		
		imageIcon = new ImageIcon("img/Punchboard/Popup/Risorse.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaButton,altezzaButton,Image.SCALE_DEFAULT);
		ImageIcon imageButtonRisorse = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img/Punchboard/Popup/PuntiMilitari.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaButton,altezzaButton,Image.SCALE_DEFAULT);
		ImageIcon imageButtonMilitari = new ImageIcon(newImage);
		
		buttonRisorse.setIcon(imageButtonRisorse);
		buttonMilitari.setIcon(imageButtonMilitari);
		
		buttonRisorse.setBorder(null);
		buttonMilitari.setBorder(null);
		
		buttonRisorse.addActionListener(buttonListenerCall);
		buttonMilitari.addActionListener(buttonListenerCall);
		
		buttonRisorse.setActionCommand("sceltoPagamentoRisorse");
		buttonMilitari.setActionCommand("sceltoPagamentoPuntiMilitari");
		
		panelButton.add(buttonRisorse);
		panelButton.add(buttonMilitari);
		
		testo = new JLabel("",SwingConstants.CENTER);
		testo.setText("COME VUOI PAGARE?");
		testo.setFont((new Font("Courier New", Font.ITALIC, 25)));
		
		this.add(testo, BorderLayout.NORTH);
		this.add(panelButton, BorderLayout.CENTER);
		
		this.setSize(larghezzaButton*2, altezzaButton);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
	}
	
}
