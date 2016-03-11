package de.oszimt.fos.fahrkartenautomat.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.oszimt.fos.fahrkartenautomat.model.Ausgaben;
import de.oszimt.fos.fahrkartenautomat.model.Fahrkartentyp;
import de.oszimt.fos.fahrkartenautomat.model.Geld;
import de.oszimt.fos.fahrkartenautomat.model.MoneySet;


/**
 * @author Alex
 * Speichert aktuelle Bestände ab
 * Generiert die Ausgaben
 */
public class GeräteController 
{
	double ink, paper;
	MoneySet totalMoney;
	ActionListener outputTarget;
	
	public GeräteController(double paper, double ink, 
			double money, ActionListener outputTarget)
	{
		this.ink = ink;
		this.paper = paper;
		this.totalMoney = new MoneySet();
		totalMoney.setValue(money);
		this.outputTarget = outputTarget;
	}
	
	private void respond(String msg, Ausgaben outputType)
	{
		ActionEvent evt = new ActionEvent(this, outputType.id(), msg);
		outputTarget.actionPerformed(evt);
	}

	public void printTicket(Fahrkartentyp ticket, boolean fourway, int count)
	{
		//todo:delay?
		StringBuilder sb = new StringBuilder();
		String name = (fourway ? "4-Fahrten-" : "") + ticket.getName();
		sb.append(count).append(name).append(":")
		.append(ticket.getDescription()).append("\n");

		respond(sb.toString(), Ausgaben.TICKET);
	}
	
	public void outputChange(MoneySet change)
	{
		StringBuilder sb = new StringBuilder();
		double value = change.getValue();
		sb.append(value).append("\n");
		for(int i = 0; i < Geld.getValidCount(); i++)
		{
			Geld selected = Geld.validMonies[i];
			int count = change.getCount(selected);
			if(count > 0)
				sb.append(count).
				append("x ").append(selected.getValue()).append("€");
		}
		
		respond(sb.toString(), Ausgaben.CHANGE);
		
	}
	
	public void addCash(MoneySet cash){
		totalMoney.add(cash);
	}
	
	public double getInkState(){
		return ink;
	}
	
	public double getPaperState(){
		return paper;
	}
	
	public void informLowResources(){
		respond("", Ausgaben.OUT_OF_ORDER);
	}
	
	public void setOutputHandler(ActionListener outputTarget){
		this.outputTarget = outputTarget;
	}

}
