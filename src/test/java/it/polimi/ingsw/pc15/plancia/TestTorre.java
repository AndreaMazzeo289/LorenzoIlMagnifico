package it.polimi.ingsw.pc15.plancia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioTorre;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.carte.Personaggio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.effetti.AnnullaGuadagno;
import it.polimi.ingsw.pc15.effetti.Effetto;
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
import org.junit.*;

import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;


public class TestTorre {

	
	//-----------------------------------------------------------------------------------------------------------//
	//          TEST SET TORRE                                                                                   //
	//-----------------------------------------------------------------------------------------------------------//
	
	Torre torre;
	Legna legna;
	Oro oro;
	Pietra pietra;
	Privilegi privilegi;
	PuntiFede puntiFede;
	PuntiMilitari puntiMilitari;
	PuntiVittoria puntiVittoria;
	Servitori servitori;
	HashSet<Risorsa> setRisorse;
	SetRisorse setRisorseTest;
	ArrayList<SetRisorse> setDelleRisorse;
	ArrayList<Carta> arrayListCarteTerritorio;
	
	HashSet<Effetto> effettoPermanente;
	HashSet<Effetto> effettoIstantaneo;
	AnnullaGuadagno annullaGuadagno;

	Territorio cartaTerritorio;
	
	//-----------------------------------------------------------------------------------------------------------//
	//          TEST LIBERA                                                                                      //
	//-----------------------------------------------------------------------------------------------------------//
	
	
	Plancia plancia;
	Personaggio cartaPersonaggio;
	Edificio cartaEdificio;
	Impresa cartaImpresa;
	
	ArrayList<Carta> arrayListCartePersonaggio;
	ArrayList<Carta> arrayListCarteEdificio;
	ArrayList<Carta> arrayListCarteImpresa;
	
	AzioneOccupaSpazioTorre azioneOccupaSpazioTorreTerritorio;
	AzioneOccupaSpazioTorre azioneOccupaSpazioTorrePersonaggio;
	AzioneOccupaSpazioTorre azioneOccupaSpazioTorreEdificio;
	AzioneOccupaSpazioTorre azioneOccupaSpazioTorreImpresa;
	
	Player player;
	Familiare familiare;
	
	@Before
	public void setUp()
	{
		
		//-----------------------------------------------------------------------------------------------------------//
		//          TEST SET TORRE                                                                                   //
		//-----------------------------------------------------------------------------------------------------------//
		
		legna = new Legna(0);
		oro = new Oro(0);
		pietra = new Pietra(0);
		privilegi = new Privilegi(0);
		puntiFede = new PuntiFede(0);
		puntiMilitari = new PuntiMilitari(0);
		puntiVittoria = new PuntiVittoria(0);
		servitori = new Servitori(0);
		setRisorse = new HashSet<Risorsa>();
		
		setRisorse.add(legna);
		setRisorse.add(oro);
		setRisorse.add(pietra);
		setRisorse.add(privilegi);
		setRisorse.add(puntiMilitari);
		setRisorse.add(puntiFede);
		setRisorse.add(puntiVittoria);
		setRisorse.add(servitori);
		
		setRisorseTest = new SetRisorse(setRisorse);
		setDelleRisorse = new ArrayList<SetRisorse>();
		setDelleRisorse.add(setRisorseTest);
		setDelleRisorse.add(setRisorseTest);
		setDelleRisorse.add(setRisorseTest);
		setDelleRisorse.add(setRisorseTest);
		torre = new Torre(4, setDelleRisorse);
		
		effettoPermanente = new HashSet<Effetto>();
		effettoIstantaneo = new HashSet<Effetto>();
		annullaGuadagno = new AnnullaGuadagno(TipoCarta.PERSONAGGIO);
		effettoPermanente.add(annullaGuadagno);
		effettoIstantaneo.add(annullaGuadagno);
		
		cartaTerritorio = new Territorio("Carta", 1, 1, setRisorseTest, effettoIstantaneo, effettoPermanente, 3, "test");
		arrayListCarteTerritorio = new ArrayList<Carta>();
		
		arrayListCarteTerritorio.add(cartaTerritorio);
		arrayListCarteTerritorio.add(cartaTerritorio);
		arrayListCarteTerritorio.add(cartaTerritorio);
		arrayListCarteTerritorio.add(cartaTerritorio);
		
		//-----------------------------------------------------------------------------------------------------------//
		//          TEST LIBERA                                                                                      //
		//-----------------------------------------------------------------------------------------------------------//
		
		cartaPersonaggio = new Personaggio("Carta", 1, 1, setRisorseTest, effettoIstantaneo, effettoPermanente, "test");
		cartaEdificio = new Edificio("Carta", 1, 1, setRisorseTest, effettoIstantaneo, effettoPermanente, 3, "test");
		cartaImpresa = new Impresa("Carta", 1, 1, setRisorseTest, effettoIstantaneo, effettoPermanente, 3, 3, "test");
		
		arrayListCartePersonaggio = new ArrayList<Carta>();
		arrayListCarteEdificio = new ArrayList<Carta>();
		arrayListCarteImpresa = new ArrayList<Carta>();
		
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
		
		player = new Player("test");
		familiare = new Familiare(ColoreFamiliare.ARANCIONE, player);
		plancia = new Plancia(4);
	}
	
	//-----------------------------------------------------------------------------------------------------------//
	//          TEST SET TORRE                                                                                   //
	//-----------------------------------------------------------------------------------------------------------//
	
	@Test
	public void testSetTorre(){
		
		Boolean result;	
		Carta cartaRisultato;
		torre.setTorre(arrayListCarteTerritorio);
		cartaRisultato = torre.getSpazio(1).getCarta();
	
		if(cartaRisultato.equals(this.cartaTerritorio))
			result = true;
		else result = false;
		
		assertTrue("Errore test set torre", result);
	}
	
	//-----------------------------------------------------------------------------------------------------------//
	//          TEST LIBERA                                                                                      //
	//-----------------------------------------------------------------------------------------------------------//
	
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
		
		plancia.setCarte(1, arrayListCarteTerritorio, arrayListCartePersonaggio, arrayListCarteEdificio, arrayListCarteImpresa);
		
		/*
		 * 	Va fatto dopo aver riempito di carte la plancia altrimenti
		 *  non può riconosce il tipo di AzionePrendiCarta da esguire.
		 */
		
		azioneOccupaSpazioTorreTerritorio = new AzioneOccupaSpazioTorre(player, familiare, plancia.getTorre(TipoCarta.TERRITORIO).getSpazio(1), 0);
		azioneOccupaSpazioTorrePersonaggio = new AzioneOccupaSpazioTorre(player, familiare, plancia.getTorre(TipoCarta.PERSONAGGIO).getSpazio(1), 0);
		azioneOccupaSpazioTorreEdificio = new AzioneOccupaSpazioTorre(player, familiare, plancia.getTorre(TipoCarta.EDIFICIO).getSpazio(1), 0);
		azioneOccupaSpazioTorreImpresa = new AzioneOccupaSpazioTorre(player, familiare, plancia.getTorre(TipoCarta.IMPRESA).getSpazio(1), 0);
		
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
		
		plancia.getTorre(TipoCarta.TERRITORIO).libera();
		plancia.getTorre(TipoCarta.PERSONAGGIO).libera();
		plancia.getTorre(TipoCarta.EDIFICIO).libera();
		plancia.getTorre(TipoCarta.IMPRESA).libera();
		
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
