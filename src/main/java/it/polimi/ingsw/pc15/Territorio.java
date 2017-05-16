package it.polimi.ingsw.pc15;

import java.util.Set;

public class Territorio extends Carta {
	
	private int requisitoRaccolta;
	private Effetto effettoRaccolta;
	
	public Territorio (String nome, int id, int periodo, Set<Effetto> effettoIstantaneo, int requisitoRaccolta, Effetto effettoRaccolta, SpazioTorre spazio) {
		super(nome, id, periodo, null, effettoIstantaneo, spazio);
		this.requisitoRaccolta = requisitoRaccolta;
		this.effettoRaccolta = effettoRaccolta;
	}

	@Override
	public boolean prendibile (Player player) {		
		
		switch (player.getTerritori().size()) {
			case 2: if (player.getSetRisorse().getPuntiMilitari().getQuantità()<3) {
						System.out.println("Hai bisogno di 3 Punti Militari per aggiungere un altra carta Territorio!");
						return false;
					}
					return true;

			case 3: if (player.getSetRisorse().getPuntiMilitari().getQuantità()<7) {
						System.out.println("Hai bisogno di 7 Punti Militari per aggiungere un altra carta Territorio!");
						return false;
					}
					return true;
				
			case 4: if (player.getSetRisorse().getPuntiMilitari().getQuantità()<12) {
						System.out.println("Hai bisogno di 12 Punti Militari per aggiungere un altra carta Territorio!");
						return false;
					}
					return true;
				
			case 5: if (player.getSetRisorse().getPuntiMilitari().getQuantità()<18) {
						System.out.println("Hai bisogno di 18 Punti Militari per aggiungere un altra carta Territorio!");
						return false;
					}
					return true;
				
			case 6: System.out.println("Hai raggiunto il limite massimo di carte Territori!");
					return false;
		
			default: break;
		}
		
		if (this.risorseSufficienti(player) == false) {
			System.out.println("Non hai risorse sufficienti!");
			return false;
		}
		
		return true;

	}
	
	public int getRequisitoRaccolta() {
		return this.requisitoRaccolta;
	}
	
	public Effetto getEffettoRaccolta() {
		return this.effettoRaccolta;
	}

	@Override
	public void daiA(Player player) {
		this.setSpazio(null);
		player.getTerritori().add(this);
		this.setPlayer(player);
		
	}

}
