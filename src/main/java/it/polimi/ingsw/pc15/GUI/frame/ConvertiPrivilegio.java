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
 * Classe che permette l'apparizione di un frame per la conversione del privilegio in risorse
 * @author AndreaMazzeo289
 *
 */
public class ConvertiPrivilegio extends JFrame{

	private JPanel panelButton;
	
	private JLabel testo;
	
	private JButton buttonOro;
	private JButton buttonServitori;
	private JButton buttonPietraLegna;
	private JButton buttonFede;
	private JButton buttonMilitari;
	
	transient ImageIcon imageIcon;
	transient Image image, newImage;
	
	private int altezzaButton;
	private int larghezzaButton;
	
	private transient ButtonListener buttonListenerCall;
	
	public ConvertiPrivilegio(ButtonListener buttonListener) {
		
		buttonListenerCall = buttonListener;
		
		altezzaButton = 300;
		larghezzaButton = 300;
		
		this.setBackground(Color.decode("15394527"));
		this.getContentPane().setLayout(new BorderLayout());
		
		panelButton = new JPanel(new GridLayout(1,5));
		
		buttonPietraLegna = new JButton();
		buttonOro = new JButton();
		buttonServitori = new JButton();
		buttonFede = new JButton();
		buttonMilitari = new JButton();
		
		imageIcon = new ImageIcon("img/Punchboard/Popup/privilegi/oro.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaButton,altezzaButton,Image.SCALE_DEFAULT);
		ImageIcon imageButtonOro = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img/Punchboard/Popup/privilegi/legnapietra.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaButton,altezzaButton,Image.SCALE_DEFAULT);
		ImageIcon imageButtonLegnapietra = new ImageIcon(newImage);

		imageIcon = new ImageIcon("img/Punchboard/Popup/privilegi/servitori.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaButton,altezzaButton,Image.SCALE_DEFAULT);
		ImageIcon imageButtonServitori = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img/Punchboard/Popup/privilegi/militari.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaButton,altezzaButton,Image.SCALE_DEFAULT);
		ImageIcon imageButtonMilitari = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img/Punchboard/Popup/privilegi/fede.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaButton,altezzaButton,Image.SCALE_DEFAULT);
		ImageIcon imageButtonFede = new ImageIcon(newImage);
		
		buttonFede.setIcon(imageButtonFede);
		buttonOro.setIcon(imageButtonOro);
		buttonPietraLegna.setIcon(imageButtonLegnapietra);
		buttonServitori.setIcon(imageButtonServitori);
		buttonMilitari.setIcon(imageButtonMilitari);
		
		buttonFede.setBorder(null);
		buttonOro.setBorder(null);
		buttonPietraLegna.setBorder(null);
		buttonServitori.setBorder(null);
		buttonMilitari.setBorder(null);
		
		buttonFede.addActionListener(buttonListenerCall);
		buttonOro.addActionListener(buttonListenerCall);
		buttonPietraLegna.addActionListener(buttonListenerCall);
		buttonServitori.addActionListener(buttonListenerCall);
		buttonMilitari.addActionListener(buttonListenerCall);
		
		buttonFede.setActionCommand("privilegioInFede");
		buttonOro.setActionCommand("privilegioInOro");
		buttonPietraLegna.setActionCommand("privilegioInPietraLegna");
		buttonServitori.setActionCommand("privilegioInServitori");
		buttonMilitari.setActionCommand("privilegioInMilitari");
		
		buttonPietraLegna.setBackground(Color.decode("15394527"));
		buttonOro.setBackground(Color.decode("15394527"));
		buttonFede.setBackground(Color.decode("15394527"));
		buttonServitori.setBackground(Color.decode("15394527"));
		buttonMilitari.setBackground(Color.decode("15394527"));
		
		panelButton.add(buttonPietraLegna);
		panelButton.add(buttonOro);
		panelButton.add(buttonServitori);
		panelButton.add(buttonFede);
		panelButton.add(buttonMilitari);
		
		testo = new JLabel("",SwingConstants.CENTER);
		testo.setText("CHE RISORSA VUOI OTTENERE?");
		testo.setFont((new Font("Courier New", Font.ITALIC, 25)));
		
		this.add(testo, BorderLayout.NORTH);
		this.add(panelButton, BorderLayout.CENTER);
		
		this.setSize(larghezzaButton*5, altezzaButton+100);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
	}
	
}
