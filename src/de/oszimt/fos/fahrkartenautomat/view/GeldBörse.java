package de.oszimt.fos.fahrkartenautomat.view;

import java.awt.Dimension;

import de.oszimt.fos.fahrkartenautomat.model.Geld;
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

		Label scheineLab = new Label("Scheine");
		FlowPane scheine = new FlowPane ();
		scheine.setPadding(new Insets(10));
		scheine.setVgap(15);
		scheine.setHgap(15);

		main.getChildren().addAll(muenzenLab, muenzen, scheineLab, scheine);
		
		
		//----------collect all money types and sort them accordingly
		Geld[] valid = Geld.validMonies;
		Geld[] invalid = Geld.unvalidMonies;
		Geld[] allMonies = new Geld[Geld.getTotalCount()];
		
		int validPos = 0;
		int invalidPos = 0;
		for(int i = 0; i < allMonies.length; i++)
		{
			Geld va = valid[validPos];
			Geld in = invalid[invalidPos];
			
			if(va.getTotalId() < in.getTotalId())
			{
				allMonies[i] = valid[validPos];
				if(validPos < valid.length)
					validPos++;
			}
			else
			{
				allMonies[i] = invalid[invalidPos];
				if(invalidPos < invalid.length)
					invalidPos++;
			}
		}
		
		//end: collect money types
		
		
		
		for(int i = 0; i < 8; i++)
		{
			DataButton<Geld> btn = new DataButton<Geld>("0", new Dimension(40, 30));
			muenzen.getChildren().add(btn);
		}
		
		for(int i = 0; i < 7; i++)
		{
			DataButton<Geld> btn = new DataButton<Geld>("0", new Dimension(40, 30));
			scheine.getChildren().add(btn);
		}
		
		
		this.setTitle("Geldbörse");
		this.setScene(new Scene(main));
		this.setWidth(212);
		//this.sizeToScene();
	}
}
