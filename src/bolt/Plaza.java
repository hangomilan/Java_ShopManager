package bolt;

import java.util.Iterator;

public interface Plaza {
	void hozzaadShop(NagyBolt p);

	void torolShop(NagyBolt p);

	void nyit();

	void zar();

	boolean isNyitva();

	@SuppressWarnings("rawtypes")
	Iterator shopok();
}