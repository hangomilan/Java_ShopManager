package bolt.aruk;

import java.util.Calendar;

public class Sajt extends Elelmiszer {

	protected double suly;
	protected boolean zsirtartalom;

	public Sajt(Long vonalKod, double suly, String gyarto, Calendar szavatossagiIdo, boolean zsirtartalom) {
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

	public boolean getZsirtartalom() {
		return zsirtartalom;
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
		return super.toString() + "Zsirtartalom:" + zsirtartalom;
	}
}
