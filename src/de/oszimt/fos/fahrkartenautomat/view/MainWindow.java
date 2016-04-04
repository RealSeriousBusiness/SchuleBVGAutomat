package de.oszimt.fos.fahrkartenautomat.view;

import java.awt.Dimension;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import de.oszimt.fos.fahrkartenautomat.controller.AuftragsController;
import de.oszimt.fos.fahrkartenautomat.controller.GeräteController;
import de.oszimt.fos.fahrkartenautomat.model.Ausgaben;
import de.oszimt.fos.fahrkartenautomat.model.Fahrkartentyp;
import de.oszimt.fos.fahrkartenautomat.view.event.AutomatUpdater;
import de.oszimt.fos.fahrkartenautomat.view.event.MainWindowActions;


/**
 * @author name
 * Hauptfenster
 */
public class MainWindow extends Application implements AutomatUpdater {

	AuftragsController auftrag;
	MainWindowActions evts;

	ArrayList<DataButton<Fahrkartentyp>> listButtons;
	int lastSelected = -1;
	TextField tfPaid  = new TextField();
	TextField tfToPay = new TextField();
	TextFlow output = new TextFlow();
	

	public MainWindow() {
		GeräteController geraet = new GeräteController(this);
		auftrag = new AuftragsController(geraet);
		evts = new MainWindowActions();
		listButtons = new ArrayList<DataButton<Fahrkartentyp>>();
	}
	
	@Override
	public void handle(Ausgaben type, Object payload) {
		switch (type) {
		case SELECT_UPDATE:
			System.out.println("WTF DONT CALL ME YOU SON OF A BITCH" + payload);
			if(!(payload instanceof Integer))
				return;
			if(lastSelected > -1)
				listButtons.get(lastSelected).setStyle("-fx-background-color:orange");
			
			lastSelected = (int)payload;
			
			if(lastSelected > -1)
				listButtons.get(lastSelected).setStyle("-fx-background-color:darkorange");
			break;
		
		case PAID_UPDATE:
			tfPaid.setText((String)payload);
			break;
			
		case TOPAY_UPDATE:
			tfToPay.setText((String)payload);
			break;
	
		case NORMAL_TEXT:
			Text t = new Text((String)payload);
			output.getChildren().add(t);
			break;
		case RED_TEXT:
			Text t2 = new Text((String)payload);
			t2.setFill(Color.RED);
			output.getChildren().add(t2);
			break;
		case OUT_OF_ORDER:
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
    	
        tfPaid.setPadding(new Insets(5));
        tfPaid.setPrefWidth(imgLogo.getWidth());
		tfPaid.setStyle("-fx-background-color:black;-fx-text-fill:white;-fx-font-weight:bold");
		tfPaid.setEditable(false);
		tfPaid.setText("0,00 €");
		
		//tfEinwurf.setOnAction(new EinwurfListener(automatDemo, tfZuZahlen, taAusgabe));
		
		DataButton<Integer> cancel = new DataButton<Integer>("Abbrechen", new Dimension(100, 35));
		cancel.setAlignment(Pos.CENTER);
		cancel.setOnAction(evts.getButtonCancel());
		
		// !!--Rechte Seite container--!!
		VBox vbRight = new VBox(10);
		vbRight.setAlignment(Pos.TOP_CENTER);
		vbRight.setPadding(new Insets(10));
		vbRight.getChildren().addAll(ivLogo, lbEinwurf, tfPaid, cancel);

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
			(ticket.getName() + '\n' + ticket.getPriceDecimal() + '€', new Dimension(170, 50), ticket);
			listButtons.add(btnTicket);
			btnTicket.setAlignment(Pos.CENTER_LEFT);
			btnTicket.setOnAction(evts.getSelectTicket());
			//TicketListener ändert Textfields zuzahlen und ausgabe
			pnButtons.getChildren().add(btnTicket);
		}

		HBox pnZuZahlen = new HBox(10);
		tfToPay.setPadding(new Insets(5));
		tfToPay.setPrefWidth(70);
		tfToPay.setEditable(false);
		tfToPay.setText("0,00 €");
		pnZuZahlen.setAlignment(Pos.CENTER_RIGHT);
		Label lbZahlbetrag = new Label("Zu zahlen:");
		lbZahlbetrag.setPadding(new Insets(5));
		pnZuZahlen.getChildren().addAll(lbZahlbetrag, tfToPay);
		
		HBox pnAnzahl = new HBox(10);
		Spinner<Integer> ticketCounter = new Spinner<Integer>(1, 100, 1); //min, max, initValue
		

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
		scAusgabe = new ScrollPane(output);
		scAusgabe.setStyle("-fx-background: white;");
		scAusgabe.setPrefSize(380, 100);
		

		// !!--Mittel Container--!!
		VBox vbCenter = new VBox(5);
		vbCenter.getChildren().addAll(pnButtons, bottom, scAusgabe);

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

		//showSideWindow(new PINEingabe(), primaryStage);
		showSideWindow(new GeldBörse(), primaryStage);
	}
	
	private void showSideWindow(Stage window, Stage src)
	{
		window.setX(src.getX() + src.getWidth());
		window.setY(src.getY());
		window.setHeight(src.getHeight());
		window.setResizable(false);
		window.show();
	}

	public static void main(String argv[]) {
		// TODO Auto-generated method stub
		System.out.println("well hello...");
		launch(argv);
		
	}





}

