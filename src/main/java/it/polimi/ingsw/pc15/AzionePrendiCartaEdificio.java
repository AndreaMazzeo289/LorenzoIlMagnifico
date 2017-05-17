package it.polimi.ingsw.pc15;

public class AzionePrendiCartaEdificio extends AzionePrendiCarta {

	public AzionePrendiCartaEdificio(Player player, Carta carta) {
		super(player, carta);
	}

	@Override
	public void daiCarta() {
		carta.setPlayer(player);	
		player.getEdifici().add((Edificio) carta);
	}

	@Override
	public boolean requisitiSoddisfatti() {
		if (player.getEdifici().size() == 6) {    //limite carte Edificio
			System.out.println("Hai raggiunto il limite massimo di carte Edificio!");
			return false;
		}
		
		return true;
	}

	@Override
	public boolean attiva() {

		if (requisitiSoddisfatti() && risorseSufficienti(carta.getCosto()) ) {
			paga(carta.getCosto());
			carta.setSpazio(null);
			daiCarta();
			carta.attivaEffettoIstantaneo();
			
			return true;
		}
		
		else return false;
	}

}