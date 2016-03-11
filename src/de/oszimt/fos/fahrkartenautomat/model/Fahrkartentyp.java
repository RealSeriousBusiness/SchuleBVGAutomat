package de.oszimt.fos.fahrkartenautomat.model;


/**
 * @author name
 * Struktur um Informationen zu Fahrkarten zu speichern
 */
public class Fahrkartentyp {
	public final static Fahrkartentyp[] tickets;
	private String name;
	private double price;
	private double fourway;
	private String description;
	private double validFor;
	private int id;
	static private int lastId = 0;
	
	public Fahrkartentyp(String name, double price, double fourway)
	{
		this(name, price, fourway, "", 0.0);
	}
	
	public Fahrkartentyp(String name, double price, double fourway, String description, double validFore)
	{
		id = lastId++;
		this.name = name;
		this.price = price;
		this.fourway = fourway;
		this.description = description;
		this.validFor = validFore;
	}
	
	//Generiert Fahrkarten
	static
	{
		tickets = new Fahrkartentyp[]{
				new Fahrkartentyp("Einzelfahrschein AB", 2.70, 9.00),
				new Fahrkartentyp("Einzelfahrschein BC", 3.00, -1),
				new Fahrkartentyp("Einzelfahrschein ABC ", 3.30, -1),
				new Fahrkartentyp("Einzel erm‰ﬂigt AB", 1.70, 5.60),
				new Fahrkartentyp("Einzel erm‰ﬂigt BC", 2.10, -1),
				new Fahrkartentyp("Einzel erm‰ﬂigt ABC", 2.40, -1),
				new Fahrkartentyp("Kurzstrecke", 1.70, 5.60),
				new Fahrkartentyp("Kurzstrecke erm‰ﬂigt", 1.30, 4.40)
		};
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getFourway() {
		return fourway;
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
