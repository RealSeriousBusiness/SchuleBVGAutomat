package de.oszimt.fos.fahrkartenautomat.model;


/**
 * @author name
 * Struktur um Informationen zu Fahrkarten zu speichern
 */
public class Fahrkartentyp {
	public static Fahrkartentyp[] tickets;
	private String name;
	private double price;
	private String description;
	private double validFor;
	private int id;
	
	public Fahrkartentyp(String name, double price, 
			String description, double validFore)
	{
		
	}
	
	//Generiert Fahrkarten
	static
	{
		
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getValidFor() {
		return validFor;
	}
	
	public int getId() {
		return id;
	}
	
	
}
