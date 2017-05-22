package it.polimi.ingsw.pc15.risorse;

public class Privilegi extends Risorsa {

	public Privilegi(int quantità) {
		super(quantità);
		
	}
	
	@Override
	public void aggiungi(int quantità) {
		
	}

	@Override
	public TipoRisorsa getTipoRisorsa() {
		// TODO Auto-generated method stub
		return TipoRisorsa.PRIVILEGI;
	}

}
