package de.oszimt.fos.fahrkartenautomat.view.event;

import de.oszimt.fos.fahrkartenautomat.controller.IFahrkartenautomat;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EinwurfListener implements EventHandler<ActionEvent>  {

	private TextField tf;
	private TextArea ta;
	private IFahrkartenautomat fa;

	public EinwurfListener(IFahrkartenautomat fa, TextField tf, TextArea ta)
	{
		super();
		this.fa = fa;
		this.ta = ta;
		this.tf = tf;
	}
	
	@Override
	public void handle(ActionEvent event) {
		TextField tfSource = (TextField) event.getSource();
		// TODO Auto-generated method stub
		
		String nachricht = fa.einzahlen(tfSource.getText());
		
		ta.appendText(nachricht + '\n');

		tfSource.setText("");
		if (fa.ticketsBezahlt()) {
			ta.setStyle("-fx-background-color: #c0f0c0;");
			String s = fa.muenzeAusgeben();
			while (s.length() > 0) {
				ta.appendText("Rückgabe: " + s + '\n');
				s = fa.muenzeAusgeben();
			}
			fa.ruecksetzen();
			tf.setText("0,00 â‚¬");
		}
	}
}
