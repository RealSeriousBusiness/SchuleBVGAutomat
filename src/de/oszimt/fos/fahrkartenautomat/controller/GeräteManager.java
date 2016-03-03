package de.oszimt.fos.fahrkartenautomat.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.oszimt.fos.fahrkartenautomat.model.Fahrkartentyp;
import de.oszimt.fos.fahrkartenautomat.model.MoneySet;
import de.oszimt.fos.fahrkartenautomat.view.event.CallbackID;

public class GeräteManager 
{
	double ink, paper;
	MoneySet money;
	ActionListener outputTarget;
	
	public GeräteManager(double paper, double ink, 
			double money, ActionListener outputTarget)
	{
		this.ink = ink;
		this.paper = paper;
		this.money = new MoneySet();
		//money.setValue(money);
		this.outputTarget = outputTarget;
	}
	
	public void setOutputHandler(ActionListener outputHandler)
	{
		if(outputHandler != null)
			outputTarget = outputHandler; 
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
		
		ActionEvent evt = new ActionEvent(this, CallbackID.MSG_REC.id(), sb.toString());
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
		
		ActionEvent evt = new ActionEvent(null, CallbackID.MSG_REC.id(), d);
		
		outputTarget.actionPerformed(evt);
		
	}
	
	public void addMoney()
	{
		
	}
	
	
}
