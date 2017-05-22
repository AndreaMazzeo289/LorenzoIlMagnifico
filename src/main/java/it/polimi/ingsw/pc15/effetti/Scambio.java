package it.polimi.ingsw.pc15.effetti;

import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class Scambio extends Effetto{
	
	private SetRisorse pagamento;
	private SetRisorse guadagno;
	private SetRisorse pagamento2;
	private SetRisorse guadagno2;
	
	public Scambio(SetRisorse pagamento, SetRisorse guadagno, SetRisorse pagamento2, SetRisorse guadagno2){
		
		this.pagamento = pagamento;
		this.guadagno = guadagno;
		this.pagamento2 = pagamento2;
		this.guadagno2 = guadagno2;
	}

	@Override
	public void attiva(Player player) {
		
		
		if(player.getSetRisorse().paragona(pagamento))
			player.getSetRisorse().aggiungi(guadagno);
		if(pagamento2!=null)
			if(player.getSetRisorse().paragona(pagamento2))
				player.getSetRisorse().aggiungi(guadagno2);
	}
		
}
