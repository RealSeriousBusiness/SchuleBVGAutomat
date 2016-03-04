package de.oszimt.fos.fahrkartenautomat.view;

import java.awt.Dimension;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * @author Alex
 * Erlaubt Einwurf von Geld in die Machine
 */
public class GeldBörse extends Stage {
	
	public GeldBörse()
	{
		VBox main = new VBox(10);
		main.setPadding(new Insets(10));
		
		Label muenzenLab = new Label("Münzen");
		FlowPane muenzen = new FlowPane ();
		muenzen.setPadding(new Insets(10));
		muenzen.setVgap(15);
		muenzen.setHgap(15);
		
		for(int i = 0; i < 8; i++)
		{
			IntButton btn = new IntButton("0", new Dimension(40, 30));
			muenzen.getChildren().add(btn);
		}
			
		
		Label scheineLab = new Label("Scheine");
		FlowPane scheine = new FlowPane ();
		scheine.setPadding(new Insets(10));
		scheine.setVgap(15);
		scheine.setHgap(15);
		for(int i = 0; i < 7; i++)
		{
			IntButton btn = new IntButton("0", new Dimension(40, 30));
			scheine.getChildren().add(btn);
		}
			

		main.getChildren().addAll(muenzenLab, muenzen, scheineLab, scheine);
		
		
		this.setTitle("Geldbörse");
		this.setScene(new Scene(main));
		this.setWidth(230);
		//this.sizeToScene();
	}
}
