package no.hvl.dat100.oppgave1;

public abstract class Innlegg {
	
	private int id;
	private String bruker;
	private String dato;
	private int likes;
	
	public Innlegg() {
		
	}

	public Innlegg(int id, String bruker, String dato) {
		this(id, bruker, dato, 0);
	}

	public Innlegg(int id, String bruker, String dato, int likes) {
		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
		this.likes = likes;
	}
	
	public String getBruker() {
		return bruker;
	}

	public void setBruker(String bruker) {
		this.bruker = bruker;
	}

	public String getDato() {
		return this.dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public int getId() {
		return this.id;
	}

	public int getLikes() {
		return this.likes;
	}
	
	public void doLike () {
		this.likes ++;
	}
	
	public boolean erLik(Innlegg innlegg) {
		return this.id == innlegg.id;
	}
	
	@Override
	public String toString() {
		String str = this.id + "\n";
		str += this.bruker + "\n";
		str += this.dato + "\n";
		str += this.likes + "\n";
		return str;
	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		return
		"<h2>" + this.getBruker() + 
		"@" + this.getDato() +
		" [" + this.getLikes() + "]<h2>\n";
	}
}
