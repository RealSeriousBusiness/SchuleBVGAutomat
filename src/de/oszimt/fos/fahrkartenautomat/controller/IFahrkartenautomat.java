package de.oszimt.fos.fahrkartenautomat.controller;

/**
 * @author Tenbusch, Schleyer
 * @version 1.1
 *
 */
public interface IFahrkartenautomat {

	/**
	 * Zurücksetzen des gesamten Ticketautomaten
	 */
	void ruecksetzen();

	/**
	 * Gibt den Namen des entsprechenden Tickets aus
	 * 
	 * @param nr
	 *            Nummer des Tickets (beginnend von 1)
	 * @return Name des Tickets
	 */
	String getTicketName(int nr);

	/**
	 * Gibt die Gesamtzahl der verkauften Tickets aus
	 * 
	 * @return Anzahl der Tickets
	 */
	int getTicketCount();

	/**
	 * Zahlt einen Betrag in den Automaten ein
	 * 
	 * @param s
	 *            Einzuzahlender Betrag
	 * @return Anzuzeigende Daten (@see
	 *         de.oszimt.fos.fahrkartenautomat.AnzeigeDaten)
	 */
	String einzahlen(String s);

	/**
	 * Wählt ein Ticket aus und erhöht den entsprechenden Gesamtbetrag
	 * 
	 * @param t
	 *            Nummer des gewünschten Tickets
	 * 
	 * @return Zu zahlender Gesamtbetrag als formatierter String
	 */
	String ticketWaehlen(int t);

	/**
	 * Kontrolliert, ob alle Tickets bezahlt wurden
	 * 
	 * @return wahr, wenn alle angeforderten Tickets bezahlt wurden
	 */
	boolean ticketsBezahlt();

	/**
	 * Gibt eine Münze des Rückgelds aus, beginnend mit der größtmöglichen.
	 * 
	 * @return Wert der Münze
	 */
	String muenzeAusgeben();

}