package bolt;

import java.io.InputStream;
import java.util.Iterator;

import bolt.kivetel.NagyBoltKivetel;

public interface Log {
	InputStream getLogStream() throws NagyBoltKivetel;

	Iterator<?> getVasarlasok();

	Iterator<?> getFeltoltesek();

	Iterator<?> getAruTorlesek();

	Iterator<?> getAruListaLekeresek();

	Iterator<?> getTeljesNaplozas();

	LogBejegyzes[] getTeljesNaplozasAsArray();

}
