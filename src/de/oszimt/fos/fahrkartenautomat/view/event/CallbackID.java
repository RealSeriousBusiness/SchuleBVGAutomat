package de.oszimt.fos.fahrkartenautomat.view.event;

public enum CallbackID {
	
	ERROR(0), MSG_REC(1);
	
	private final int value;
	
    private CallbackID(int value) {
        this.value = value;
    }

    public int id() {
        return value;
    }
}
