package tests;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;

import bolt.aruk.Sajt;
import bolt.aruk.Tej;
import bolt.aruk.tej.TartosTej;

public class Tests {
	
	@Test
	public void tartostejJomeg()
	{
		Tej tej = new TartosTej(12345678910L, Tej.LITER, "gyarto",  new GregorianCalendar(2017, 04, 11), Tej.ZSIROS);
		Boolean result = tej.joMeg();
		assertEquals(true, result);
	}
	
	@Test
	
	public void sajtjJomeg()
	{
		Sajt sajt = new Sajt(12345678910L, 1000, "sajt gyarto", new GregorianCalendar(2017, 11, 11), true);
		Boolean result = sajt.joMeg();
		assertEquals(true, result);
	}
	
}
