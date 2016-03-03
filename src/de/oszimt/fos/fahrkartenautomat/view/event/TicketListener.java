package de.oszimt.fos.fahrkartenautomat.view.event;

import de.oszimt.fos.fahrkartenautomat.controller.IFahrkartenautomat;
import de.oszimt.fos.fahrkartenautomat.view.IntButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TicketListener implements EventHandler<ActionEvent> {

	private TextField tf;
	private TextArea ta;
	private IFahrkartenautomat fa;

	
	public TicketListener(IFahrkartenautomat fa, TextField tf, TextArea ta)
	{
		super();
		this.fa = fa;
		this.ta = ta;
		this.tf = tf;
	}
	
	@Override
	public void handle(ActionEvent event) {

		// Setze Ausgabe zurück?
		// taAusgabe.setText(null);
		// taAusgabe.setStyle("-fx-background-color: #cccccc;");			

		Object obj = event.getSource();

		// Teste auf Klasse
		if (obj.getClass() == IntButton.class)
		{
			int ticketId = ((IntButton) obj).getTicketId();
			ta.appendText(String.format("TICKET BESTELLT: [%d] %s%n",  ticketId, fa.getTicketName(ticketId)));
			tf.setText(fa.ticketWaehlen(ticketId));
		}
	}

}
