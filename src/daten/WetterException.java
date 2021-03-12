package daten;

public class WetterException extends RuntimeException {

	private Fehlertyp typ;

	public WetterException(String arg0, Fehlertyp typ ) {
		super(arg0);
		this.typ = typ;

	}
	
	
    public Fehlertyp getTyp() {
		return typ;
	}


	public void setTyp(Fehlertyp typ) {
		this.typ = typ;
	}


	public String Message() {
		return super.getMessage() + "------->" + typ;
	}
	
}
