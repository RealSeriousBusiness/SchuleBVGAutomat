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
	GeräteController device;
	
	Fahrkartentyp selectedTicket;
	int countSingles;
	int countFourways;
	int paid;
	int toPay;
	
	MoneySet insertedMoney;

	public static AuftragsController getSingleton(){
		return currentObj;
	}
	
	public AuftragsController(GeräteController geräteController) {
		currentObj = this;
		this.device = geräteController;
		reset();
	}
	
	public boolean reset(){
		if(paid > 0) //money left form the last order?
			device.giveChange(insertedMoney); //if so, output it
		insertedMoney = new MoneySet();
		selectedTicket = null;
		countSingles = 1;
		countFourways = 0;
		paid = 0;
		toPay = 0;
		device.resetView();
		return true;
	}
	
	public void selectTicket(Fahrkartentyp ticket){
		this.selectedTicket = ticket;
		setTicketCount((countFourways * 4) + countSingles);
	}

	public void setTicketCount(int count){
		if(selectedTicket == null) return;
		
		if(selectedTicket.getFourway() > 0)
			this.countFourways = count / 4;
		
		this.countSingles = count - (countFourways * 4);

		toPay = (selectedTicket.getPrice() * countSingles) + 
				(selectedTicket.getFourway() * countFourways);
		
		device.selection(selectedTicket.getId(), count, Geld.toDecimal(toPay));
	}
	
	public void insertCash(Geld cash){
		boolean invalidInsert = true;
		
		if(selectedTicket == null)
			device.msg("Wählen Sie zuerst ein Ticket aus!", false);
		else if(!cash.isValid())
			device.msg("Dieses Geldstück/Schein wird nicht angenommen!", false);
		else if(cash.getValueDecimal() == 20.0 && Geld.toDecimal(toPay) < 10)
			device.msg("20€ Scheine werden erst ab 10€ Einkaufswert angenommen!", false);
		else
			invalidInsert = false;

		if(invalidInsert)
		{
			device.singleChange(cash.getValueDecimal());
			return;
		}
		
		insertedMoney.add(cash);
		paid += cash.getValue();
		device.insertedMoney(Geld.toDecimal(paid)); //update view
		
		if(paid >= toPay) //already enough inserted?
		{
			device.addCash(insertedMoney); //add money to device container
			
			int diff = paid - toPay;
			MoneySet change = new MoneySet();
			change.populate(diff, false); //calc change
			
			device.giveChange(change); //output change
			device.removeCash(change); //remove from container
			
			device.printTicket(selectedTicket.getName(), 
					Geld.toDecimal(toPay), countSingles, countFourways);
			paid = 0; //reset money which was inserted, 
			reset(); //reset machine and its view
		}

	}
	
	public void payByPin(int pin){
		return;
	}
	
}
