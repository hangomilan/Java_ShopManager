package bolt;

public interface Logger {
	static final int FELTOLTES = 1;
	static final int TORLES = 1;
	static final int VASARLAS = 1;
	static final int ARULISTALEKERES = 1;

	void addVasarlas(String info);

	void addAruTorles(String info);

	void addAruFeltoltes(String info);

	void addAruListaLekerdezese(String info);

	void closeLogging();
}
