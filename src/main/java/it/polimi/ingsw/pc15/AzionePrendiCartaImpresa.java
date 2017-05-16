package it.polimi.ingsw.pc15;

public class AzionePrendiCartaImpresa extends AzionePrendiCarta {

	public AzionePrendiCartaImpresa(Player player, Carta carta) {
		super(player, carta);
	}

	@Override
	public void daiCarta() {
		carta.setSpazio(null);
		player.getImprese().add((Impresa) carta);
		carta.setPlayer(player);	
	}

	@Override
	public boolean controllaRequisiti() {
		if (player.getImprese().size() == 6) {  //limite carte Impresa
			System.out.println("Hai raggiunto il limite massimo di carte Impresa!");
			return false;
		}
		
		return true;
	}
}

