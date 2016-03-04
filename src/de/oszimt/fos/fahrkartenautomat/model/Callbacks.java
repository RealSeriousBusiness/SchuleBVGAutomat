package de.oszimt.fos.fahrkartenautomat.model;

public enum Callbacks {
	ERROR(0), MSG_REC(1);
	
	private final int value;
	
    private Callbacks(int value) {
        this.value = value;
    }

    public int id() {
        return value;
    }
}
