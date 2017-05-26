package it.polimi.ingsw.pc15.effetti;

import java.util.Scanner;

import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class Scambio extends Effetto{
	
	private SetRisorse pagamento1;
	private SetRisorse guadagno1;
	private SetRisorse pagamento2;
	private SetRisorse guadagno2;
	
	public Scambio(SetRisorse pagamento1, SetRisorse guadagno1, SetRisorse pagamento2, SetRisorse guadagno2){
		
		this.pagamento1 = pagamento1;
		this.guadagno1 = guadagno1;
		this.pagamento2 = pagamento2;
		this.guadagno2 = guadagno2;
	}

	@Override
	public void attiva(Player player) {
		
		int scelta = 0;
		
		if (pagamento1 != null && pagamento2 != null) {
			System.out.println("Quale scambio vuoi attivare?");
			Scanner in = new Scanner (System.in);
			scelta = in.nextInt();
		}
		
		if (scelta==1 || pagamento2 == null) {
			if(player.getSetRisorse().paragona(pagamento1)) {
				player.getSetRisorse().sottrai(pagamento1);
				player.getSetRisorse().aggiungi(guadagno1);
			}
			else System.out.println("Non hai risorse sufficienti per attivare questo scambio!");
		}
		
		if (scelta==2 || pagamento1 == null) {
			if(player.getSetRisorse().paragona(pagamento2)) {
				player.getSetRisorse().sottrai(pagamento2);
				player.getSetRisorse().aggiungi(guadagno2);
			}
			else System.out.println("Non hai risorse sufficienti per attivare questo scambio!");
		}
	}	
}
