package bolt.aruk;

import java.util.Calendar;
import java.util.GregorianCalendar;

import bolt.Aru;

public abstract class Elelmiszer extends Aru{
	
	protected Calendar szavatossagiIdo;
	
	public Elelmiszer(Long vonalKod, String gyarto, Calendar szavatossagiIdo) {
		super(vonalKod, gyarto);
		this.szavatossagiIdo = szavatossagiIdo;
	}

	public boolean joMeg() {
		return new GregorianCalendar().before(szavatossagiIdo);
	}
	
	public Long getVonalKod() {
		return vonalKod;
	}

	public String getGyarto() {
		return gyarto;
	}

	public Calendar getSzavatossagiIdo() {
		return szavatossagiIdo;
	}

	@Override
	public String toString() {
		return "Elelmiszer [vonalKod=" + vonalKod + ", gyarto=" + gyarto + ", szavatossagiIdo=" + szavatossagiIdo + "]";
	}
}
