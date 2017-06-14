package it.polimi.ingsw.pc15.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.pc15.model.StatoPartita;

public interface RMIHandlerInterface extends Remote {

	public void aggiornaStatoPartita(StatoPartita statoPartita) throws RemoteException;

}
