package it.polimi.ingsw.pc15;

public class AzionePrendiCartaEdificio extends AzionePrendiCarta {

	public AzionePrendiCartaEdificio(Player player, Carta carta) {
		super(player, carta);
	}

	@Override
	public void daiCarta() {
		carta.setSpazio(null);
		player.getEdifici().add((Edificio) carta);
		carta.setPlayer(player);		
	}

	@Override
	public boolean controllaRequisiti() {
		if (player.getEdifici().size() == 6) {    //limite carte Edificio
			System.out.println("Hai raggiunto il limite massimo di carte Edificio!");
			return false;
		}
		
		return true;
	}

}
