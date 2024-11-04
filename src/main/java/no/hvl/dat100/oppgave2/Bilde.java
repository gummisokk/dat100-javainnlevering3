package no.hvl.dat100.oppgave2;

public class Bilde extends Tekst {

	private String url;
	
	public Bilde(int id, String bruker, String dato, String tekst, String url) {
		super(id, bruker, dato, tekst);
		this.url = url;
	}

	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
		super(id, bruker, dato, likes, tekst);
		this.url = url;
	}
	
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		String str = "BILDE\n";
		str += this.getId() + "\n";
		str += this.getBruker() + "\n";
		str += this.getDato() + "\n";
		str += this.getLikes() + "\n";
		str += this.getTekst() + "\n";
		str += this.getUrl() + "\n";
		return str;
	}

	@Override
	public String toHTML() {
		return
		"		<h2>" + this.getBruker() + 
		"@" + this.getDato() +
		" [" + this.getLikes() + "]</h2>\n" +
		"		<p>" + this.getTekst() + "</p>\n" +
		"		<iframe src=\"" + this.getUrl() + "\"height=600 width=800></iframe><hr>\n";
	}
}
