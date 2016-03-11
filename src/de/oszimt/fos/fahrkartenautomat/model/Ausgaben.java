package de.oszimt.fos.fahrkartenautomat.model;

public enum Ausgaben {
	OUT_OF_ORDER(0), ORDER_UPDATE(1), TICKET(2), CHANGE(3);
	
	private final int value;
	
    private Ausgaben(int value) {
        this.value = value;
    }

    public int id() {
        return value;
    }
}
