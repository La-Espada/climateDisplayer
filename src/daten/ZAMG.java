package daten;

import java.io.*;
import java.util.*;

public class ZAMG {
	

	HashMap<String,Wetterdaten> ortsWetter = new HashMap<>();
	
	public List<Messwert> addWetterDaten(String ort,Wetterdaten w) {
		List<Messwert> we = null;
		
		if(!ortsWetter.containsKey(ort)) {
		ortsWetter.put(ort, w);
		}
		else if(ortsWetter.containsKey(ort)) {
			if(ortsWetter.get(ort) == null){
				ortsWetter.replace(ort, w);
			}
			else if(ortsWetter.get(ort) != null) {
				we = ortsWetter.get(ort).getWetterdaten();
				ortsWetter.replace(ort, w);
			}
		}
		return we;
	}
	
	public void addWetterDaten(String ort, File f) {
		Wetterdaten w = new Wetterdaten();
		w.read(f);
		addWetterDaten(ort,w);
		
	}
	
	public void erweiterteWetter(String ort, Messwert m) throws Exception {
		if(ortsWetter.containsKey(ort)) {
			ortsWetter.get(ort).add(m);
		}
		else {
			throw new Exception("Dieser Ort existiert nicht!!");
		}
	}
	
	public void loeschen(int jahr) {
		Set<String> it = ortsWetter.keySet();
		for(String s : it) {
			ortsWetter.get(s).del(jahr);
		}
	}
	public void save(String ort, File f) {
		try(PrintStream ps = new PrintStream(new FileOutputStream(f,false))){
				ps.println(ort + ortsWetter.get(ort));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ausgeben() {
		Set<String> keys =ortsWetter.keySet();
		for(String s : keys) {
			System.out.println(s + ortsWetter.get(s));
		}
	}
	
}
