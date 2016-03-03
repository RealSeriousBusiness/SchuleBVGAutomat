package de.oszimt.fos.fahrkartenautomat.view;



import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GeldB�rse extends Stage {

	public GeldB�rse()
	{
		VBox main = new VBox();
		
		Label muenzenLab = new Label("M�nzen");
		FlowPane muenzen = new FlowPane ();
		
		for(int i = 0; i < 10; i++)
			muenzen.getChildren().add(new Button("0"));
		
		Label scheineLab = new Label("Scheine");
		FlowPane scheine = new FlowPane ();
		for(int i = 0; i < 10; i++)
			scheine.getChildren().add(new Button("0"));

		main.getChildren().addAll(muenzenLab, muenzen, scheineLab, scheine);
		
		
		

		
		this.setTitle("Geldb�rse");
		this.setScene(new Scene(main));
		this.sizeToScene();
	}
}
