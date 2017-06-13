package it.polimi.ingsw.pc15.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SpazioConsiglio extends JPanel{

	JLabel labelEast;
	JLabel labelWest;
	JLabel labelSouth;
	JLabel labelNorth;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	JLabel labelCenter;

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
	
	public SpazioConsiglio() {
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)screenSize.getWidth()/2;
		
		this.setLayout(new BorderLayout());
		
		int altezzaECW = 295;//549
		int altezzaN = 110;
		int altezzaS = 779;//635
		int larghezzaW = 2181;//2059
		int larghezzaE = 819;//727
		int larghezzaC = 1067;//1282
		int larghezzaS = larghezzaW+larghezzaE+larghezzaC;
		int larghezzaN = larghezzaS;
		
		larghezzaTotale = 4076;
		altezzaTotale = 6530;
		
		labelEast = new JLabel();
		labelWest = new JLabel();
		labelSouth = new JLabel();
		labelCenter = new JLabel();
		labelNorth = new JLabel();
		
		ImageIcon imageIcon;
		Image image, newImage;
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpazioConsiglio\\north.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaN)/larghezzaTotale),((int)(altezzaSchermo*altezzaN)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageNorth = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpazioConsiglio\\east.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaE)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageEast = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpazioConsiglio\\west.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaW)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageWest = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpazioConsiglio\\center.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaC)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageCenter = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpazioConsiglio\\south.png");
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
		
		button1 = new ButtonTransparent("SpazioConsiglioPosizione1",100,85);
		button2= new ButtonTransparent("SpazioConsiglioPosizione2",100,85);
		button3 = new ButtonTransparent("SpazioConsiglioPosizione3",100,85);
		button4 = new ButtonTransparent("SpazioConsiglioPosizione4",100,85);
		button5 = new ButtonTransparent("SpazioConsiglioPosizione5",100,85);
		button6 = new ButtonTransparent("SpazioConsiglioPosizione6",100,85);
		button7 = new ButtonTransparent("SpazioConsiglioPosizione7",100,85);
		button8 = new ButtonTransparent("SpazioConsiglioPosizione8",100,85);
		button9 = new ButtonTransparent("SpazioConsiglioPosizione9",100,85);
		button10 = new ButtonTransparent("SpazioConsiglioPosizione10",100,85);
		button11 = new ButtonTransparent("SpazioConsiglioPosizione11",100,85);
		button12 = new ButtonTransparent("SpazioConsiglioPosizione12",100,85);
		button13 = new ButtonTransparent("SpazioConsiglioPosizione13",100,85);
		button14 = new ButtonTransparent("SpazioConsiglioPosizione14",100,85);
		button15 = new ButtonTransparent("SpazioConsiglioPosizione15",100,85);
		button16 = new ButtonTransparent("SpazioConsiglioPosizione16",100,85);
		
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
