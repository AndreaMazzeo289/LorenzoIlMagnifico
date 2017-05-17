package it.polimi.ingsw.pc15;

public class AzionePrendiCartaImpresa extends AzionePrendiCarta {

	public AzionePrendiCartaImpresa(Player player, Carta carta) {
		super(player, carta);
	}

	@Override
	public void daiCarta() {
		carta.setPlayer(player);	
		player.getImprese().add((Impresa) carta);
	}

	@Override
	public boolean requisitiSoddisfatti() {
		if (player.getImprese().size() == 6) {  //limite carte Impresa
			System.out.println("Hai raggiunto il limite massimo di carte Impresa!");
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


