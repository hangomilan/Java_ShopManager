package bolt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import bolt.kivetel.NagyBoltKivetel;

public class BoltLogger implements Log, Logger {
	
	private Vector<BoltLogBejegyzes> logs;
	private File f;

	public BoltLogger() {
		logs = new Vector<BoltLogBejegyzes>();
	}

	class BoltLogBejegyzes implements LogBejegyzes {
		private int code;
		private Date datum;
		private String logInfo;

		public BoltLogBejegyzes(int code, Date datum, String logInfo) {
			this.code = code;
			this.datum = datum;
			this.logInfo = logInfo;
		}

		public Date getDatum() {
			return datum;
		}

		public String getLogInfo() {
			return logInfo;
		}

		public boolean isVasarlas() {
			return code == Logger.VASARLAS;
		}

		public boolean isFeltoltes() {
			return code == Logger.FELTOLTES;
		}

		public boolean isAruTorles() {
			return code == Logger.TORLES;
		}

		public boolean isAruListaLekeres() {
			return code == Logger.ARULISTALEKERES;
		}

		public String toString() {
			return logInfo + " dátuma:" + datum;
		}
	}

	public InputStream getLogStream() throws NagyBoltKivetel {
		if (f == null)
			throw new NagyBoltKivetel("A log még nincs lezárva");
		try {
			return new FileInputStream(f);
		} catch (FileNotFoundException e) {
			throw new NagyBoltKivetel("I/O hiba");
		}
	}

	public Iterator<LogBejegyzes> getVasarlasok() {
		Vector<LogBejegyzes> vasarlasok = new Vector<LogBejegyzes>();
		for (int i = 0; i < logs.size(); i++) {
			LogBejegyzes o = (LogBejegyzes) logs.elementAt(i);
			if (o.isVasarlas())
				vasarlasok.add(o);
		}
		return vasarlasok.iterator();
	}

	public Iterator<LogBejegyzes> getFeltoltesek() {
		Vector<LogBejegyzes> vasarlasok = new Vector<LogBejegyzes>();
		for (int i = 0; i < logs.size(); i++) {
			LogBejegyzes o = (LogBejegyzes) logs.elementAt(i);
			if (o.isFeltoltes())
				vasarlasok.add(o);
		}
		return vasarlasok.iterator();
	}

	public Iterator<LogBejegyzes> getAruTorlesek() {
		Vector<LogBejegyzes> vasarlasok = new Vector<LogBejegyzes>();
		for (int i = 0; i < logs.size(); i++) {
			LogBejegyzes o = (LogBejegyzes) logs.elementAt(i);
			if (o.isAruTorles())
				vasarlasok.add(o);
		}
		return vasarlasok.iterator();
	}

	public Iterator<LogBejegyzes> getAruListaLekeresek() {
		Vector<LogBejegyzes> vasarlasok = new Vector<LogBejegyzes>();
		for (int i = 0; i < logs.size(); i++) {
			LogBejegyzes o = (LogBejegyzes) logs.elementAt(i);
			if (o.isAruListaLekeres())
				vasarlasok.add(o);
		}
		return vasarlasok.iterator();
	}

	public Iterator<BoltLogBejegyzes> getTeljesNaplozas() {
		return logs.iterator();
	}

	public LogBejegyzes[] getTeljesNaplozasAsArray() {
		return (LogBejegyzes[]) logs.toArray(new LogBejegyzes[logs.size()]);
	}

	public void addVasarlas(String info) {
		logs.add(new BoltLogBejegyzes(Logger.VASARLAS, new Date(), info));
	}

	public void addAruTorles(String info) {
		logs.add(new BoltLogBejegyzes(Logger.TORLES, new Date(), info));
	}

	public void addAruFeltoltes(String info) {
		logs.add(new BoltLogBejegyzes(Logger.FELTOLTES, new Date(), info));
	}

	public void addAruListaLekerdezese(String info) {
		logs.add(new BoltLogBejegyzes(Logger.ARULISTALEKERES, new Date(), info));
	}

	public void closeLogging() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < logs.size(); i++) {
			BoltLogBejegyzes boltLogBejegyzes = (BoltLogBejegyzes) logs.elementAt(i);
			sb.append(boltLogBejegyzes + "");
		}
		try {
			f = new File("C:/log.txt");
			FileWriter w = new FileWriter(f);
			w.write(sb.toString());
			w.close();
		} catch (Exception e) {
		}
	}
}
