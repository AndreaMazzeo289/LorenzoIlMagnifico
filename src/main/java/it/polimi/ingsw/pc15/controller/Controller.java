package it.polimi.ingsw.pc15.controller;

import java.util.Observable;
import java.util.Observer;

import it.polimi.ingsw.pc15.model.Model;
import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.view.View;


public class Controller implements Observer {
	
	private final Model gioco;
	
	public Controller (Model gioco, View view) {
		this.gioco = gioco;
		view.addObserver(this);
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		//
		((Player) this.gioco.getPlayers().get(0)).occupaSpazio ((Spazio) this.gioco.getPlancia().getSpaziMercato().get(0), ((Player) this.gioco.getPlayers().get(0)).getFamiliare(ColoreFamiliare.ARANCIONE));
		
	}

}
