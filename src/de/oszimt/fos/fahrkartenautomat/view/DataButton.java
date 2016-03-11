package de.oszimt.fos.fahrkartenautomat.view;

import java.awt.Dimension;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


/**
 * @author name
 * Button, welcher einen int-Wert in sich speichert
 */
public class DataButton<T> extends Button {

	private T data = null;

	public DataButton(String label, String style, 
			FontWeight font, int fontSize, Dimension size, T data)
	{
		super();
		this.setText(label);
		this.setStyle(style);
		this.setFont(Font.font(null, FontWeight.BOLD, fontSize));
		this.setPrefSize(size.getWidth(), size.getHeight());
		this.data = data;
		
	}
	
	public DataButton(String label, String style, 
			FontWeight font, int fontSize, Dimension size)
	{
		this(label, style, font, fontSize, size, null);
	}

	public DataButton(String label, Dimension size, T data)
	{
		this(label, "-fx-background-color:orange", 
				FontWeight.BOLD, 14, size);
		this.data = data;
	}
	
	public DataButton(String label, Dimension size)
	{
		this(label, size, null);
	}
	
	/*
	 * 	
	 * this.id = ticketId;
		this.setText(label);
		this.setStyle("-fx-background-color:orange");
		this.setFont(Font.font(null, FontWeight.BOLD, 14));
		this.setPrefSize(140, 30);
	 */

	public T getDataField() {
		return data;
	}

}

