package de.oszimt.fos.fahrkartenautomat.view.event;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * @author name
 * EventHandler für das PINEingabe-Fenster
 */
public class PinEingabeActions {

	EventHandler<ActionEvent> buttonNumber = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			
		}
	};
	
	EventHandler<ActionEvent> buttonCancel = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			
		}
	};
	
	EventHandler<ActionEvent> buttonConfirm = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			
		}
	};

	public EventHandler<ActionEvent> getButtonNumber() {
		return buttonNumber;
	}

	public EventHandler<ActionEvent> getButtonCancel() {
		return buttonCancel;
	}

	public EventHandler<ActionEvent> getButtonConfirm() {
		return buttonConfirm;
	}
}
