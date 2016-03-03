package de.oszimt.fos.fahrkartenautomat.model;

public class Fahrkartentyp {
	public static Fahrkartentyp[] tickets;
	private String name;
	private double price;
	private String description;
	private double validFor;
	private int id;
	
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
