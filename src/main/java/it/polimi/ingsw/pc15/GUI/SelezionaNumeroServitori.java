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
import javax.swing.JTextField;

public class SelezionaNumeroServitori extends JFrame{

	JPanel panelButton;
	
	JLabel testo;
	
	JButton buttonNo;
	JButton buttonSi;
	
	ImageIcon imageIcon;
	Image image, newImage;
	
	int altezzaButton;
	int larghezzaButton;
	
	JFrame frameNumeroServitori;
	JTextField inputNumero;
	
	ButtonListener buttonListenerCall;
	
	public SelezionaNumeroServitori(ButtonListener buttonListener) {
		
		buttonListenerCall = buttonListener;
		
		altezzaButton = 200;
		larghezzaButton = 200;
		
		this.setBackground(Color.decode("15394527"));
		this.getContentPane().setLayout(new BorderLayout());
		
		panelButton = new JPanel(new GridLayout(1,2));
		
		buttonNo = new JButton();
		buttonSi = new JButton();
		
		/*imageIcon = new ImageIcon("img/Punchboard/Popup/SiButton.png");
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
		buttonNo.setBorder(null);*/
		
		buttonSi.setText("SI");
		buttonNo.setText("NO");
		
		buttonSi.addActionListener(buttonListenerCall);
		buttonNo.addActionListener(buttonListenerCall);
		
		buttonSi.setActionCommand("siServitori");
		buttonNo.setActionCommand("noServitori");
		
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
	
	public void numeroServitoriPopup() {
		
		frameNumeroServitori = new JFrame();
		
		JButton submit = new JButton("OK!");
		submit.setActionCommand("submitNumeroServitori");
		submit.addActionListener(buttonListenerCall);
		
		
		inputNumero = new JTextField("Inserire il numero...");
		
		JLabel labelTitolo = new JLabel();
		
		labelTitolo.setText("INSERISCI IL NUMERO DI SERVITORI AGGIUNTIVI:");
		
		frameNumeroServitori.getContentPane().setLayout(new BorderLayout());
		frameNumeroServitori.add(labelTitolo, BorderLayout.NORTH);
		frameNumeroServitori.add(inputNumero, BorderLayout.CENTER);
		frameNumeroServitori.add(submit, BorderLayout.SOUTH);
		
		frameNumeroServitori.setSize(larghezzaButton*2, altezzaButton);
		frameNumeroServitori.setVisible(true);
		frameNumeroServitori.setAlwaysOnTop(true);
	}
	
	public JFrame getPopupNumeroServitori() {
		return frameNumeroServitori;
	}
	
	public int getInputNumero() {
		return Integer.parseInt(inputNumero.getText());
	}
	
}
