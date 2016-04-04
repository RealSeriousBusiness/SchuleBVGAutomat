package de.oszimt.fos.fahrkartenautomat.model;


/**
 * @author name
 * Struktur, um Geldbestände(Satz) abzuspeichern
 * Enthält Methoden, um einen Geldwert in einen Geldbestand umzuwandeln.
 */
public class MoneySet {
	public final static double[] values = null;
	private int[] counts = new int[Geld.getValidCount()];
	
	public MoneySet(){};
	
	public void add(Geld geld){
		counts[geld.getValidId()]++;
	}
	
	public void add(Geld geld, int count){
		counts[geld.getValidId()] += count;
	}
	
	public void remove(Geld geld){
		counts[geld.getValidId()]--;
	}
	
	public void remove(Geld geld, int count){
		counts[geld.getValidId()] -= count;
	}
	
	//merge with another moneyset
	public void merge(MoneySet geld){
		for(int i = 0; i < counts.length; i++)
			this.counts[i] += geld.counts[i];
	}
	
	public void substract(MoneySet geld){
		for(int i = 0; i < counts.length; i++)
			this.counts[i] -= geld.counts[i];
	}
	
	public int getCount(Geld geld){
		return counts[geld.getValidId()];
	}
	
	public double calcValueDecimal(){
		return (double)calcValue() / 100.0;
	}
	
	public int calcValue(){
		int value = 0;
		for (int id = 0; id < Geld.getValidCount(); id++)
			value += Geld.validMonies[id].getValue() * counts[id];
		return value;
	}
	
	public double populateDecimal(double value, boolean allowBills){
		return (double)populate((int)(value * 100), allowBills) / 100.0;
	}
	
	//return: remainder
	public int populate(int value, boolean allowBills){
		
		Geld[] g = Geld.validMonies;
		for(int i = g.length - 1; i > -1; i--)
		{
			Geld s = g[i];
			if(s.isBill() && !allowBills) //skip bill if desired
				continue;

			int curVal = s.getValue();
			while(curVal <= value) //does our selected value fit in the remaining number?
			{
				counts[s.getValidId()]++; 
				value -= curVal; 
			}
		}
		
		return value; //remainder
	}
	
	public int populate(int value, MoneySet src, boolean allowBills)
	{
		return -1;
	}

	
}
