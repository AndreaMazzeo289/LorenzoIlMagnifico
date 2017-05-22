package it.polimi.ingsw.pc15.risorse;

public class Servitori extends Risorsa {

	public Servitori(int quantità) {
		super(quantità);
	}

	@Override
	public TipoRisorsa getTipoRisorsa() {
		// TODO Auto-generated method stub
		return TipoRisorsa.SERVITORI;
	}

}
