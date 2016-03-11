package de.oszimt.fos.fahrkartenautomat.view.event;

import de.oszimt.fos.fahrkartenautomat.controller.AuftragsController;
import de.oszimt.fos.fahrkartenautomat.model.Geld;
import de.oszimt.fos.fahrkartenautomat.view.DataButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


/**
 * @author name
 * EventHandler f�r das Geldb�rse-Fenster
 */
public class Geldb�rseActions {

	EventHandler<ActionEvent> buttonMoney = new EventHandler<ActionEvent>() {

		AuftragsController automat = AuftragsController.getSingleton();
		
		@Override
		public void handle(ActionEvent event) {
			
			Object src = event.getSource();
			if(src != DataButton.class)
				return;
			
			DataButton<Geld> button = (DataButton<Geld>)src;
			automat.insertCash(button.getDataField());

		}
	};

	public EventHandler<ActionEvent> getButtonMoney() {
		return buttonMoney;
	}
	
	
}
