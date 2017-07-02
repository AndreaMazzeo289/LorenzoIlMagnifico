package it.polimi.ingsw.pc15.effetti;

import static org.junit.Assert.*;


import org.junit.*;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.Player;

public class TestAzionePrendiCartaAggiuntiva {
	
	
	AzionePrendiCartaAggiuntiva azionePrendiCartaAggiuntiva;
	Player player;
	
	
	
	
	@Before
	public void setUp(){
		
		player = new Player("test");
		
		azionePrendiCartaAggiuntiva = new AzionePrendiCartaAggiuntiva(TipoCarta.ALL, 5);
		
	}
	
	
	/*
	 * L'effetto in questione deve essere ancora definito.
	 * Stessa cosa vale per AzionePrendiCartaAggiuntivaConSconto.
	 */
	
	@Test
	public void testAttiva(){}
	
	
}
