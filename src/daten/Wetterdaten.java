package daten;

import java.io.*;
import java.util.*;

public class Wetterdaten {

	List<Messwert> wetterdaten = new ArrayList<>();

	public void add(Messwert m) {
		if (!wetterdaten.contains(m)) {
			wetterdaten.add(m);
		}
	}

	public void del(Messwert m) {
		wetterdaten.remove(m);
	}

	public void del(int jahr) {
		Iterator<Messwert> it = wetterdaten.iterator();
		while (it.hasNext()) {
			
			if (it.next().getDatum().getYear() == jahr) {
				it.remove();
			}
		}
	}
	
	public void save(File f) {
		try(PrintStream ps = new PrintStream(new FileOutputStream(f, false))){
			for(Messwert m : wetterdaten) {
				ps.println(m);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void read(File f) {
		try(BufferedReader br = new BufferedReader(new FileReader(f)) ){
		     String s;
		     while((s = br.readLine())!= null) {
		    	Messwert m = Messwert.getMesswert(s);
		    	if(!wetterdaten.contains(m)) {
		    	wetterdaten.add(m);
		    	}
		     }
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public List<Messwert> getWetterdaten() {
		return wetterdaten;
	}

	public void setWetterdaten(List<Messwert> wetterdaten) {
		this.wetterdaten = wetterdaten;
	}

	public void ausgeben() {
		for (Messwert m : wetterdaten) {
			System.out.println(m);
		}
	}

	@Override
	public String toString() {
		return " wetterdaten= \n"  + wetterdaten   ;
	}
	
	
}

