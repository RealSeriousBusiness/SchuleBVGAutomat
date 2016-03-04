package de.oszimt.fos.fahrkartenautomat.view;

import java.awt.Dimension;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


/**
 * @author name
 * Button, welcher einen int-Wert in sich speichert
 */
public class IntButton extends Button {

	private int id = -1;

	public IntButton(String label, String style, 
			FontWeight font, int fontSize, Dimension size, int id)
	{
		super();
		this.setText(label);
		this.setStyle(style);
		this.setFont(Font.font(null, FontWeight.BOLD, fontSize));
		this.setPrefSize(size.getWidth(), size.getHeight());
		this.id = id;
		
	}
	
	public IntButton(String label, String style, 
			FontWeight font, int fontSize, Dimension size)
	{
		this(label, style, font, fontSize, size, -1);
	}

	public IntButton(String label, Dimension size, int id)
	{
		this(label, "-fx-background-color:orange", 
				FontWeight.BOLD, 14, size);
		this.id = id;
	}
	
	public IntButton(String label, Dimension size)
	{
		this(label, size, -1);
	}
	
	/*
	 * 	
	 * this.id = ticketId;
		this.setText(label);
		this.setStyle("-fx-background-color:orange");
		this.setFont(Font.font(null, FontWeight.BOLD, 14));
		this.setPrefSize(140, 30);
	 */

	public int getIntValue() {
		return id;
	}

}

