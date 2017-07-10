package it.polimi.ingsw.pc15.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import it.polimi.ingsw.pc15.ParserXML;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.carte.Impresa;

import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.plancia.SpazioMercato;
import it.polimi.ingsw.pc15.plancia.SpazioTorre;
import it.polimi.ingsw.pc15.plancia.TesseraScomunica;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Leader;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;


public class CLI extends ClientView {
	
	private Scanner input;
	
	public CLI(NetworkHandler networkHandler, ClientModel clientModel){
		super(networkHandler, clientModel);
		this.input = new Scanner(System.in);
	}
	
	@Override
	public void run(){
		
	    while (this.clientModel.getPeriodo() <= ParserXML.leggiValore("numeroPeriodi")) {
			
			message.clear();
			//Thread thread = new Thread(new ClientTimer(this));
			//thread.start();
			
			
			try {
		    	switch (input.next()) {
		    	case "0": if (tuoTurno()) { 
		    		
				    		message.add("posiziona familiare");
				    	
							/////////////SCELTA FAMILIARE///////////////////////////////
				
							System.out.println("\nQuale familiare vuoi posizionare?");		
							if (this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.NERO).disponibile())
								System.out.println("  1. familiare NERO (valore: " + this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.NERO).getValore() +")");
							if (this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.BIANCO).disponibile())
								System.out.println("  2. familiare BIANCO (valore: " + this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.BIANCO).getValore() +")");
							if (this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.ARANCIONE).disponibile())
								System.out.println("  3. familiare ARANCIONE (valore: " + this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.ARANCIONE).getValore() +")");
							if (this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.NEUTRO).disponibile())
								System.out.println("  4. familiare NEUTRO (valore: " + this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.NEUTRO).getValore() +")");
							
							switch(input.nextInt()) {
							case 1: message.add("familiare nero");
									break;
							case 2: message.add("familiare bianco");
									break;
							case 3: message.add("familiare arancione");
									break;
							case 4: message.add("familiare neutro");
									break;
							default: throw new InputMismatchException();
							}	
							
							//////////////FINE SCELTA FAMILIARE///////////////////////////
							
							////////////////SCELTA SERVITORI/////////////////////////////
							
								 
							System.out.println("\nVuoi spendere dei servitori per aumentare il valore della tua azione?  (S/N)");
							String in = input.next();
							switch (in) {
							case "S":
							case "s":
							case "sì":
							case "si": System.out.println("\nQuanti servitori vuoi spendere? (Servitori in tuo possesso: " + clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.SERVITORI).getQuantità() + ")");
									int numeroServitori = input.nextInt();
									if (this.clientModel.getStatoGiocatore().getEffettiAttivi().sovrapprezzoServitori())
										numeroServitori /= 2;
									if (numeroServitori > clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.SERVITORI).getQuantità())
										throw new InputMismatchException();
									else message.add(String.valueOf(numeroServitori));
										break;
							case "no":
							case "N":
							case "n": message.add("0");
									break;
							default: throw new InputMismatchException();
							}
							
							//////////////FINE SCELTA SERVITORI////////////////////////////////
							
							/////////////SCELTA SPAZIO/////////////////////////////////////////
							
							System.out.println("\nQuale spazio vuoi occupare?\n  1. Spazio del Mercato\n  2. Spazio del Consiglio\n  3. Spazio raccolta\n  4. Spazio produzione\n  5. Spazio di una torre");
							switch (input.nextInt()) {
							case 1: message.add("mercato");
								System.out.println("\nQuale spazio del mercato vuoi occupare?");
								for (SpazioMercato spazio : this.clientModel.getStatoPlancia().getSpaziMercato())
									if (spazio.vuoto())
									System.out.println("  " + (this.clientModel.getStatoPlancia().getSpaziMercato().lastIndexOf(spazio)+1) + ") " + spazio.getEffetto().toString());
								int scelta = input.nextInt();
								if (scelta>this.clientModel.getStatoPlancia().getSpaziMercato().size())
									throw new InputMismatchException();
								message.add(String.valueOf(scelta-1));
								break;
							case 2: message.add("consiglio");
									System.out.println("\nChe risorsa vuoi ottenere?\n  1. Legna(1) e Pietra(1)\n  2. Servitori(2)\n  3. Oro(2)\n  4. Punti Militari(2)\n  5. Punti Fede(1)");
									int sceltaRisorse = input.nextInt();
									if (sceltaRisorse>5 || sceltaRisorse<1)
										throw new InputMismatchException();
									else message.add(String.valueOf(sceltaRisorse));
								break;
							case 3: message.add("raccolta");
								break;
							case 4: message.add("produzione");
								break;
							case 5: message.add("torre");
									System.out.println("\nQuale torre vuoi occupare?\n  1. Verde\n  2. Blu\n  3. Gialla\n  4. Viola");
									int sceltaSpazio;
									switch(input.nextInt()) {
									case 1: message.add("verde");
											System.out.println("Quale spazio della torre?");
											for(SpazioTorre spazio : this.clientModel.getStatoPlancia().getTorre(TipoCarta.TERRITORIO).getSpaziTorre())
							    				if (spazio.vuoto())
							    					System.out.println("  - Spazio " + (this.clientModel.getStatoPlancia().getTorre(TipoCarta.TERRITORIO).getSpaziTorre().lastIndexOf(spazio)+1) + ": LIBERO - Carta " + TipoCarta.TERRITORIO.name() + " presente: " + spazio.getCarta().toString());
							    				else {
							    					System.out.print("  - Spazio " + (this.clientModel.getStatoPlancia().getTorre(TipoCarta.TERRITORIO).getSpaziTorre().lastIndexOf(spazio)+1) + ": occupato dal familiare ");
								    				for (Familiare familiare : spazio.getFamiliari())
								    					System.out.println(familiare.getColore().name() + " di " + familiare.getPlayer().getNome() + " ");
							    				}
											sceltaSpazio = input.nextInt();
											if (sceltaSpazio>this.clientModel.getStatoPlancia().getTorre(TipoCarta.TERRITORIO).getSpaziTorre().size())
												throw new InputMismatchException();
											message.add(String.valueOf(sceltaSpazio-1));
											break;
									case 2: message.add("blu");
											System.out.println("Quale spazio della torre?");
											sceltaSpazio = input.nextInt();
											for(SpazioTorre spazio : this.clientModel.getStatoPlancia().getTorre(TipoCarta.PERSONAGGIO).getSpaziTorre())
							    				if (spazio.vuoto())
							    					System.out.println("  - Spazio " + (this.clientModel.getStatoPlancia().getTorre(TipoCarta.PERSONAGGIO).getSpaziTorre().lastIndexOf(spazio)+1) + ": LIBERO - Carta " + TipoCarta.PERSONAGGIO.name() + " presente: " + spazio.getCarta().toString());
							    				else {
							    					System.out.print("  - Spazio " + (this.clientModel.getStatoPlancia().getTorre(TipoCarta.PERSONAGGIO).getSpaziTorre().lastIndexOf(spazio)+1) + ": occupato dal familiare ");
								    				for (Familiare familiare : spazio.getFamiliari())
								    					System.out.println(familiare.getColore().name() + " di " + familiare.getPlayer().getNome() + " ");
							    				}
											if (sceltaSpazio>this.clientModel.getStatoPlancia().getTorre(TipoCarta.PERSONAGGIO).getSpaziTorre().size())
												throw new InputMismatchException();
											message.add(String.valueOf(sceltaSpazio-1));
											break;
									case 3: message.add("gialla");
											System.out.println("Quale spazio della torre?");
											for(SpazioTorre spazio : this.clientModel.getStatoPlancia().getTorre(TipoCarta.EDIFICIO).getSpaziTorre())
							    				if (spazio.vuoto())
							    					System.out.println("  - Spazio " + (this.clientModel.getStatoPlancia().getTorre(TipoCarta.EDIFICIO).getSpaziTorre().lastIndexOf(spazio)+1) + ": LIBERO - Carta " + TipoCarta.EDIFICIO.name() + " presente: " + spazio.getCarta().toString());
							    				else {
							    					System.out.print("  - Spazio " + (this.clientModel.getStatoPlancia().getTorre(TipoCarta.EDIFICIO).getSpaziTorre().lastIndexOf(spazio)+1) + ": occupato dal familiare ");
								    				for (Familiare familiare : spazio.getFamiliari())
								    					System.out.println(familiare.getColore().name() + " di " + familiare.getPlayer().getNome() + " ");
							    				}
											sceltaSpazio = input.nextInt();
											if (sceltaSpazio>this.clientModel.getStatoPlancia().getTorre(TipoCarta.EDIFICIO).getSpaziTorre().size())
												throw new InputMismatchException();
											message.add(String.valueOf(sceltaSpazio-1));
											break;
									case 4: message.add("viola");
											System.out.println("Quale spazio della torre?");
											for(SpazioTorre spazio : this.clientModel.getStatoPlancia().getTorre(TipoCarta.IMPRESA).getSpaziTorre())
							    				if (spazio.vuoto())
							    					System.out.println("  - Spazio " + (this.clientModel.getStatoPlancia().getTorre(TipoCarta.IMPRESA).getSpaziTorre().lastIndexOf(spazio)+1) + ": LIBERO - Carta " + TipoCarta.IMPRESA.name() + " presente: " + spazio.getCarta().toString());
							    				else {
							    					System.out.print("  - Spazio " + (this.clientModel.getStatoPlancia().getTorre(TipoCarta.IMPRESA).getSpaziTorre().lastIndexOf(spazio)+1) + ": occupato dal familiare ");
								    				for (Familiare familiare : spazio.getFamiliari())
								    					System.out.println(familiare.getColore().name() + " di " + familiare.getPlayer().getNome() + " ");
							    				}
											sceltaSpazio = input.nextInt();
											if (sceltaSpazio>this.clientModel.getStatoPlancia().getTorre(TipoCarta.IMPRESA).getSpaziTorre().size())
												throw new InputMismatchException();
											message.add(String.valueOf(sceltaSpazio-1));
											if (this.clientModel.getStatoPlancia().getSpazioTorre(TipoCarta.IMPRESA, sceltaSpazio-1).getCarta().getCosto().getRisorse().isEmpty()==false && ((Impresa) this.clientModel.getStatoPlancia().getSpazioTorre(TipoCarta.IMPRESA, sceltaSpazio-1).getCarta()).getRequisitoPuntiMilitari()!=0) {
												System.out.println("Vuoi pagare il costo in risorse (1) o in punti militari (2) ?");
												message.add(String.valueOf(input.nextInt()));
											}
											else {
												if (this.clientModel.getStatoPlancia().getSpazioTorre(TipoCarta.IMPRESA, sceltaSpazio-1).getCarta().getCosto().getRisorse().isEmpty())
													message.add(String.valueOf(2));
												else message.add(String.valueOf(1));
											}

												
											break;

									default: throw new InputMismatchException();
									}
									
								break;
									
							default: throw new InputMismatchException();
							} 
								
								////////////FINE SCELTA SPAZIO///////////////////////////////////
							setChanged();
		    	
		    	}  else throw new InputMismatchException();
					
				break;		
					
		    	case "1": System.out.println("\nAl momento possiedi le seguenti risorse: ");
						System.out.println("  - Oro: " + this.clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.ORO).getQuantità());
						System.out.println("  - Legna: " + this.clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.LEGNA).getQuantità());
						System.out.println("  - Pietra: " + this.clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.PIETRA).getQuantità());
						System.out.println("  - Servitori: " + this.clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.SERVITORI).getQuantità());
						System.out.println("\n  - Punti Vittoria: " + this.clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.PUNTIVITTORIA).getQuantità());
						System.out.println("  - Punti Militari: " + this.clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.PUNTIMILITARI).getQuantità());
						System.out.println("  - Punti Fede: " + this.clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.PUNTIFEDE).getQuantità());
						update(this, "");
				break;

						
		    	case "2": System.out.println("\nI tuoi familiari disponibili sono i seguenti: ");
		    			if (this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.NERO).disponibile())
		    				System.out.println("  - Familiare nero - valore: " + this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.NERO).getValore());
		    			if (this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.BIANCO).disponibile())
		    				System.out.println("  - Familiare bianco - valore: " + this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.BIANCO).getValore());
		    			if (this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.ARANCIONE).disponibile())
		    				System.out.println("  - Familiare arancione - valore: " + this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.ARANCIONE).getValore());
		    			if (this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.NEUTRO).disponibile())
		    				System.out.println("  - Familiare neutro - valore: " + this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.NEUTRO).getValore());
						update(this, "");
		    	break;
		    			
		    	
		    	case "3": for (SpazioMercato spazioMercato : this.clientModel.getStatoPlancia().getSpaziMercato())
		    				if (spazioMercato.vuoto())
		    					System.out.println("  - Spazio del Mercato " + this.clientModel.getStatoPlancia().getSpaziMercato().lastIndexOf(spazioMercato) + ": LIBERO");
		    				else 
		    					System.out.print("  - Spazio del Mercato " + this.clientModel.getStatoPlancia().getSpaziMercato().lastIndexOf(spazioMercato) + ": Occupato dal familiare  " + spazioMercato.getFamiliari().get(0).getColore().name() + " di " + spazioMercato.getFamiliari().get(0).getPlayer().getNome() + "\n");
						
		    			if (this.clientModel.getStatoPlancia().getSpazioRaccolta().vuoto())
							System.out.println("\n  - Spazio raccolta : LIBERO");
		    			else {
		    				System.out.print("\n  - Spazio raccolta: Occupato da: ");
		    				for (Familiare familiare : this.clientModel.getStatoPlancia().getSpazioRaccolta().getFamiliari())
		    					System.out.print("familiare " + familiare.getColore().name() + " di " + familiare.getPlayer().getNome() + " - ");
		    				System.out.println("");
		    			}
		    			
		    			if (this.clientModel.getStatoPlancia().getSpazioProduzione().vuoto())
							System.out.println("  - Spazio produzione : LIBERO");
		    			else {
		    				System.out.print("  - Spazio produzione: Occupato da ");
		    				for (Familiare familiare : this.clientModel.getStatoPlancia().getSpazioProduzione().getFamiliari())
		    					System.out.print("familiare " + familiare.getColore().name() + " di " + familiare.getPlayer().getNome() + " - ");
		    				System.out.println("");
		    			}
		    			
		    			if (this.clientModel.getStatoPlancia().getSpazioConsiglio().vuoto())
							System.out.println("\n  - Spazio del Consiglio : LIBERO");
		    			else {
		    				System.out.print("\n  - Spazio del Consiglio: Occupato da ");
		    				for (Familiare familiare : this.clientModel.getStatoPlancia().getSpazioConsiglio().getFamiliari())
		    					System.out.print("familiare " + familiare.getColore().name() + " di " + familiare.getPlayer().getNome() + " - ");
		    				System.out.print("\n");
		    			}
		    			
		    			for (TipoCarta tipo: TipoCarta.values()) {
		    				if (tipo.equals(TipoCarta.ALL));
		    				else {
		    					
				    			System.out.println("\n    Torre " + tipo.name());
				    			for (SpazioTorre spazio : this.clientModel.getStatoPlancia().getTorre(tipo).getSpaziTorre())
				    				if (spazio.vuoto())
				    					System.out.println("  - Spazio " + (this.clientModel.getStatoPlancia().getTorre(tipo).getSpaziTorre().lastIndexOf(spazio)+1) + ": LIBERO - Carta " + tipo.name() + " presente: " + spazio.getCarta().toString());
				    				else {
				    					System.out.print("  - Spazio " + (this.clientModel.getStatoPlancia().getTorre(tipo).getSpaziTorre().lastIndexOf(spazio)+1) + ": occupato dal familiare ");
					    				for (Familiare familiare : spazio.getFamiliari())
					    					System.out.println(familiare.getColore().name() + " di " + familiare.getPlayer().getNome() + " ");
				    				}
		    					}
		    			}
		    			
		    			
		    			System.out.println("\n    SCOMUNICHE:");
		    			for (Entry<Integer, TesseraScomunica> scomunica : this.clientModel.getStatoPlancia().getScomuniche().entrySet())
		    				System.out.println("  - Periodo " + scomunica.getKey() + ": " + scomunica.getValue().toString());
		    			
	
	
						update(this, "");
		    	break;
		    	
						
		    	case "4": System.out.println("\nAl momento possiedi le seguenti carte Leader:");
		    			for (Leader leader : this.clientModel.getStatoGiocatore().getCarteLeader())
		    				if (leader!=null)
		    					System.out.println("  - " + leader.toString());
		    			System.out.println(this.clientModel.getStatoGiocatore().getTesseraBonus().getRisorseBonusProduzione());
						update(this, "");
		    	break;
		    	
		    	
		    	case "5": System.out.println("\nAl momento possiedi le seguenti carte Sviluppo:");
		    	
		    			for (TipoCarta tipo : TipoCarta.values()) {
		    				if (tipo.equals(TipoCarta.ALL));
		    				else {
		    					
				    			System.out.println(" carte " + tipo.name() + ": ");
				    			if (this.clientModel.getStatoGiocatore().getCarte(tipo).isEmpty())
				    				System.out.println("  [nessuna]");
				    			else for (Carta carta : this.clientModel.getStatoGiocatore().getCarte(tipo))
									System.out.println("  - " + carta.getNome() + " (EFFETTO PERMANENTE: " + carta.getEffettoPermanente().toString() + ")");
		    				}		    				
		    			}
		    			
						update(this, "");
				break;
		    	
			
				case "6": if (tuoTurno()) {
							message = new ArrayList<String>();
							message.add("gioca Leader"); 
							System.out.println("\nQuale Leader vuoi giocare?");
			    			for (Leader leader : this.clientModel.getStatoGiocatore().getCarteLeader())
			    				System.out.println("  " + (this.clientModel.getStatoGiocatore().getCarteLeader().lastIndexOf(leader)+1) +". " + leader.getNome());
							message.add(String.valueOf(input.nextInt()-1));
							setChanged();
						} else throw new InputMismatchException();
				
				break;	
				
						
				case "7": if (tuoTurno()) {
					message = new ArrayList<String>();
					message.add("scarta Leader"); 
					System.out.println("\nQuale Leader vuoi scartare?");
	    			for (Leader leader : this.clientModel.getStatoGiocatore().getCarteLeader())
	    				System.out.println("  " + (this.clientModel.getStatoGiocatore().getCarteLeader().lastIndexOf(leader)+1) +". " + leader.getNome());
					message.add(String.valueOf(input.nextInt()-1));
					System.out.println("\nChe risorsa vuoi ottenere?\n  1. Legna(1) e Pietra(1)\n  2. Servitori(2)\n  3. Oro(2)\n  4. Punti Militari(2)\n  5. Punti Fede(1)");
					int sceltaRisorse = input.nextInt();
					if (sceltaRisorse>5 || sceltaRisorse<1)
						throw new InputMismatchException();
					else message.add(String.valueOf(sceltaRisorse));
					setChanged();
				} else throw new InputMismatchException();
	
				break;	
				
						
				case "8": if (tuoTurno()) {
							message = new ArrayList<String>();
							message.add("attiva effetto Leader"); 
							System.out.println("\nQuale Leader vuoi attivare?");
			    			for (Leader leader : this.clientModel.getStatoGiocatore().getCarteLeader())
			    				System.out.println("  " + (this.clientModel.getStatoGiocatore().getCarteLeader().lastIndexOf(leader)+1) +". " + leader.getNome());
			    			message.add(String.valueOf(input.nextInt()-1));
							setChanged();
						} else throw new InputMismatchException();
		
				break;
						
				default: throw new InputMismatchException();
					
		    	}	
		    	
			} catch (InputMismatchException e) {
	    		System.out.print("\n--ERRORE: Inserire un comando valido!--");
				update(this, "");
				
			}
			
			if (this.clientModel.getTurno()==ParserXML.leggiValore("numeroTurniPerPeriodo") && this.clientModel.getAzione()== ParserXML.leggiValore("numeroAzioniPerTurno") && hasChanged()) {
				if (this.clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.PUNTIFEDE).getQuantità() <= ParserXML.leggiValore("puntiFedePeriodo" + String.valueOf(this.clientModel.getPeriodo()))) {
					System.out.println("\n  --- SOSTEGNO ALLA CHIESA ---\nVuoi pagare i tuoi Punti Fede (1) o subire la scomunica della Chiesa? (2)");
					message.add(String.valueOf(input.nextInt()));
				}
				else message.add("2");
			}
			
			//thread.interrupt();
			
	    	notifyObservers(message);
	  
	    }			
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		System.out.println((String)arg1);
		
		if (this.clientModel.getPeriodo() <= ParserXML.leggiValore("numeroPeriodi")) {
			
	    	if (tuoTurno())
	    		System.out.println("\n(È il tuo turno!)");
	    	else 
	    		System.out.println("\n(È il turno di " + this.clientModel.getGiocatoreCorrente()+"!)");
			
	    	ArrayList<String> message = new ArrayList<String>();
			
	    	System.out.println("\n" + clientModel.getStatoGiocatore().getNome() + ", cosa vuoi fare?");
	    	if (tuoTurno())
	    		System.out.println("  0. Posiziona un familiare");
	    	System.out.println("  1. Visualizza risorse\n  2. Visualizza familiari disponibili\n  3. Visualizza plancia\n  4. Visualizza carte Leader in tuo possesso\n  5. Visualizza carte Sviluppo in tuo possesso");
	    	if (tuoTurno())
	    		System.out.println("  6. Gioca una carta Leader\n  7. Scarta una carta Leader\n  8. Attiva l'effetto di una carta Leader");
    	}
		
	}
	
	public void close() {
		setChanged();
		notifyObservers(new ArrayList<String>(Arrays.asList("CONNESSIONE CHIUSA")));
		return;
	}

}