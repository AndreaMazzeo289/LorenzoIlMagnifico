package it.polimi.ingsw.pc15.testCarte;



import it.polimi.ingsw.pc15.carte.Impresa;
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

import java.util.HashSet;

import org.junit.*;
import static org.junit.Assert.*;


public class TestImpresa {

	
	Impresa cartaImpresa;
	SetRisorse setRisorse;
	HashSet<Risorsa> risorsa;
	Legna legna;
	Oro oro;
	Pietra pietra;
	Privilegi privilegi;
	PuntiFede puntiFede;
	PuntiMilitari puntiMilitari;
	PuntiVittoria puntiVittoria;
	Servitori servitori;
	
	HashSet<Effetto> effettoPermanente;
	HashSet<Effetto> effettoIstantaneo;
	AnnullaGuadagno annullaGuadagno;
	
	
	@Before
	public void setUp(){
		
		legna = new Legna(0);
		oro = new Oro(0);
		pietra = new Pietra(0);
		privilegi = new Privilegi(0);
		puntiFede = new PuntiFede(0);
		puntiMilitari = new PuntiMilitari(0);
		puntiVittoria = new PuntiVittoria(0);
		servitori = new Servitori(0);
		
		risorsa = new HashSet<Risorsa>();
		
		risorsa.add(legna);
		risorsa.add(oro);
		risorsa.add(pietra);
		risorsa.add(privilegi);
		risorsa.add(puntiFede);
		risorsa.add(puntiMilitari);
		risorsa.add(puntiVittoria);
		risorsa.add(servitori);
		
		setRisorse = new SetRisorse(risorsa);
		
		effettoPermanente = new HashSet<Effetto>();
		effettoIstantaneo = new HashSet<Effetto>();
		
		annullaGuadagno = new AnnullaGuadagno(TipoCarta.IMPRESA);
		effettoPermanente.add(annullaGuadagno);
		effettoIstantaneo.add(annullaGuadagno);
		
		cartaImpresa = new Impresa("Carta", 1, 1, setRisorse, effettoIstantaneo, effettoPermanente, 3, 1, "test");
		
		
	}
	
	@Test
	public void testGetRequisitoPuntiMilitari(){
		assertEquals("Errore test get requisito punti militari", 3, cartaImpresa.getRequisitoPuntiMilitari());
	}
	
	@Test
	public void testGetCostoPuntiMilitari(){
		assertEquals("Errore test get requisito produzione", 1, cartaImpresa.getCostoPuntiMilitari());
	}
}
