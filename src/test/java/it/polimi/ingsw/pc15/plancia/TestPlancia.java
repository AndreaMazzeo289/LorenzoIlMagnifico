package it.polimi.ingsw.pc15.plancia;

import org.junit.*;

import it.polimi.ingsw.pc15.azioni.AzionePrendiCarta;
import it.polimi.ingsw.pc15.azioni.AzionePrendiCartaPersonaggio;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.carte.Personaggio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.effetti.AnnullaGuadagno;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.plancia.SpazioTorre;
import it.polimi.ingsw.pc15.plancia.Torre;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.EffettiAttivi;
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
	
	
	Torre torre;
	SpazioTorre spazioTorre;
	ArrayList<SetRisorse> arrayRisorse;
	
	
	EffettiAttivi effettiAttivi1;
	EffettiAttivi effettiAttivi2;
	
	Familiare familiare1;
	Familiare familiare2;
	
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
		
		cartaTerritorio = new Territorio("Carta", 1, 1, setRisorsePlayer, effettoIstantaneo, effettoPermanente, 3);
		cartaPersonaggio = new Personaggio("Carta", 1, 1, setRisorsePlayer, effettoIstantaneo, effettoPermanente);
		cartaEdificio = new Edificio("Carta", 1, 1, setRisorsePlayer, effettoIstantaneo, effettoPermanente, 3);
		cartaImpresa = new Impresa("Carta", 1, 1, setRisorsePlayer, effettoIstantaneo, effettoPermanente, 3, 3);
		
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
}
