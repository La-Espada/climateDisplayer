package test;

import java.io.*;
import java.time.LocalDate;

import daten.*;

public class test {

	public static void main(String[] args) {
	File f = new File("output.txt");
	File f1 = new File("input.txt");
	Messwert m = new Messwert(LocalDate.of(2002, 3, 30),-90,1);
	Messwert m1 = new Messwert(LocalDate.of(2001, 3, 30),-90,1);
//	m.setDatum(LocalDate.now().plusWeeks(1));
//	System.out.println(m.toString());
	Wetterdaten wd = new Wetterdaten();
	ZAMG z = new ZAMG();
    wd.add(m);
    wd.add(m1);
//    wd.ausgeben();
//    wd.del(m);
//    System.out.println("");
//    wd.ausgeben();
//    wd.del(2002);
//    System.out.println("");
    wd.ausgeben();
    
    wd.save(f1);
    wd.read(f);
    System.out.println("");
    wd.ausgeben();
    System.out.println();
    z.addWetterDaten("Wien", wd);
    z.ausgeben();
    System.out.println();
    z.addWetterDaten("Salzburg", f);
    z.ausgeben();
    z.save("Wien", f1);
    z.loeschen(2002);
    z.ausgeben();
	}

}
