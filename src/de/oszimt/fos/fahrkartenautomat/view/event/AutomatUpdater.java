package de.oszimt.fos.fahrkartenautomat.view.event;

import de.oszimt.fos.fahrkartenautomat.model.Ausgaben;

public interface AutomatUpdater {
	public void handle(Ausgaben type, Object payload);
}
