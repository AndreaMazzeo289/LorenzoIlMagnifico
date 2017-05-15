package it.polimi.ingsw.pc15;

public class AzioneProduzione extends Azione{
	
	public AzioneProduzione(int valoreDado){
		super(valoreDado);
	}
	
	@Override
	public void attiva(Player player){
		
		iterator<Edificio> edificio= this.player.getEdifici().iterator();
		
		while(edificio.hasnext()){
			if (this.valoreDado >= edificio.getRequisitoProduz())
				edificio.getEffettoProduz().attiva(this.player);
		}
	}
}
