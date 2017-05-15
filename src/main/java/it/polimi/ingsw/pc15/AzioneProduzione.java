package it.polimi.ingsw.pc15;

import java.util.Iterator;

public class AzioneProduzione extends Azione{
	
	public AzioneProduzione(int valoreDado){
		super(valoreDado);
	}
	
	@Override
	public void attiva(Player player){
		
		Iterator<Edificio> edificio= this.player.getEdifici().iterator();
		
		while(edificio.hasNext()){
			if (this.valoreDado >= edificio.getRequisitoProduz())
				edificio.getEffettoProduz().attiva(this.player);
		}
	}
}
