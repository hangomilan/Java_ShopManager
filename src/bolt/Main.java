package bolt;

import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Vector;

import bolt.aruk.Szappan;
import bolt.aruk.Tej;
import bolt.aruk.tej.TartosTej;

public class Main {

	public static void main(String[] args) {
		TartosTej tej1 = new TartosTej(321312332L, Tej.LITER, "tej gyarto", new GregorianCalendar(2018, 11, 11),
				Tej.ZSIROS);
		TartosTej tej2 = new TartosTej(321312332L, Tej.LITER, "tej gyarto", new GregorianCalendar(2018, 11, 11),
				Tej.FELZSIROS);
		Szappan szappan1 = new Szappan(321344121L, "szappan gyarto A", 'A');
		Szappan szappan2 = new Szappan(366644121L, "szappan gyarto B", 'B');

		System.out.println("Tej jó még?");
		System.out.println(tej1.joMeg());
		System.out.println("Zsírtartalma?");
		System.out.println(tej2.getZsirtartalom());
		System.out.println("Mosóhatása a szappannak?");
		System.out.println(szappan1.getMosohatas());
		System.out.println("A szappan vonalkódját kérlek.");
		System.out.println(szappan2.vonalKod);

		Hashtable<Long, Integer> aruk = new Hashtable<>();
		aruk.put(tej2.vonalKod, 10);
		aruk.put(szappan1.vonalKod, 15);
		aruk.put(szappan2.vonalKod, 20);

		Bolt bolt1 = new Bolt("Bolt 1", "Tulaj 1", "Utca 1", aruk, 1);
		System.out.println("Bolt tuljdonos?");
		System.out.println(bolt1.getTulajdonos());
		System.out.println("Áruról valami infó?");
		System.out.println(aruk);
		System.out.println("Bolt besorolása?");
		System.out.println(bolt1.getBesorolas());
		
		Bolt bolt2 = new Bolt("Bolt 2", "Tulaj 2", "Utca 2", aruk, 2);
		
		Vector<Object> boltok = new Vector<>();
		PlazaImpl plaza = new PlazaImpl(boltok);
		plaza.hozzaadShop(bolt1);
		plaza.hozzaadShop(bolt2);
		System.out.println("Nyitva van a pláza?");
		//plaza.nyit();
		System.out.println(plaza.isNyitva());
	}

}
