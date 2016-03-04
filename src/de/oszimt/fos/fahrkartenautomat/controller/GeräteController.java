package de.oszimt.fos.fahrkartenautomat.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.oszimt.fos.fahrkartenautomat.model.Callbacks;
import de.oszimt.fos.fahrkartenautomat.model.Fahrkartentyp;
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

	public void printTicket(Fahrkartentyp ticket, int count)
	{
		//todo:delay?
		
		StringBuilder sb = new StringBuilder();
		sb.append("Ticketausgabe:\n");
		for(int i = 0; i < count; i++)
		{
			//sb.append(ticket.getName()).append('\n');
		}
		
		ActionEvent evt = new ActionEvent(this, Callbacks.MSG_REC.id(), sb.toString());
		outputTarget.actionPerformed(evt);
	}
	
	public void outputChange(double[] change)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Rückgabe, Münzen:\n");
		for(int i = 0; i < change.length; i++)
		{
			sb.append(change[i]).append('\n');
		}
		String d = sb.toString();
		
		ActionEvent evt = new ActionEvent(null, Callbacks.MSG_REC.id(), d);
		
		outputTarget.actionPerformed(evt);
		
	}
	
	public void addCash(double cash){
		
	}
	
	public double getInkState(){
		return 0.0;
	}
	
	public double getPaperState(){
		return 0.0;
	}
	
	public void setOutputHandler(ActionListener outputTarget){
		this.outputTarget = outputTarget;
	}
	
	
	
}
