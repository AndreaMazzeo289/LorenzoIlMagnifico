package it.polimi.ingsw.pc15;

public class Scambio extends Effetto{
	
	private SetRisorse pagamento;
	private SetRisorse guadagno;
	
	public Scambio(SetRisorse pagamento, SetRisorse guadagno){
		
		this.pagamento = pagamento;
		this.guadagno = guadagno;
	}

	@Override
	public void attiva(Player player) {
		
		
		if(player.getSetRisorse().paragona(pagamento))
			player.getSetRisorse().aggiungi(guadagno);
		
	}
		
}
