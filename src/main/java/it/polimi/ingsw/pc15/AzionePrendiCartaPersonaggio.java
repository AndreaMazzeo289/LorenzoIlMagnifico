package it.polimi.ingsw.pc15;

public class AzionePrendiCartaPersonaggio extends AzionePrendiCarta {

	public AzionePrendiCartaPersonaggio(Player player, Carta carta) {
		super(player, carta);
	}

	@Override
	public void daiCarta() {
		carta.setSpazio(null);
		player.getPersonaggi().add((Personaggio) carta);
		carta.setPlayer(player);
		
	}

	@Override
	public boolean controllaRequisiti() {
		if (player.getPersonaggi().size() == 6) {  //limite carte Personaggio
			System.out.println("Hai raggiunto il limite massimo di carte Personaggio!");
			return false;
		}
			
		return true;
	}

}
