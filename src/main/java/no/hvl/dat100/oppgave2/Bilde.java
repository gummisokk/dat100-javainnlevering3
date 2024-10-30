package no.hvl.dat100.oppgave2;

import no.hvl.dat100.common.TODO;

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

	// Metoden nedenfor er kun for valgfri oppgave 6
	@Override
	public String toHTML() {
		
		throw new UnsupportedOperationException(TODO.method());
				
	}
}
