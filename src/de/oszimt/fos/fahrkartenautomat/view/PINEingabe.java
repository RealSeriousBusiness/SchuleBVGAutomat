package de.oszimt.fos.fahrkartenautomat.view;

import java.awt.Dimension;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * @author name
 * Erlaubt die Eingabe eines Pins
 */
public class PINEingabe extends Stage
{

	public PINEingabe()
	{
		VBox main = new VBox(10);
		main.setPadding(new Insets(10));
		
		Label toPay = new Label("Zu zahlen: ");
		TextField pinInput = new TextField();
		
		GridPane gp = new GridPane();
		gp.setHgap(20);
		gp.setVgap(20);
		gp.setPadding(new Insets(10));
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 3; j++)
			{
				int number = (i * 3) + j + 1;
				DataButton<Integer> btn = new DataButton<Integer>(String.valueOf(number), new Dimension(40, 30));
				gp.add(btn, j, i);
			}
				
		DataButton<Integer> submit = new DataButton<Integer>("Bestätigen", new Dimension(100, 30));
		
		main.getChildren().addAll(toPay, pinInput, gp, submit);
		
		
		
		this.setTitle("Pin-Eingabe");
		this.setScene(new Scene(main));
		//this.sizeToScene();
		
	}
}
