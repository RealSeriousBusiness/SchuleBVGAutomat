package de.oszimt.fos.fahrkartenautomat.view.event;

import de.oszimt.fos.fahrkartenautomat.controller.AutomatController;
import de.oszimt.fos.fahrkartenautomat.view.IntButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


/**
 * @author name
 * EventHandler für das Geldbörse-Fenster
 */
public class GeldbörseActions {

	EventHandler<ActionEvent> buttonMoney = new EventHandler<ActionEvent>() {

		AutomatController automat = AutomatController.getSingleton();
		
		@Override
		public void handle(ActionEvent event) {
			
			Object src = event.getSource();
			if(src != IntButton.class)
				return;
			
			IntButton button = (IntButton)src;
			automat.insertCash(button.getIntValue());
			
			
		}
	};

	public EventHandler<ActionEvent> getButtonMoney() {
		return buttonMoney;
	}
	
	
}
