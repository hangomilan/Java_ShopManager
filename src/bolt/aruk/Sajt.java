package bolt.aruk;

import java.util.Date;

public class Sajt extends Elelmiszer {

	protected double suly;
	protected double zsirtartalom;
	protected Long vonalKod;
	protected String gyarto;
	protected Date szavatossagiIdo;

	public Sajt(Long vonalKod, double suly, String gyarto, Date szavatossagiIdo, double zsirtartalom) {
		super(vonalKod, gyarto, szavatossagiIdo);
		this.suly = suly;
		this.zsirtartalom = zsirtartalom;
	}

	public boolean joMeg() {
		return true;
	}

	public double getSuly() {
		return suly;
	}

	public double getZsirtartalom() {
		return zsirtartalom;
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
		return super.toString() + "Zsirtartalom:" + zsirtartalom;
	}
}
