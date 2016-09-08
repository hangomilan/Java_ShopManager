package bolt;

import java.util.Iterator;

import bolt.kivetel.NagyBoltKivetel;
import bolt.kivetel.ZarvaKivetel;

public interface NagyBolt {

	static final int ELELMISZER = 1;
	static final int BARKACS = 2;
	static final int RUHAZAT = 3;
	static final int GYORSETTEREM = 4;
	static final int KONYVESBOLT = 5;

	@SuppressWarnings("rawtypes")
	Iterator aruk() throws ZarvaKivetel;

	void vasarol(Aru a, long mennyiseg) throws ZarvaKivetel, BoltKivetel;

	String getNev();

	String getCim();

	String getTulajdonos();

	void nyit();

	void zar();

	Log getLog() throws NagyBoltKivetel;

	static int getBesorolas() {
		return 0;
	}
}
