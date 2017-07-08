package it.polimi.ingsw.pc15.testEffetti;

import org.junit.*;

import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioTorre;
import it.polimi.ingsw.pc15.azioni.RisultatoAzione;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.carte.Personaggio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.effetti.AggiuntaRisorse;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.effetti.Produzione;
import it.polimi.ingsw.pc15.plancia.Plancia;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.ColorePlayer;
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
import it.polimi.ingsw.pc15.player.TesseraBonus;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

public class TestProduzione {
	
	Produzione produzione;
	Player player;
	Plancia plancia;
	
	TesseraBonus tesseraBonus;
	
	Legna legna1;
	Oro oro1;
	Pietra pietra1;
	Privilegi privilegi1;
	PuntiFede puntiFede1;
	PuntiMilitari puntiMilitari1;
	PuntiVittoria puntiVittoria1;
	Servitori servitori1;
	
	Legna legna2;
	Oro oro2;
	Pietra pietra2;
	Privilegi privilegi2;
	PuntiFede puntiFede2;
	PuntiMilitari puntiMilitari2;
	PuntiVittoria puntiVittoria2;
	Servitori servitori2;
	
	HashSet<Risorsa> risorse1;
	Legna legna3;
	Oro oro3;
	Pietra pietra3;
	Privilegi privilegi3;
	PuntiFede puntiFede3;
	PuntiMilitari puntiMilitari3;
	PuntiVittoria puntiVittoria3;
	Servitori servitori3;
	
	HashSet<Risorsa> risorse3;
	HashSet<Risorsa> risorse2;
	SetRisorse setRisorseTest1;
	SetRisorse setRisorseTest2;
	SetRisorse costoCarta;
	
	Territorio cartaTerritorio;
	Personaggio cartaPersonaggio;
	Edificio cartaEdificio;
	Impresa cartaImpresa;
	
	HashSet<Effetto> effettoPermanente;
	HashSet<Effetto> effettoIstantaneo;
	
	AggiuntaRisorse aggiuntaRisorse1;
	AggiuntaRisorse aggiuntaRisorse2;
	
	ArrayList<Carta> arrayListCarteTerritorio;
	ArrayList<Carta> arrayListCartePersonaggio;
	ArrayList<Carta> arrayListCarteEdificio;
	ArrayList<Carta> arrayListCarteImpresa;
	
	AzioneOccupaSpazioTorre azioneOccupaSpazioTorre;
	RisultatoAzione risultatoAzione;
	
	@Before
	public void setUp(){
		
		player = new Player("test",ColorePlayer.BLU);
		
		
		
		player.getSetRisorse().aggiungi(new Legna(0));
		player.getSetRisorse().aggiungi(new Oro(0));
		player.getSetRisorse().aggiungi(new Pietra(0));
		player.getSetRisorse().aggiungi(new Privilegi(0));
		player.getSetRisorse().aggiungi(new PuntiFede(0));
		player.getSetRisorse().aggiungi(new PuntiMilitari(0));
		player.getSetRisorse().aggiungi(new PuntiVittoria(0));
		player.getSetRisorse().aggiungi(new Servitori(0));
		
		
		
		
		produzione = new Produzione(3);
		plancia = new Plancia(4);
		
		
		legna1 = new Legna(0);
		oro1 = new Oro(0);
		pietra1 = new Pietra(0);
		privilegi1 = new Privilegi(0);
		puntiFede1 = new PuntiFede(0);
		puntiMilitari1 = new PuntiMilitari(0);
		puntiVittoria1 = new PuntiVittoria(0);
		servitori1 = new Servitori(0);
		risorse1 = new HashSet<Risorsa>();
		risorse1.add(legna1);
		risorse1.add(oro1);
		risorse1.add(pietra1);
		risorse1.add(privilegi1);
		risorse1.add(puntiMilitari1);
		risorse1.add(puntiFede1);
		risorse1.add(puntiVittoria1);
		risorse1.add(servitori1);
		
		setRisorseTest1 = new SetRisorse(risorse1);
		
		tesseraBonus = new TesseraBonus(setRisorseTest1, setRisorseTest1, "test");
		
		player.setTesseraBonus(tesseraBonus);
		
		legna2 = new Legna(2);
		oro2 = new Oro(2);
		pietra2 = new Pietra(2);
		privilegi2 = new Privilegi(0);
		puntiFede2 = new PuntiFede(2);
		puntiMilitari2 = new PuntiMilitari(2);
		puntiVittoria2 = new PuntiVittoria(2);
		servitori2 = new Servitori(2);
		risorse2 = new HashSet<Risorsa>();
		risorse2.add(legna2);
		risorse2.add(oro2);
		risorse2.add(pietra2);
		risorse2.add(privilegi2);
		risorse2.add(puntiMilitari2);
		risorse2.add(puntiFede2);
		risorse2.add(puntiVittoria2);
		risorse2.add(servitori2);
		
		setRisorseTest2 = new SetRisorse(risorse2);
		
		aggiuntaRisorse1 = new AggiuntaRisorse(setRisorseTest1);
		aggiuntaRisorse2 = new AggiuntaRisorse(setRisorseTest2);
		
		legna3 = new Legna(0);
		oro3 = new Oro(0);
		pietra3 = new Pietra(0);
		privilegi3 = new Privilegi(0);
		puntiFede3 = new PuntiFede(0);
		puntiMilitari3 = new PuntiMilitari(0);
		puntiVittoria3 = new PuntiVittoria(0);
		servitori3 = new Servitori(0);
		risorse3 = new HashSet<Risorsa>();
		risorse3.add(legna3);
		risorse3.add(oro3);
		risorse3.add(pietra3);
		risorse3.add(privilegi3);
		risorse3.add(puntiMilitari3);
		risorse3.add(puntiFede3);
		risorse3.add(puntiVittoria3);
		risorse3.add(servitori3);
		
		costoCarta = new SetRisorse(risorse3);
		
	
		
		effettoIstantaneo = new HashSet<Effetto>();
		effettoPermanente = new HashSet<Effetto>();
		
		
		effettoIstantaneo.add(aggiuntaRisorse1);
		effettoPermanente.add(aggiuntaRisorse2);
		
		cartaTerritorio = new Territorio("Carta", 1, 1, costoCarta, effettoIstantaneo, effettoPermanente, 3,"test");
		cartaPersonaggio = new Personaggio("Carta", 1, 1, costoCarta, effettoIstantaneo, effettoPermanente,"test");
		cartaEdificio = new Edificio("Carta", 1, 1, costoCarta, effettoIstantaneo, effettoPermanente, 0,"test");
		cartaImpresa = new Impresa("Carta", 1, 1, costoCarta, effettoIstantaneo, effettoPermanente, 3, 3,"test");
		
		arrayListCarteTerritorio = new ArrayList<Carta>();
		arrayListCartePersonaggio = new ArrayList<Carta>();
		arrayListCarteEdificio = new ArrayList<Carta>();
		arrayListCarteImpresa = new ArrayList<Carta>();
		
		
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
	public void testAttiva(){
		
		Boolean result;
		
		plancia.setCarte(1, arrayListCarteTerritorio, arrayListCartePersonaggio, arrayListCarteEdificio, arrayListCarteImpresa);
		player.getFamiliare(ColoreFamiliare.NERO).setValore(6);
		this.azioneOccupaSpazioTorre = new AzioneOccupaSpazioTorre(player, player.getFamiliare(ColoreFamiliare.NERO), plancia.getSpazioTorre(TipoCarta.EDIFICIO, 0), 0, 1);
		this.azioneOccupaSpazioTorre.controlloFamiliariTorre();
		assertTrue("Errore fallisce il controllo torre", azioneOccupaSpazioTorre.controlloFamiliariTorre());
		

		
		
		
		this.risultatoAzione = azioneOccupaSpazioTorre.èValida();

		
		
		
		assertTrue("Errore fallsce è valida", risultatoAzione.getRisultato());
		
		this.azioneOccupaSpazioTorre.attiva();
		
		
		produzione.attiva(player);
		
		if(player.getSetRisorse().paragona(setRisorseTest2))
		{
			result = true;
		}
		else result = false;
		
		
		assertTrue("Errore test attiva aggiunta risorse da spazio", result);
		
		
	}
	
}
