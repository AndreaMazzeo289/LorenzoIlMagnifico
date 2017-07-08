package it.polimi.ingsw.pc15.testPlancia;

import org.junit.*;

import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioTorre;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.carte.Personaggio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.effetti.AnnullaGuadagno;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.plancia.Plancia;
import it.polimi.ingsw.pc15.plancia.Torre;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.ColorePlayer;
import it.polimi.ingsw.pc15.player.Familiare;
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

import java.util.ArrayList;
import java.util.HashSet;


public class TestPlancia {

	//-----------------------------------------------------------------------------------------------------------//
	//          TEST SET CARTE                                                                                   //
	//-----------------------------------------------------------------------------------------------------------//
	
	Plancia plancia;
	Legna legna;
	Oro oro;
	Pietra pietra;
	Privilegi privilegi;
	PuntiFede puntiFede;
	PuntiMilitari puntiMilitari;
	PuntiVittoria puntiVittoria;
	Servitori servitori;
	HashSet<Risorsa> risorsePlayer;
	SetRisorse setRisorsePlayer;
	
	Territorio cartaTerritorio;
	Personaggio cartaPersonaggio;
	Edificio cartaEdificio;
	Impresa cartaImpresa;
	
	HashSet<Effetto> effettoPermanente;
	HashSet<Effetto> effettoIstantaneo;
	AnnullaGuadagno annullaGuadagno;
	
	ArrayList<Carta> arrayListCarteTerritorio;
	ArrayList<Carta> arrayListCartePersonaggio;
	ArrayList<Carta> arrayListCarteEdificio;
	ArrayList<Carta> arrayListCarteImpresa;
	
	//-----------------------------------------------------------------------------------------------------------//
	//          TEST LIBERA                                                                                      //
	//-----------------------------------------------------------------------------------------------------------//
	
	AzioneOccupaSpazioTorre azioneOccupaSpazioTorreTerritorio;
	AzioneOccupaSpazioTorre azioneOccupaSpazioTorrePersonaggio;
	AzioneOccupaSpazioTorre azioneOccupaSpazioTorreEdificio;
	AzioneOccupaSpazioTorre azioneOccupaSpazioTorreImpresa;
	Player player;
	Torre torreTerritorio;
	Torre torrePersonaggio;
	Torre torreEdificio;
	Torre torreImpresa;
	Familiare familiare;
	ArrayList<SetRisorse> arrayRisorse;
	
	@Before 
	public void setUp(){
		
		//-----------------------------------------------------------------------------------------------------------//
		//          TEST SET CARTE                                                                                   //
		//-----------------------------------------------------------------------------------------------------------//
		
		plancia = new Plancia(4);
		
		legna = new Legna(0);
		oro = new Oro(0);
		pietra = new Pietra(0);
		privilegi = new Privilegi(0);
		puntiFede = new PuntiFede(0);
		puntiMilitari = new PuntiMilitari(0);
		puntiVittoria = new PuntiVittoria(0);
		servitori = new Servitori(0);
		risorsePlayer = new HashSet<Risorsa>();
		risorsePlayer.add(legna);
		risorsePlayer.add(oro);
		risorsePlayer.add(pietra);
		risorsePlayer.add(privilegi);
		risorsePlayer.add(puntiMilitari);
		risorsePlayer.add(puntiFede);
		risorsePlayer.add(puntiVittoria);
		risorsePlayer.add(servitori);
		
		setRisorsePlayer = new SetRisorse(risorsePlayer);

		effettoPermanente = new HashSet<Effetto>();
		effettoIstantaneo = new HashSet<Effetto>();
		
		arrayListCarteTerritorio = new ArrayList<Carta>();
		arrayListCartePersonaggio = new ArrayList<Carta>();
		arrayListCarteEdificio = new ArrayList<Carta>();
		arrayListCarteImpresa = new ArrayList<Carta>();
		
		annullaGuadagno = new AnnullaGuadagno(TipoCarta.PERSONAGGIO);
		effettoPermanente.add(annullaGuadagno);
		effettoIstantaneo.add(annullaGuadagno);
		
		cartaTerritorio = new Territorio("Carta", 1, 1, setRisorsePlayer, effettoIstantaneo, effettoPermanente, 3, "test");
		cartaPersonaggio = new Personaggio("Carta", 1, 1, setRisorsePlayer, effettoIstantaneo, effettoPermanente, "test");
		cartaEdificio = new Edificio("Carta", 1, 1, setRisorsePlayer, effettoIstantaneo, effettoPermanente, 3, "test");
		cartaImpresa = new Impresa("Carta", 1, 1, setRisorsePlayer, effettoIstantaneo, effettoPermanente, 3, 3, "test");
		
		arrayListCarteTerritorio.add(cartaTerritorio);
		arrayListCarteTerritorio.add(cartaTerritorio);
		arrayListCarteTerritorio.add(cartaTerritorio);
		arrayListCarteTerritorio.add(cartaTerritorio);
		
		arrayListCartePersonaggio.add(cartaPersonaggio);
		arrayListCartePersonaggio.add(cartaPersonaggio);
		arrayListCartePersonaggio.add(cartaPersonaggio);
		arrayListCartePersonaggio.add(cartaPersonaggio);
		
		arrayListCarteEdificio.add(cartaEdificio);
		arrayListCarteEdificio.add(cartaEdificio);
		arrayListCarteEdificio.add(cartaEdificio);
		arrayListCarteEdificio.add(cartaEdificio);
		
		arrayListCarteImpresa.add(cartaImpresa);
		arrayListCarteImpresa.add(cartaImpresa);
		arrayListCarteImpresa.add(cartaImpresa);
		arrayListCarteImpresa.add(cartaImpresa);
		
		//-----------------------------------------------------------------------------------------------------------//
		//          TEST LIBERA                                                                                      //
		//-----------------------------------------------------------------------------------------------------------//
		
		player = new Player("test",ColorePlayer.BLU);
		
		arrayRisorse = new ArrayList<SetRisorse>();
		arrayRisorse.add(setRisorsePlayer);
		arrayRisorse.add(setRisorsePlayer);
		arrayRisorse.add(setRisorsePlayer);
		arrayRisorse.add(setRisorsePlayer);
		
		torreTerritorio = new Torre(4, arrayRisorse);
		torrePersonaggio = new Torre(4, arrayRisorse);
		torreEdificio = new Torre(4, arrayRisorse);
		torreImpresa = new Torre(4, arrayRisorse);
						
		familiare = new Familiare(ColoreFamiliare.ARANCIONE, player);
	}	
	
	@Test
	public void testSetCarte()
	{
		
		plancia.setCarte(1, arrayListCarteTerritorio, arrayListCartePersonaggio, arrayListCarteEdificio, arrayListCarteImpresa);
		
		Carta cartaTerritorioTest = plancia.getSpazioTorre(TipoCarta.TERRITORIO, 1).getCarta();
		Carta cartaPersonaggioTest = plancia.getSpazioTorre(TipoCarta.PERSONAGGIO, 1).getCarta();
		Carta cartaEdificioTest = plancia.getSpazioTorre(TipoCarta.EDIFICIO, 1).getCarta();
		Carta cartaImpresaTest =  plancia.getSpazioTorre(TipoCarta.IMPRESA, 1).getCarta();
		
		assertEquals("Errore test set carte", cartaTerritorioTest.toString(), cartaTerritorio.toString());
		assertEquals("Errore test set carte", cartaPersonaggioTest.toString(), cartaPersonaggio.toString());
		assertEquals("Errore test set carte", cartaEdificioTest.toString(), cartaEdificio.toString());
		assertEquals("Errore test set carte", cartaImpresaTest.toString(), cartaImpresa.toString());
	}
	
	@Test
	public void testLibera(){
		
		Boolean risultatoOccupaSpazioTerritorio;
		Boolean risultatoOccupaSpazioPersonaggio;
		Boolean risultatoOccupaSpazioEdificio;
		Boolean risultatoOccupaSpazioImpresa;
		
		Boolean risultatoLiberaSpazioTerritorio;
		Boolean risultatoLiberaSpazioPersonaggio;
		Boolean risultatoLiberaSpazioEdificio;
		Boolean risultatoLiberaSpazioImpresa;
		
		
		player.getSetRisorse().aggiungi(new Servitori(3));
		
		plancia.setCarte(1, arrayListCarteTerritorio, arrayListCartePersonaggio, arrayListCarteEdificio, arrayListCarteImpresa);
		
		/*
		 * 	Va fatto dopo aver riempito di carte la plancia altrimenti
		 *  non può riconosce il tipo di AzionePrendiCarta da esguire.
		 */
	
		azioneOccupaSpazioTorreTerritorio = new AzioneOccupaSpazioTorre(player, familiare, plancia.getTorre(TipoCarta.TERRITORIO).getSpazio(1), 0, 1);
		azioneOccupaSpazioTorrePersonaggio = new AzioneOccupaSpazioTorre(player, familiare, plancia.getTorre(TipoCarta.PERSONAGGIO).getSpazio(1), 0, 1);
		azioneOccupaSpazioTorreEdificio = new AzioneOccupaSpazioTorre(player, familiare, plancia.getTorre(TipoCarta.EDIFICIO).getSpazio(1), 0, 1);
		azioneOccupaSpazioTorreImpresa = new AzioneOccupaSpazioTorre(player, familiare, plancia.getTorre(TipoCarta.IMPRESA).getSpazio(1), 0, 1);
		
		azioneOccupaSpazioTorreTerritorio.attiva();
		azioneOccupaSpazioTorrePersonaggio.attiva();
		azioneOccupaSpazioTorreEdificio.attiva();
		azioneOccupaSpazioTorreImpresa.attiva();
		
		risultatoOccupaSpazioTerritorio = plancia.getTorre(TipoCarta.TERRITORIO).occupata();
		risultatoOccupaSpazioPersonaggio = plancia.getTorre(TipoCarta.PERSONAGGIO).occupata();
		risultatoOccupaSpazioEdificio = plancia.getTorre(TipoCarta.EDIFICIO).occupata();
		risultatoOccupaSpazioImpresa = plancia.getTorre(TipoCarta.IMPRESA).occupata();
			
		assertTrue("La torre verde non è stata occupata correttamente", risultatoOccupaSpazioTerritorio);
		assertTrue("La torre blu non è stata occupata correttamente", risultatoOccupaSpazioPersonaggio);
		assertTrue("La torre gialla non è stata occupata correttamente", risultatoOccupaSpazioEdificio);
		assertTrue("La torre viola non è stata occupata correttamente", risultatoOccupaSpazioImpresa);
		
		plancia.libera();
		
		risultatoLiberaSpazioTerritorio = plancia.getTorre(TipoCarta.TERRITORIO).occupata();
		risultatoLiberaSpazioPersonaggio = plancia.getTorre(TipoCarta.PERSONAGGIO).occupata();
		risultatoLiberaSpazioEdificio = plancia.getTorre(TipoCarta.EDIFICIO).occupata();
		risultatoLiberaSpazioImpresa = plancia.getTorre(TipoCarta.IMPRESA).occupata();
		
		assertFalse("La torre verde non è stata liberata completamente", risultatoLiberaSpazioTerritorio);
		assertFalse("La torre blu non è stata liberata completamente", risultatoLiberaSpazioPersonaggio);
		assertFalse("La torre gialla non è stata liberata completamente", risultatoLiberaSpazioEdificio);
		assertFalse("La torre viola non è stata liberata completamente", risultatoLiberaSpazioImpresa);
	}
}
