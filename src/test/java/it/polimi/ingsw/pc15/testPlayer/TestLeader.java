package it.polimi.ingsw.pc15.testPlayer;

import org.junit.*;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.Leader;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.Legna;
import it.polimi.ingsw.pc15.risorse.Oro;
import it.polimi.ingsw.pc15.risorse.Pietra;
import it.polimi.ingsw.pc15.risorse.Privilegi;
import it.polimi.ingsw.pc15.risorse.PuntiFede;
import it.polimi.ingsw.pc15.risorse.PuntiMilitari;
import it.polimi.ingsw.pc15.risorse.PuntiVittoria;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.Servitori;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TestLeader {
	
	Leader leader;
	String nome;
	String imgPath;
	Set<Effetto> effettoPermanente;
	Set<Effetto> effettoPerTurno;
	SetRisorse requisitoRisorse;
	HashSet<Risorsa> risorse;
	HashMap<TipoCarta,Integer> requisitoCarte;
	
	Player player;
	
	@Before
	public void setUp() throws Exception {
		
		nome = "pippo";
		effettoPermanente = new HashSet<Effetto>();
		effettoPerTurno = new HashSet<Effetto>();
		risorse = new HashSet<Risorsa>();
		imgPath = "";
		
		Legna legna = new Legna(0);
		Oro oro = new Oro(0);
		Pietra pietra = new Pietra(0);
		Privilegi privilegi = new Privilegi(0);
		PuntiFede puntiFede = new PuntiFede(0);
		PuntiMilitari puntiMilitari = new PuntiMilitari(0);
		PuntiVittoria puntiVittoria = new PuntiVittoria(0);
		Servitori servitori = new Servitori(0);
		
		risorse.add(legna);
		risorse.add(oro);
		risorse.add(pietra);
		risorse.add(privilegi);
		risorse.add(puntiFede);
		risorse.add(puntiMilitari);
		risorse.add(puntiVittoria);
		risorse.add(servitori);
		requisitoRisorse = new SetRisorse(risorse);
		
		requisitoCarte = new HashMap<TipoCarta, Integer>();
		leader = new Leader(nome, effettoPerTurno, effettoPermanente, requisitoRisorse, requisitoCarte, imgPath);
		
		player = null;
	}
	
	@Test
	public void testEffettoAttivato(){
		
		leader.setEffettoAttivato(true);
		assertTrue("Errore effetto attivato", leader.effettoGiàAttivato());
	}
	
	@Test
	public void testSetGiocato(){
		
		leader.setGiocato();
		assertTrue("Errore leader giocato", leader.giocato());
	}
	
	@Test
	public void testGetNome(){
		
		assertEquals("Errore get nome", nome, leader.getNome());
	}
	
	@Test
	public void testEffettoGiàAttivato(){
		
		assertFalse("Errore effetto già attivato", leader.effettoGiàAttivato());
	}
	
	@Test
	public void testGiocato(){
		
		assertFalse("Errore giocato", leader.giocato());
	}
	
	@Test
	public void testGetRequisitoCarte(){}
	
	@Test
	public void testGetRequisitoRisorse(){}
	
	@Test
	public void testGetEffettoPerTurno(){}
	
	@Test
	public void testGetEffettoPermanente(){}
}
