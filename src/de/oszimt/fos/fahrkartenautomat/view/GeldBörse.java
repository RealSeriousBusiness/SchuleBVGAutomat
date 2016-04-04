package de.oszimt.fos.fahrkartenautomat.view;

import java.awt.Dimension;

import de.oszimt.fos.fahrkartenautomat.model.Geld;
import de.oszimt.fos.fahrkartenautomat.view.event.Geldb�rseActions;
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
public class GeldB�rse extends Stage {
	
	Geldb�rseActions evts = new Geldb�rseActions();
	public GeldB�rse()
	{

		VBox main = new VBox(10);
		main.setPadding(new Insets(10));
		
		Label muenzenLab = new Label("M�nzen");
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
		
		Geld[] monies = Geld.getAllMonies();
	
		for(int i = 0; i < monies.length; i++){
			Geld s = monies[i];
			DataButton<Geld> btn = 
					new DataButton<Geld>(s.getValueDecimal() + "�", new Dimension(70, 30), s);
			btn.setOnAction(evts.getButtonMoney());
		
			if(btn.getDataField().isBill())
				scheine.getChildren().add(btn);
			else
				muenzen.getChildren().add(btn);	
		}
		
		
		this.setTitle("Geldb�rse");
		this.setScene(new Scene(main));
		this.setWidth(300);
		//this.sizeToScene();
	}
}
