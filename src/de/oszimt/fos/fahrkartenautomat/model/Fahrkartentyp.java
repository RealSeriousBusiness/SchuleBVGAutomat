package de.oszimt.fos.fahrkartenautomat.model;


/**
 * @author name
 * Struktur um Informationen zu Fahrkarten zu speichern
 */
public class Fahrkartentyp {
	public final static Fahrkartentyp[] tickets;
	private String name;
	private int price;
	private int fourway;
	private String description;
	private int validFor;
	private int id;
	static private int lastId = 0;
	
	public Fahrkartentyp(String name, int price, int fourway)
	{
		this(name, price, fourway, "", 0);
	}
	
	public Fahrkartentyp(String name, int price, int fourway, String description, int validFor)
	{
		id = lastId++;
		this.name = name;
		this.price = price;
		this.fourway = fourway;
		this.description = description;
		this.validFor = validFor;
	}
	
	//Generiert Fahrkarten
	static
	{
		tickets = new Fahrkartentyp[]{
				new Fahrkartentyp("Einzelfahrschein AB", 270, 900),
				new Fahrkartentyp("Einzelfahrschein BC", 300, -1),
				new Fahrkartentyp("Einzelfahrschein ABC ", 330, -1),
				new Fahrkartentyp("Einzel erm‰ﬂigt AB", 170, 560),
				new Fahrkartentyp("Einzel erm‰ﬂigt BC", 210, -1),
				new Fahrkartentyp("Einzel erm‰ﬂigt ABC", 240, -1),
				new Fahrkartentyp("Kurzstrecke", 170, 560),
				new Fahrkartentyp("Kurzstrecke erm‰ﬂigt", 130, 440)
		};
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public double getPriceDecimal(){
		return (double)price / 100.0;
	}
	
	public int getFourway() {
		return fourway;
	}
	
	public double getFourwayDecimal() {
		return (double)fourway / 100.0;
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
