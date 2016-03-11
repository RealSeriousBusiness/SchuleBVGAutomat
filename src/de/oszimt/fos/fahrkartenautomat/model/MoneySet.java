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
	
	public void add(MoneySet geld){
		
	}
	
	public int getCount(Geld geld){
		return counts[geld.getValidId()];
	}
	
	public double getValue(){
		double value = 0.0;
		for (int id = 0; id < Geld.getValidCount(); id++)
			value += Geld.validMonies[id].getValue() * counts[id];
		return value;
	}
	
	public void setValue(double value){
		counts[0] = 10; //5 cent
		counts[5] = 10; //1 euro
		
	}
	
	public boolean setValue(double value, MoneySet pool){
		setValue(value);
		return false;
	}
	
}
