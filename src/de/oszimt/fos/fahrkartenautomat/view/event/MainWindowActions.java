package de.oszimt.fos.fahrkartenautomat.view.event;


import de.oszimt.fos.fahrkartenautomat.controller.AuftragsController;
import de.oszimt.fos.fahrkartenautomat.model.Fahrkartentyp;
import de.oszimt.fos.fahrkartenautomat.view.DataButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Spinner;


/**
 * @author name
 * EventHandler f�r das Haupt-Fenster
 */
public class MainWindowActions {

	AuftragsController auftrag = AuftragsController.getSingleton();

	EventHandler<ActionEvent> selectTicket = new EventHandler<ActionEvent>() {

		@SuppressWarnings("unchecked")
		@Override
		public void handle(ActionEvent event) {
			Object src = event.getSource();
			if(!(src instanceof DataButton))
				return;
			
			DataButton<Fahrkartentyp> tBtn = (DataButton<Fahrkartentyp>)src;
			Fahrkartentyp ticket = tBtn.getDataField();
			auftrag.selectTicket(ticket);
		}
	};

	EventHandler<ActionEvent> buttonCancel = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			auftrag.reset();
		}
	};
	
	ChangeListener<Integer> spinnerCount = new ChangeListener<Integer>() {

		@Override
		public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
			auftrag.setTicketCount(newValue);
		}
	};
	
//	EventHandler<ActionEvent> cashButton = new EventHandler<ActionEvent>() {
//
//		@Override
//		public void handle(ActionEvent event) {
//			// TODO Auto-generated method stub
//			
//		}
//	};

	public EventHandler<ActionEvent> getSelectTicket() {
		return selectTicket;
	}

	public EventHandler<ActionEvent> getButtonCancel() {
		return buttonCancel;
	}

	public ChangeListener<Integer> getSpinnerCount() {
		return spinnerCount;
	}

//	public EventHandler<ActionEvent> getCashButton() {
//		return cashButton;
//	}
}
