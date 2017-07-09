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

/**
 * Classe che permette l'apparizione di un frame che richiede quale metodo di pagamento si vuole scegliere
 * @author AndreaMazzeo289
 *
 */
public class FrameRapportoVaticano extends JFrame{

	private JPanel panelButton;
	
	private JLabel testo;
	
	private JButton pagaPunti;
	private JButton prendiScomunica;
	
	transient ImageIcon imageIcon;
	transient Image image, newImage;
	
	private int altezzaButton;
	private int larghezzaButton;
	
	private transient ButtonListener buttonListenerCall;
	
	public FrameRapportoVaticano(ButtonListener buttonListener) {
		
		buttonListenerCall = buttonListener;
		
		altezzaButton = 200;
		larghezzaButton = 600;
		
		this.setBackground(Color.decode("15394527"));
		this.getContentPane().setLayout(new BorderLayout());
		
		panelButton = new JPanel(new GridLayout(1,2));
		
		pagaPunti = new JButton();
		prendiScomunica = new JButton();
		
		imageIcon = new ImageIcon("img/Punchboard/Popup/pagaPuntiFede.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaButton,altezzaButton,Image.SCALE_DEFAULT);
		ImageIcon imagePunti = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img/Punchboard/Popup/subisciScomunica.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaButton,altezzaButton,Image.SCALE_DEFAULT);
		ImageIcon imageScomunica = new ImageIcon(newImage);
		
		pagaPunti.setIcon(imagePunti);
		prendiScomunica.setIcon(imageScomunica);
		
		pagaPunti.setBorder(null);
		prendiScomunica.setBorder(null);
		
		pagaPunti.addActionListener(buttonListenerCall);
		prendiScomunica.addActionListener(buttonListenerCall);
		
		pagaPunti.setActionCommand("sceltoPagarePuntiFede");
		prendiScomunica.setActionCommand("sceltoSubireScomunica");
		
		panelButton.add(pagaPunti);
		panelButton.add(prendiScomunica);
		
		testo = new JLabel("",SwingConstants.CENTER);
		testo.setText("COSA INTENDI FARE?");
		testo.setFont((new Font("Courier New", Font.ITALIC, 25)));
		
		this.add(testo, BorderLayout.NORTH);
		this.add(panelButton, BorderLayout.CENTER);
		
		this.setSize(larghezzaButton*2, altezzaButton);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
	}
	
}
