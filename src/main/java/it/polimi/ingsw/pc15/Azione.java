package it.polimi.ingsw.pc15;

public abstract class Azione extends Effetto {

	protected int valoreDado;
	
	public Azione(int valoreDado){
		this.valoreDado = valoreDado;
	}
	
	@Override
	public void attiva(Player player){}
	
	public int getValoreDado(){
		return this.valoreDado;
	}
}
