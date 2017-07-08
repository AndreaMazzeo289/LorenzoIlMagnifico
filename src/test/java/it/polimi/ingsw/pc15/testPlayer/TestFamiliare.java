package it.polimi.ingsw.pc15.testPlayer;

import static org.junit.Assert.*;
import org.junit.*;

import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.ColorePlayer;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;

public class TestFamiliare {

	Player player;
	Familiare familiare;
	int valore;
	int valoreBonus;
	
	@Before
	public void setUp() throws Exception{
		
		player = new Player("Test", ColorePlayer.BLU);
		familiare = new Familiare(ColoreFamiliare.ARANCIONE, player);
		valore = 0;
		valoreBonus = 0;
	}
	
	@Test
	public void testSetDisponibilità(){
		
		familiare.setDisponibilità(false);
		assertFalse("Errore set disponibilità", familiare.disponibile());
	}
	
	@Test
	public void testSetValoreFissato(){
		familiare.setValoreFissato();
		assertTrue("Errore set valore fissato", familiare.getValoreFissato());
	}
	
	@Test
	public void testSetValore(){
		familiare.setValore(4);
		valore += 4;
		int risultatoValore = valore + valoreBonus;
		assertEquals("Errose set valore", risultatoValore, familiare.getValore());
	}
	
	@Test
	public void testIncrementaValoreBonus(){
		
		valoreBonus += 2;
		familiare.incrementaValoreBonus(2);
		assertEquals("Errore incrementa valore bonus", valoreBonus, familiare.getValoreBonus());
	}
	
	@Test
	public void testGetColore(){
		assertEquals("Errore get colore", ColoreFamiliare.ARANCIONE, familiare.getColore());
	}
	
	@Test
	public void testGetPlayer(){
		assertEquals("Errore get player", "Test", player.getNome());
	}
	
	@Test 
	public void testGetValoreBonus(){
		assertEquals("Errore get valore bonus", valoreBonus, familiare.getValoreBonus());
	}
	
	@Test
	public void testGetValore(){
		int valoreTotaleFamiliare = valore+valoreBonus;
		assertEquals("Errore get valore", valoreTotaleFamiliare, familiare.getValore());
	}
	
	@Test
	public void testDisponibilità(){
		assertTrue("Errore disponibilità", familiare.disponibile());
	}
	
	@Test
	public void testGetValoreFissato(){
		assertFalse("Errore get valore fissato", familiare.getValoreFissato());
	}
}
