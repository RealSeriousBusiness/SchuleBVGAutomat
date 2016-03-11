package de.oszimt.fos.fahrkartenautomat.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import de.oszimt.fos.fahrkartenautomat.controller.AuftragsController;
import de.oszimt.fos.fahrkartenautomat.controller.Ger�teController;
import de.oszimt.fos.fahrkartenautomat.model.Ausgaben;
import de.oszimt.fos.fahrkartenautomat.model.Fahrkartentyp;
import de.oszimt.fos.fahrkartenautomat.view.event.MainWindowActions;


/**
 * @author name
 * Hauptfenster
 */
public class MainWindow extends Application implements ActionListener {

	AuftragsController automat = null;
	ArrayList<DataButton<Fahrkartentyp>> listButtons = new ArrayList<DataButton<Fahrkartentyp>>();
	

	TextField tfEinwurf  = new TextField();
	TextField tfZuZahlen = new TextField();
	TextFlow output = new TextFlow();
	
	MainWindowActions evts = new MainWindowActions();

	public MainWindow() {
		Ger�teController geraet = new Ger�teController(0, 0, 9999, this);
		automat = new AuftragsController(geraet);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Ausgaben result = Ausgaben.values()[e.getID()];

		switch(result)
		{
		case OUT_OF_ORDER:
			break;
		case TICKET:
			break;
		case CHANGE:
			break;
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
    	Label lbEinwurf = new Label("Eingeworfenes Geld:");
        tfEinwurf.setPadding(new Insets(5));
        tfEinwurf.setPrefWidth(imgLogo.getWidth());
		tfEinwurf.setStyle("-fx-background-color:black;-fx-text-fill:white;-fx-font-weight:bold");
		tfEinwurf.setText("9999,00 �");
		//tfEinwurf.setOnAction(new EinwurfListener(automatDemo, tfZuZahlen, taAusgabe));
		
		DataButton<Integer> cancel = new DataButton<Integer>("Abbrechen", new Dimension(100, 30));
		
		// !!--Rechte Seite container--!!
		VBox vbRight = new VBox(10);
		vbRight.setAlignment(Pos.TOP_CENTER);
		vbRight.setPadding(new Insets(10));
		vbRight.getChildren().addAll(ivLogo, lbEinwurf, tfEinwurf, cancel);

		//-----------------MITTE----------------
		// Ticket Buttons		
		TilePane pnButtons = new TilePane();
		pnButtons.setPadding(new Insets(10));
		pnButtons.setHgap(20);
		pnButtons.setVgap(20);
		pnButtons.setPrefColumns(2);
		pnButtons.setAlignment(Pos.TOP_CENTER);
		for (int i = 0; i < Fahrkartentyp.tickets.length; i++) {
			Fahrkartentyp ticket = Fahrkartentyp.tickets[i];
			DataButton<Fahrkartentyp> btnTicket = new DataButton<Fahrkartentyp>
			(ticket.getName() + '\n' + ticket.getPrice() + '�', new Dimension(170, 50), ticket);
			btnTicket.setAlignment(Pos.CENTER_LEFT);
			btnTicket.setOnAction(evts.getSelectTicket());
			//TicketListener �ndert Textfields zuzahlen und ausgabe
			pnButtons.getChildren().add(btnTicket);
		}

		HBox pnZuZahlen = new HBox(10);
		tfZuZahlen.setPadding(new Insets(5));
		tfZuZahlen.setPrefWidth(70);
		pnZuZahlen.setAlignment(Pos.CENTER_RIGHT);
		Label lbZahlbetrag = new Label("Zu zahlen:");
		lbZahlbetrag.setPadding(new Insets(5));
		pnZuZahlen.getChildren().addAll(lbZahlbetrag, tfZuZahlen);
		
		HBox pnAnzahl = new HBox(10);
		Spinner<Integer> ticketCounter = new Spinner<Integer>(10, 100, 10);

		ticketCounter.valueProperty().addListener(evts.getSpinnerCount());
		ticketCounter.setPrefWidth(70);
		pnAnzahl.setAlignment(Pos.CENTER_LEFT);
		Label lbl = new Label("Anzahl");
		lbl.setPadding(new Insets(5));
		pnAnzahl.getChildren().addAll(lbl, ticketCounter);
		
		AnchorPane bottom = new AnchorPane(pnAnzahl, pnZuZahlen);
		AnchorPane.setLeftAnchor(pnAnzahl, 0.0);
		AnchorPane.setRightAnchor(pnZuZahlen, 0.0);

		
		output.setPadding(new Insets(0, 6, 0, 6));
		ScrollPane scAusgabe = new ScrollPane(output);
		scAusgabe.setStyle("-fx-background: white;");
		scAusgabe.setPrefSize(380, 100);
		

		// !!--Mittel Container--!!
		VBox vbCenter = new VBox(5);
		vbCenter.getChildren().addAll(pnButtons, bottom, scAusgabe);

		// f�ge container borderpane hinzu
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
		
		
		
		//showSideWindow(new PINEingabe(), primaryStage);
		showSideWindow(new GeldB�rse(), primaryStage);
	}
	
	private void showSideWindow(Stage window, Stage src)
	{
		window.setX(src.getX() + src.getWidth());
		window.setY(src.getY());
		window.setHeight(src.getHeight());
		window.show();
	}

	public static void main(String argv[]) {
		// TODO Auto-generated method stub
		System.out.println("well hello...");
		launch(argv);
		
	}



}

