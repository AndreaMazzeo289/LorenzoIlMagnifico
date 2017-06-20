package it.polimi.ingsw.pc15.testPlayer;

import org.junit.*;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.EffettiAttivi;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

import static org.junit.Assert.*;

import java.util.HashMap;


public class TestEffettiAttivi {

	EffettiAttivi effettiAttivi;
	HashMap<TipoCarta, Integer> bonusDadoCarte;
	HashMap<TipoCarta, SetRisorse> scontoCostoCarte;
	HashMap<TipoCarta, Boolean> bonusPuntiVittoriaFinale;
	Boolean bonusDisponibilitàMercato;
	Boolean bonusSpazioTorre;
	Boolean requisitoTerritori;
	Boolean permessoSpaziOccupati;
	
	int bonusRaccolta;
	int bonusProduzione;
	int moltiplicatoreRisorseCarte;
	int moltiplicatoreRisorseSpazi;
	
	@Before
	public void setUp() throws Exception {
		
		effettiAttivi = new EffettiAttivi();
		bonusDadoCarte = new HashMap<TipoCarta, Integer>();
		bonusDadoCarte.put(TipoCarta.TERRITORIO, 0);
		bonusDadoCarte.put(TipoCarta.PERSONAGGIO, 0);
		bonusDadoCarte.put(TipoCarta.EDIFICIO, 0);
		bonusDadoCarte.put(TipoCarta.IMPRESA, 0);
		bonusDadoCarte.put(TipoCarta.ALL, 0);
		
		scontoCostoCarte = new HashMap<TipoCarta, SetRisorse>();
		
		bonusPuntiVittoriaFinale = new HashMap<TipoCarta, Boolean>();
		bonusPuntiVittoriaFinale.put(TipoCarta.TERRITORIO, true);
		bonusPuntiVittoriaFinale.put(TipoCarta.PERSONAGGIO, true);
		bonusPuntiVittoriaFinale.put(TipoCarta.IMPRESA, true);
		
		bonusRaccolta = 0;
		bonusProduzione = 0;
		
		bonusDisponibilitàMercato = true;
		bonusSpazioTorre = true;
		requisitoTerritori = true;
		permessoSpaziOccupati = false;
	
	}
	
	@Test
	public void testIncrementaBonusDadoCarte(){
		
		int valoreDaIncrementare = 3;
		int val1;
		int val2;
		bonusDadoCarte.put(TipoCarta.TERRITORIO, valoreDaIncrementare);
		effettiAttivi.incrementaBonusDadoCarte(TipoCarta.TERRITORIO, valoreDaIncrementare);
		val1 = bonusDadoCarte.get(TipoCarta.TERRITORIO);
		val2 = effettiAttivi.getBonusDadoCarte(TipoCarta.TERRITORIO);
		assertEquals("Errore test incrementa bonus dado carte", val1, val2 );
		
	}
	
	@Test
	public void testAggiungiScontoCarte(){
		
		
	}
	
	@Test
	public void testAnnullaBonusPuntiVittoriaFinale(){
		bonusPuntiVittoriaFinale.put(TipoCarta.TERRITORIO, false);
		effettiAttivi.annullaBonusPuntiVittoriaFinale(TipoCarta.TERRITORIO);
		assertEquals("Errore annulla bonus punti vittoria finale", bonusPuntiVittoriaFinale.get(TipoCarta.TERRITORIO), effettiAttivi.bonusPuntiVittoriaFinale(TipoCarta.TERRITORIO));
	}
	
	@Test
	public void testIncrementaBonusRaccolta(){
		int valoreRaccoltaBonus = 3;
		bonusRaccolta+= valoreRaccoltaBonus;
		effettiAttivi.incrementaBonusRaccolta(valoreRaccoltaBonus);		
		assertEquals("Errore incrementa bonus raccolta", bonusRaccolta, effettiAttivi.getBonusRaccolta());
		
	}
	
	@Test
	public void testIncrementaBonusProduzione(){
		int valoreProduzioneBonus = 3;
		bonusProduzione+= valoreProduzioneBonus;
		effettiAttivi.incrementaBonusProduzione(valoreProduzioneBonus);
		assertEquals("Errore incrementa bonus produzione", bonusProduzione, effettiAttivi.getBonusProduzione());
		
	}
	
	@Test
	public void testAnnullaDisponibilitàMercato(){
		bonusDisponibilitàMercato = false;
		effettiAttivi.annullaDisponibilitàMercato();
		assertEquals("Errore annulla bonus disponibilità mercato", bonusDisponibilitàMercato, effettiAttivi.disponibilitàMercato());
	}
	
	@Test
	public void testAnnullaBonusSpazioTorre(){
		bonusSpazioTorre = false;
		effettiAttivi.annullaBonusSpazioTorre();
		assertEquals("Errore annulla bonus spazio torre", bonusSpazioTorre, effettiAttivi.disponibilitàBonusSpazioTorri());
	}
	
	@Test
	public void testAnnullaRequisitoTerritori(){
		requisitoTerritori = false;
		effettiAttivi.annullaRequisitoTerritori();
		assertEquals("Errore annulla requisito territorio attivo", requisitoTerritori, effettiAttivi.requisitoTerritoriAttivo());
	}
	
	@Test
	public void testConcediPermessoSpaziOccupati(){
		permessoSpaziOccupati = true;
		effettiAttivi.concediPermessoSpaziOccupati();
		assertEquals("Errore concedi permesso spazi occupati", permessoSpaziOccupati, effettiAttivi.controllaPermessoSpaziOccupati());
	}
	
	@Test
	public void testSetMoltiplicatoreRisorseCarte(){
		int nuovoMoltiplicatoreRisorseCarte = 2;
		effettiAttivi.setMoltiplicatoreRisorseCarte(nuovoMoltiplicatoreRisorseCarte);
		assertEquals("Errore set moltiplicatore risorse carte", nuovoMoltiplicatoreRisorseCarte, effettiAttivi.getMoltiplicatoreRisorseCarte());
		
	}
	
	@Test
	public void testSetMoltiplicatoreRisorseSpazi(){
		int nuovoMoltiplicatoreRisorseSpazi = 2;
		effettiAttivi.setMoltiplicatoreRisorseSpazi(nuovoMoltiplicatoreRisorseSpazi);
		assertEquals("Errore set moltiplicatore risorse carte", nuovoMoltiplicatoreRisorseSpazi, effettiAttivi.getMoltiplicatoreRisorseSpazi());
		
	}
	
	@Test
	public void testGetBonusRaccolta(){
		
		assertEquals("Errore get bonus raccolta", bonusRaccolta, effettiAttivi.getBonusRaccolta());
		
	}
	
	@Test
	public void testGetBonusProduzione(){
		
		assertEquals("Errore get bonus produzione", bonusProduzione, effettiAttivi.getBonusProduzione());
		
	}
	
	@Test
	public void testGetBonusDadoCarte(){
		int val1 = bonusDadoCarte.get(TipoCarta.EDIFICIO);
		
		
		
		
		
		
		int val2 = effettiAttivi.getBonusDadoCarte(TipoCarta.EDIFICIO);
		assertEquals("Errore get bonus dado carte", val1 , val2);
	}
	
	@Test
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void testGetScontoCostoCarte(){}
	
	@Test
	public void testBonusPuntiVittoraFinale(){
		
		
		assertTrue("Errore bonus punti vittoria finale", effettiAttivi.bonusPuntiVittoriaFinale(TipoCarta.TERRITORIO));
		
		
		
		
		
		
		
		
		assertTrue("Errore bonus punti vittoria finale", effettiAttivi.bonusPuntiVittoriaFinale(TipoCarta.PERSONAGGIO));
		
		assertTrue("Errore bonus punti vittoria finale", effettiAttivi.bonusPuntiVittoriaFinale(TipoCarta.IMPRESA));
	}
	
	@Test
	public void testDisponibilitàMercato(){
		
		assertTrue("Errore get disponibilità mercato", effettiAttivi.disponibilitàMercato());
	}
	
	@Test
	public void testDisponibilitàBonusSpazioTorri(){
		
		assertTrue("Errore get disponibilità spazio torri", effettiAttivi.disponibilitàBonusSpazioTorri());
	}
	
	@Test
	public void testRequisitoTerritoriAttivo(){
		
		assertTrue("Errore get requisito territori attivo", effettiAttivi.requisitoTerritoriAttivo());
	}
	
	@Test
	public void testControllaPermessoSpaziOccupati(){
		
		assertFalse("Errore controlla permesso spazi occupati", effettiAttivi.controllaPermessoSpaziOccupati());
	}
	
	@Test
	public void testGetMoltiplicatoreRisorseCarte(){
		
		assertEquals("Errore get moltiplicatore risorse carte", 1, effettiAttivi.getMoltiplicatoreRisorseCarte());
	}
	
	@Test
	public void testGetMoltiplicatoreRisorseSpazi(){
		
		assertEquals("Errore get moltiplicatore risorse spazi", 1, effettiAttivi.getMoltiplicatoreRisorseSpazi());
	}
	
	@Test 
	public void testGetRisorseBonusSpazi(){
		
		
	}
	
	@Test
	public void testGetRisorseBonusCarte(){
		
		
	}
}
