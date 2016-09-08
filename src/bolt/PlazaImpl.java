package bolt;

import java.util.Iterator;
import java.util.Vector;

public class PlazaImpl implements Plaza {
	
	@SuppressWarnings("rawtypes")
	private Vector shops;
	private boolean nyitva = false;

	@SuppressWarnings("rawtypes")
	public PlazaImpl(Vector shops) {
		this.shops = shops;
	}

	@SuppressWarnings("unchecked")
	public void hozzaadShop(NagyBolt p) {
		shops.add(p);
	}

	public void torolShop(NagyBolt p) {
		shops.remove(p);
	}

	public void nyit() {
		nyitva = true;
		for (int i = 0; i < shops.size(); i++) {
			NagyBolt shop = (NagyBolt) shops.elementAt(i);
			shop.nyit();
		}
	}

	public void zar() {
		nyitva = false;
		for (int i = 0; i < shops.size(); i++) {
			NagyBolt shop = (NagyBolt) shops.elementAt(i);
			shop.zar();
		}
	}

	public boolean isNyitva() {
		return nyitva;
	}

	@SuppressWarnings("rawtypes")
	public Iterator shopok() {
		return shops.iterator();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Iterator shopok(int besorolas) {
		Vector shopk = new Vector();
		for (int i = 0; i < shops.size(); i++) {
			NagyBolt shop = (NagyBolt) shops.elementAt(i);
			if (NagyBolt.getBesorolas() == besorolas)
				shopk.add(shop);
		}
		return shopk.iterator();
	}
}