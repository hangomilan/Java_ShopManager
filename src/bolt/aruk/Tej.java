package bolt.aruk;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Tej extends Elelmiszer {

	public static final int LITER = 1000;
	public static final int FELLITER = 500;
	public static final int POHAR = 200;
	public static final double ZSIROS = 2.8;
	public static final double FELZSIROS = 1.5;

	protected int urtartalom = 0;
	protected double zsirtartalom;

	public Tej(Long vonalKod, int urtartalom, String gyarto, Calendar szavatossagiIdo, double zsirtartalom) {
		super(vonalKod, gyarto, szavatossagiIdo);
		this.urtartalom = urtartalom;
		this.zsirtartalom = zsirtartalom;
	}

	public Long getVonalKod() {
		return vonalKod;
	}

	public boolean joMeg() {
		Calendar most = new GregorianCalendar();
		int hasonlitas = this.szavatossagiIdo.compareTo(most);
		if (!(hasonlitas == -1)) 
		{
			return true;
		} 
		else 
		{ 
			return false;
		}
	}

	public int getUrtartalom() {
		return urtartalom;
	}

	public String getGyarto() {
		return gyarto;
	}

	public Calendar getSzavatossagiIdo() {
		return szavatossagiIdo;
	}

	public double getZsirtartalom() {
		return zsirtartalom;
	}
	
	@Override
	public String toString(){
		 return super.toString()+"Zsirtartalom:"+zsirtartalom;
	}
}