package it.polimi.ingsw.pc15.GUI.gameboard;

import javax.swing.JPanel;

/**
 * Classe astratta che verrà estesa da tutti gli spazi mercato
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 * 
 */
public abstract class SpazioMercato extends JPanel{
	
	/**
	 * metodo che permette di inserire un familiare nello spazio
	 * @param path del familiare che si vuole inserire
	 */
	public void inserisciFamiliare(String path) {
	}
	
	/**
	 * metodo che permette di rimuovere il familiare che lo occupa
	 */
	public void rimuoviFamiliare() {
	}
	
}
