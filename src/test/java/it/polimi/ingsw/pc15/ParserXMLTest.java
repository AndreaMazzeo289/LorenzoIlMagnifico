package it.polimi.ingsw.pc15;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class ParserXMLTest {

	ArrayList<Carta> carteTerritorio;
	ArrayList<Carta> carteEdificio;
	ArrayList<Carta> cartePersonaggio;
	ArrayList<Carta> carteImpresa;
	
	@Before
	public void initialize() {
		carteTerritorio = ParserXML.getCarteXML(TipoCarta.TERRITORIO);
		carteEdificio = ParserXML.getCarteXML(TipoCarta.EDIFICIO);
		cartePersonaggio = ParserXML.getCarteXML(TipoCarta.PERSONAGGIO);
		carteImpresa = ParserXML.getCarteXML(TipoCarta.IMPRESA);
	}
	
	@Test
	public void testCarteTerritorio() {
		Territorio territorio = (Territorio) carteTerritorio.get(2);
		assertEquals("Borgo", territorio.getNome());
	}

}
