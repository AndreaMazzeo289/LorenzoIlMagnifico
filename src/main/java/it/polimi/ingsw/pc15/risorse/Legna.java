package it.polimi.ingsw.pc15.risorse;

public class Legna extends Risorsa {

	public Legna(int quantità) {
		super(quantità);
		
	}

	@Override
	public TipoRisorsa getTipoRisorsa() {
		// TODO Auto-generated method stub
		return TipoRisorsa.LEGNA;
	}

}
