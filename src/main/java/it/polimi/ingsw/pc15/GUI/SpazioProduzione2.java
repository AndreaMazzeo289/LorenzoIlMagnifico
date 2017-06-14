package it.polimi.ingsw.pc15.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SpazioProduzione2 extends JPanel{

	JLabel labelNorth;
	JLabel labelEast;
	JLabel labelWest;
	JLabel labelSouth;
	JLabel labelCenter;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	ButtonTransparent button1;
	ButtonTransparent button2;
	ButtonTransparent button3;
	ButtonTransparent button4;
	ButtonTransparent button5;
	ButtonTransparent button6;
	ButtonTransparent button7;
	ButtonTransparent button8;
	ButtonTransparent button9;
	ButtonTransparent button10;
	ButtonTransparent button11;
	ButtonTransparent button12;
	ButtonTransparent button13;
	ButtonTransparent button14;
	ButtonTransparent button15;
	ButtonTransparent button16;
	
	int altezzaSchermo;
	int larghezzaSchermo;
	int larghezzaTotale;
	int altezzaTotale;
	
	ImageIcon imageIcon;
	Image image, newImage;
	
	float rapporto;
	
	public SpazioProduzione2() {
		
		larghezzaTotale = mainGUI.larghezzaTotale;
		altezzaTotale =  mainGUI.altezzaTotale;
		rapporto = mainGUI.rapporto;
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)(((float)screenSize.getWidth())*rapporto);
		//larghezzaSchermo = (int)screenSize.getWidth()/2;
		
		this.setLayout(new BorderLayout());
		
		int altezzaECW = 170;
		int altezzaN = 487;
		int altezzaS = 200;//59
		int larghezzaW = 158;
		int larghezzaE = 512;
		int larghezzaC = 820;
		int larghezzaN = larghezzaW+larghezzaE+larghezzaC; //956
		int larghezzaS = larghezzaN;
		System.out.println("larghezza spazio prod 2:" +larghezzaS);
		
		labelNorth = new JLabel();
		labelEast = new JLabel();
		labelWest = new JLabel();
		labelSouth = new JLabel();
		labelCenter = new JLabel();
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziProduzione\\2\\north.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaN)/larghezzaTotale),((int)(altezzaSchermo*altezzaN)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageNorth = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziProduzione\\2\\east.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaE)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageEast = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziProduzione\\2\\west.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaW)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageWest = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziProduzione\\2\\center.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaC)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageCenter = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziProduzione\\2\\south.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaS)/larghezzaTotale),((int)(altezzaSchermo*altezzaS)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageSouth = new ImageIcon(newImage);
		
		labelNorth.setIcon(imageNorth);
		labelEast.setIcon(imageEast);
		labelWest.setIcon(imageWest);
		labelSouth.setIcon(imageSouth);
		labelCenter.setIcon(imageCenter);
		
		labelCenter.setLayout(new BorderLayout());
		JLabel labelButton = new JLabel();
		labelButton.setLayout(new GridLayout(2,8));
		
		button1 = new ButtonTransparent("SpazioProduzionePosizione1",100,85);
		button2= new ButtonTransparent("SpazioProduzionePosizione2",100,85);
		button3 = new ButtonTransparent("SpazioProduzionePosizione3",100,85);
		button4 = new ButtonTransparent("SpazioProduzionePosizione4",100,85);
		button5 = new ButtonTransparent("SpazioProduzionePosizione5",100,85);
		button6 = new ButtonTransparent("SpazioProduzionePosizione6",100,85);
		button7 = new ButtonTransparent("SpazioProduzionePosizione7",100,85);
		button8 = new ButtonTransparent("SpazioProduzionePosizione8",100,85);
		button9 = new ButtonTransparent("SpazioProduzionePosizione9",100,85);
		button10 = new ButtonTransparent("SpazioProduzionePosizione10",100,85);
		button11 = new ButtonTransparent("SpazioProduzionePosizione11",100,85);
		button12 = new ButtonTransparent("SpazioProduzionePosizione12",100,85);
		button13 = new ButtonTransparent("SpazioProduzionePosizione13",100,85);
		button14 = new ButtonTransparent("SpazioProduzionePosizione14",100,85);
		button15 = new ButtonTransparent("SpazioProduzionePosizione15",100,85);
		button16 = new ButtonTransparent("SpazioProduzionePosizione16",100,85);
		
		labelButton.add(button1);
		labelButton.add(button2);
		labelButton.add(button3);
		labelButton.add(button4);
		labelButton.add(button5);
		labelButton.add(button6);
		labelButton.add(button7);
		labelButton.add(button8);
		labelButton.add(button9);
		labelButton.add(button10);
		labelButton.add(button11);
		labelButton.add(button12);
		labelButton.add(button13);
		labelButton.add(button14);
		labelButton.add(button15);
		labelButton.add(button16);
		
		labelButton.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
		labelButton.setAlignmentY(java.awt.Component.CENTER_ALIGNMENT);
		labelCenter.add(labelButton);
		
		this.add(labelNorth, BorderLayout.NORTH);
		this.add(labelEast, BorderLayout.EAST);
		this.add(labelWest, BorderLayout.WEST);
		this.add(labelSouth, BorderLayout.SOUTH);
		this.add(labelCenter, BorderLayout.CENTER);
	}
	
	public void inserisciFamiliare(String path, ButtonTransparent button) {
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*102)/larghezzaTotale),((int)(altezzaSchermo*85)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageButton = new ImageIcon(newImage);
		
		button.setIcon(imageButton);
		button.setBorder(null);
	}
	
	public ButtonTransparent getButtonPosizione1() {
		return button1;
	}
	
	public ButtonTransparent getButtonPosizione2() {
		return button2;
	}
	
	public ButtonTransparent getButtonPosizione3() {
		return button3;
	}
	
	public ButtonTransparent getButtonPosizione4() {
		return button4;
	}
	
	public ButtonTransparent getButtonPosizione5() {
		return button5;
	}
	
	public ButtonTransparent getButtonPosizione6() {
		return button6;
	}
	
	public ButtonTransparent getButtonPosizione7() {
		return button7;
	}
	
	public ButtonTransparent getButtonPosizione8() {
		return button8;
	}
	
	public ButtonTransparent getButtonPosizione9() {
		return button9;
	}
	public ButtonTransparent getButtonPosizione10() {
		return button10;
	}
	
	public ButtonTransparent getButtonPosizione11() {
		return button11;
	}
	
	public ButtonTransparent getButtonPosizione12() {
		return button12;
	}
	
	public ButtonTransparent getButtonPosizione13() {
		return button13;
	}
	
	public ButtonTransparent getButtonPosizione14() {
		return button14;
	}
	
	public ButtonTransparent getButtonPosizione15() {
		return button15;
	}
	
	public ButtonTransparent getButtonPosizione16() {
		return button16;
	}
	
	
}
