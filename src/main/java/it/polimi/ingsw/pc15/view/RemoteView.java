package it.polimi.ingsw.pc15.view;

/*import java.util.Observable;
import java.util.Observer;

import it.polimi.ingsw.pc15.controller.Controller;
import it.polimi.ingsw.pc15.model.Model;
import it.polimi.ingsw.pc15.networking.Connection;
import it.polimi.ingsw.pc15.player.Player;

public class RemoteView extends View implements Observer{

	private Player player;
	private Connection connection;	
	
	
	public RemoteView(Player player, Connection connection, Model model){
		
		super(player, model);
		this.player = player;
		this.connection = connection;
		this.connection.addObserver(this);
		this.model.addObserver(this);
		
	}
	
	@Override
	public void showModel(String message) {
		// TODO Auto-generated method stub
		System.out.println("Gioca " + player.getNome());
		connection.send("Gioca " + player.getNome());
	
	}
	
	@Override
	public void update(Observable o, Object message) {
		// TODO Auto-generated method stub
		if(!(o instanceof Connection)|| !(message instanceof String)){
			throw new IllegalArgumentException();
		}
		System.out.println("checkremoteview");
		provaView((String)message);
	}

}
*/