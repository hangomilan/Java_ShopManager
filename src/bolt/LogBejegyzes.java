package bolt;

import java.util.Date;

public interface LogBejegyzes {
	Date getDatum();

	String getLogInfo();

	boolean isVasarlas();

	boolean isFeltoltes();

	boolean isAruTorles();

	boolean isAruListaLekeres();
}
