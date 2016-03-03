package de.oszimt.fos.fahrkartenautomat.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PINEingabe extends Stage
{

	public PINEingabe()
	{
		VBox main = new VBox();
		
		Label toPay = new Label("Zu zahlen: ");
		TextField pinInput = new TextField();
		
		
		
		
		GridPane gp = new GridPane();
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 3; j++)
				gp.add(new Button("0"), j, i);
		
		
		main.getChildren().addAll(toPay, pinInput, gp, new Button("Bestätigen"));
		
		
		
		this.setTitle("Pin-Eingabe");
		this.setScene(new Scene(main));
		this.sizeToScene();
		
	}
}
