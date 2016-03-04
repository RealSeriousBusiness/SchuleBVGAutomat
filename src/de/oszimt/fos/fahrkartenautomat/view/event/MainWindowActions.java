package de.oszimt.fos.fahrkartenautomat.view.event;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


/**
 * @author name
 * EventHandler für das Haupt-Fenster
 */
public class MainWindowActions {

	EventHandler<ActionEvent> selectTicket = new EventHandler<ActionEvent>() {

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
	
	ChangeListener<Integer> spinnerCount = new ChangeListener<Integer>() {

		@Override
		public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
			System.out.println("changed.");
			
		}
	};
	
	EventHandler<ActionEvent> cashButton = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			
		}
	};

	public EventHandler<ActionEvent> getSelectTicket() {
		return selectTicket;
	}

	public EventHandler<ActionEvent> getButtonCancel() {
		return buttonCancel;
	}



	public ChangeListener<Integer> getSpinnerCount() {
		return spinnerCount;
	}

	public EventHandler<ActionEvent> getCashButton() {
		return cashButton;
	}
}
