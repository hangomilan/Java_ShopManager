package bolt.aruk;

import java.util.Date;

import bolt.Aru;

public abstract class Elelmiszer extends Aru{
	
	protected Long vonalKod;
	protected String gyarto;
	protected Date szavatossagiIdo;
	
	public Elelmiszer(Long vonalKod, String gyarto, Date szavatossagiIdo) {
		super(vonalKod, gyarto);
		this.szavatossagiIdo = szavatossagiIdo;
	}

	public boolean joMeg() {
		 return new Date().before( szavatossagiIdo );
	}
	
	public Long getVonalKod() {
		return vonalKod;
	}

	public String getGyarto() {
		return gyarto;
	}

	public Date getSzavatossagiIdo() {
		return szavatossagiIdo;
	}

	@Override
	public String toString() {
		return "Elelmiszer [vonalKod=" + vonalKod + ", gyarto=" + gyarto + ", szavatossagiIdo=" + szavatossagiIdo + "]";
	}
}
