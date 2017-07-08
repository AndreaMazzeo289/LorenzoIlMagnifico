package it.polimi.ingsw.pc15.GUI.playerboard;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import it.polimi.ingsw.pc15.GUI.ButtonListener;
import it.polimi.ingsw.pc15.GUI.GUI;
import it.polimi.ingsw.pc15.carte.TipoCarta;

public class PlayerBoard extends JPanel{

	private CarteGioco carta;
	private PersonalBonus personalBonus;
	private CartaLeader cartaLeader;
	private JPanel panelCarteLeader;
	private JPanel risorsePlayer;
	private JPanel cartePlayer;
	private JPanel contentPanel;
	private JPanel presentationPanel;
	private JPanel panelPersonalBonus;
	private JLabel labelTesto;
	
	private ArrayList<CarteGioco> cartePlayerVerdi;
	private ArrayList<CarteGioco> cartePlayerBlu;
	private ArrayList<CarteGioco> cartePlayerGialle;
	private ArrayList<CarteGioco> cartePlayerViola;
	
	private HashMap<TipoCarta,ArrayList<CarteGioco>> cartePlayerMap;
	
	public PlayerBoard(ButtonListener listener, GUI gui) {
		
		this.setLayout(new GridBagLayout());
		
		risorsePlayer = new JPanel(new GridBagLayout());
		cartePlayer = new JPanel(new GridBagLayout());
		contentPanel = new JPanel(new GridBagLayout());
		presentationPanel = new JPanel (new GridBagLayout());
		panelPersonalBonus = new JPanel();
		panelCarteLeader = new JPanel(new GridLayout(4,1));
		
		cartePlayerVerdi = new ArrayList<CarteGioco>();
		cartePlayerBlu = new ArrayList<CarteGioco>();
		cartePlayerGialle = new ArrayList<CarteGioco>();
		cartePlayerViola = new ArrayList<CarteGioco>();
		
		cartePlayerMap = new HashMap<TipoCarta,ArrayList<CarteGioco>>();
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Presentation panel
		//-----------------------//
		gbc.gridx=0;
		gbc.gridy=0;
		presentationPanel.add(new GraphicButton(2500, 400,"img\\Punchboard\\statoGioco.png", "buttonStatoGioco", listener,true,gui),gbc);
		gbc.gridx=1;
		presentationPanel.add(new GraphicButton(1500, 400,"img\\Punchboard\\scomunicheButton.png", "buttonScomuniche", listener,true,gui),gbc);
		
		for(int i=0; i<6; i++) 
			cartePlayerVerdi.add(new CarteGioco("img/DevCardsBack/devcards_b_c_g_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg", TipoCarta.TERRITORIO,gui));
		for(int i=0; i<6; i++) 
			cartePlayerBlu.add(new CarteGioco("img/DevCardsBack/devcards_b_c_b_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg", TipoCarta.TERRITORIO,gui));
		for(int i=0; i<6; i++) 
			cartePlayerGialle.add(new CarteGioco("img/DevCardsBack/devcards_b_c_y_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg", TipoCarta.TERRITORIO,gui));
		for(int i=0; i<6; i++) 
			cartePlayerViola.add(new CarteGioco("img/DevCardsBack/devcards_b_c_p_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg", TipoCarta.TERRITORIO,gui));
		
		cartePlayerMap.put(TipoCarta.TERRITORIO,cartePlayerVerdi);
		cartePlayerMap.put(TipoCarta.PERSONAGGIO,cartePlayerBlu);
		cartePlayerMap.put(TipoCarta.EDIFICIO,cartePlayerGialle);
		cartePlayerMap.put(TipoCarta.IMPRESA,cartePlayerViola);
		
		// Panel carte
		//-----------------------//
		gbc.gridx=0;
		gbc.gridy=0;
		cartePlayer.add(new GraphicButton(400,1100,"img\\Punchboard\\Button\\buttonPosizionaFamiliare.png","posizionaFamiliare", listener, false,gui),gbc);
		for(int i=0; i<6; i++) {
			gbc.gridx=i+1;
			//cartePlayer.add(new CarteGioco("img/DevCardsBack/devcards_b_c_g_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg", TipoCarta.TERRITORIO,gui),gbc);
			cartePlayer.add(cartePlayerVerdi.get(i),gbc);
		}
		gbc.gridx=0;
		gbc.gridy=1;
		cartePlayer.add(new GraphicButton(400,1100,"img\\Punchboard\\Button\\buttonEffettoLeader.png","attivaEffettoLeader", listener, false,gui),gbc);
		for(int i=0; i<6; i++) {
			gbc.gridx=i+1;
			//cartePlayer.add(new CarteGioco("img/DevCardsBack/devcards_b_c_g_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg", TipoCarta.EDIFICIO,gui),gbc);
			cartePlayer.add(cartePlayerBlu.get(i),gbc);
		}
		gbc.gridx=0;
		gbc.gridy=2;
		cartePlayer.add(new GraphicButton(400,1100,"img\\Punchboard\\Button\\buttonAttivaLeader.png","attivaCartaLeader",listener, false,gui),gbc);
		for(int i=0; i<6; i++) {
			gbc.gridx=i+1;
			//cartePlayer.add(new CarteGioco("img/DevCardsBack/devcards_b_c_g_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg", TipoCarta.PERSONAGGIO,gui),gbc);
			cartePlayer.add(cartePlayerGialle.get(i),gbc);
		}
		gbc.gridx=0;
		gbc.gridy=3;
		cartePlayer.add(new GraphicButton(400,1100,"img\\Punchboard\\Button\\buttonScartaLeader.png","scartaCartaLeader", listener, false,gui),gbc);
		for(int i=0; i<6; i++) {
			gbc.gridx=i+1;
			//cartePlayer.add(new CarteGioco("img/DevCardsBack/devcards_b_c_g_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg", TipoCarta.IMPRESA,gui),gbc);
			cartePlayer.add(cartePlayerViola.get(i),gbc);
		}
		
		gbc.gridx=0;
		gbc.gridy=0;
		contentPanel.add(cartePlayer,gbc);
		
		personalBonus = new PersonalBonus("img/Punchboard/personalBonus/bonus1.png", gui);
		panelPersonalBonus.add(personalBonus);
		gbc.gridx=1;
		contentPanel.add(panelPersonalBonus,gbc);
		
		for(int i=1; i<=4; i++) {
			cartaLeader = new CartaLeader("img/Leaders/leaders_b_c_00.jpg","leader"+i,gui);
			panelCarteLeader.add(cartaLeader);
		}
		gbc.gridx=2;
		contentPanel.add(panelCarteLeader,gbc);
		
		// Panel risorse
		//-----------------------//
		gbc.gridx=0;
		gbc.gridy=0;
		risorsePlayer.add(new PanelRisorse("img\\Punchboard\\Risorse\\northOro.png", 0,gui), gbc);
		gbc.gridx=1;
		risorsePlayer.add(new PanelRisorse("img\\Punchboard\\Risorse\\northLegna.png", 0,gui), gbc);
		gbc.gridx=2;
		risorsePlayer.add(new PanelRisorse("img\\Punchboard\\Risorse\\northPietra.png", 0,gui), gbc);
		gbc.gridx=3;
		risorsePlayer.add(new PanelRisorse("img\\Punchboard\\Risorse\\northServitori.png", 0,gui), gbc);
		gbc.gridx=4;
		risorsePlayer.add(new PanelRisorse("img\\Punchboard\\Risorse\\northMilitari.png", 0,gui), gbc);
		gbc.gridx=5;
		risorsePlayer.add(new PanelRisorse("img\\Punchboard\\Risorse\\northFede.png", 0,gui), gbc);
		gbc.gridx=6;
		risorsePlayer.add(new PanelRisorse("img\\Punchboard\\Risorse\\northVittoria.png", 0,gui), gbc);
		gbc.gridx=7;
		risorsePlayer.add(new SpazioFamiliariDisponibili(gui), gbc);
		System.out.println(gui.getPlayerCorrente());
		labelTesto = new JLabel("",SwingConstants.CENTER);
		labelTesto.setFont((new Font("Courier New", Font.ITALIC, 22)));
		
		gbc.gridx=0;
		gbc.gridy=1;
		this.add(labelTesto,gbc);
		gbc.gridx=0;
		gbc.gridy=2;
		this.add(presentationPanel,gbc);
		gbc.gridx=0;
		gbc.gridy=3;
		this.add(contentPanel,gbc);
		gbc.gridx=0;
		gbc.gridy=4;
		this.add(risorsePlayer, gbc);
		
		this.setVisible(true);	
	}
	
	//-------------------------------------------------------------------//
	// METODI GET
	//-------------------------------------------------------------------//
	
	// Button
	//---------------------------//
	public GraphicButton getButtonPosizionaFamiliare() {
		return (GraphicButton) cartePlayer.getComponent(0);
	}
	
	public GraphicButton getButtonAttivaEffettoLeader() {
		return (GraphicButton) cartePlayer.getComponent(7);
	}
	
	public GraphicButton getButtonGiocaLeader() {
		return (GraphicButton) cartePlayer.getComponent(14);
	}
	
	public GraphicButton getButtonScartaLeader() {
		return (GraphicButton) cartePlayer.getComponent(21);
	}
	
	// Panel risorse
	//---------------------------//
	
	public PanelRisorse getPanelRisorseOro(){
		return (PanelRisorse)this.risorsePlayer.getComponent(0);
	}
	
	public PanelRisorse getPanelRisorseLegna(){
		return (PanelRisorse)this.risorsePlayer.getComponent(1);
	}
	
	public PanelRisorse getPanelRisorsePietra(){
		return (PanelRisorse)this.risorsePlayer.getComponent(2);
	}
	
	public PanelRisorse getPanelRisorseServitori(){
		return (PanelRisorse)this.risorsePlayer.getComponent(3);
	}
	
	public PanelRisorse getPanelRisorsePuntiMilitari(){
		return (PanelRisorse)this.risorsePlayer.getComponent(4);
	}
	
	public PanelRisorse getPanelRisorsePuntiFede(){
		return (PanelRisorse)this.risorsePlayer.getComponent(5);
	}
	
	public PanelRisorse getPanelRisorsePuntiVittoria(){
		return (PanelRisorse)this.risorsePlayer.getComponent(6);
	}
	
	// Panel familiari disponibili
	//---------------------------//
	public SpazioFamiliariDisponibili getPanelSpazioFamiliariDisponibili(){
		return (SpazioFamiliariDisponibili)this.risorsePlayer.getComponent(7);
	}
	
	// Carte leader
	//---------------------------//
	public CartaLeader getCartaLeader1() {
		//return (CartaLeader) cartePlayer.getComponent(7);
		return (CartaLeader) panelCarteLeader.getComponent(0);
	}
	public CartaLeader getCartaLeader2() {
		//return (CartaLeader) cartePlayer.getComponent(15);
		return (CartaLeader) panelCarteLeader.getComponent(1);
	}
	public CartaLeader getCartaLeader3() {
		//return (CartaLeader) cartePlayer.getComponent(23);
		return (CartaLeader) panelCarteLeader.getComponent(2);
	}
	public CartaLeader getCartaLeader4() {
		//return (CartaLeader) cartePlayer.getComponent(31);
		return (CartaLeader) panelCarteLeader.getComponent(3);
	}
	
	// Carte gioco
	//---------------------------//
	public CarteGioco getCartaGioco(TipoCarta tipoCarta, int numero) {
		return this.cartePlayerMap.get(tipoCarta).get(numero);
	}
	
	public void scriviMessaggio(String text) {
		labelTesto.setText(text);
	}
}
