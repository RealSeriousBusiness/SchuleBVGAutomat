package de.oszimt.fos.fahrkartenautomat.view;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class IntButton extends Button {

	private int ticketId;

	public IntButton(int ticketId, String label) {
		super();
		this.ticketId = ticketId;
		this.setText(label);
		this.setStyle("-fx-background-color:orange");
		this.setFont(Font.font(null, FontWeight.BOLD, 14));
		this.setPrefSize(140, 30);
		this.setMaxSize(170, 30);
	}

	public int getTicketId() {
		return ticketId;
	}

}

