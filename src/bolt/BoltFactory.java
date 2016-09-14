package bolt;

import bolt.aruk.Tej;
import bolt.aruk.Sajt;
import bolt.aruk.Szappan;
import bolt.aruk.tej.TartosTej;
import bolt.aruk.tej.FeltartosTej;
import java.util.GregorianCalendar;

public abstract class BoltFactory {

	public static Tej ujTarosTej(Long vonalKod, int urtartalom, String gyarto, GregorianCalendar szavatossagiIdo,
			double zsirtartalom) {
		return new TartosTej(vonalKod, urtartalom, gyarto, szavatossagiIdo, zsirtartalom);
	}

	public static Tej ujFeltarosTej(Long vonalKod, int urtartalom, String gyarto, GregorianCalendar szavatossagiIdo,
			double zsirtartalom) {
		return new TartosTej(vonalKod, urtartalom, gyarto, szavatossagiIdo, zsirtartalom);
	}

	public static Tej ujFelzsirosTarosTej(Long vonalKod, int urtartalom, String gyarto, GregorianCalendar szavatossagiIdo) {
		return new TartosTej(vonalKod, urtartalom, gyarto, szavatossagiIdo, Tej.FELZSIROS);
	}

	public static Tej ujZsirosTarosTej(Long vonalKod, int urtartalom, String gyarto, GregorianCalendar szavatossagiIdo) {
		return new TartosTej(vonalKod, urtartalom, gyarto, szavatossagiIdo, Tej.ZSIROS);
	}

	public static Tej ujFelzsirosFeltarosTej(Long vonalKod, int urtartalom, String gyarto, GregorianCalendar szavatossagiIdo) {
		return new FeltartosTej(vonalKod, urtartalom, gyarto, szavatossagiIdo, Tej.FELZSIROS);
	}
	
	public static Tej ujZsirosFeltarosTej(Long vonalKod, int urtartalom, String gyarto, GregorianCalendar szavatossagiIdo) {
		return new TartosTej(vonalKod, urtartalom, gyarto, szavatossagiIdo, Tej.ZSIROS);
	}

	public static Tej ujFelzsirosLiteresTarosTej(Long vonalKod, String gyarto, GregorianCalendar szavatossagiIdo) {
		return new TartosTej(vonalKod, Tej.LITER, gyarto, szavatossagiIdo, Tej.FELZSIROS);
	}
	
	public static Tej ujZsirosLiteresTarosTej(Long vonalKod, String gyarto, GregorianCalendar szavatossagiIdo) {
		return new TartosTej(vonalKod, Tej.LITER, gyarto, szavatossagiIdo, Tej.ZSIROS);
	}
	
	public static Tej ujFelzsirosLiteresFeltarosTej(Long vonalKod, String gyarto, GregorianCalendar szavatossagiIdo) {
		return new TartosTej(vonalKod, Tej.LITER, gyarto, szavatossagiIdo, Tej.FELZSIROS);
	}
	
	public static Tej ujZsirosLiteresFeltarosTej(Long vonalKod, String gyarto, GregorianCalendar szavatossagiIdo) {
		return new TartosTej(vonalKod, Tej.LITER, gyarto, szavatossagiIdo, Tej.FELZSIROS);
	}
	
	public static Sajt ujSajt(Long vonalKod, double suly, String gyarto, GregorianCalendar szavatossagiIdo, boolean zsirtartalom) {
		return new Sajt(vonalKod, suly, gyarto, szavatossagiIdo,zsirtartalom);
	}
	
	public static Szappan ujSzappan(Long vonalKod, String gyarto, char mosohatas) {
		return new Szappan(vonalKod, gyarto, mosohatas);
	}
	
	public static Szappan ujA_MosohatasuSzappan(Long vonalKod, String gyarto) {
		return new Szappan(vonalKod, gyarto, Szappan.AMOSOHATAS);
	}
	
	public static Szappan ujB_MosohatasuSzappan(Long vonalKod, String gyarto) {
		return new Szappan(vonalKod, gyarto, Szappan.BMOSOHATAS);
	}
}
