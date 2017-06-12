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
	private JPanel risorsePlayer;
	
	public PlayerBoard() {
		
		this.setLayout(new GridBagLayout());
		
		risorsePlayer = new JPanel(new GridBagLayout());
		//risorsePlayer = new JPanel(new GridLayout(1,7));
		JPanel cartePlayer = new JPanel(new GridLayout(4,7));
		JPanel scomunicheButtonPanel = new JPanel (new GridLayout(1,2));
		JPanel presentationPanel = new JPanel (new GridBagLayout());
		JPanel buttonPanel = new JPanel(new GridLayout(2,2));
		JPanel scomunichePanel = new JPanel(new GridLayout(1,3));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Presentation panel
		//-----------------------//
		
		JButton statoGioco = new ButtonStatoGioco();
		gbc.gridx=0;
		gbc.gridy=0;
		presentationPanel.add(statoGioco,gbc);
		
		// ScomunicheButtonPanel 
		//-----------------------//
		JButton posizionaFamiliare = new ButtonPosizionaFamiliare();
		JButton attivaEffettoLeader = new ButtonAttivaEffettoLeader();
		JButton giocaLeader = new ButtonGiocaLeader();
		JButton scartaLeader = new ButtonScartaLeader();
		
		buttonPanel.add(posizionaFamiliare);
		buttonPanel.add(attivaEffettoLeader);
		buttonPanel.add(giocaLeader);
		buttonPanel.add(scartaLeader);
		
		cartaScomunica = new CartaScomunica("img/PunchboardCut/excomm_1_1.png");
		scomunichePanel.add(cartaScomunica);
		cartaScomunica = new CartaScomunica("img/PunchboardCut/excomm_2_1.png");
		scomunichePanel.add(cartaScomunica);
		cartaScomunica = new CartaScomunica("img/PunchboardCut/excomm_3_1.png");
		scomunichePanel.add(cartaScomunica);
		
		scomunicheButtonPanel.add(scomunichePanel);
		scomunicheButtonPanel.add(buttonPanel);
		
		// Panel carte
		//-----------------------//
		for(int i=0; i<6; i++) {
			carta = new CarteGioco("img/DevCardsBack/devcards_b_c_g_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg");
			carta.addActionListener(new ButtonListenerCarte());
			cartePlayer.add(carta);
		}
		carta = new CarteGioco("img/Leaders/leaders_b_c_00.jpg");
		carta.addActionListener(new ButtonListenerCarte());
		cartePlayer.add(carta);
		
		for(int i=0; i<6; i++) {
			carta = new CarteGioco("img/DevCardsBack/devcards_b_c_b_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg");
			carta.addActionListener(new ButtonListenerCarte());
			cartePlayer.add(carta);
		}
		carta = new CarteGioco("img/Leaders/leaders_b_c_00.jpg");
		carta.addActionListener(new ButtonListenerCarte());
		cartePlayer.add(carta);
		
		for(int i=0; i<6; i++) {
			carta = new CarteGioco("img/DevCardsBack/devcards_b_c_y_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg");
			carta.addActionListener(new ButtonListenerCarte());
			cartePlayer.add(carta);
		}
		carta = new CarteGioco("img/Leaders/leaders_b_c_00.jpg");
		carta.addActionListener(new ButtonListenerCarte());
		cartePlayer.add(carta);
		
		for(int i=0; i<6; i++) {
			carta = new CarteGioco("img/DevCardsBack/devcards_b_c_p_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg");
			carta.addActionListener(new ButtonListenerCarte());
			cartePlayer.add(carta);
		}
		carta = new CarteGioco("img/Leaders/leaders_b_c_00.jpg");
		carta.addActionListener(new ButtonListenerCarte());
		cartePlayer.add(carta);
		
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
		risorsePlayer.add(new FamiliariDisponibili(), gbc);
		
		
		gbc.gridx=0;
		gbc.gridy=0;
		this.add(presentationPanel,gbc);
		gbc.gridx=0;
		gbc.gridy=1;
		this.add(scomunicheButtonPanel,gbc);
		gbc.gridx=0;
		gbc.gridy=2;
		this.add(cartePlayer, gbc);
		gbc.gridx=0;
		gbc.gridy=3;
		this.add(risorsePlayer, gbc);
		
		this.setVisible(true);	
		
		attivaEffettoLeader.addActionListener(new ButtonListener());
		posizionaFamiliare.addActionListener(new ButtonListener());
		scartaLeader.addActionListener(new ButtonListener());
		giocaLeader.addActionListener(new ButtonListener());
		statoGioco.addActionListener(new ButtonListener());
		
	}
	
	
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
	
	public FamiliariDisponibili getPanelFamiliariDisponibili(){
		return (FamiliariDisponibili)this.risorsePlayer.getComponent(7);
	}
	
}
