package it.polimi.ingsw.pc15;

import java.util.Iterator;

public class AzioneRaccolto extends Azione{
	
	public AzioneRaccolto(int valoreDado){
		super(valoreDado);
	}
	
	@Override
	public void attiva(Player player){
		
		Iterator<Territorio> territorio = this.player.getTerritori().iterator();
		
		while(territorio.hasnext()){
			if (this.valoreDado >= territorio.getRequisitoRaccolta())
				territorio.getEffettoRaccolta().attiva(this.player);
		}
	}
}