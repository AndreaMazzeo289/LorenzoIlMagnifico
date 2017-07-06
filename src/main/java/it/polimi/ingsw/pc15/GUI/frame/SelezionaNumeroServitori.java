package it.polimi.ingsw.pc15.GUI.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import it.polimi.ingsw.pc15.GUI.ButtonListener;

public class SelezionaNumeroServitori extends JFrame{

	private JPanel panelButton;
	
	private JLabel testo;
	
	private JButton buttonNo;
	private JButton buttonSi;
	
	transient ImageIcon imageIcon;
	transient Image image, newImage;
	
	private int altezzaButton;
	private int larghezzaButton;
	
	private JFrame frameNumeroServitori;
	private JTextArea inputNumero;
	
	private ButtonListener buttonListenerCall;
	
	public SelezionaNumeroServitori(ButtonListener buttonListener) {
		
		buttonListenerCall = buttonListener;
		
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
		
		//buttonSi.setText("SI");
		//buttonNo.setText("NO");
		
		buttonSi.addActionListener(buttonListenerCall);
		buttonNo.addActionListener(buttonListenerCall);
		
		buttonSi.setActionCommand("siServitori");
		buttonNo.setActionCommand("noServitori");
		
		panelButton.add(buttonSi);
		panelButton.add(buttonNo);
		
		testo = new JLabel("",SwingConstants.CENTER);
		testo.setText("VUOI USARE SERVITORI AGGIUNTIVI?");
		testo.setFont((new Font("Courier New", Font.ITALIC, 15)));
		
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
		
		inputNumero = new JTextArea();
		inputNumero.setLayout(new GridLayout(1,1));
		
		inputNumero.setFont((new Font("Courier New", Font.ITALIC, 50)));
		
		JLabel labelTitolo = new JLabel("",SwingConstants.CENTER);
		labelTitolo.setFont((new Font("Courier New", Font.ITALIC, 15)));
		
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
