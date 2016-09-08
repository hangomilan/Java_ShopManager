package bolt;

public abstract class Aru {

	protected Long vonalKod;
	protected String gyarto;

	public Aru(Long vonalKod, String gyarto) {
		super();
		this.vonalKod = vonalKod;
		this.gyarto = gyarto;
	}

	public Long getVonalKod() {
		return vonalKod;
	}

	public void setVonalKod(Long vonalKod) {
		this.vonalKod = vonalKod;
	}

	public String getGyarto() {
		return gyarto;
	}

	public void setGyarto(String gyarto) {
		this.gyarto = gyarto;
	}

	@Override
	public String toString() {
		return "Aru [vonalKod=" + vonalKod + ", gyarto=" + gyarto + "]";
	}
}
