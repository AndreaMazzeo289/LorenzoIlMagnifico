package it.polimi.ingsw.pc15;

public class AzionePrendiCartaPersonaggio extends AzionePrendiCarta {

	public AzionePrendiCartaPersonaggio(Player player, Carta carta) {
		super(player, carta);
	}

	@Override
	public void daiCarta() {
		carta.setSpazio(null);
		carta.setPlayer(player);
		player.getPersonaggi().add((Personaggio) carta);	
	}

	@Override
	public boolean requisitiSoddisfatti() {
		if (player.getPersonaggi().size() == 6) {  //limite carte Personaggio
			System.out.println("Hai raggiunto il limite massimo di carte Personaggio!");
			return false;
		}
			
		return true;
	}

	@Override
	public boolean attiva() {

		if (requisitiSoddisfatti() && risorseSufficienti(carta.getCosto()) ) {
			paga(carta.getCosto());
			daiCarta();
			carta.attivaEffettoIstantaneo();
			
			return true;
		}
		
		else return false;
	}

}
