package it.polimi.ingsw.pc15.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *Interfaccia remota che definisce i metodi remoti di RMIHandler
 *
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

import it.polimi.ingsw.pc15.model.StatoPartita;

/**
 *Interfaccia remota che contiene i metodi remoti di RMIHandler
 *
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public interface RMIHandlerInterface extends Remote {

	public void aggiornaStatoPartita(StatoPartita statoPartita) throws RemoteException;
	
	public String remoteGetNome() throws RemoteException;
	
	public void remoteOK() throws RemoteException;

}
