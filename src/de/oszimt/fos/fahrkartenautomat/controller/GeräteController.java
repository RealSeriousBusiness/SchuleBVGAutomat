package de.oszimt.fos.fahrkartenautomat.controller;

import de.oszimt.fos.fahrkartenautomat.model.Ausgaben;
import de.oszimt.fos.fahrkartenautomat.model.Geld;
import de.oszimt.fos.fahrkartenautomat.model.MoneySet;
import de.oszimt.fos.fahrkartenautomat.view.event.AutomatUpdater;


/**
 * @author Alex
 * Speichert aktuelle Bestände ab
 * Generiert die Ausgaben
 */
public class GeräteController 
{
	double ink, paper;
	MoneySet totalMoney;
	AutomatUpdater src;
	private final String SEPERATOR = "\n-----------\n";
	
	public GeräteController(AutomatUpdater outputTarget)
	{
		MoneySet ms = new MoneySet();
		Geld[] g = Geld.validMonies;
		for(int i = 0; i < g.length; i++)
			ms.add(g[i], 1000);
		this.totalMoney = ms;
		this.ink = 1000.0;
		this.paper = 1000.0;
		this.src = outputTarget;
	}
	
	public void msg(String msg, boolean red)
	{
		src.handle(red ? Ausgaben.RED_TEXT : Ausgaben.NORMAL_TEXT ,
				msg + '\n');
	}
	
	public void selection(int ticketId, int count, double price)
	{
		src.handle(Ausgaben.SELECT_UPDATE, ticketId);
		src.handle(Ausgaben.TOPAY_UPDATE, price + " €");
	}
	
	public void resetView()
	{
		src.handle(Ausgaben.SELECT_UPDATE, -1);
		src.handle(Ausgaben.TOPAY_UPDATE, "0.00 €");
		src.handle(Ausgaben.PAID_UPDATE, "0.00 €");
	}
	
	public void insertedMoney(double money)
	{
		src.handle(Ausgaben.PAID_UPDATE, money + " €");
	}

	public void giveChange(MoneySet change)
	{
		src.handle(Ausgaben.NORMAL_TEXT, "Geld wird zurückgegeben..." + SEPERATOR);
		StringBuilder sb = new StringBuilder();
		Geld[] g = Geld.validMonies;
		for(int i = 0; i < g.length; i++)
		{
			Geld selected = g[i];
			int count = change.getCount(selected);
			if(count > 0)
			{
				sb.append(count + "x " + selected.getValueDecimal() + "€\n");
			}
		}
		sb.append(SEPERATOR);
		src.handle(Ausgaben.NORMAL_TEXT, sb.toString());
		src.handle(Ausgaben.NORMAL_TEXT, "Gesamt: " + change.calcValueDecimal() + "€\n\n");
	}
	
	public void singleChange(double value)
	{
		src.handle(Ausgaben.NORMAL_TEXT, "Rückgabe: " + value + " €\n");
	}
	
	public void printTicket(String ticketName, double price, int singles, int fourways)
	{
		ink--;
		paper--;
		src.handle(Ausgaben.NORMAL_TEXT, "Tickets werden gedruckt..." + SEPERATOR);
		StringBuilder sb = new StringBuilder();
		if(singles > 0)
			sb.append(singles + "x " + ticketName + "\n");
		if(fourways > 0)
			sb.append(fourways + "x " + "4-Fahrten-" + ticketName);
		sb.append(SEPERATOR);
		src.handle(Ausgaben.NORMAL_TEXT, sb.toString());
		src.handle(Ausgaben.NORMAL_TEXT, "Gesamt: " + price + " €\n");
		
	}

	public void addCash(MoneySet cash){
		totalMoney.merge(cash);
	}
	
	public void removeCash(MoneySet cash){
		totalMoney.substract(cash);
	}

}
