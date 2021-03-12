package daten;

import java.time.*;
import java.time.format.DateTimeFormatter;


public class Messwert {
	
	private LocalDate datum;
	private int temperatur;
	private int windstaerke;
	
	public Messwert(LocalDate datum, int temperatur, int windstaerke) {
		super();
		setDatum(datum);
		setTemperatur(temperatur);
		setWindstaerke(windstaerke);
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		LocalDate plus1Woche = LocalDate.now().plusWeeks(1);
		if(datum.isAfter(plus1Woche)) {
			throw new WetterException("Das Datum darf nicht nicht mehr als eine Woche in der Zukunft liegen!!",Fehlertyp.DATUM);
		}
		this.datum = datum;
	}

	public int getTemperatur() {
		return temperatur;
	}

	public void setTemperatur(int temperatur) {
		if(temperatur > 65 || temperatur < -90) {
			throw new WetterException("Die Temperatur muss zwischen -90 und 65 sein!!",Fehlertyp.DATUM);
		}
		this.temperatur = temperatur;
	}

	public int getWindstaerke() {
		return windstaerke;
	}

	public void setWindstaerke(int windstaerke) {
		if(windstaerke < 0 || windstaerke >12) {
			throw new WetterException("Die Windstärke muss zwischen 0 und 12 sein",Fehlertyp.MESSDATEN);
		}
		this.windstaerke = windstaerke;
	}

	@Override
	public String toString() {
		DateTimeFormatter format =  DateTimeFormatter.ofPattern("dd.MM.yy");
		return   datum.format(format)+":"  + temperatur +":" + windstaerke  + "\n";
	}
	
	public static Messwert getMesswert(String s ) {
//		yyyy-MM-dd:temperatur:windstaerke 
		String[]part = s.split(":");
	    Messwert m = new Messwert(LocalDate.parse(part[0]),Integer.parseInt(part[1]),Integer.parseInt(part[2]));
	    
	    return m;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Messwert other = (Messwert) obj;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		return true;
	}
	
}
