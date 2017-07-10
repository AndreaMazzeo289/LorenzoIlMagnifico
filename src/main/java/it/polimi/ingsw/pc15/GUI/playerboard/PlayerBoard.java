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

/**
 * Classe che gestisce l'intera visualizzazione della playerboard
 * ossia la componente della gui che ha come scopo l'interazione con il player
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 * 
 */
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
	
	private ArrayList<CartaLeader> carteLeader;
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
		
		carteLeader = new ArrayList<CartaLeader>();
		carteLeader.add(new CartaLeader("img/Leaders/leaders_b_c_00.jpg","leader0",gui));
		carteLeader.add(new CartaLeader("img/Leaders/leaders_b_c_00.jpg","leader1",gui));
		carteLeader.add(new CartaLeader("img/Leaders/leaders_b_c_00.jpg","leader2",gui));
		carteLeader.add(new CartaLeader("img/Leaders/leaders_b_c_00.jpg","leader3",gui));
		
		for(int i=0; i<4; i++) {
			panelCarteLeader.add(carteLeader.get(i));
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
		labelTesto = new JLabel("",SwingConstants.CENTER);
		labelTesto.setFont((new Font("Courier New", Font.ITALIC, 17)));
		
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
	/**
	 * metodo di acquisizione del button di posizionamento del familiare
	 * @return istanza del button
	 */
	public GraphicButton getButtonPosizionaFamiliare() {
		return (GraphicButton) cartePlayer.getComponent(0);
	}
	
	/**
	 * metodo di acquisizione del button di attivazione dell'effetto leader
	 * @return istanza del button
	 */
	public GraphicButton getButtonAttivaEffettoLeader() {
		return (GraphicButton) cartePlayer.getComponent(7);
	}
	
	/**
	 * metodo di acquisizione del button di attivazione della carta leader
	 * @return istanza del button
	 */
	public GraphicButton getButtonGiocaLeader() {
		return (GraphicButton) cartePlayer.getComponent(14);
	}
	
	/**
	 * metodo di acquisizione del button per scartare una carta leader
	 * @return istanza del button
	 */
	public GraphicButton getButtonScartaLeader() {
		return (GraphicButton) cartePlayer.getComponent(21);
	}
	
	// Panel risorse
	//---------------------------//
	/**
	 * metodo di acquisizione del pannello della risorsa ORO
	 * @return istanza del component
	 */
	public PanelRisorse getPanelRisorseOro(){
		return (PanelRisorse)this.risorsePlayer.getComponent(0);
	}
	
	/**
	 * metodo di acquisizione del pannello della risorsa LEGNA
	 * @return istanza del component
	 */
	public PanelRisorse getPanelRisorseLegna(){
		return (PanelRisorse)this.risorsePlayer.getComponent(1);
	}
	
	/**
	 * metodo di acquisizione del pannello della risorsa PIETRA
	 * @return istanza del component
	 */
	public PanelRisorse getPanelRisorsePietra(){
		return (PanelRisorse)this.risorsePlayer.getComponent(2);
	}
	
	/**
	 * metodo di acquisizione del pannello della risorsa SERVITORI
	 * @return istanza del component
	 */
	public PanelRisorse getPanelRisorseServitori(){
		return (PanelRisorse)this.risorsePlayer.getComponent(3);
	}
	
	/**
	 * metodo di acquisizione del pannello della risorsa PUNTI_MILITARI
	 * @return istanza del component
	 */
	public PanelRisorse getPanelRisorsePuntiMilitari(){
		return (PanelRisorse)this.risorsePlayer.getComponent(4);
	}
	
	/**
	 * metodo di acquisizione del pannello della risorsa PUNTI_FEDE
	 * @return istanza del component
	 */
	public PanelRisorse getPanelRisorsePuntiFede(){
		return (PanelRisorse)this.risorsePlayer.getComponent(5);
	}
	
	/**
	 * metodo di acquisizione del pannello della risorsa PUNTI_VITTORIA
	 * @return istanza del component
	 */
	public PanelRisorse getPanelRisorsePuntiVittoria(){
		return (PanelRisorse)this.risorsePlayer.getComponent(6);
	}
	
	// Panel familiari disponibili
	//---------------------------//
	/**
	 * metodo di acquisizione del pannello che contiene i familiari disponbili del player
	 * @return istanza dell'oggetto
	 */
	public SpazioFamiliariDisponibili getPanelSpazioFamiliariDisponibili(){
		return (SpazioFamiliariDisponibili)this.risorsePlayer.getComponent(7);
	}
	
	// Carte leader
	//---------------------------//
	/**
	 * metodo di acquisizione dello spazio relativo alla carta leade
	 * @param numero della carte leader
	 * @return istanza dell'oggetto
	 */
	public CartaLeader getCartaLeader(int numero) {
		return carteLeader.get(numero);
	}
	
	// Carte leader
	//---------------------------//
	/**
	 * metodo di acquisizione dello spazio relativo alla carta leade
	 * @param numero della carte leader
	 * @return istanza dell'oggetto
	 */
	public PersonalBonus getPersonalBonus() {
		return personalBonus;
	}	

	// Carte gioco
	//---------------------------//
	/**
	 * metodo di acquisizione dello spazio che contiene una carta gioco posseduta dal player
	 * @param tipoCarta che si vuole acquisire
	 * @param numero della carta
	 * @return istanza della cartaGioco
	 */
	public CarteGioco getCartaGioco(TipoCarta tipoCarta, int numero) {
		return this.cartePlayerMap.get(tipoCarta).get(numero);
	}
	
	/**
	 * metodo che permette di aggiornare il messaggio presente nella playerboard
	 * @param testo da scrivere nell'apposita label
	 */
	public void scriviMessaggio(String text) {
		labelTesto.setText(text);
	}
}
