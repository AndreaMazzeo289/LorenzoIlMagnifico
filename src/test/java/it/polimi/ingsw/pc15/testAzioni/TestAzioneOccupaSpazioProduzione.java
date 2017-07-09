package it.polimi.ingsw.pc15.testAzioni;

import java.util.HashSet;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioProduzione;

import it.polimi.ingsw.pc15.plancia.SpazioProduzione;
import it.polimi.ingsw.pc15.plancia.TesseraScomunica;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.ColorePlayer;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.player.TesseraBonus;
import it.polimi.ingsw.pc15.risorse.Oro;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.Servitori;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class TestAzioneOccupaSpazioProduzione {

	AzioneOccupaSpazioProduzione azioneOccupaSpazioProduzione;
	HashSet<Risorsa> risorse;
	SetRisorse setRisorse;
	
	Player player;
	Familiare familiare;
	SpazioProduzione spazioProduzione;
	
	TesseraBonus tesseraBonus;
	
	@Before
	public void setUp(){
		
		
		player = new Player("test", ColorePlayer.BLU);
		familiare = new Familiare(ColoreFamiliare.NERO, player);
		
		risorse = new HashSet<Risorsa>();
		risorse.add(new Oro(5));
		setRisorse = new SetRisorse(risorse);
		
		spazioProduzione = new SpazioProduzione(1);
		
		azioneOccupaSpazioProduzione = new AzioneOccupaSpazioProduzione(player, familiare, spazioProduzione, 0);
		
		tesseraBonus = new TesseraBonus(setRisorse, setRisorse, "path");
	
		
	}
	
	@Test
	public void testAttiva(){
		
		player.setTesseraBonus(tesseraBonus);
		player.getSetRisorse().aggiungi(new Servitori(0));
		
		azioneOccupaSpazioProduzione.attiva();
		

		setRisorse.aggiungi(new Servitori(0));
		assertFalse("errore attiva azione occupa spazio consiglio", spazioProduzione.vuoto());
		assertFalse("errore attiva azione occupa spazio consiglio", familiare.disponibile());
		assertEquals("errore attiva azione occupa spazio consiglio", player.getSetRisorse().toString(),setRisorse.toString());
		
	}
	
}
