package it.polimi.ingsw.pc15.testAzioni;

import org.junit.*;

import it.polimi.ingsw.pc15.azioni.AzioneAttivaEffettoLeader;
import it.polimi.ingsw.pc15.azioni.RisultatoAzione;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.effetti.AggiuntaRisorse;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.ColorePlayer;
import it.polimi.ingsw.pc15.player.Leader;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.Legna;
import it.polimi.ingsw.pc15.risorse.Oro;
import it.polimi.ingsw.pc15.risorse.Pietra;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TestAzioneAttivaEffettoLeader {

	AzioneAttivaEffettoLeader azioneAttivaEffettoLeader;
	
	Player player;
	Leader leader;
	Set<Effetto> effettoPerTurno;
	Set<Effetto> effettoPermanente;
	SetRisorse requisitoRisorse;
	HashMap<TipoCarta,Integer> requisitoCarte;
	
	HashSet<Risorsa> risorseSet;
	
	Effetto aggiuntaRisorse;
	RisultatoAzione risultatoAzione;
	
	@Before
	public void SetUp(){
		
		
		
		risorseSet = new HashSet<Risorsa>();
		
		risorseSet.add(new Legna(3));
		risorseSet.add(new Pietra(3));
		risorseSet.add(new Oro(3));
		
		requisitoRisorse = new SetRisorse(risorseSet);
		
		aggiuntaRisorse = new AggiuntaRisorse(requisitoRisorse);
		
		effettoPermanente = new HashSet<Effetto>();
		effettoPerTurno = new HashSet<Effetto>();
		
		effettoPermanente.add(aggiuntaRisorse);
		effettoPerTurno.add(aggiuntaRisorse);
		
		requisitoCarte = new HashMap<TipoCarta, Integer>();
		
		requisitoCarte.put(TipoCarta.EDIFICIO, 0);
		requisitoCarte.put(TipoCarta.PERSONAGGIO, 0);
		requisitoCarte.put(TipoCarta.TERRITORIO, 0);
		requisitoCarte.put(TipoCarta.IMPRESA, 0);
		
		player = new Player("test", ColorePlayer.BLU);
		leader = new Leader("test", effettoPermanente, effettoPerTurno, requisitoRisorse, requisitoCarte, "img");
		
		azioneAttivaEffettoLeader = new AzioneAttivaEffettoLeader(player, leader);
		
	}
	
	
	@Test
	public void testAttiva()
	{
		azioneAttivaEffettoLeader.attiva();
		
		assertTrue("Errore test attiva azione effetto leader", leader.effettoGiàAttivato());
		assertEquals("Errore test attiva azione effetto leader", player.getSetRisorse().toString(), requisitoRisorse.toString());
	}
	
	@Test
	public void testValida(){
		
		leader.setGiocato();
		
		this.risultatoAzione = azioneAttivaEffettoLeader.èValida();
		
		assertTrue("Errore test è valida", risultatoAzione.getRisultato());
		
		
	}
}
