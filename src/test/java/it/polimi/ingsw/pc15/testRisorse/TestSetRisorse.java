package it.polimi.ingsw.pc15.testRisorse;

import org.junit.Assert.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.*;

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
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class TestSetRisorse {

	SetRisorse setRisorse1;
	SetRisorse setRisorse2;
	SetRisorse setRisultatoAggiunta;
	SetRisorse setRisultatoSottrai;
	HashSet<Risorsa> risorsa1;
	HashSet<Risorsa> risorsa2;
	HashSet<Risorsa> risultatoAggiunta;
	HashSet<Risorsa> risultatoSottrai;
	Legna legna;
	Oro oro;
	Pietra pietra;
	Privilegi privilegi;
	PuntiFede puntiFede;
	PuntiMilitari puntiMilitari;
	PuntiVittoria puntiVittoria;
	Servitori servitori;
	
	@Before
	public void setUp() throws Exception {
		
		risorsa1 = new HashSet<Risorsa>();
		risorsa2 = new HashSet<Risorsa>();
		risultatoAggiunta = new HashSet<Risorsa>();
		risultatoSottrai = new HashSet<Risorsa>();
		
		risorsa1.add(new Legna(3));
		risorsa1.add(new Oro(3));
		risorsa1.add(new Pietra(3));
		risorsa1.add(new Privilegi(3));
		risorsa1.add(new PuntiFede(3));
		risorsa1.add(new PuntiMilitari(3));
		risorsa1.add(new PuntiVittoria(3));
		risorsa1.add(new Servitori(3));
		
		risorsa2.add(new Legna(3));
		risorsa2.add(new Oro(3));
		risorsa2.add(new Pietra(3));
		risorsa2.add(new Privilegi(3));
		risorsa2.add(new PuntiFede(3));
		risorsa2.add(new PuntiMilitari(3));
		risorsa2.add(new PuntiVittoria(3));
		risorsa2.add(new Servitori(3));
		
		risultatoAggiunta.add(new Legna(6));
		risultatoAggiunta.add(new Oro(6));
		risultatoAggiunta.add(new Pietra(6));
		risultatoAggiunta.add(new Privilegi(6));
		risultatoAggiunta.add(new PuntiFede(6));
		risultatoAggiunta.add(new PuntiMilitari(6));
		risultatoAggiunta.add(new PuntiVittoria(6));
		risultatoAggiunta.add(new Servitori(6));
		
		risultatoSottrai.add(new Legna(0));
		risultatoSottrai.add(new Oro(0));
		risultatoSottrai.add(new Pietra(0));
		risultatoSottrai.add(new Privilegi(0));
		risultatoSottrai.add(new PuntiFede(0));
		risultatoSottrai.add(new PuntiMilitari(0));
		risultatoSottrai.add(new PuntiVittoria(0));
		risultatoSottrai.add(new Servitori(0));
		
		setRisorse1 = new SetRisorse(risorsa1);
		setRisorse2 = new SetRisorse(risorsa2);
		setRisultatoAggiunta = new SetRisorse(risultatoAggiunta);
		setRisultatoSottrai = new SetRisorse(risultatoSottrai);
		}
	
		@Test
		public void testParagona(){
			assertTrue("Errore paragona", this.setRisorse1.paragona(this.setRisorse2));
		}
		
		@Test
		public void testAggiungi(){
			
			Boolean result;
			this.setRisorse1.aggiungi(this.setRisorse2);
		
			if(setRisorse1.paragona(setRisultatoAggiunta))
				result = true;
			else result = false;
			assertTrue("Errore aggiunta", result);	
			
			/*
			 * 
			 * Test per con dichiarazioni conformi ai nuovi metodi di setRisorse.
			 */
			
			HashSet<Risorsa> setProva1 = new HashSet<Risorsa>();
			HashSet<Risorsa> setProva2 = new HashSet<Risorsa>();
			HashSet<Risorsa> risProva = new HashSet<Risorsa>();
		
			setProva1.add(new Oro(2));
			setProva2.add(new Pietra(2));
			risProva.add(new Oro(2));
			risProva.add(new Pietra(2));
			
			SetRisorse risorseProva1 = new SetRisorse(setProva1);
			SetRisorse risorseProva2 = new SetRisorse(setProva2);
			SetRisorse risorseRisultato = new SetRisorse(risProva);
			
			risorseProva1.aggiungi(risorseProva2);
			assertEquals("Errore aggiungi setRisorse", risorseProva1.toString(), risorseRisultato.toString());
		}
	
		@Test
		public void testSottrai(){
			
			Boolean result;
		
			this.setRisorse1.sottrai(this.setRisorse2);
			
			if(setRisultatoSottrai.paragona(setRisorse1))
				result = true;
			else result = false;
			assertTrue("Errore sottrazione", result);
			
			
			/*
			 * 
			 * Test per con dichiarazioni conformi ai nuovi metodi di setRisorse.
			 */
			
			HashSet<Risorsa> setProva1 = new HashSet<Risorsa>();
			HashSet<Risorsa> setProva2 = new HashSet<Risorsa>();
			HashSet<Risorsa> risProva = new HashSet<Risorsa>();
		
			setProva1.add(new Oro(2));
			setProva2.add(new Oro(6));
			risProva.add(new Oro(0));
			
			SetRisorse risorseProva1 = new SetRisorse(setProva1);
			SetRisorse risorseProva2 = new SetRisorse(setProva2);
			SetRisorse risorseRisultato = new SetRisorse(risProva);
			
			risorseProva1.aggiungi(risorseProva2);
			assertTrue("Errore sottrai setRisorse", risorseProva1.paragona(risorseRisultato));
		}
		
		@Test
		public void testGetRisorsa(){
			Legna legna = new Legna(3);
			assertEquals("Errore getRisorsa", legna.toString(), setRisorse1.getRisorsa(TipoRisorsa.LEGNA).toString());
		}
		
		@Test
		public void testAggiungiSingolaRisorsa(){
			
			
			HashSet<Risorsa> setProva1 = new HashSet<Risorsa>();
			HashSet<Risorsa> setProva2 = new HashSet<Risorsa>();
			
			setProva1.add(new Oro(2));
			setProva1.add(new Pietra(2));
			setProva2.add(new Oro(3));
			setProva1.add(new Pietra(2));
			
			SetRisorse risorseProva1 = new SetRisorse(setProva1);
			SetRisorse risorseProva2 = new SetRisorse(setProva2);
			
			risorseProva1.aggiungi(new Oro(1));
			
			assertTrue("Errore aggiunta singola risorsa", risorseProva1.paragona(risorseProva2));
			
			
		}
}
