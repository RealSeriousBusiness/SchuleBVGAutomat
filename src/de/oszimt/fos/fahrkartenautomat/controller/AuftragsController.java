package de.oszimt.fos.fahrkartenautomat.controller;

import de.oszimt.fos.fahrkartenautomat.model.Fahrkartentyp;
import de.oszimt.fos.fahrkartenautomat.model.Geld;
import de.oszimt.fos.fahrkartenautomat.model.MoneySet;


/**
 * @author name
 * -Nimmt Informationen zur aktuellen Bestellung von der GUI entgegen und speichert diese
 * -Überprüft ob genug Geld eingeworfen wurde, um dann das Wechselgeld auszugeben
 * sowie die Tickets auszugeben
 */
public class AuftragsController {
	private static AuftragsController currentObj;
	GeräteController deviceControl;
	Fahrkartentyp selectedTicket;
	int countTickets;
	MoneySet insertedMoney;
	
	public static AuftragsController getSingleton(){
		return currentObj;
	}
	
	public AuftragsController(GeräteController geräteController) {
		this.deviceControl = geräteController;
	}
	
	public boolean selectTicket(Fahrkartentyp ticket){
		this.selectedTicket = ticket;
		return true;
	}
	
	public double addTicket(){
		countTickets++;
		return 0.0;
	}
	
	public double removeTicket(){
		countTickets--;
		return 0.0;
	}
	
	public double insertCash(Geld cash){
		insertedMoney.add(cash);
		double paid = insertedMoney.getValue();
		double toPay = selectedTicket.getPrice();
		if(paid >= toPay)
		{
			double change = paid - toPay;
			if(change > 0)
			{
				MoneySet ms = new MoneySet();
				ms.setValue(change);
				deviceControl.outputChange(ms);
			}
			deviceControl.printTicket(selectedTicket, false, countTickets);
		}
			
		return insertedMoney.getValue();
	}
	
	public void payByPin(int pin){
		return;
	}
	
	public boolean reset(){
		return false;
	}

}
