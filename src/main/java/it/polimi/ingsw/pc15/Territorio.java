package it.polimi.ingsw.pc15;

import java.util.Set;

public class Territorio extends Carta {
	
	private int requisitoRaccolta;
	private Effetto effettoRaccolta;
	
	public Territorio (String nome, int id, int periodo, Set<Effetto> effettoIstantaneo, int requisitoRaccolta, Effetto effettoRaccolta) {
		super(nome, id, periodo, effettoIstantaneo);
		this.requisitoRaccolta = requisitoRaccolta;
		this.effettoRaccolta = effettoRaccolta;
	}

	@Override
	public boolean acquistabile(Player player) {
		
		if (this.getSpazio().getTorre().occupata())
			if (this.getPlayer().getRisorse().getOro().getQuantità() <3) {
				return false;
			}
		
		
		switch (player.getTerritori().size()) {
		case 2: if (player.getSetRisorse().getPuntiMilitari().getQuantità()<3) 
					return false;
				return true;

		case 3: if (player.getSetRisorse().getPuntiMilitari().getQuantità()<7) 
					return false;
				return true;
				
		case 4: if (player.getSetRisorse().getPuntiMilitari().getQuantità()<12) 
					return false;
				return true;
				
		case 5: if (player.getSetRisorse().getPuntiMilitari().getQuantità()<18) 
					return false;
				return true;
				
		case 6: return false;
		
		default: return true;
			
			
		}
	}

}
