package bolt;

import java.util.Hashtable;
import java.util.Iterator;

import bolt.aruk.Elelmiszer;
import bolt.aruk.Sajt;
import bolt.aruk.Tej;
import bolt.kivetel.NagyBoltKivetel;
import bolt.kivetel.NemLetezoAruKivetel;
import bolt.kivetel.TulSokLevonasKivetel;
import bolt.kivetel.ZarvaKivetel;

import java.util.Enumeration;

public class Bolt implements NagyBolt {

	private String nev, tulajdonos, cim;
	private boolean nyitva = false;
	private BoltLogger logger;
	private int besorolas;

	private Hashtable<?, ?> arupult;

	public class BoltBejegyzes {
		private Aru a;
		private long mennyiseg;
		private long ar;

		public BoltBejegyzes(Elelmiszer e, long mennyiseg, long ar, Aru a) {
			this.a = a;
			this.mennyiseg = mennyiseg;
			this.ar = ar;
		}

		public Aru getAru() {
			return a;
		}

		public void setAru(Aru a) {
			this.a = a;
		}

		public void setAr(long ar) {
			this.ar = ar;
		}

		public long getMennyiseg() {
			return mennyiseg;
		}

		public void setMennyiseg(long mennyiseg) {
			this.mennyiseg = mennyiseg;
		}

		public void adMennyiseg(long mennyiseg) {
			this.mennyiseg += mennyiseg;
		}

		public void levonMennyiseg(long mennyiseg) {
			this.mennyiseg -= mennyiseg;
		}

		public long getAr() {
			return ar;
		}

		public void setAr(int ar) {
			this.ar = ar;
		}
	}

	public Bolt(String nev, String tulajdonos, String cim, int besorolas) {
		this(nev, tulajdonos, cim, new Hashtable<Object, Object>(), besorolas);
	}

	public Bolt(String nev, String tulajdonos, String cim, Hashtable<?, ?> arupult, int besorolas) {
		this.nev = nev;
		this.tulajdonos = tulajdonos;
		this.cim = cim;
		this.arupult = arupult;
		this.besorolas = besorolas;
	}

	public String getNev() {
		return nev;
	}

	public String getTulajdonos() {
		return tulajdonos;
	}

	public String getCim() {
		return cim;
	}

	private boolean vanMegAdottAru(Class<?> c) {
		logger.addAruListaLekerdezese("Árutípus készletezettségének ellenõrzése:" + c);
		for (Enumeration<?> e = arupult.elements(); e.hasMoreElements();) {
			BoltBejegyzes b = (BoltBejegyzes) e.nextElement();
			if (c.isInstance(b.getAru()) && b.getMennyiseg() > 0)
				return true;
		}
		return false;
	}

	public boolean vanMegTej() {
		return vanMegAdottAru(Tej.class);
	}

	public boolean vanMegSajt() {
		return vanMegAdottAru(Sajt.class);
	}

	public void feltoltElelmiszerrel(Long vonalKod, long mennyiseg) throws BoltKivetel {
		logger.addAruTorles("Elelmiszerfeltoltes a" + vonalKod + " arubol" + mennyiseg + " mennyiseggel");
		BoltBejegyzes b = (BoltBejegyzes) arupult.get(vonalKod);
		if (b == null)
			throw new NemLetezoAruKivetel("Nincs ilyen áru:" + vonalKod);
		b.adMennyiseg(mennyiseg);
	}

	public void feltoltUjElelmiszerrel(Elelmiszer e, long mennyiseg, long ar) {
		logger.addAruTorles("Új élelmiszer feltoltese:" + e + ";" + mennyiseg + "mennyiseggel");
		BoltBejegyzes b = new BoltBejegyzes(e, mennyiseg, ar, e);
		b.adMennyiseg(mennyiseg);
	}

	public void torolElelmiszert(Long vonalKod) throws BoltKivetel {
		logger.addAruTorles("Elelmiszertorles:" + vonalKod);
		if (arupult.remove(vonalKod) == null)
			throw new NemLetezoAruKivetel("Nincs ilyen áru:" + vonalKod);
	}

	public void vasarolElelmiszert(Long vonalKod, long mennyiseg) throws BoltKivetel {
		logger.addVasarlas("Elelmiszervásárlás a" + vonalKod + " arubol" + mennyiseg + " mennyiseggel");
		BoltBejegyzes b = (BoltBejegyzes) arupult.get(vonalKod);
		if (b == null)
			throw new NemLetezoAruKivetel("Nincs ilyen áru:" + vonalKod);
		if (b != null) {
			if (b.getMennyiseg() < mennyiseg)
				throw new TulSokLevonasKivetel("Nincs elegendõ mennyiség:" + vonalKod);
			b.levonMennyiseg(mennyiseg);
		}
	}

	class AruIterator implements Iterator<Object> {
		private Iterator<?> i;

		AruIterator(Iterator<?> i) {
			this.i = i;
		}

		public boolean hasNext() {
			return i.hasNext();
		}

		public Object next() {
			Aru a = (Aru) i.next();
			return new Aru(a.getVonalKod(), a.getGyarto()) {
			};
		}

		public void remove() {
			i.remove();
		}
	}

	@Override
	public Iterator<?> aruk() throws ZarvaKivetel {
		if (!nyitva)
			throw new ZarvaKivetel("A bolt zárva van");
		return new AruIterator(arupult.values().iterator());
	}

	public void vasarol(Aru a, long mennyiseg) throws ZarvaKivetel, BoltKivetel {
		if (!nyitva)
			throw new ZarvaKivetel("A bolt zárva van");
		vasarolElelmiszert(a.getVonalKod(), mennyiseg);
	}

	@Override
	public void nyit() {
		nyitva = true;
		logger = new BoltLogger();
	}

	@Override
	public void zar() {
		nyitva = false;
		logger.closeLogging();
	}

	@Override
	public Log getLog() throws NagyBoltKivetel {
		return logger;
	}

	public int getBesorolas() {
		return besorolas;
	}

}