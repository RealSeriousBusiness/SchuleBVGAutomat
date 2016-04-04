package de.oszimt.fos.fahrkartenautomat.model;

public class Geld {
	public final static Geld[] validMonies;
	public final static Geld[] invalidMonies;
	private int value = 0; //int is used because double becomes imprecise if used in calculations
	private boolean isBill = false;
	private int totalId; //total id in array which combines valid and invalid
	private int validId;
	
	private static int totalCount = 0;
	private static int validCount = 0;
	

	static
	{
		Geld[] themMonies = new Geld[]{
				new Geld(1, false, false),
				new Geld(2, false, false),
				new Geld(5, true, false),
				new Geld(10, true, false),
				new Geld(20, true, false),
				new Geld(50, true, false),
				new Geld(100, true, false),
				new Geld(200, true, false),
				new Geld(500, true, true),
				new Geld(1000, true, true),
				new Geld(2000, true, true),
				new Geld(5000, false, true),
				new Geld(10000, false, true),
				new Geld(20000, false, true),
				new Geld(50000, false, true) //15
		};
		
		validMonies = new Geld[validCount];
		invalidMonies = new Geld[totalCount - validCount];
		int unvalidPos = 0;
		
		for(int i = 0; i < totalCount; i++)
		{
			Geld selected = themMonies[i];
			if(selected.validId > -1)
				validMonies[selected.validId] = selected;
			else
				invalidMonies[unvalidPos++] = selected;
		}
		
	}
	
	private Geld(int value, boolean isUseable, boolean isBill) {
		this.totalId = totalCount++;
		this.validId = isUseable ? validCount++ : -1;
		this.value = value;
		this.isBill = isBill;
	}
	
	public static Geld[] getAllMonies() //combines all monies in one array
	{
		Geld[] g = new Geld[totalCount];
		for(int i = 0; i < validMonies.length; i++)
			g[validMonies[i].getTotalId()] = validMonies[i];
		for(int j = 0; j < invalidMonies.length; j++)
			g[invalidMonies[j].getTotalId()] = invalidMonies[j];
		return g;
	}
	
	public static int toInt(double value)
	{
		return (int)(value * 100);
	}
	
	public static double toDecimal(int value)
	{
		return (double)value / 100.0;
	}
	
	public static Geld getObject(int value)
	{
		Geld[] g = getAllMonies();
		for(int i = 0; i < g.length; i++)
			if(g[i].getValue() == value)
				return g[i];
		return null;
	}

	public int getValue() {
		return value;
	}
	
	public double getValueDecimal(){
		return (double)value / 100.0;
	}

	public boolean isBill() {
		return isBill;
	}

	public int getTotalId() {
		return totalId;
	}

	public int getValidId() {
		return validId;
	}
	
	public boolean isValid()
	{
		return validId > -1;
	}

	public static int getTotalCount() {
		return totalCount;
	}

	public static int getValidCount() {
		return validCount;
	}

}
