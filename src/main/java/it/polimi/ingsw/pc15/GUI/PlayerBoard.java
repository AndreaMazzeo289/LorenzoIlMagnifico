package it.polimi.ingsw.pc15.GUI;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.polimi.ingsw.pc15.carte.TipoCarta;

public class PlayerBoard extends JPanel{

	private CarteGioco carta;
	private PersonalBonus personalBonus;
	private CartaLeader cartaLeader;
	private JPanel panelCarteLeader;
	private JPanel risorsePlayer;
	private JPanel cartePlayer;
	private JPanel contentPanel;
	JButton posizionaFamiliare;
	JButton attivaEffettoLeader;
	JButton giocaLeader;
	JButton scartaLeader;
	ButtonListener listener = new ButtonListener();
	
	public PlayerBoard(ActionListener listener) {
		
		this.setLayout(new GridBagLayout());
		
		risorsePlayer = new JPanel(new GridBagLayout());
		//risorsePlayer = new JPanel(new GridLayout(1,7));
		cartePlayer = new JPanel(new GridBagLayout());
		contentPanel = new JPanel(new GridBagLayout());
		JPanel scomunicheButtonPanel = new JPanel (new GridLayout(1,2));
		JPanel presentationPanel = new JPanel (new GridBagLayout());
		JPanel buttonPanel = new JPanel(new GridLayout(2,2));
		JPanel panelPersonalBonus = new JPanel();
		panelCarteLeader = new JPanel(new GridLayout(4,1));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Presentation panel
		//-----------------------//
		
		JButton statoGioco = new ButtonStatoGioco();
		JButton scomunicheButton = new ButtonScomuniche();
		gbc.gridx=0;
		gbc.gridy=0;
		presentationPanel.add(statoGioco,gbc);
		gbc.gridx=1;
		presentationPanel.add(scomunicheButton,gbc);
		
		// Panel carte
		//-----------------------//
		gbc.gridx=0;
		gbc.gridy=0;
		posizionaFamiliare = new ButtonPosizionaFamiliare();
		cartePlayer.add(posizionaFamiliare,gbc);
		for(int i=0; i<6; i++) {
			carta = new CarteGioco("img/DevCardsBack/devcards_b_c_g_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg", TipoCarta.TERRITORIO);
			carta.addActionListener(new ButtonListenerCarte());
			gbc.gridx=i+1;
			cartePlayer.add(carta,gbc);
		}
		/*gbc.gridx=7;
		cartaLeader = new CartaLeader("img/Leaders/leaders_b_c_00.jpg","leader1");
		cartePlayer.add(cartaLeader,gbc);*/
		
		gbc.gridx=0;
		gbc.gridy=1;
		attivaEffettoLeader = new ButtonAttivaEffettoLeader();
		cartePlayer.add(attivaEffettoLeader,gbc);
		for(int i=0; i<6; i++) {
			carta = new CarteGioco("img/DevCardsBack/devcards_b_c_y_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg", TipoCarta.EDIFICIO);
			carta.addActionListener(new ButtonListenerCarte());
			gbc.gridx=i+1;
			cartePlayer.add(carta,gbc);
		}
		/*gbc.gridx=7;
		cartaLeader = new CartaLeader("img/Leaders/leaders_b_c_00.jpg","leader2");
		cartePlayer.add(cartaLeader,gbc);*/
		
		gbc.gridx=0;
		gbc.gridy=2;
		giocaLeader = new ButtonGiocaLeader();
		cartePlayer.add(giocaLeader,gbc);
		for(int i=0; i<6; i++) {
			carta = new CarteGioco("img/DevCardsBack/devcards_b_c_b_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg", TipoCarta.PERSONAGGIO);
			carta.addActionListener(new ButtonListenerCarte());
			gbc.gridx=i+1;
			cartePlayer.add(carta,gbc);
		}
		/*gbc.gridx=7;
		cartaLeader = new CartaLeader("img/Leaders/leaders_b_c_00.jpg","leader3");
		cartePlayer.add(cartaLeader,gbc);*/
		
		gbc.gridx=0;
		gbc.gridy=3;
		scartaLeader = new ButtonScartaLeader();
		cartePlayer.add(scartaLeader,gbc);
		for(int i=0; i<6; i++) {
			carta = new CarteGioco("img/DevCardsBack/devcards_b_c_p_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg", TipoCarta.IMPRESA);
			carta.addActionListener(new ButtonListenerCarte());
			gbc.gridx=i+1;
			cartePlayer.add(carta,gbc);
		}
		/*gbc.gridx=7;
		cartaLeader = new CartaLeader("img/Leaders/leaders_b_c_00.jpg","leader4");
		cartePlayer.add(cartaLeader,gbc);*/
		
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
		
		
		
		attivaEffettoLeader.addActionListener(listener);
		posizionaFamiliare.addActionListener(listener);
		scartaLeader.addActionListener(listener);
		giocaLeader.addActionListener(listener);
		statoGioco.addActionListener(listener);
		
	}
	
	//-------------------------------------------------------------------//
	// METODI GET
	//-------------------------------------------------------------------//
	
	// Button
	//---------------------------//
	public ButtonPosizionaFamiliare getButtonPosizionaFamiliare() {
		return (ButtonPosizionaFamiliare) cartePlayer.getComponent(0);
	}
	
	public ButtonAttivaEffettoLeader getButtonAttivaEffettoLeader() {
		return (ButtonAttivaEffettoLeader) cartePlayer.getComponent(7);
	}
	
	public ButtonGiocaLeader getButtonGiocaLeader() {
		return (ButtonGiocaLeader) cartePlayer.getComponent(14);
	}
	
	public ButtonScartaLeader getButtonScartaLeader() {
		return (ButtonScartaLeader) cartePlayer.getComponent(21);
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
