package no.hvl.dat100.oppgave2;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.Innlegg;

public class Tekst extends Innlegg {

	private String tekst;

	public Tekst () {
		
	}
	
	public Tekst(int id, String bruker, String dato, String tekst) {
		super(id, bruker, dato);
		this.tekst = tekst;	}
	
	public Tekst(int id, String bruker, String dato, int likes, String tekst) {
		super(id, bruker, dato, likes);
		this.tekst = tekst;
	}
	
	public String getTekst() {
		return this.tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	@Override
	public String toString() {
		String str = "TEKST";
		str += this.getId() + "\n";
		str += this.getBruker() + "\n";
		str += this.getDato() + "\n";
		str += this.getLikes() + "\n";
		str += this.getTekst() + "\n";
		return str;
	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	@Override
	public String toHTML() {
			
		throw new UnsupportedOperationException(TODO.method());
				
	}
}
