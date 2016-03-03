package de.oszimt.fos.fahrkartenautomat.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import de.oszimt.fos.fahrkartenautomat.controller.FahrkartenautomatDemo;
import de.oszimt.fos.fahrkartenautomat.controller.IFahrkartenautomat;
import de.oszimt.fos.fahrkartenautomat.view.event.CallbackID;
import de.oszimt.fos.fahrkartenautomat.view.event.EinwurfListener;
import de.oszimt.fos.fahrkartenautomat.view.event.TicketListener;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow extends Application implements ActionListener {

	IFahrkartenautomat automatDemo = new FahrkartenautomatDemo();

	ArrayList<IntButton> listButtons = new ArrayList<IntButton>();

	TextField tfEinwurf  = new TextField();
	TextField tfZuZahlen = new TextField();
	TextArea taAusgabe   = new TextArea();

	
	@Override
	public void actionPerformed(ActionEvent e) {
		CallbackID callback = CallbackID.values()[e.getID()];
		
		switch(callback)
		{
		case MSG_REC:
			break;
		case ERROR:
		
		default:
			break;
		
		}
		
	}

	@Override
	public void start(Stage primaryStage) {
		
		//-----------------RECHTE SEITE-----------
		// Lade Logo
        Image imgLogo = new Image(MainWindow.class.getClassLoader().getResourceAsStream("bvglogo.png"));
        ImageView ivLogo = new ImageView();        
        ivLogo.setImage(imgLogo);
       
        //Einwurf Textfield + Label
    	Label lbEinwurf = new Label("Geldeinwurf:");
        tfEinwurf.setPadding(new Insets(5));
        tfEinwurf.setPrefWidth(imgLogo.getWidth());
		tfEinwurf.setStyle("-fx-background-color:black;-fx-text-fill:white;-fx-font-weight:bold");
		tfEinwurf.setOnAction(new EinwurfListener(automatDemo, tfZuZahlen, taAusgabe));
		
		// !!--Rechte Seite container--!!
		VBox vbRight = new VBox(10);
		vbRight.setAlignment(Pos.TOP_CENTER);
		vbRight.setPadding(new Insets(10));
		vbRight.getChildren().addAll(ivLogo, lbEinwurf, tfEinwurf);

		//-----------------MITTE----------------
		// Ticket Buttons		
		TilePane pnButtons = new TilePane();
		pnButtons.setPadding(new Insets(10));
		pnButtons.setHgap(20);
		pnButtons.setVgap(20);
		pnButtons.setPrefColumns(2);
		pnButtons.setAlignment(Pos.TOP_CENTER);
		for (int i = 0; i < 10; i++) {
			IntButton btnTicket = new IntButton(i, automatDemo.getTicketName(i));
			//TicketListener ändert Textfields zuzahlen und ausgabe
			btnTicket.setOnAction(new TicketListener(automatDemo, tfZuZahlen, taAusgabe)); 
			pnButtons.getChildren().add(btnTicket);
		}

		// Einwurf
		HBox pnZuZahlen = new HBox(10);
		tfZuZahlen.setPadding(new Insets(5));
		tfZuZahlen.setPrefWidth(70);
		pnZuZahlen.setAlignment(Pos.CENTER_RIGHT);
		Label lbZahlbetrag = new Label("Zu zahlen:");
		lbZahlbetrag.setPadding(new Insets(5));
		pnZuZahlen.getChildren().addAll(lbZahlbetrag, tfZuZahlen);
		
		taAusgabe.setPrefSize(380, 100);
		taAusgabe.setEditable(false);
		ScrollPane scAusgabe = new ScrollPane(taAusgabe);	
		
		// !!--Mittel Container--!!
		VBox vbCenter = new VBox(5);
		vbCenter.getChildren().addAll(pnButtons, pnZuZahlen, scAusgabe);

		// füge container borderpane hinzu
		BorderPane pnlMain = new BorderPane();
		pnlMain.setPadding(new Insets(5));
		pnlMain.setRight(vbRight);
		pnlMain.setCenter(vbCenter);

		// Lade Scene und Stage
		Scene myScene = new Scene(pnlMain);
		// primaryStage.setHeight(400);
		// primaryStage.setWidth(500);
		primaryStage.setTitle("Fahrkartenautomat");
		primaryStage.setScene(myScene);
		primaryStage.sizeToScene();
		primaryStage.show();
		
		GeldBörse gb = new GeldBörse();
		gb.show();
		
		PINEingabe pin = new PINEingabe();
		pin.show();
	}

	public static void main(String argv[]) {
		// TODO Auto-generated method stub
		launch(argv);
	}



}

