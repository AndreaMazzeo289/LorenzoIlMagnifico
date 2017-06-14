package it.polimi.ingsw.pc15.GUI;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlayerBoard extends JPanel{

	private CarteGioco carta;
	private CartaScomunica cartaScomunica;
	private CartaLeader cartaLeader;
	private JPanel risorsePlayer;
	private JPanel cartePlayer;
	private JPanel contentPanel;
	JButton posizionaFamiliare;
	JButton attivaEffettoLeader;
	JButton giocaLeader;
	JButton scartaLeader;
	
	public PlayerBoard() {
		
		this.setLayout(new GridBagLayout());
		
		risorsePlayer = new JPanel(new GridBagLayout());
		//risorsePlayer = new JPanel(new GridLayout(1,7));
		cartePlayer = new JPanel(new GridBagLayout());
		contentPanel = new JPanel(new GridBagLayout());
		JPanel scomunicheButtonPanel = new JPanel (new GridLayout(1,2));
		JPanel presentationPanel = new JPanel (new GridBagLayout());
		JPanel buttonPanel = new JPanel(new GridLayout(2,2));
		JPanel scomunichePanel = new JPanel(new GridLayout(3,1));
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Presentation panel
		//-----------------------//
		
		JButton statoGioco = new ButtonStatoGioco();
		gbc.gridx=0;
		gbc.gridy=0;
		presentationPanel.add(statoGioco,gbc);
		
		// Panel carte
		//-----------------------//
		gbc.gridx=0;
		gbc.gridy=0;
		posizionaFamiliare = new ButtonPosizionaFamiliare();
		cartePlayer.add(posizionaFamiliare,gbc);
		for(int i=0; i<6; i++) {
			carta = new CarteGioco("img/DevCardsBack/devcards_b_c_g_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg");
			carta.addActionListener(new ButtonListenerCarte());
			gbc.gridx=i+1;
			cartePlayer.add(carta,gbc);
		}
		gbc.gridx=7;
		cartaLeader = new CartaLeader("img/Leaders/leaders_b_c_00.jpg","leader1");
		cartePlayer.add(cartaLeader,gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		attivaEffettoLeader = new ButtonAttivaEffettoLeader();
		cartePlayer.add(attivaEffettoLeader,gbc);
		for(int i=0; i<6; i++) {
			carta = new CarteGioco("img/DevCardsBack/devcards_b_c_b_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg");
			carta.addActionListener(new ButtonListenerCarte());
			gbc.gridx=i+1;
			cartePlayer.add(carta,gbc);
		}
		gbc.gridx=7;
		cartaLeader = new CartaLeader("img/Leaders/leaders_b_c_00.jpg","leader2");
		cartePlayer.add(cartaLeader,gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		giocaLeader = new ButtonGiocaLeader();
		cartePlayer.add(giocaLeader,gbc);
		for(int i=0; i<6; i++) {
			carta = new CarteGioco("img/DevCardsBack/devcards_b_c_y_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg");
			carta.addActionListener(new ButtonListenerCarte());
			gbc.gridx=i+1;
			cartePlayer.add(carta,gbc);
		}
		gbc.gridx=7;
		cartaLeader = new CartaLeader("img/Leaders/leaders_b_c_00.jpg","leader3");
		cartePlayer.add(cartaLeader,gbc);
		
		gbc.gridx=0;
		gbc.gridy=3;
		scartaLeader = new ButtonScartaLeader();
		cartePlayer.add(scartaLeader,gbc);
		for(int i=0; i<6; i++) {
			carta = new CarteGioco("img/DevCardsBack/devcards_b_c_p_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg");
			carta.addActionListener(new ButtonListenerCarte());
			gbc.gridx=i+1;
			cartePlayer.add(carta,gbc);
		}
		gbc.gridx=7;
		cartaLeader = new CartaLeader("img/Leaders/leaders_b_c_00.jpg","leader4");
		cartePlayer.add(cartaLeader,gbc);
		
		gbc.gridx=0;
		gbc.gridy=0;
		contentPanel.add(cartePlayer,gbc);
		
		cartaScomunica = new CartaScomunica("img/PunchboardCut/excomm_1_1.png");
		scomunichePanel.add(cartaScomunica);
		cartaScomunica = new CartaScomunica("img/PunchboardCut/excomm_2_1.png");
		scomunichePanel.add(cartaScomunica);
		cartaScomunica = new CartaScomunica("img/PunchboardCut/excomm_3_1.png");
		scomunichePanel.add(cartaScomunica);
		
		gbc.gridx=1;
		contentPanel.add(scomunichePanel,gbc);
		
		// Panel risorse
		//-----------------------//
		gbc.gridx=0;
		gbc.gridy=0;
		risorsePlayer.add(new PanelRisorse("img\\Punchboard\\Risorse\\northOro.png"), gbc);
		gbc.gridx=1;
		risorsePlayer.add(new PanelRisorse("img\\Punchboard\\Risorse\\northLegna.png"), gbc);
		gbc.gridx=2;
		risorsePlayer.add(new PanelRisorse("img\\Punchboard\\Risorse\\northPietra.png"), gbc);
		gbc.gridx=3;
		risorsePlayer.add(new PanelRisorse("img\\Punchboard\\Risorse\\northServitori.png"), gbc);
		gbc.gridx=4;
		risorsePlayer.add(new PanelRisorse("img\\Punchboard\\Risorse\\northMilitari.png"), gbc);
		gbc.gridx=5;
		risorsePlayer.add(new PanelRisorse("img\\Punchboard\\Risorse\\northFede.png"), gbc);
		gbc.gridx=6;
		risorsePlayer.add(new PanelRisorse("img\\Punchboard\\Risorse\\northVittoria.png"), gbc);
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
		
		attivaEffettoLeader.addActionListener(new ButtonListener());
		posizionaFamiliare.addActionListener(new ButtonListener());
		scartaLeader.addActionListener(new ButtonListener());
		giocaLeader.addActionListener(new ButtonListener());
		statoGioco.addActionListener(new ButtonListener());
		
	}
	
	//-------------------------------------------------------------------//
	// METODI GET
	//-------------------------------------------------------------------//
	
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
		return (CartaLeader) cartePlayer.getComponent(7);
	}
	public CartaLeader getCartaLeader2() {
		return (CartaLeader) cartePlayer.getComponent(15);
	}
	public CartaLeader getCartaLeader3() {
		return (CartaLeader) cartePlayer.getComponent(23);
	}
	public CartaLeader getCartaLeader4() {
		return (CartaLeader) cartePlayer.getComponent(31);
	}
	
}
