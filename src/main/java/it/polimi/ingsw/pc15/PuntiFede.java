package it.polimi.ingsw.pc15;

public class PuntiFede extends Risorsa{

	public PuntiFede(int quantità) {
		super(quantità);
		
	}

	@Override
	public TipoRisorsa getTipoRisorsa() {
		// TODO Auto-generated method stub
		return TipoRisorsa.PUNTIFEDE;
	}

}
