package it.polimi.ingsw.pc15.GUI;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class PlayerBoard extends JPanel{

	CarteGioco carta;
	CartaScomunica cartaScomunica;
	
	public PlayerBoard() {
		
		this.setLayout(new GridBagLayout());
		
		JPanel risorsePlayer = new JPanel(new GridBagLayout());
		JPanel cartePlayer = new JPanel(new GridLayout(4,7));
		JPanel scomunicheButtonPanel = new JPanel (new GridLayout(1,2));
		JPanel presentationPanel = new JPanel (new GridBagLayout());
		JPanel buttonPanel = new JPanel(new GridLayout(2,2));
		JPanel scomunichePanel = new JPanel(new GridLayout(1,3));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Presentation panel
		//-----------------------//
		gbc.gridx=0;
		gbc.gridy=0;
		presentationPanel.add(new Presentazione(),gbc);
		gbc.gridx=1;
		gbc.gridy=0;
		presentationPanel.add(new ButtonStatoGioco(),gbc);
		
		// ScomunicheButtonPanel 
		//-----------------------//
		buttonPanel.add(new ButtonPosizionaFamiliare());
		buttonPanel.add(new ButtonGiocaLeader());
		buttonPanel.add(new ButtonAttivaEffettoLeader());
		buttonPanel.add(new ButtonScartaLeader());
		
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
			cartePlayer.add(carta);
		}
		carta = new CarteGioco("img/Leaders/leaders_b_c_00.jpg");
		cartePlayer.add(carta);
		
		for(int i=0; i<6; i++) {
			carta = new CarteGioco("img/DevCardsBack/devcards_b_c_b_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg");
			cartePlayer.add(carta);
		}
		carta = new CarteGioco("img/Leaders/leaders_b_c_00.jpg");
		cartePlayer.add(carta);
		
		for(int i=0; i<6; i++) {
			carta = new CarteGioco("img/DevCardsBack/devcards_b_c_y_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg");
			cartePlayer.add(carta);
		}
		carta = new CarteGioco("img/Leaders/leaders_b_c_00.jpg");
		cartePlayer.add(carta);
		
		for(int i=0; i<6; i++) {
			carta = new CarteGioco("img/DevCardsBack/devcards_b_c_p_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg");
			cartePlayer.add(carta);
		}
		carta = new CarteGioco("img/Leaders/leaders_b_c_00.jpg");
		cartePlayer.add(carta);
		
		// Panel risorse
		//-----------------------//
		gbc.gridx=0;
		gbc.gridy=0;
		risorsePlayer.add(new ForziereOro(),gbc);
		gbc.gridx=1;
		gbc.gridy=0;
		risorsePlayer.add(new CestaLegna(),gbc);
		gbc.gridx=2;
		gbc.gridy=0;
		risorsePlayer.add(new CestaPietra(),gbc);
		gbc.gridx=3;
		gbc.gridy=0;
		risorsePlayer.add(new TappetoServitori(),gbc);
		gbc.gridx=4;
		gbc.gridy=0;
		risorsePlayer.add(new PuntiGiocatore(),gbc);
		gbc.gridx=5;
		gbc.gridy=0;
		risorsePlayer.add(new FamiliariDisponibili(),gbc);
		
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
		
	}
	
}
