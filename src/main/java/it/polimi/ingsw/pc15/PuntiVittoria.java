package it.polimi.ingsw.pc15;

public class PuntiVittoria extends Risorsa {

	public PuntiVittoria(int quantità) {
		super(quantità);
		
	}

	@Override
	public TipoRisorsa getTipoRisorsa() {
		// TODO Auto-generated method stub
		return TipoRisorsa.PUNTIVITTORIA;
	}

}
