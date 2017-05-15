package it.polimi.ingsw.pc15;


public class AzioneCarta extends Azione{
	
	private Colore coloreCarta;
	
	public AzioneCarta(int valoreDado, colore coloreCarta){
		super(valoreDado);
		this.coloreCarta = coloreCarta;
	}
	
	@Override
	public void attiva(Player player){
		//manca la view
	}

}
