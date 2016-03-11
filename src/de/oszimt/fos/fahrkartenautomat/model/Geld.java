package de.oszimt.fos.fahrkartenautomat.model;

public class Geld {
	public final static Geld[] validMonies;
	public final static Geld[] unvalidMonies;
	private double value = 0.0;
	private boolean isBill = false;
	private int totalId;
	private int validId;
	
	private static int totalCount = 0;
	private static int validCount = 0;
	

	static
	{
		Geld[] themMonies = new Geld[]{
				new Geld(0.01, false, false),
				new Geld(0.02, false, false),
				new Geld(0.05, true, false),
				new Geld(0.10, true, false),
				new Geld(0.20, true, false),
				new Geld(0.50, true, false),
				new Geld(1.00, true, false),
				new Geld(2.00, true, false),
				new Geld(5.00, true, true),
				new Geld(10.00, true, true),
				new Geld(20.00, true, true),
				new Geld(50.00, false, true),
				new Geld(100.00, false, true),
				new Geld(200.00, false, true),
				new Geld(500.00, false, true)
		};
		
		validMonies = new Geld[validCount];
		unvalidMonies = new Geld[totalCount - validCount];
		int unvalidPos = 0;
		
		for(int i = 0; i < totalCount; i++)
		{
			Geld selected = themMonies[i];
			if(selected.validId > -1)
				validMonies[selected.validId] = selected;
			else
				unvalidMonies[unvalidPos++] = selected;
		}
		
	}
	
	private Geld(double value, boolean isUseable, boolean isBill) {
		this.totalId = totalCount++;
		this.validId = isUseable ? validCount++ : -1;
		this.value = value;
		this.isBill = isBill;
	}

	public double getValue() {
		return value;
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

	public static int getTotalCount() {
		return totalCount;
	}

	public static int getValidCount() {
		return validCount;
	}

}
