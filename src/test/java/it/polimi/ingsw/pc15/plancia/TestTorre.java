package it.polimi.ingsw.pc15.plancia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

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

import it.polimi.ingsw.pc15.player.Player;


public class TestTorre {

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
	
	HashSet<Effetto> effettoPermanente;
	HashSet<Effetto> effettoIstantaneo;
	AnnullaGuadagno annullaGuadagno;
	
	ArrayList<Carta> arrayListCarteTerritorio;
	
	Territorio cartaTerritorio;
	
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
		
		cartaTerritorio = new Territorio("Carta", 1, 1, setRisorseTest, effettoIstantaneo, effettoPermanente, 3);
		
		arrayListCarteTerritorio = new ArrayList<Carta>();
		
		arrayListCarteTerritorio.add(cartaTerritorio);
		arrayListCarteTerritorio.add(cartaTerritorio);
		arrayListCarteTerritorio.add(cartaTerritorio);
		arrayListCarteTerritorio.add(cartaTerritorio);
		
		
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
		{
			result = true;
		}
		else result = false;
		
		assertTrue("Errore test set torre", result);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
