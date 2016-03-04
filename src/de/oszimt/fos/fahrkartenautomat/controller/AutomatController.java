package de.oszimt.fos.fahrkartenautomat.controller;

import de.oszimt.fos.fahrkartenautomat.model.Fahrkartentyp;
import de.oszimt.fos.fahrkartenautomat.model.MoneySet;


/**
 * @author name
 * -Nimmt Informationen zur aktuellen Bestellung von der GUI entgegen und speichert diese
 * -Überprüft ob genug Geld eingeworfen wurde, um dann das Wechselgeld auszugeben
 * sowie die Tickets auszugeben
 */
public class AutomatController {
	private static AutomatController currentObj;
	GeräteController deviceControl;
	Fahrkartentyp selectedTicket;
	int countTickets;
	MoneySet insertedMoney;
	
	public static AutomatController getSingleton(){
		return currentObj;
	}
	
	public AutomatController(GeräteController geräteController) {
		// TODO Auto-generated constructor stub
	}
	
	public boolean selectTicket(Fahrkartentyp ticket){
		return false;
	}
	
	public boolean addTicket(){
		return false;
	}
	
	public boolean removeTicket(){
		return false;
	}
	
	public double insertCash(double cash){
		return 0.0;
	}
	
	public void payByPin(int pin){
		return;
	}
	
	public boolean reset(){
		return false;
	}

}
