package it.polimi.ingsw.pc15.GUI.playerboard;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import it.polimi.ingsw.pc15.GUI.ButtonListener;
import it.polimi.ingsw.pc15.GUI.ButtonListenerCarte;
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
	
	public PlayerBoard(ButtonListener listener) {
		
		this.setLayout(new GridBagLayout());
		
		risorsePlayer = new JPanel(new GridBagLayout());
		cartePlayer = new JPanel(new GridBagLayout());
		contentPanel = new JPanel(new GridBagLayout());
		presentationPanel = new JPanel (new GridBagLayout());
		panelPersonalBonus = new JPanel();
		panelCarteLeader = new JPanel(new GridLayout(4,1));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Presentation panel
		//-----------------------//
		gbc.gridx=0;
		gbc.gridy=0;
		presentationPanel.add(new GraphicButton(2500, 400,"img\\Punchboard\\statoGioco.png", "buttonStatoGioco", listener,true),gbc);
		gbc.gridx=1;
		presentationPanel.add(new GraphicButton(1500, 400,"img\\Punchboard\\scomunicheButton.png", "buttonScomuniche", listener,true),gbc);
		
		// Panel carte
		//-----------------------//
		gbc.gridx=0;
		gbc.gridy=0;
		cartePlayer.add(new GraphicButton(400,1100,"img\\Punchboard\\Button\\buttonPosizionaFamiliare.png","posizionaFamiliare", listener, false),gbc);
		for(int i=0; i<6; i++) {
			carta = new CarteGioco("img/DevCardsBack/devcards_b_c_g_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg", TipoCarta.TERRITORIO);
			carta.addActionListener(new ButtonListenerCarte());
			gbc.gridx=i+1;
			cartePlayer.add(carta,gbc);
		}
		gbc.gridx=0;
		gbc.gridy=1;
		cartePlayer.add(new GraphicButton(400,1100,"img\\Punchboard\\Button\\buttonEffettoLeader.png","attivaEffettoLeader", listener, false),gbc);
		for(int i=0; i<6; i++) {
			carta = new CarteGioco("img/DevCardsBack/devcards_b_c_y_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg", TipoCarta.EDIFICIO);
			carta.addActionListener(new ButtonListenerCarte());
			gbc.gridx=i+1;
			cartePlayer.add(carta,gbc);
		}
		gbc.gridx=0;
		gbc.gridy=2;
		cartePlayer.add(new GraphicButton(400,1100,"img\\Punchboard\\Button\\buttonAttivaLeader.png","attivaCartaLeader",listener, false),gbc);
		for(int i=0; i<6; i++) {
			carta = new CarteGioco("img/DevCardsBack/devcards_b_c_b_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg", TipoCarta.PERSONAGGIO);
			carta.addActionListener(new ButtonListenerCarte());
			gbc.gridx=i+1;
			cartePlayer.add(carta,gbc);
		}
		gbc.gridx=0;
		gbc.gridy=3;
		cartePlayer.add(new GraphicButton(400,1100,"img\\Punchboard\\Button\\buttonScartaLeader.png","scartaCartaLeader", listener, false),gbc);
		for(int i=0; i<6; i++) {
			carta = new CarteGioco("img/DevCardsBack/devcards_b_c_p_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg", TipoCarta.IMPRESA);
			carta.addActionListener(new ButtonListenerCarte());
			gbc.gridx=i+1;
			cartePlayer.add(carta,gbc);
		}
		
		gbc.gridx=0;
		gbc.gridy=0;
		contentPanel.add(cartePlayer,gbc);
		
		personalBonus = new PersonalBonus("img/Punchboard/personalBonus/bonus1.png");
		panelPersonalBonus.add(personalBonus);
		gbc.gridx=1;
		contentPanel.add(panelPersonalBonus,gbc);
		
		for(int i=1; i<=4; i++) {
			cartaLeader = new CartaLeader("img/Leaders/leaders_b_c_00.jpg","leader"+i);
			panelCarteLeader.add(cartaLeader);
		}
		gbc.gridx=2;
		contentPanel.add(panelCarteLeader,gbc);
		
		// Panel risorse
		//-----------------------//
		gbc.gridx=0;
		gbc.gridy=0;
		risorsePlayer.add(new PanelRisorse("img\\Punchboard\\Risorse\\northOro.png", 0), gbc);
		gbc.gridx=1;
		risorsePlayer.add(new PanelRisorse("img\\Punchboard\\Risorse\\northLegna.png", 0), gbc);
		gbc.gridx=2;
		risorsePlayer.add(new PanelRisorse("img\\Punchboard\\Risorse\\northPietra.png", 0), gbc);
		gbc.gridx=3;
		risorsePlayer.add(new PanelRisorse("img\\Punchboard\\Risorse\\northServitori.png", 0), gbc);
		gbc.gridx=4;
		risorsePlayer.add(new PanelRisorse("img\\Punchboard\\Risorse\\northMilitari.png", 0), gbc);
		gbc.gridx=5;
		risorsePlayer.add(new PanelRisorse("img\\Punchboard\\Risorse\\northFede.png", 0), gbc);
		gbc.gridx=6;
		risorsePlayer.add(new PanelRisorse("img\\Punchboard\\Risorse\\northVittoria.png", 0), gbc);
		gbc.gridx=7;
		risorsePlayer.add(new SpazioFamiliariDisponibili(), gbc);
		
		
		gbc.gridx=0;
		gbc.gridy=0;
		this.add(presentationPanel,gbc);
		gbc.gridx=0;
		gbc.gridy=1;
		this.add(contentPanel,gbc);
		gbc.gridx=0;
		gbc.gridy=2;
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
	
	
}
