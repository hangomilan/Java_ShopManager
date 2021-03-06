package tests;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Vector;

import org.junit.Test;

import bolt.Bolt;
import bolt.PlazaImpl;
import bolt.aruk.Sajt;
import bolt.aruk.Szappan;
import bolt.aruk.Tej;
import bolt.aruk.tej.TartosTej;

public class Tests {

	@Test
	public void zsirosTejJomeg() {
		Tej tej = new TartosTej(12345678910L, Tej.LITER, "tej gyarto", new GregorianCalendar(2017, 04, 11), Tej.ZSIROS);
		Boolean result = tej.joMeg();
		assertEquals(true, result);
	}

	@Test
	public void felzsirosTejJomeg() {
		Tej tej = new TartosTej(12345678910L, Tej.LITER, "tej gyarto", new GregorianCalendar(2017, 06, 21),
				Tej.FELZSIROS);
		Boolean result = tej.joMeg();
		assertEquals(true, result);
	}

	@Test
	public void sajtjJomeg() {
		Sajt sajt = new Sajt(12345678910L, 1000, "sajt gyarto", new GregorianCalendar(2017, 11, 11), true);
		Boolean result = sajt.joMeg();
		assertEquals(true, result);
	}

	@Test
	public void sajtNemNull() {
		Sajt sajt = new Sajt(23123123123L, 2500, "sajt gyarto", new GregorianCalendar(2016, 12, 12), false);
		assertNotNull(sajt);
	}

	@Test
	public void szappanNemNull() {
		Szappan szappan = new Szappan(9876543211L, "szappan gyarto", 'A');
		assertNotNull(szappan);
	}

	@Test
	public void hashtablaNem�res() {
		Hashtable<Long, Integer> arukHash = new Hashtable<>();
		assertTrue("Az �j hasht�bla nem �res!", arukHash.isEmpty());
	}

	@Test
	public void ujBoltLetrehozasNemNull() {
		Hashtable<Long, Integer> aruk = new Hashtable<>();
		Bolt ujBolt = new Bolt("Uj bolt", "Uj tulaj", "Uj cim", aruk, 1);
		assertNotNull("Letrej�tt az uj bolt.", ujBolt);
	}
	
	@Test
	public void plazaisNyitvaTrue()
	{
		Hashtable<Long, Integer> aruk = new Hashtable<>();
		Bolt ujBolt = new Bolt("Uj bolt", "Uj tulaj", "Uj cim", aruk, 1);
		Vector<Object> boltok = new Vector<>();
		PlazaImpl plaza = new PlazaImpl(boltok);
		plaza.hozzaadShop(ujBolt);
		plaza.nyit();
		assertTrue("A pl�za nyitva", plaza.isNyitva());

	}
}
