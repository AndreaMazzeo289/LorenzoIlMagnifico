package it.polimi.ingsw.pc15;

public abstract class Bonus implements Effetto{
	
	private int valore;
	
	public Bonus (int valore)
	{
		this.valore = valore;
	}

	@Override
	public void attiva(Player player) {
		// TODO Auto-generated method stub
		
	}
	
	public int getValore(){
		return this.valore;
	}
}
