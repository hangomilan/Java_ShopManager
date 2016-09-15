package bolt;

import java.util.GregorianCalendar;
import java.util.Hashtable;

import bolt.aruk.Szappan;
import bolt.aruk.Tej;
import bolt.aruk.tej.TartosTej;
import bolt.kivetel.ZarvaKivetel;

public class Main {

	public static void main(String[] args) 
	{
		TartosTej tej1 = new TartosTej(321312332L, Tej.LITER, "tej gyarto", new GregorianCalendar(2018,11,11), Tej.ZSIROS);
		TartosTej tej2 = new TartosTej(321312332L, Tej.LITER, "tej gyarto", new GregorianCalendar(2018,11,11), Tej.FELZSIROS);
		Szappan szappan1 = new Szappan(321344121L, "szappan gyarto A", 'A');
		Szappan szappan2 = new Szappan(366644121L, "szappan gyarto B", 'B');

		System.out.println(tej1.joMeg());
		System.out.println(tej2.getUrtartalom());
		System.out.println(szappan1.getMosohatas());
		System.out.println(szappan2.vonalKod);
		
		Hashtable<Long, Integer> aruk = new Hashtable<>();
		aruk.put(tej1.vonalKod, 5);
		aruk.put(tej2.vonalKod, 10);
		aruk.put(szappan1.vonalKod, 15);
		aruk.put(szappan2.vonalKod, 20);
		
		Bolt bolt = new Bolt("Bolt 1", "Tulaj 1", "Utca 1", aruk, 1);
		try {
			System.out.println(bolt.aruk());
		} catch (ZarvaKivetel e) {
			e.printStackTrace();
		}
	}

}
