package testRisorse;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.pc15.risorse.Legna;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class SetRisorseTest {

	SetRisorse set1;
	SetRisorse set2;
	
	@Before
	public void initialize () {
		Legna legna1 = new Legna (1);
		Legna legna2 = new Legna (3);
		
		HashSet<Risorsa> risorse1 = new HashSet<>();
		HashSet<Risorsa> risorse2 = new HashSet<>();
		
		risorse1.add(legna1);
		risorse2.add(legna2);
		
		set1 = new SetRisorse(risorse1);
		set2 = new SetRisorse(risorse2);
		
	}
	
	@Test
	public void aggiungiTest() {
		
		set1.aggiungi(set2);
		assertEquals(4, set1.getRisorsa(TipoRisorsa.LEGNA).getQuantità());
	}
	
	@Test
	public void sottraiTest() {
		set2.sottrai(set1);
		assertEquals(2, set2.getRisorsa(TipoRisorsa.LEGNA).getQuantità());
	}
	
	@Test
	public void paragonaTest() {
		Legna legna = new Legna(2);
		HashSet<Risorsa> risorse = new HashSet<>();
		risorse.add(legna);
		SetRisorse set = new SetRisorse(risorse);
		set1.aggiungi(set);
		assertEquals(true, set1.paragona(set2));
	}

}
