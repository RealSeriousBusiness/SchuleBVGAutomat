package de.oszimt.fos.fahrkartenautomat.controller;

public class FahrkartenautomatDemo implements IFahrkartenautomat {
	
	private int ticketCount;
	private int muenzenCounter;

	public FahrkartenautomatDemo() {
		//this.muenzenCounter = 10;
		this.ticketCount = 9;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.oszimt.fos.fahrkartenautomat.IFahrkartenautomat#ruecksetzen()
	 */
	@Override
	public void ruecksetzen() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.oszimt.fos.fahrkartenautomat.IFahrkartenautomat#getTicketName(int)
	 */
	@Override
	public String getTicketName(int nr) {
		return "Demo-Ticket " + (nr + 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.oszimt.fos.fahrkartenautomat.IFahrkartenautomat#einzahlen(java.lang
	 * .String)
	 */
	@Override
	public String einzahlen(String s) {
		return "EINGABE ERHALTEN: " + s;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.oszimt.fos.fahrkartenautomat.IFahrkartenautomat#ticketWaehlen(int)
	 */
	@Override
	public String ticketWaehlen(int t) {		
		return String.format("%.2f €", (t + 1) * 1.0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.oszimt.fos.fahrkartenautomat.IFahrkartenautomat#ticketsBezahlt()
	 */
	@Override
	public boolean ticketsBezahlt() {
			return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.oszimt.fos.fahrkartenautomat.IFahrkartenautomat#muenzeAusgeben()
	 */
	@Override
	public String muenzeAusgeben() {
		if (muenzenCounter > 0)
		{
			this.muenzenCounter--;
			return "Demo-Münze";
		}
		else
		{
			this.muenzenCounter = 1 + (int) (Math.random() * 4.0);
			return "";
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.oszimt.fos.fahrkartenautomat.IFahrkartenautomat#getTicketCount()
	 */
	@Override
	public int getTicketCount() {
		// Demo-Tickets: 0 - 10  Stück
		return ticketCount;
	}
}
