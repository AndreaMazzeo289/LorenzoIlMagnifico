package it.polimi.ingsw.pc15;

import java.util.Iterator;

public class AzioneRaccolto extends Azione{
	
	public AzioneRaccolto(int valoreDado){
		super(valoreDado);
	}
	
	@Override
	public void attiva(Player player){
		
		Iterator<Territorio> territorio = player.getTerritori().iterator();
		
		while(territorio.hasNext()){
			if (getValoreDado() >= territorio.getRequisitoRaccolta())
				territorio.getEffettoRaccolta().attiva(this.player);
		}
	}
}
