package it.polimi.ingsw.pc15.risorse;

public class Pietra extends Risorsa{

	public Pietra(int quantità) {
		super(quantità);
		
	}

	@Override
	public TipoRisorsa getTipoRisorsa() {
		// TODO Auto-generated method stub
		return TipoRisorsa.PIETRA;
	}

}
