/*package it.polimi.ingsw.pc15.effetti;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.*;

public class ScambioTest {

	Moltiplicazione moltiplicazione;
	Player player1;
	SetRisorse pagamento;
	SetRisorse guadagno;
	int quantità;
	Scambio scambio;
	
	@Before
	public void initialize(){
		player1 = new Player("nomePlayer1");
		quantità = 2;
		Legna legna = new Legna (1);
		Oro oro = new Oro(3);
		
		HashSet<Risorsa> risorseGuadagno = new HashSet<>();
		HashSet<Risorsa> risorsePagamento = new HashSet<>();
		
		risorsePagamento.add(legna);
		risorseGuadagno.add(oro);
		
		guadagno = new SetRisorse(risorseGuadagno);
		pagamento = new SetRisorse(risorsePagamento);
	}
	
	@Test
	public void moltiplicaTest() {
		scambio = new Scambio(pagamento, guadagno, null, null);
		scambio.attiva(player1);
		assertEquals(9, player1.getSetRisorse().getRisorsa(TipoRisorsa.LEGNA).getQuantità());
		assertEquals(13, player1.getSetRisorse().getRisorsa(TipoRisorsa.ORO).getQuantità());
	}
}
*/