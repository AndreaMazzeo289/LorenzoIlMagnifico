package it.polimi.ingsw.pc15.client;

import java.io.Serializable;
import java.util.ArrayList;

import it.polimi.ingsw.pc15.GUI.GUI;

public interface FasePartita extends Serializable {

	public ArrayList<String> attiva(CLI cli);
	
	public ArrayList<String> attiva(GUI gui);
	

}
