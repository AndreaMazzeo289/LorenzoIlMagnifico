package it.polimi.ingsw.pc15;

public class Oro extends Risorsa {

	public Oro(int quantità) {
		super(quantità);
		
	}

	@Override
	public TipoRisorsa getTipoRisorsa() {
		// TODO Auto-generated method stub
		return TipoRisorsa.ORO;
	}

}
