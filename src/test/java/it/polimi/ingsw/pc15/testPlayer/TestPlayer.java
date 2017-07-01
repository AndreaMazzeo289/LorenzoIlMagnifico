package it.polimi.ingsw.pc15.testPlayer;

import org.junit.*;

import it.polimi.ingsw.pc15.azioni.AzionePrendiCarta;
import it.polimi.ingsw.pc15.azioni.AzionePrendiCartaPersonaggio;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.Personaggio;
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
import java.util.Set;


public class TestPlayer {

	Player player;
	
	
	
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
	
	
	
	Personaggio carta;
	HashSet<Effetto> effettoPermanente;
	HashSet<Effetto> effettoIstantaneo;
	AnnullaGuadagno annullaGuadagno;
	ArrayList<Carta> arrayListCarte;
	AzionePrendiCartaPersonaggio azionePrendiCartaPersonaggio;
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
		//          TEST GET NOME                                                                                    //
		//-----------------------------------------------------------------------------------------------------------//
		
		
		player = new Player("pippo");	
		
		
		//-----------------------------------------------------------------------------------------------------------//
		//          TEST GET RISORSE                                                                                 //
		//-----------------------------------------------------------------------------------------------------------//
		
		
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
		
		
		//-----------------------------------------------------------------------------------------------------------//
		//       TEST GET CARTA                                                                                      //
		//-----------------------------------------------------------------------------------------------------------//
		
		
		effettoPermanente = new HashSet<Effetto>();
		effettoIstantaneo = new HashSet<Effetto>();
		
		arrayListCarte = new ArrayList<Carta>();
		
		annullaGuadagno = new AnnullaGuadagno(TipoCarta.PERSONAGGIO);
		effettoPermanente.add(annullaGuadagno);
		effettoIstantaneo.add(annullaGuadagno);
		
		carta = new Personaggio("Carta", 1, 1, setRisorsePlayer, effettoIstantaneo, effettoPermanente);
		arrayListCarte.add(carta);
		azionePrendiCartaPersonaggio = new AzionePrendiCartaPersonaggio(player, carta);
		
		arrayRisorse = new ArrayList<SetRisorse>();
		arrayRisorse.add(setRisorsePlayer);
		arrayRisorse.add(setRisorsePlayer);
		arrayRisorse.add(setRisorsePlayer);
		arrayRisorse.add(setRisorsePlayer);
		torre = new Torre(4, arrayRisorse);
		spazioTorre = new SpazioTorre(1, setRisorsePlayer, torre);
		
		
		//-----------------------------------------------------------------------------------------------------------//
		//       TEST GET FAMILIARE                                                                                  //
		//-----------------------------------------------------------------------------------------------------------//
		
		familiare1 = new Familiare(ColoreFamiliare.ARANCIONE, player);
		
	}
	
	@Test
	public void testGetNome(){
		
		assertEquals("Errore get nome", "pippo", player.getNome());
		
	}
	
	@Test
	public void testGetSetRisorse(){
		
		Boolean risultato;
		
		if(setRisorsePlayer.paragona(player.getSetRisorse()))
		{
			risultato = true;
		} 
		else risultato = false;
		assertTrue("Errore get set risorse", risultato);
		
	}
	
	@Test 
	public void testGetCarte(){
		
		Boolean testRisultatoCarte;
		ArrayList<Carta> arrayRisultato;
		
		carta.setSpazio(spazioTorre);
		
		arrayRisultato = new ArrayList<Carta>();
		
		azionePrendiCartaPersonaggio.daiCarta();
		
		arrayRisultato = player.getCarte(TipoCarta.PERSONAGGIO);
		
		if(arrayRisultato.equals(arrayListCarte))
		{
			testRisultatoCarte = true;
			
		}
		else testRisultatoCarte = false;
		
		assertTrue("Errore test GetCarte", testRisultatoCarte);
		
	}
	
	@Test
	public void testGetFamiliare(){
		
		Boolean risultato;
		
		this.familiare1 = player.getFamiliare(ColoreFamiliare.ARANCIONE);
		
		this.familiare2 = player.getFamiliare(ColoreFamiliare.ARANCIONE);
		if(familiare1.equals(familiare2))
		{
			risultato = true;
		}
		else risultato = false;
		
		assertTrue("Errore test get familiare", risultato);
	}
	
}
